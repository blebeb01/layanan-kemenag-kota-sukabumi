package com.naufalm.layanankemenagkotasukabumi.ui.screens.subbag_tu_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufalm.layanankemenagkotasukabumi.data.ApiService
import kotlinx.coroutines.launch

class SubbagTuViewModel : ViewModel() {
    var infoSubbagTuResponse: List<String> by mutableStateOf(emptyList())
    private var errorMessage: String by mutableStateOf("")

    fun getInfoSubbagTu() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val infoSubbagTu = apiService.getPosts()
                if (infoSubbagTu.isNotEmpty()) {
                    infoSubbagTuResponse = infoSubbagTu[0].subbagTuInfo
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}