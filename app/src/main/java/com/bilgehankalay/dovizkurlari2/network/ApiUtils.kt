package com.bilgehankalay.dovizkurlari2.network

import retrofit2.create

class ApiUtils {
    companion object{
        private const val BASE_URL = "https://api.collectapi.com/economy/"
        fun DovizDAOInterfaceGetir() : DovizDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(DovizDAOInterface::class.java)
        }
    }
}