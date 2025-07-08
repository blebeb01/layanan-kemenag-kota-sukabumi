package com.naufalm.layanankemenagkotasukabumi.data

import com.naufalm.layanankemenagkotasukabumi.data.model.LayananKemenag
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/profile")
    suspend fun getPosts(): List<LayananKemenag>

    companion object {
        private var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://be-kemenag-ih32.vercel.app")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}