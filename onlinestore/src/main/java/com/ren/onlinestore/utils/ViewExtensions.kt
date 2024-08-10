package com.ren.onlinestore.utils

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.snackbar.Snackbar
import com.ren.onlinestore.R

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .fallback(R.drawable.fallback_image)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>,
                isFirstResource: Boolean
            ): Boolean {
                Log.e("image", e?.message ?: "Unknown error: Image not loaded", e)
                return false
            }

            override fun onResourceReady(
                resource: Drawable,
                model: Any,
                target: Target<Drawable>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean = false
        })
        .into(this)
}

fun View.showSnackbar(message: String, duration: Int) {
    Snackbar.make(this, message, duration).show()
}