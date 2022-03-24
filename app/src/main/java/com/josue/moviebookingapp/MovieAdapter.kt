package com.josue.moviebookingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class MovieAdapter(private val movieList: ArrayList<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_template, parent,false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]
        holder.movieImage.setImageResource(currentMovie.movieImage)
        holder.movieTitle.text = currentMovie.movieTitle
        holder.movieCert.setImageResource(currentMovie.movieCert)
        holder.movieStarring.text = currentMovie.movieStarring
        holder.movieTime.text = currentMovie.movieTime
        holder.movieSeats.text = currentMovie.movieSeats_remaining
        //holder.movieDescription.text = currentMovie.movieDescription
        //holder.movieSeatsIcon.setImageResource(R.drawable.SEATS IMAGE HERE)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieCert: ImageView = itemView.findViewById(R.id.movieCert)
        val movieStarring: TextView = itemView.findViewById(R.id.movieStarring)
        val movieTime: TextView = itemView.findViewById(R.id.movieTime)
        val movieSeats: TextView = itemView.findViewById(R.id.movieSeats)
        //val movieDescription: TextView = itemView.findViewById(R.id.movieDescription)
        //val movieSeatsIcon: ImageView = itemView.findViewById(R.id.movieIconSeats)
    }
}



