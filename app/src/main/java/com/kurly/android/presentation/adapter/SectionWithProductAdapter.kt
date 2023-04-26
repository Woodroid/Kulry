package com.kurly.android.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.databinding.SectionWithProductListItemBinding
import com.kurly.android.presentation.adapter.diffutil.SectionWithProductDiffCallback
import com.kurly.android.presentation.adapter.viewholder.SectionWithProductViewHolder
import com.kurly.android.presentation.prefs.ProductSharedPreference
import javax.inject.Inject

/** 단일 뷰홀더 구현 */
class SectionWithProductAdapter @Inject constructor(private val productSharedPreference: ProductSharedPreference) :
    PagingDataAdapter<SectionWithProduct, SectionWithProductViewHolder>(SectionWithProductDiffCallback()) {

    override fun onBindViewHolder(holder: SectionWithProductViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionWithProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SectionWithProductViewHolder(SectionWithProductListItemBinding.inflate(layoutInflater, parent, false), productSharedPreference)
    }
}