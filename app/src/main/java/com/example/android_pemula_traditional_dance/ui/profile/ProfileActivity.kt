package com.example.android_pemula_traditional_dance.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_pemula_traditional_dance.R
import com.example.android_pemula_traditional_dance.databinding.ActivityProfileBinding
import com.example.android_pemula_traditional_dance.util.load

class ProfileActivity : AppCompatActivity() {

    private val binding : ActivityProfileBinding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUi()
    }

    private fun setupUi() {
        supportActionBar?.apply {
            title = getString(R.string.profile)
            setDisplayHomeAsUpEnabled(true)
        }
        binding.imgProfile.load(R.drawable.foto_adit)
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFinishAfterTransition()
        onBackPressed()
        return true
    }
}