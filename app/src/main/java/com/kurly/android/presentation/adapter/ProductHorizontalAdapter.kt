package com.kurly.android.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kurly.android.data.model.Product
import com.kurly.android.databinding.ProductHorizontalListItemBinding
import com.kurly.android.presentation.adapter.diffutil.ProductDiffCallback
import com.kurly.android.presentation.adapter.viewholder.ProductHorizontalViewHolder
import com.kurly.android.presentation.prefs.ProductSharedPreference
import javax.inject.Inject

class ProductHorizontalAdapter @Inject constructor(private val prefs: ProductSharedPreference): ListAdapter<Product, ProductHorizontalViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHorizontalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductHorizontalViewHolder(ProductHorizontalListItemBinding.inflate(layoutInflater, parent, false), prefs)
    }

    override fun onBindViewHolder(holder: ProductHorizontalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}