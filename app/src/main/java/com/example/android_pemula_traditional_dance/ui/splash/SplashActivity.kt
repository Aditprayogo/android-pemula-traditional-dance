package com.example.android_pemula_traditional_dance.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.android_pemula_traditional_dance.databinding.ActivitySplashBinding
import com.example.android_pemula_traditional_dance.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private val binding : ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        addLottieAnimation()
    }

    private fun addLottieAnimation() {
        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this, MainActivity::class.java).also { startActivity(it) }
        }, 3000)
    }
}