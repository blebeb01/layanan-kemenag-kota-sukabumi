package com.naufalm.layanankemenagkotasukabumi.ui.screens.subbag_tu_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.naufalm.layanankemenagkotasukabumi.components.MyLargeTopAppBar
import com.naufalm.layanankemenagkotasukabumi.ui.theme.jakartaSansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubbagTuScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val isAdmin = true //sementara, dummy
    var isEditMode by remember { mutableStateOf(false) }
    var editedText by remember { mutableStateOf("") }

    val viewModel: SubbagTuViewModel = viewModel()
    val infoSubbagTu = viewModel.infoSubbagTuResponse

    LaunchedEffect(Unit) {
        viewModel.getInfoSubbagTu()
    }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MyLargeTopAppBar(
                title = "Sub Tata Usaha",
                navigateBack = { navController.navigateUp() },
                scrollBehavior = scrollBehavior
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            infoSubbagTu.forEach { subbagTu ->
                if (isAdmin && isEditMode) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = editedText,
                        onValueChange = { editedText = it }
                    )
                } else {
                    Text(
                        text = subbagTu,
                        fontFamily = jakartaSansFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )

                    if (isAdmin && !isEditMode) {
                        TextButton(
                            onClick = {
                                editedText = subbagTu
                                isEditMode = true
                            }
                        ) {
                            Text("Edit")
                        }
                    }

                    if (isAdmin && isEditMode) {
                        Row {
                            TextButton(
                                onClick = {
                                    TODO("kirim editedText ke backend disini")
                                    isEditMode = false
                                }
                            ) {
                                Text("Simpan")
                            }

                            TextButton(
                                onClick = {
                                    isEditMode = false
                                }
                            ) {
                                Text("Batal")
                            }
                        }
                    }
                }
            }
        }
    }
}