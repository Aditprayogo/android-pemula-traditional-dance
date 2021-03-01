package com.example.android_pemula_traditional_dance.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_pemula_traditional_dance.R
import com.example.android_pemula_traditional_dance.data.TraditionalDanceData
import com.example.android_pemula_traditional_dance.databinding.ActivityMainBinding
import com.example.android_pemula_traditional_dance.ui.profile.ProfileActivity

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.idMenuProfile -> startActivity(Intent(this, ProfileActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}