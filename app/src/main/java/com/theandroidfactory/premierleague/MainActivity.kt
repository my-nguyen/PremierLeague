package com.theandroidfactory.premierleague

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.theandroidfactory.premierleague.databinding.ActivityMainBinding

private const val TAG = "MainActivity-Truong"

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ClubsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Premier League Home"
        MyApplication.clubs = getClubs()
        adapter = ClubsAdapter(MyApplication.clubs, object: ClubsAdapter.OnClickListener {
            override fun onButtonClicked(position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("EXTRA_CLUB_ID", MyApplication.clubs[position].id)
                }
                startActivity(intent)
            }

            override fun onFavoriteClicked(position: Int) {
                MyApplication.clubs[position].isFavorite = !MyApplication.clubs[position].isFavorite
                adapter.notifyItemChanged(position)
            }
        })

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    private fun getClubs(): List<Club> {
        return mutableListOf<Club>().apply {
            add(
                Club(
                    "arsenal",
                    "Arsenal",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a single line",
                    "Learn more",
                    R.drawable.arsenal,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F707909635156348949%2F&psig=AOvVaw3LD-FAMIEWSrHUuNjvHtKx&ust=1678072761553000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCNjbzajqw_0CFQAAAAAdAAAAABAE",
                    "https://www.arsenal.com/"
                )
            )
            add(
                Club(
                    "man_city",
                    "Manchester City",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a single line",
                    "Learn more",
                    R.drawable.man_city,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2Fmanchester-city-twitter-header--707909635156348947%2F&psig=AOvVaw1oW573U6OyYJtDhCggcTJ6&ust=1678072656784000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCMDMxPbpw_0CFQAAAAAdAAAAABAE",
                    "https://www.mancity.com/"
                )
            )
            add(
                Club(
                    "man_united",
                    "Manchester United",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a single line",
                    "Learn more",
                    R.drawable.man_united,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2Fmanchester-united-twitter-header--526499012685938517%2F&psig=AOvVaw3R0K3M80JsOJbXCa2piAO0&ust=1678072099509000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCPD47ovqw_0CFQAAAAAdAAAAABAE",
                    "https://www.manutd.com/"
                )
            )
            add(
                Club(
                    "tottenham",
                    "Tottenham Hotspur",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a single line",
                    "Learn more",
                    R.drawable.tottenham,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Ff-edits.tumblr.com%2Fpost%2F151100205100%2Ftottenham-hotspur-twitter-header&psig=AOvVaw0Y8J1XHoWxDlsmts04vnRI&ust=1678072810565000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCOjE_b_qw_0CFQAAAAAdAAAAABAE",
                    "https://www.tottenhamhotspur.com/"
                )
            )
            add(
                Club(
                    "chelsea",
                    "Chelsea",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a single line",
                    "Learn more",
                    R.drawable.chelsea,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Ff-edits.tumblr.com%2Fpost%2F150435158577%2Fchelsea-twitter-header&psig=AOvVaw3YlI4FrFIcLlB9ZNw_k1te&ust=1678072837414000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCPC75szqw_0CFQAAAAAdAAAAABAE",
                    "https://www.chelseafc.com/en"
                )
            )
            add(
                Club(
                    "leicester_city",
                    "Leicester City",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a single line",
                    "Learn more",
                    R.drawable.leicester_city,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Ftwitter.com%2FF_Edits%2Fstatus%2F773110666102267904&psig=AOvVaw09E-NjBhKa-s2GLIMJ--eS&ust=1678072935728000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCKjZ1Pvqw_0CFQAAAAAdAAAAABAE",
                    "https://www.lcfc.com/?lang=en"
                )
            )
        }
    }
}
