package com.aranirahan.yogyawisata.data.model

import com.aranirahan.yogyawisata.presentation.model.Wisata
import com.google.gson.annotations.SerializedName

data class WisataModel(
        @SerializedName("nama_pariwisata")
        var namaPariwisata: String? = null,

        @SerializedName("alamat_pariwisata")
        var alamatPariwisata: String? = null,

        @SerializedName("detail_pariwisata")
        var detailPariwisata: String? = null,

        @SerializedName("gambar_pariwisata")
        var gambarPariwisata: String? = null ){

        fun transform() : Wisata = Wisata(
                namaPariwisata = this.namaPariwisata,
                alamatPariwisata = this.alamatPariwisata,
                detailPariwisata = this.detailPariwisata,
                gambarPariwisata = this.gambarPariwisata
        )
}