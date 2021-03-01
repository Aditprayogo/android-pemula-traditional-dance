package com.example.android_pemula_traditional_dance.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_pemula_traditional_dance.data.TraditionalDance
import com.example.android_pemula_traditional_dance.databinding.ActivityDetailBinding
import com.example.android_pemula_traditional_dance.util.load

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TRADITIONAL_DANCE = "extra_traditional_dance"
    }

    private val binding : ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUi()
        setupData()
    }

    private fun setupData() {
        val data = intent.getParcelableExtra<TraditionalDance>(EXTRA_TRADITIONAL_DANCE)
        with(binding) {
            imgDance.load(data?.image)
            supportActionBar?.title = data?.name
            txtDanceDescription.text = data?.description

            with(rvDanceImages) {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
                val listImagesAdapter = DetailAcvitiyAdapter(data?.images!!, this@DetailActivity)
                listImagesAdapter.setActivity(this@DetailActivity)
                adapter = listImagesAdapter
            }

        }
    }

    private fun setupUi() {
        supportActionBar?.apply {
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFinishAfterTransition()
        onBackPressed()
        return true
    }
}