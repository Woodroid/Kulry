package com.kurly.android.presentation.adapter.viewholder

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.databinding.SectionWithProductListItemBinding
import com.kurly.android.presentation.adapter.ProductGridAdapter
import com.kurly.android.presentation.adapter.ProductHorizontalAdapter
import com.kurly.android.presentation.adapter.ProductVerticalAdapter
import com.kurly.android.presentation.prefs.ProductSharedPreference
import javax.inject.Inject

class SectionWithProductViewHolder @Inject constructor(private val binding: SectionWithProductListItemBinding,
private val productSharedPreference: ProductSharedPreference): ViewHolder(binding.root) {

    companion object {
        const val GRID = "grid"
        const val HORIZONTAL = "horizontal"
        const val VERTICAL = "vertical"
    }

    private val mContext = binding.root.context

    fun bind(sectionWithProduct: SectionWithProduct) {
        binding.sectionTitle = sectionWithProduct.title

        when (sectionWithProduct.type) {
            GRID -> {
                val adapter = ProductGridAdapter(productSharedPreference)
                binding.productRecyclerView.adapter = adapter
                val layoutManager = GridLayoutManager(mContext, 3) // column count를 3으로 설정
                binding.productRecyclerView.layoutManager = layoutManager
                binding.productRecyclerView.post {
                    adapter.submitList(sectionWithProduct.products)
                }
            }
            HORIZONTAL -> {
                val adapter = ProductHorizontalAdapter(productSharedPreference)
                binding.productRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                binding.productRecyclerView.adapter = adapter
                adapter.submitList(sectionWithProduct.products)
            }
            VERTICAL -> {
                val adapter = ProductVerticalAdapter(productSharedPreference)
                binding.productRecyclerView.layoutManager = LinearLayoutManager(mContext)
                binding.productRecyclerView.adapter = adapter
                adapter.submitList(sectionWithProduct.products)
            }
            else -> {
                val adapter = ProductGridAdapter(productSharedPreference)
                binding.productRecyclerView.adapter = adapter
                binding.productRecyclerView.layoutManager = LinearLayoutManager(mContext)
                adapter.submitList(sectionWithProduct.products)
            }
        }

        binding.executePendingBindings()
    }

}