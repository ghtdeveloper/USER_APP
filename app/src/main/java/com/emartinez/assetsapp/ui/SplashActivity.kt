package com.emartinez.assetsapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.emartinez.assetsapp.R
import com.emartinez.assetsapp.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    @Override
    override fun onStart() {
        super.onStart()
        showSplashScreen()
    }

    /*
        Muesta la pantalla de bienvenidad por x tiempo
        y luego se cambia a la vista principal
     */

    private fun showSplashScreen()
    {
        Handler().postDelayed(
            {
                val mIntent = Intent(this, MainActivity::class.java)
                startActivity(mIntent)
                finish()
            }, 1100)
    }

}