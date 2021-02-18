package com.example.android_pemula_traditional_dance.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

fun ImageView.load(imageSource : Any?, radius : Int = 16) {
    Glide.with(context.applicationContext)
        .load(imageSource)
        .transition(DrawableTransitionOptions.withCrossFade(getDrawableFactory()))
        .apply(
            RequestOptions().transform(CenterCrop(), RoundedCorners(radius))
        )
        .into(this)
}

private fun getDrawableFactory() : DrawableCrossFadeFactory {
    return DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
}