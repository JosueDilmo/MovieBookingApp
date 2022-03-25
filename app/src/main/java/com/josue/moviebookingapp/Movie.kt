package com.josue.moviebookingapp

data class Movie(
    var movieImage: Int, //should be String
    var movieTitle: String,
    var movieCert: Int, //should be String
    var movieStarring: String, // should be Array<String>
    var movieTime: String, // should be Int, Have to convert to hours + mins
    var movieSeatsRemaining: String, // should be Int, //= (0..15).random()
    var movieSeatsSelected: String, // should be Int AND not used in MovieAdapter yet
    var movieDescription: String
)
