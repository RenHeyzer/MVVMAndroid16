package com.ren.onlinestore.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ren.onlinestore.R

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .fallback(R.drawable.fallback_image)
        .into(this)
}

fun View.showSnackbar(message: String, duration: Int) {
    Snackbar.make(this, message, duration).show()
}