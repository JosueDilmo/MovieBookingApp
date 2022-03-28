package com.josue.moviebookingapp

import android.content.Intent
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
    lateinit var movieSeatsSelected: Array<Int>
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
            getString(R.string.Ambulance_casting),
            getString(R.string.Sing2_casting),
            getString(R.string.TheBadGuys_casting),
            getString(R.string.Uncharted_casting),
            getString(R.string.TheBatman_casting),
            getString(R.string.TheNan_casting)
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
            0,
            0,
            0,
            0,
            0,
            0
        )

        movieDescription = arrayOf(
            getString(R.string.Ambulance),
            getString(R.string.Sing_2),
            getString(R.string.The_Bad_Guys),
            getString(R.string.Uncharted),
            getString(R.string.The_Batman),
            getString(R.string.The_Nan_Movie)

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
                //Toast.makeText(this@MainActivity,"Clicked item number $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, MovieActivity::class.java)
                intent.putExtra("movieImage",newArrayList[position].movieImage)
                intent.putExtra("movieTitle",newArrayList[position].movieTitle)
                intent.putExtra("movieCert",newArrayList[position].movieCert)
                intent.putExtra("movieStarring",newArrayList[position].movieStarring)
                intent.putExtra("movieTime",newArrayList[position].movieTime)
                intent.putExtra("movieSeatsRemaining",newArrayList[position].movieSeatsRemaining)
                intent.putExtra("movieSeatsSelected",newArrayList[position].movieSeatsSelected)
                intent.putExtra("movieDescription",newArrayList[position].movieDescription)
                startActivity(intent)
            }
        })





    }

}