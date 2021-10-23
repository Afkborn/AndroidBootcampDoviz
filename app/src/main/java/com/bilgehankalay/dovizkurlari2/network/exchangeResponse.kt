package com.bilgehankalay.dovizkurlari2.network

import com.bilgehankalay.dovizkurlari2.models.DovizKur
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class exchangeResponse(
    @SerializedName("success") @Expose var success : Boolean,
    @SerializedName("result") @Expose var result : resultResponse,
)
