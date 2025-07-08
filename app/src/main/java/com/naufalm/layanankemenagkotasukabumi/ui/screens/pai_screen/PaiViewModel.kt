package com.naufalm.layanankemenagkotasukabumi.ui.screens.pai_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufalm.layanankemenagkotasukabumi.data.ApiService
import kotlinx.coroutines.launch

class PaiViewModel : ViewModel() {
    var infoPaiResponse: List<String> by mutableStateOf(emptyList())
    private var errorMessage: String by mutableStateOf("")

    fun getInfoPai() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val infoPai = apiService.getPosts()
                if (infoPai.isNotEmpty()) {
                    infoPaiResponse = infoPai[0].paiInfo
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}