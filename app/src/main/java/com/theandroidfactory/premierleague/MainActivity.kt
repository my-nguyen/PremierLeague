package com.theandroidfactory.premierleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.theandroidfactory.premierleague.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clubs = getClubs()
        val adapter = ClubsAdapter(clubs)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
//        adapter.notifyDataSetChanged()
    }

    private fun getClubs(): List<Club> {
        return mutableListOf<Club>().apply {
            add(
                Club(
                    "arsenal",
                    "Arsenal",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a",
                    "Learn more",
                    R.drawable.arsenal,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F707909635156348949%2F&psig=AOvVaw3LD-FAMIEWSrHUuNjvHtKx&ust=1678072761553000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCNjbzajqw_0CFQAAAAAdAAAAABAE"
                )
            )
            add(
                Club(
                    "man_city",
                    "Manchester City",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a",
                    "Learn more",
                    R.drawable.man_city,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2Fmanchester-city-twitter-header--707909635156348947%2F&psig=AOvVaw1oW573U6OyYJtDhCggcTJ6&ust=1678072656784000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCMDMxPbpw_0CFQAAAAAdAAAAABAE"
                )
            )
            add(
                Club(
                    "man_united",
                    "Manchester United",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a",
                    "Learn more",
                    R.drawable.man_united,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2Fmanchester-united-twitter-header--526499012685938517%2F&psig=AOvVaw3R0K3M80JsOJbXCa2piAO0&ust=1678072099509000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCPD47ovqw_0CFQAAAAAdAAAAABAE"
                )
            )
            add(
                Club(
                    "tottenham",
                    "Tottenham Hotspur",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a",
                    "Learn more",
                    R.drawable.tottenham,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Ff-edits.tumblr.com%2Fpost%2F151100205100%2Ftottenham-hotspur-twitter-header&psig=AOvVaw0Y8J1XHoWxDlsmts04vnRI&ust=1678072810565000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCOjE_b_qw_0CFQAAAAAdAAAAABAE"
                )
            )
            add(
                Club(
                    "chelsea",
                    "Chelsea",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a",
                    "Learn more",
                    R.drawable.chelsea,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Ff-edits.tumblr.com%2Fpost%2F150435158577%2Fchelsea-twitter-header&psig=AOvVaw3YlI4FrFIcLlB9ZNw_k1te&ust=1678072837414000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCPC75szqw_0CFQAAAAAdAAAAABAE"
                )
            )
            add(
                Club(
                    "leicester_city",
                    "Leicester City",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a",
                    "Learn more",
                    R.drawable.leicester_city,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Ftwitter.com%2FF_Edits%2Fstatus%2F773110666102267904&psig=AOvVaw09E-NjBhKa-s2GLIMJ--eS&ust=1678072935728000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCKjZ1Pvqw_0CFQAAAAAdAAAAABAE"
                )
            )
        }
    }
}

// man united: https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2Fmanchester-united-twitter-header--526499012685938517%2F&psig=AOvVaw3R0K3M80JsOJbXCa2piAO0&ust=1678072099509000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCPD47ovqw_0CFQAAAAAdAAAAABAE
// man city: https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2Fmanchester-city-twitter-header--707909635156348947%2F&psig=AOvVaw1oW573U6OyYJtDhCggcTJ6&ust=1678072656784000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCMDMxPbpw_0CFQAAAAAdAAAAABAE
// arsenal: https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F707909635156348949%2F&psig=AOvVaw3LD-FAMIEWSrHUuNjvHtKx&ust=1678072761553000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCNjbzajqw_0CFQAAAAAdAAAAABAE
// tottenham: https://www.google.com/url?sa=i&url=https%3A%2F%2Ff-edits.tumblr.com%2Fpost%2F151100205100%2Ftottenham-hotspur-twitter-header&psig=AOvVaw0Y8J1XHoWxDlsmts04vnRI&ust=1678072810565000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCOjE_b_qw_0CFQAAAAAdAAAAABAE
// chelsea: https://www.google.com/url?sa=i&url=https%3A%2F%2Ff-edits.tumblr.com%2Fpost%2F150435158577%2Fchelsea-twitter-header&psig=AOvVaw3YlI4FrFIcLlB9ZNw_k1te&ust=1678072837414000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCPC75szqw_0CFQAAAAAdAAAAABAE
// leicester city: https://www.google.com/url?sa=i&url=https%3A%2F%2Ftwitter.com%2FF_Edits%2Fstatus%2F773110666102267904&psig=AOvVaw09E-NjBhKa-s2GLIMJ--eS&ust=1678072935728000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCKjZ1Pvqw_0CFQAAAAAdAAAAABAE
