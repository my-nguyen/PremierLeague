package com.theandroidfactory.premierleague

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

private const val TAG = "DetailFragment-Truong"

class DetailFragment: Fragment(R.layout.fragment_detail) {
    private val club: Club by lazy {
        (activity as MainActivity).clubs.find {
            it.id == requireArguments().getString("EXTRA_CLUB_ID")
        } ?: Club()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "Club: $club")
    }
}