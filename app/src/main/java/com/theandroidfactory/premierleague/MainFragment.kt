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
                    addToBackStack(null)
                    replace(R.id.fragment_container_view, DetailFragment().apply {
                        arguments = Bundle().apply {
                            putString("EXTRA_CLUB_ID", clubs[position].id)
                        }
                    })
                }
            }

            override fun onFavoriteClicked(position: Int) {
                clubs[position].isFavorite = !clubs[position].isFavorite
                adapter.notifyItemChanged(position)
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