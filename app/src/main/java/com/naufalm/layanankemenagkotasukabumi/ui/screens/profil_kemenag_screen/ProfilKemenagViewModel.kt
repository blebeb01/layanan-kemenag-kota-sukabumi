package com.naufalm.layanankemenagkotasukabumi.ui.screens.profil_kemenag_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufalm.layanankemenagkotasukabumi.data.ApiService
import kotlinx.coroutines.launch

class ProfilKemenagViewModel : ViewModel() {
    var profilKemenagResponse: List<String> by mutableStateOf(emptyList())
    var isLoading: Boolean by mutableStateOf(false)
    private var errorMessage: String by mutableStateOf("")

    fun getProfilKemenag() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val profilKemenag = apiService.getPosts()
                if (profilKemenag.isNotEmpty()) {
                    profilKemenagResponse = profilKemenag[0].kemenagProfile
                } else {
                    errorMessage = "No data available."
                }
            } catch (e: Exception) {
                errorMessage = "Unable to load data. Please check your internet connection."
            } finally {
                isLoading = false
            }
        }
    }
}