package com.josue.moviebookingapp

import android.graphics.Color.green
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MovieActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        //variables for this class
        val movieImageLayout: ImageView = findViewById(R.id.movieImage)
        val movieTitleLayout: TextView = findViewById(R.id.movieTitle)
        val movieCertLayout: ImageView = findViewById(R.id.movieCert)
        val movieStarringLayout: TextView = findViewById(R.id.movieStarring)
        val movieTimeLayout: TextView = findViewById(R.id.movieTime)
        val movieSeatsRemainingLayout: TextView = findViewById(R.id.movieSeatsRemaining)
        val movieSeatsSelectedLayout: TextView = findViewById(R.id.movieSeatsSelected)
        val movieDescriptionLayout: TextView = findViewById(R.id.movieDescription)

        //getting data from the main act
        val bundle: Bundle? = intent.extras
        val movieTitle = bundle!!.getString("movieTitle")
        val movieImage = bundle.getInt("movieImage")
        val movieCert = bundle.getInt("movieCert")
        val movieStarring = bundle.getString("movieStarring")
        val movieTime = bundle.getString("movieTime")
        var movieSeatsRemaining = bundle.getInt("movieSeatsRemaining")
        var movieSeatsSelected = bundle.getInt("movieSeatsSelected")
        val movieDescription = bundle.getString("movieDescription")


        //connecting variables and layouts
        movieImageLayout.setImageResource(movieImage)
        movieTitleLayout.text = movieTitle
        movieCertLayout.setImageResource(movieCert)
        movieStarringLayout.text = movieStarring
        movieTimeLayout.text = movieTime
        movieSeatsRemainingLayout.text = movieSeatsRemaining.toString()
        movieSeatsSelectedLayout.text = movieSeatsSelected.toString()
        movieDescriptionLayout.text = movieDescription


        // add and remove seats
        // not working
        val seatsIcon: ImageView = findViewById(R.id.movieIconSeats)
        val seatsPlus: ImageView = findViewById(R.id.seatsIconPlus)
        val seatsMinus: ImageView = findViewById(R.id.seatsIconMinus)
        if (movieSeatsRemaining > 0) {
            movieSeatsSelectedLayout.visibility = View.VISIBLE
        } else movieSeatsSelectedLayout.visibility = View.GONE

        seatsPlus.setOnClickListener {
                movieSeatsSelected += 1
                movieSeatsRemaining -= 1
            }
       seatsMinus.setOnClickListener {
            movieSeatsSelected -= 1
            movieSeatsRemaining += 1

        }
        seatsIcon.setColorFilter(ContextCompat.getColor(this, R.color.green))

    }
}