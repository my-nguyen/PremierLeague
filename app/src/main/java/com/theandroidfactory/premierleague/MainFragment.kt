package com.theandroidfactory.premierleague

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.theandroidfactory.premierleague.databinding.FragmentMainBinding

class MainFragment : BaseFragment(R.layout.fragment_main) {
    private lateinit var adapter: ClubsAdapter
    private val clubs: List<Club>
        get() = mainActivity.clubs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarTitle("Premier League")
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter = ClubsAdapter(clubs, object : ClubsAdapter.OnClickListener {
            override fun onButtonClicked(position: Int) {
                mainActivity.supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    // reference: https://developer.android.com/guide/fragments/animate
                    // setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
                    // setCustomAnimations(R.anim.slide_in, R.anim.fade_out, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    replace(R.id.fragment_container_view, DetailFragment().apply {
                        arguments = Bundle().apply {
                            putString("EXTRA_CLUB_ID", clubs[position].id)
                        }
                    })
                    addToBackStack(null)
                }
            }

            override fun onFavoriteClicked(position: Int) {
                val club = clubs[position]
                club.isFavorite = !club.isFavorite
                adapter.notifyItemChanged(position)
                Preferences.setFavoriteClub(club.id, club.isFavorite)
            }
        })

        FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}