package com.ren.onlinestore.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ren.onlinestore.R

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .fallback(R.drawable.fallback_image)
        .into(this)
}