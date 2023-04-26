package com.kurly.android

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop

object AdapterBindings {

    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    fun loadImageWithRadius(
        view: ImageView, url: String?,
    ) {
        val multiTransformation = MultiTransformation(CenterCrop())
        Glide.with(view).load(url).transform(multiTransformation).into(view)
    }

}