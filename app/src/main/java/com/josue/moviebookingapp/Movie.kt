package com.josue.moviebookingapp

data class Movie(
    var movieImage: Int, //should be String
    var movieTitle: String,
    var movieCert: Int, //should be String
    var movieStarring: String, // should be Array<String>
    var movieTime: String, // should be Int, Have to convert to hours + mins
    var movieSeatsRemaining: Int,
    var movieSeatsSelected: Int, // should be Int
    var movieDescription: String,
    //var movieIconSeats: Int
)
