package com.kurly.android.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kurly.android.databinding.GridListItemBinding

class GridItemViewHolder(private val binding: GridListItemBinding) : ViewHolder(binding.root) {

    fun bind() {
        binding.executePendingBindings()
    }

}