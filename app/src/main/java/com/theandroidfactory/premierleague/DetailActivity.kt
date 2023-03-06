package com.theandroidfactory.premierleague

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.theandroidfactory.premierleague.databinding.ActivityDetailBinding

private const val TAG = "DetailActivity-Truong"
class DetailActivity: AppCompatActivity() {
    private lateinit var club: Club

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Club Overview"
        }
        val backup = Club(title = "Whoops", description = "Something went wrong, please try again")
        club = intent.getSerializableExtra("EXTRA_CLUB") as Club ?: backup
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
            R.id.menu_link -> {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(club.officialUrl)))
                true
            }
            R.id.menu_favorite -> {
                item.setIcon(if (club.isFavorite) R.drawable.ic_favorite_outline else R.drawable.ic_favorite)
                club.isFavorite = !club.isFavorite
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        if (club.isFavorite) {
            menu?.findItem(R.id.menu_favorite)?.setIcon(R.drawable.ic_favorite)
        }
        return true
    }
}