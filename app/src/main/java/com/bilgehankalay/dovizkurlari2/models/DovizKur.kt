package com.bilgehankalay.dovizkurlari2.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DovizKur(
    @SerializedName("code") @Expose var code : String,
    @SerializedName("name") @Expose var name : String,
    @SerializedName("rate") @Expose var rate : Double,
    @SerializedName("calculatedstr") @Expose var calculatedstr : String,
    @SerializedName("calculated") @Expose var calculated : Double
) : Serializable
