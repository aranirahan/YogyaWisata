package com.aranirahan.yogyawisata.presentation.ui.main

import com.aranirahan.yogyawisata.presentation.model.Wisata
import com.aranirahan.yogyawisata.presentation.base.BaseView

interface MainView : BaseView {

    fun showProgress(progress: Boolean)

    fun showMessage(message: String?)

    fun displayWisata(wisata: List<Wisata>)
}