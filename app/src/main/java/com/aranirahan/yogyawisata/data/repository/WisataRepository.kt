package com.aranirahan.yogyawisata.data.repository

import com.aranirahan.yogyawisata.presentation.model.Wisata
import io.reactivex.Flowable

interface WisataRepository {
    fun getClubs(): Flowable<List<Wisata>>
}