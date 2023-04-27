package com.kurly.android.presentation.adapter.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kurly.android.data.model.Product
import com.kurly.android.databinding.ProductVerticalListItemBinding
import com.kurly.android.presentation.prefs.ProductSharedPreference
import javax.inject.Inject

class ProductVerticalViewHolder @Inject constructor(
    private val binding: ProductVerticalListItemBinding,
    private val prefs: ProductSharedPreference
) : ProductViewHolder(binding) {

    override fun bind(product: Product) {
        setProductImage(product.image)
        setProductName(product.name)

        setProductPrice(
            originalPrice = product.originalPrice,
            discountedPrice = product.discountedPrice
        )

        setProductLike(prefs.isProductLike(product.id))
        setLikeButtonClickListener(product, prefs)

        binding.executePendingBindings()
    }
}