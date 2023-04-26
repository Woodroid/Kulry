package com.kurly.android.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kurly.android.data.model.Product
import com.kurly.android.databinding.ProductHorizontalListItemBinding
import com.kurly.android.presentation.prefs.ProductSharedPreference

class ProductHorizontalViewHolder(
    private val binding: ProductHorizontalListItemBinding,
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