package com.example.android_pemula_traditional_dance.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_pemula_traditional_dance.R
import com.example.android_pemula_traditional_dance.data.TraditionalDanceData
import com.example.android_pemula_traditional_dance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var rvDance : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupAdapter()
    }

    private fun setupAdapter() {
        val listTraditionalDance = TraditionalDanceData.traditionalDanceData
        rvDance = binding.rvDance

        with(rvDance) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            val listDanceAdapter = MainAdapter(this@MainActivity, listTraditionalDance)
            listDanceAdapter.setActivity(this@MainActivity)
            adapter = listDanceAdapter
        }
    }
}