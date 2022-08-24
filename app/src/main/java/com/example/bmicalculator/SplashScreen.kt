package com.example.bmicalculator

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)



        //Code to create a timer from splashscreen to the MainActivity
        //The suppress annotation helps us override deprecated methods
        @Suppress("DEPRECATED")
        //The splashcreen will first dislay and after 3secs the app will switch to the main activity
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)




        //hide the status bar
//Doing away with the statusbar
        @Suppress("DEPRECATED")
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{
            window.setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

    }
}