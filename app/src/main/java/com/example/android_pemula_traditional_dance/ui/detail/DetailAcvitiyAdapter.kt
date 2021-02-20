package com.example.android_pemula_traditional_dance.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_pemula_traditional_dance.R
import com.example.android_pemula_traditional_dance.databinding.ItemRowDetailImagesBinding
import com.example.android_pemula_traditional_dance.util.load

class DetailAcvitiyAdapter(private val listImages: List<Int>, private val context: Context) :
    RecyclerView.Adapter<DetailAcvitiyAdapter.ViewHolder>() {

    private lateinit var detailActivity: DetailActivity

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding : ItemRowDetailImagesBinding = ItemRowDetailImagesBinding.bind(itemView)

        fun bind(data : Int) {
            binding.ivImages.load(data)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailAcvitiyAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_row_detail_images, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DetailAcvitiyAdapter.ViewHolder, position: Int) {
        holder.bind(listImages[position])
    }

    override fun getItemCount(): Int = listImages.size

    fun setActivity(activity: DetailActivity) {
        this.detailActivity = activity
    }
}