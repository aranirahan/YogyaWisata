package com.aranirahan.yogyawisata.data

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PreferencesManager @Inject constructor(context: Context) {

    private val sp: SharedPreferences = context.getSharedPreferences("yogyawisata", Context.MODE_PRIVATE)
    private val spe: SharedPreferences.Editor = sp.edit()

    var isRegister: Boolean
        get() = sp.getBoolean("isRegister", true)
        set(value) {
            spe.putBoolean("isRegister", value)
            spe.apply()
        }
}