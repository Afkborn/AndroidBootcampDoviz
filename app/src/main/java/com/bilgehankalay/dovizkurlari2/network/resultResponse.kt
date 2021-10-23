package com.bilgehankalay.dovizkurlari2.network

import com.bilgehankalay.dovizkurlari2.models.DovizKur
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class resultResponse (
    @SerializedName("base") @Expose var base: String,
    @SerializedName("lastupdate") @Expose var lastupdate: String,
    @SerializedName("data") @Expose var data: List<DovizKur>
)