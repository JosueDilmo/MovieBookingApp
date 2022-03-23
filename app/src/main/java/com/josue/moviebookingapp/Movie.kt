package com.josue.moviebookingapp

class Movie {
    var name: String = "Movie Name"
    var image: String = "Movie Image"
    var certification: String = "Movie Certification"
    var description: String = "Movie Description"
    var starring = arrayOf(
            "First actor",
            "Second actor",
            "Third actress"
    )
    //Have to convert to hours + mins
    var running_time_mins: Int = 0
    var seats_remaining: Int = (0..15).random()
    var seats_selected: Int = 0
}