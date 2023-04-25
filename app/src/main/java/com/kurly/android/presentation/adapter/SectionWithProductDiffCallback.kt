package com.kurly.android.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kurly.android.data.model.SectionWithProduct

class SectionWithProductDiffCallback : DiffUtil.ItemCallback<SectionWithProduct>() {
    override fun areItemsTheSame(oldItem: SectionWithProduct, newItem: SectionWithProduct
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: SectionWithProduct,
        newItem: SectionWithProduct
    ): Boolean {
        return oldItem.title == newItem.title
    }
}