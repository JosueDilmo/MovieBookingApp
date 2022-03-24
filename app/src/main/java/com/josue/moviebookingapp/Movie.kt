package com.josue.moviebookingapp

data class Movie(
    var movieImage: Int, //should be String
    var movieTitle: String,
    var movieCert: Int, //should be String
    var movieDescription: String,
    var movieStarring: String, // should be Array<String>
    //Have to convert to hours + mins
    var movieTime: String, // should be Int,
    var movieSeats_remaining: String, // should be Int, //= (0..15).random()
    //var movieSeats_selected: String // should be Int AND not used in MovieAdapter yet
)
