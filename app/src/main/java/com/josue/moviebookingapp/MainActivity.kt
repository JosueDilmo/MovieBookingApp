package com.josue.moviebookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList : ArrayList<Movie>
    lateinit var movieImage : Array<Int>
    lateinit var movieTitle : Array<String>
    lateinit var movieCert: Array<Int>
    lateinit var movieStarring: Array<String>
    lateinit var movieTime: Array<String>
    lateinit var movieSeatsRemaining: Array<Int>
    lateinit var movieSeatsSelected: Array<String>
    lateinit var movieDescription: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieImage = arrayOf(
            R.drawable.ambulance,
            R.drawable.sing,
            R.drawable.the_bad_guys,
            R.drawable.uncharted,
            R.drawable.the_batman,
            R.drawable.nan_movie
        )

        movieTitle = arrayOf(
            "Ambulance",
            "Sing 2",
            "The Bad Guys",
            "Uncharted",
            "The Batman",
            "The Nan Movie"
        )

        movieCert = arrayOf(
            R.drawable.cert_15a,
            R.drawable.cert_g,
            R.drawable.cert_g,
            R.drawable.cert_12a,
            R.drawable.cert_15a,
            R.drawable.cert_15a
        )

        movieStarring = arrayOf(
            "Eiza González, Jake Gyllenhaal, Yahya Abdul-Mateen II",
            "Reese Witherspoon, Matthew McConaughey, Scarlett Johansson",
            "Craig Robinson, Marc Maron, Sam Rockwell",
            "Tom Holland, Mark Wahlberg, Antonio Banderas",
            "Robert Pattinson, Zoe Kravitz, Paul Dano, Colin Farrell",
            "Catherine Tate, Mathew Horne, Katherine Parkinson"
        )
        movieTime = arrayOf(
            "2hrs 16mins",
            "1hr 50mins",
            "1hr 40mins",
            "1hr 56mins",
            "2hrs 55mins",
            "1hr 35mins"
        )
        movieSeatsRemaining = arrayOf(
            (0..15).random(),
            (0..15).random(),
            (0..15).random(),
            (0..15).random(),
            (0..15).random(),
            (0..15).random()
        )

        movieSeatsSelected = arrayOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6"
        )

        movieDescription = arrayOf(
            "\"Over one day across the streets of L.A., three lives will change forever.\"",
            "\"Can-do koala Buster Moon and his all-star cast of animal performers prepare to launch their most dazzling stage extravaganza yet... in the glittering entertainment capital of the world.\"",
            "\"In the new action comedy from DreamWorks Animation, based on the New York Times best-selling book series, a crackerjack criminal crew of animal outlaws are about to attempt their most challenging con yet - becoming model citizens.\"",
            "\"Street-smart Nathan Drake (Tom Holland) is recruited by seasoned treasure hunter Victor \"Sully\" Sullivan (Mark Wahlberg) to recover a fortune amassed by Ferdinand Magellan and lost 500 years ago by the House of Moncada.\"",
            "\"From Warner Bros. Pictures comes \"The Batman,\" with director Matt Reeves (the \"Planet of the Apes\" films) at the helm and with Robert Pattinson (\"Tenet,\" \"The Lighthouse,\" \"Good Time\") starring as Gotham City's vigilante detective, Batman.\"",
            "\"Catherine Tate's iconic character Nan hits the big screen as she goes on a wild road trip from London to Ireland with her grandson Jamie (Mathew Horne) to make amends with her estranged sister Nell (Katherine Parkinson).\""
        )

        newRecyclerView = findViewById(R.id.movieRecycle)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()


    }

    private fun getUserData() {
        for (i in movieImage.indices ){
            val movies = Movie(movieImage[i],movieTitle[i],movieCert[i],movieStarring[i],movieTime[i],
                movieSeatsRemaining[i],movieSeatsSelected[i],movieDescription[i])
            newArrayList.add(movies)
        }

        var adapter = MovieAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object: MovieAdapter.onItemClickListener{
            override fun onItemClick(position: Int){
                Toast.makeText(this@MainActivity,"Clicked item number $position", Toast.LENGTH_SHORT).show()

            }
        })





    }

}