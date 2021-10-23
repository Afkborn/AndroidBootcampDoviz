package com.bilgehankalay.dovizkurlari2.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface DovizDAOInterface {
    @GET("currencyToAll")
    @Headers("authorization: apikey 2ChxxLdG0t1sE8wQVp91sU:5ztro3zzWtESkOoXAZuCR3","content-type: application/json")
    fun dovizleriAl(
        @Query("base") base : String,
        @Query("int") int : Int
    ) : Call<exchangeResponse>
}