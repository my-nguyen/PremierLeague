package com.theandroidfactory.premierleague

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.theandroidfactory.premierleague.databinding.ActivityMainBinding

private const val TAG = "MainActivity-Truong"

class MainActivity : AppCompatActivity() {
    lateinit var clubs: List<Club>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clubs = generateClubs()

        // reference: https://developer.android.com/guide/fragments/create?gclid=CjwKCAiAu5agBhBzEiwAdiR5tMhS9WEkeY84w2nB2WcMPiH5XeTk9t-XpO4LGQjAP-JexaZfhGT7DRoClKoQAvD_BwE&gclsrc=aw.ds
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view, MainFragment())
        }
    }

    private fun generateClubs(): List<Club> {
        return mutableListOf<Club>().apply {
            add(
                Club(
                    "arsenal",
                    "Arsenal",
                    "Description of the club",
                    "A longer description of the club that wouldn't fit on a single line",
                    "Learn more",
                    R.drawable.arsenal,
                    "https://i.pinimg.com/originals/00/b9/57/00b957e908fd86d72b3e014892d4b895.jpg",
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
                    "https://i.pinimg.com/originals/8f/11/48/8f11480ce075ee1ad4f006f8e4f2be8d.jpg",
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
                    "https://i.pinimg.com/originals/8f/85/15/8f85159ed8306846b050386384893c1e.jpg",
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
                    "https://64.media.tumblr.com/7474355861d4269d4f27e91986895b8f/tumblr_odrogoBumv1ude0uno1_500h.jpg",
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
                    "https://64.media.tumblr.com/4163bc45d59f167c164b84cc7cfd5f9c/tumblr_od5gi53Zgi1ude0uno1_500h.jpg",
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
                    "https://pbs.twimg.com/media/Crqj7hGW8AAhXJW.jpg",
                    "https://www.lcfc.com/?lang=en"
                )
            )
        }
    }
}
