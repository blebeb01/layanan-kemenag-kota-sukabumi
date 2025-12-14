package com.naufalm.layanankemenagkotasukabumi.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.naufalm.layanankemenagkotasukabumi.ui.theme.jakartaSansFontFamily

@Composable
fun AboutButton(
    profilKemenag: List<String>,
    isLoading: Boolean
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Tentang Kemenag Kota Sukabumi")
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Tutup" else "Buka",
                    modifier = Modifier.rotate(if (expanded) 180f else 0f)
                )
            }
        }

        AnimatedVisibility(visible = expanded) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA))
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                    val kemenag = LatLng(-6.924510424579178, 106.9170887542417)
                    val kemenagMarkerState = rememberMarkerState(position = kemenag)
                    val cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(kemenag, 16f)
                    }

                    if (isLoading) {
                        Text(text = "Sedang memuat...")
                    } else {
                        if (profilKemenag.isNotEmpty()) {
                            profilKemenag.forEach { line ->
                                Text(
                                    text = line,
                                    fontFamily = jakartaSansFontFamily,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.5f)
                            .padding(5.dp),
                        border = BorderStroke(width = 2.dp, color = Color.LightGray)
                    ) {
                        GoogleMap(
                            modifier = Modifier
                                .fillMaxSize(),
                            cameraPositionState = cameraPositionState
                        ) {
                            Marker(
                                state = kemenagMarkerState,
                                title = "Kemenag Kota Sukabumi",
                                snippet = "Kantor Kemenag Kota Sukabumi"
                            )
                        }
                    }
                }
            }
        }
    }
}