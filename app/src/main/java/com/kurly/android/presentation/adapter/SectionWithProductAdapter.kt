package com.kurly.android.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kurly.android.R
import com.kurly.android.data.model.SectionWithProduct
import com.kurly.android.databinding.GridListItemBinding
import com.kurly.android.databinding.HorizontalListItemBinding
import com.kurly.android.databinding.VerticalListItemBinding
import com.kurly.android.presentation.adapter.viewholder.GridItemViewHolder
import com.kurly.android.presentation.adapter.viewholder.HorizontalItemViewHolder
import com.kurly.android.presentation.adapter.viewholder.VerticalItemViewHolder

class SectionWithProductAdapter :
    PagingDataAdapter<SectionWithProduct, ViewHolder>(SectionWithProductDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is VerticalItemViewHolder -> {
                holder.bind()
            }
            is HorizontalItemViewHolder -> {
                holder.bind()
            }
            is GridItemViewHolder -> {
                holder.bind()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            R.layout.vertical_list_item -> {
                VerticalItemViewHolder(
                    VerticalListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.horizontal_list_item -> {
                HorizontalItemViewHolder(
                    HorizontalListItemBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
            }
            else -> {
                GridItemViewHolder(
                    GridListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        var itemViewType = R.layout.grid_list_item
        val item = getItem(position)
        when (item?.type) {
            "VERTICAL" -> {
                itemViewType = R.layout.vertical_list_item
            }
            "HORIZONTAL" -> {
                itemViewType = R.layout.horizontal_list_item
            }
        }
        return itemViewType
    }

}