package com.example.rickandmorty

import com.example.rickandmorty.models.BaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface CartoonApiService {

    @GET("character")
    fun fetchCharacters(): Call<BaseResponse>

}