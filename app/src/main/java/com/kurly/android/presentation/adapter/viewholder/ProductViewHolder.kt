package com.kurly.android.presentation.adapter.viewholder

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.kurly.android.R
import com.kurly.android.data.model.Product
import com.kurly.android.presentation.prefs.ProductSharedPreference

abstract class ProductViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(product: Product)

    protected fun setProductImage(imageUrl: String?) {
        binding.setVariable(BR.imageUrl, imageUrl)
    }

    protected fun setProductName(name: String?) {
        binding.setVariable(BR.name, name)
    }

    protected fun setProductLike(like: Boolean) {
        binding.setVariable(BR.like, like)
    }

    protected fun setProductPrice(originalPrice: Int, discountedPrice: Int?) {
        if (discountedPrice != null) {
            val discountRate =
                ((originalPrice - discountedPrice) / originalPrice.toFloat() * 100).toInt()
            binding.setVariable(BR.discountAmount, "${discountRate}%")
            binding.setVariable(BR.originalPrice, "${originalPrice}원")
            binding.setVariable(BR.discountedPrice, "${discountedPrice}원")
        } else {
            binding.setVariable(BR.discountedPrice, "${originalPrice}원")
        }
    }

    fun setLikeButtonClickListener(product: Product, prefs: ProductSharedPreference) {
        val likeButton = binding.root.findViewById<ImageView>(R.id.like_image_view)
        likeButton.setOnClickListener {
            val isLiked = !prefs.isProductLike(product.id)
            setProductLike(isLiked)
            prefs.setProductLike(product.id, isLiked)
        }
    }
}