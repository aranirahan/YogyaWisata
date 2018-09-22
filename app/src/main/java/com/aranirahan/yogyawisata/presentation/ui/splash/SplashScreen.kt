package com.aranirahan.yogyawisata.presentation.ui.splash

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.aranirahan.yogyawisata.R
import com.aranirahan.yogyawisata.presentation.ui.register.RegisterActivity

class SplashScreenActivity : Activity() {

    private val SPLASH_TIME_OUT = 3000
    private val SHARED_NAME = "SPLASH"
    private val FIRST_TIME = "FIRST_TIME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!checkFirstTime(this)) {
            setContentView(R.layout.activity_splash_screen)
            Handler().postDelayed({
                startActivity(Intent(this@SplashScreenActivity, RegisterActivity::class.java))
                finish()
            }, SPLASH_TIME_OUT.toLong())
        } else {
            startActivity(Intent(this@SplashScreenActivity, RegisterActivity::class.java))
            finish()
        }
    }

    private fun checkFirstTime(ctx: Context): Boolean {
        var settings = ctx.getSharedPreferences(SHARED_NAME, 0)
        val first = settings.getBoolean(FIRST_TIME, false)
        if (!first) {
            settings = ctx.getSharedPreferences(SHARED_NAME, 0)
            val editor = settings.edit()
            editor.putBoolean(FIRST_TIME, true)
            editor.apply()
        }
        return first
    }

}