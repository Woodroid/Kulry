package com.kurly.android.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kurly.android.databinding.HorizontalListItemBinding

class HorizontalItemViewHolder(private val binding: HorizontalListItemBinding): ViewHolder(binding.root) {


    fun bind() {

        binding.executePendingBindings()
    }
}