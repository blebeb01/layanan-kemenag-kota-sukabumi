package com.naufalm.layanankemenagkotasukabumi.ui.screens.bimas_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufalm.layanankemenagkotasukabumi.data.ApiService
import kotlinx.coroutines.launch

class BimasViewModel : ViewModel() {
    var infoBimasResponse: String by mutableStateOf("")
    private var errorMessage: String by mutableStateOf("")

    fun getInfoBimas() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val infoBimas = apiService.getPosts()
                if (infoBimas.isNotEmpty()) {
                    infoBimasResponse = infoBimas[0].bimasInfo
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}