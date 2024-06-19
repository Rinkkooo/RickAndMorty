package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.rickandmorty.databinding.CharacterItemBinding
import com.example.rickandmorty.models.Character

class CartoonPagingAdapter :
    PagingDataAdapter<Character, CharacterViewHolder>(CharacterItemCallback()) {
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }
}

class CharacterItemCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}

class CharacterViewHolder(private val binding: CharacterItemBinding) : ViewHolder(binding.root) {
    fun bind(item: Character?) {
        binding.characterName.text = item?.name
        binding.characterStatus.text = item?.species
        Glide.with(binding.imgItem.context)
            .load(item?.image)
            .into(binding.imgItem)
    }

}
