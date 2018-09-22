package com.aranirahan.yogyawisata.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wisata(var namaPariwisata: String? = "",
                  var alamatPariwisata: String? = "",
                  var detailPariwisata: String? = "",
                  var gambarPariwisata: String? = ""
) : Parcelable