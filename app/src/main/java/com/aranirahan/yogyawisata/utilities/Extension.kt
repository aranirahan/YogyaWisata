package com.aranirahan.yogyawisata.utilities

import android.util.Log
import com.aranirahan.yogyawisata.BuildConfig
import com.google.gson.Gson
import com.google.gson.JsonElement

fun logD(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.d(tag, msg)
}

fun toJsonElement(any: Any): JsonElement = Gson().toJsonTree(any)