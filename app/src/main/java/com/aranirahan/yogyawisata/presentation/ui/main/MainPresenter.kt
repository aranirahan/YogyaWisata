package com.aranirahan.yogyawisata.presentation.ui.main

import com.aranirahan.yogyawisata.data.repository.WisataRepository
import com.aranirahan.yogyawisata.presentation.base.BasePresenter
import com.aranirahan.yogyawisata.utilities.logD
import com.aranirahan.yogyawisata.utilities.toJsonElement
import io.reactivex.android.schedulers.AndroidSchedulers

import javax.inject.Inject

class MainPresenter @Inject constructor(private val wisataRepository: WisataRepository): BasePresenter<MainView>() {

    private val tag = "MainPresenter"

    fun getWisata(){
        view?.showProgress(true)
        disposables.add(
                wisataRepository.getClubs()
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnComplete { view?.showProgress(false) }
                        .subscribe({
                            logD(tag, "wisata list : ${toJsonElement(it)}")
                            view?.displayWisata(it)

                        }, Throwable::printStackTrace)
        )
    }
}