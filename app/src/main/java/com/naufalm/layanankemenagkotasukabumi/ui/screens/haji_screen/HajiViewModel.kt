package com.naufalm.layanankemenagkotasukabumi.ui.screens.haji_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufalm.layanankemenagkotasukabumi.data.ApiService
import kotlinx.coroutines.launch

class HajiViewModel : ViewModel() {
    var infoHajiResponse: String by mutableStateOf("")
    private var errorMessage: String by mutableStateOf("")

    fun getInfoHaji() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val infoHaji = apiService.getPosts()
                if (infoHaji.isNotEmpty()) {
                    infoHajiResponse = infoHaji[0].hajjInfo
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}