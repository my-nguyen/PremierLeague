package com.theandroidfactory.premierleague

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theandroidfactory.premierleague.databinding.ItemClubBinding

class ClubsAdapter(private val clubs: List<Club>, private val listener: OnClickListener): RecyclerView.Adapter<ClubsAdapter.ViewHolder>() {
    interface OnClickListener {
        fun onButtonClicked(position: Int)
        fun onFavoriteClicked(position: Int)
    }

    inner class ViewHolder(private val binding: ItemClubBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(club: Club) {
            binding.apply {
                image.setImageResource(club.imageResId)
                title.text = club.title
                description.text = club.description
                button.setOnClickListener {
                    listener.onButtonClicked(adapterPosition)
                }
                favorite.setImageResource(if (club.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_outline)
                favorite.setOnClickListener {
                    listener.onFavoriteClicked(adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemClubBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = clubs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clubs[position])
    }
}