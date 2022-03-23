package com.josue.moviebookingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    lateinit var movieSeats: Array<String>
    //lateinit var movieSeats_remaining: Array<String>
    //lateinit var movieSeats_selected: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieImage = arrayOf(
            R.drawable.test_img,
            R.drawable.test_img,
            R.drawable.test_img,
            R.drawable.test_img,
            R.drawable.test_img,
            R.drawable.test_img
        )

        movieTitle = arrayOf(
            "Title ONE",
            "Title TWO",
            "Title THREE",
            "Title FOUR",
            "Title FIVE",
            "Title SIX"
        )

        movieCert = arrayOf(
            R.drawable.test_cert,
            R.drawable.test_cert,
            R.drawable.test_cert,
            R.drawable.test_cert,
            R.drawable.test_cert,
            R.drawable.test_cert
        )

        movieStarring = arrayOf(
            "Actor one",
            "Actor two",
            "Actor three",
            "Actress One",
            "Actress two",
            "Actress three"
        )
        movieTime = arrayOf(
            "##time",
            "##time",
            "##time",
            "##time",
            "##time",
            "##time"
        )
        movieSeats = arrayOf(
            "seats##",
            "seats##",
            "seats##",
            "seats##",
            "seats##",
            "seats##"
        )

        newRecyclerView = findViewById(R.id.movieRecycle)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()


    }

    private fun getUserData() {
        for (i in movieImage.indices ){
            val movies = Movie(movieImage[i],movieTitle[i],movieCert[i],movieStarring[i],movieTime[i],movieSeats[i])
            newArrayList.add(movies)
        }
        newRecyclerView.adapter = MovieAdapter(newArrayList)
    }
}