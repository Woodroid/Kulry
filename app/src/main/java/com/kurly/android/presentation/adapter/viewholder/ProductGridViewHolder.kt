package com.kurly.android.presentation.adapter.viewholder

import android.util.Log
import com.kurly.android.data.model.Product
import com.kurly.android.databinding.ProductGridListItemBinding
import com.kurly.android.presentation.prefs.ProductSharedPreference
import javax.inject.Inject

class ProductGridViewHolder @Inject constructor(
    private val binding: ProductGridListItemBinding,
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