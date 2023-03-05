package com.theandroidfactory.premierleague

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.theandroidfactory.premierleague.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Club Overview"
        }
        val backup = Club(title = "Whoops", description = "Something went wrong, please try again")
        val club = intent.getSerializableExtra("EXTRA_CLUB") as Club ?: backup
        binding.apply {
            image.setImageResource(club.imageResId)
            title.text = club.title
            description.text = club.description
            descriptionLong.text = club.descriptionLong
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}