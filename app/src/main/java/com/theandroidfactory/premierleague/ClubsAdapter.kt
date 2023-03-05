package com.theandroidfactory.premierleague

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.theandroidfactory.premierleague.databinding.ItemClubBinding

class ClubsAdapter(private val clubs: List<Club>): RecyclerView.Adapter<ClubsAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemClubBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(club: Club) {
            binding.apply {
                image.setImageResource(club.imageResId)
                title.text = club.title
                description.text = club.description
                button.setOnClickListener {
                    Toast.makeText(it.context, "$adapterPosition clicked", Toast.LENGTH_LONG).show()
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