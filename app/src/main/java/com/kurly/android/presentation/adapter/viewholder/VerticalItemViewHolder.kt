package com.kurly.android.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kurly.android.databinding.VerticalListItemBinding

class VerticalItemViewHolder(private val binding: VerticalListItemBinding): ViewHolder(binding.root) {

    fun bind() {
        binding.executePendingBindings()
    }
}