package com.aranirahan.yogyawisata.data

import com.aranirahan.yogyawisata.data.model.Response
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("bootcamp/jsonBootcamp.php")
    fun getClubs() : Flowable<Response>
}