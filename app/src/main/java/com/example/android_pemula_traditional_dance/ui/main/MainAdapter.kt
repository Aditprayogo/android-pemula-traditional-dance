package com.example.android_pemula_traditional_dance.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_pemula_traditional_dance.R
import com.example.android_pemula_traditional_dance.data.TraditionalDance
import com.example.android_pemula_traditional_dance.databinding.ItemRowDanceBinding
import com.example.android_pemula_traditional_dance.ui.detail.DetailActivity
import com.example.android_pemula_traditional_dance.util.load

class MainAdapter(
    private val context: Context,
    private val traditionalDanceList: List<TraditionalDance>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var mainActivity: MainActivity

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemRowDanceBinding = ItemRowDanceBinding.bind(itemView)

        fun bind(data: TraditionalDance) {
            with(binding) {
                imgDancePhoto.load(data.image)
                txtName.text = data.name
                txtPlaceOfOrigin.text = data.placeOfOrigin
                txtDescription.text = data.description

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                        .apply { putExtra(DetailActivity.EXTRA_TRADITIONAL_DANCE, data) }
                        .also { itemView.context.startActivity(it) }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_row_dance, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(traditionalDanceList[position])
    }

    override fun getItemCount(): Int = traditionalDanceList.size

    fun setActivity(activity: MainActivity) {
        this.mainActivity = activity
    }
}