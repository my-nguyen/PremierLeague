package com.theandroidfactory.premierleague

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.squareup.picasso.Picasso
import com.theandroidfactory.premierleague.databinding.FragmentDetailBinding

private const val TAG = "DetailFragment-Truong"

class DetailFragment: BaseFragment(R.layout.fragment_detail) {
    private val club: Club by lazy {
        mainActivity.clubs.find {
            it.id == requireArguments().getString("EXTRA_CLUB_ID")
        } ?: Club()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle("Club Info")
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val binding = FragmentDetailBinding.bind(view)
        binding.apply {
            title.text = club.title
            description.text = club.description
            descriptionLong.text = club.descriptionLong
        }
        Picasso.get().load(club.imageUrl).into(binding.image)

        requireActivity().addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_detail, menu)
                if (club.isFavorite) {
                    menu.findItem(R.id.menu_favorite)?.setIcon(R.drawable.ic_favorite)
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    android.R.id.home -> {
                        mainActivity.supportFragmentManager.popBackStack()
                        true
                    }
                    R.id.menu_link -> {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(club.officialUrl)))
                        true
                    }
                    R.id.menu_favorite -> {
                        menuItem.setIcon(if (club.isFavorite) R.drawable.ic_favorite_outline else R.drawable.ic_favorite)
                        club.isFavorite = !club.isFavorite
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}