package com.aranirahan.yogyawisata.data.repository

import com.aranirahan.yogyawisata.data.ApiService
import com.aranirahan.yogyawisata.presentation.model.Wisata
import io.reactivex.Flowable
import javax.inject.Inject


class WisataRepositoryImpl @Inject constructor(private val service: ApiService): WisataRepository {

    override fun getClubs(): Flowable<List<Wisata>> {
        return service.getClubs()
                .flatMap { Flowable.fromIterable(it.data) }
                .map { it.transform() }
                .toList()
                .toFlowable()
    }
}