package com.kurly.android.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kurly.android.data.model.Product
import com.kurly.android.databinding.ProductVerticalListItemBinding
import com.kurly.android.presentation.adapter.diffutil.ProductDiffCallback
import com.kurly.android.presentation.adapter.viewholder.ProductVerticalViewHolder
import com.kurly.android.presentation.prefs.ProductSharedPreference
import javax.inject.Inject

class ProductVerticalAdapter @Inject constructor(private val prefs: ProductSharedPreference): ListAdapter<Product, ProductVerticalViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVerticalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductVerticalViewHolder(ProductVerticalListItemBinding.inflate(layoutInflater, parent, false), prefs)
    }

    override fun onBindViewHolder(holder: ProductVerticalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}