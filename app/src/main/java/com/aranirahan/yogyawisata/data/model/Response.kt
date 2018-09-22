package com.aranirahan.yogyawisata.data.model

import com.google.gson.annotations.SerializedName

data class Response(
        @SerializedName("result")
        var result: String? = null,

        @SerializedName("data")
        var data: List<WisataModel>? = null
)