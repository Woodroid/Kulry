package com.kurly.android.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kurly.android.data.model.Product
import com.kurly.android.databinding.ProductGridListItemBinding
import com.kurly.android.presentation.adapter.diffutil.ProductDiffCallback
import com.kurly.android.presentation.adapter.viewholder.ProductGridViewHolder
import com.kurly.android.presentation.prefs.ProductSharedPreference
import javax.inject.Inject

class ProductGridAdapter @Inject constructor(private val prefs: ProductSharedPreference): ListAdapter<Product, ProductGridViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductGridViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductGridViewHolder(ProductGridListItemBinding.inflate(layoutInflater, parent, false), prefs)
    }

    override fun onBindViewHolder(holder: ProductGridViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
