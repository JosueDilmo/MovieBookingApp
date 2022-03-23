package com.josue.moviebookingapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class MovieAdapter(private val movies: Array<Movie>, private val resultLauncher: ActivityResultLauncher<Intent>, private val context: Context):
    RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.recycle_template, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = movies[position]
        val imageView = holder.itemView.findViewById<ImageView>(R.id.movieImage) // should load image from Movie class
        Picasso.get()
            .load(R.drawable.test_img)
            .placeholder(ContextCompat.getDrawable(context, R.drawable.test_img)!!)
            .error(ContextCompat.getDrawable(context, R.drawable.ic_launcher_background)!!)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .into(imageView)
        holder.itemView.findViewById<TextView>(R.id.movieName).text = movies.name //name of the movie in Movie class
        holder.itemView.findViewById<TextView>(R.id.movieCert).text = movies.certification //image is set in the recycler template, certification in Movie class
        //holder.itemView.findViewById<ListView>(R.id.movieStarringList).text = movies.starring.toString() //should load starring array from Movie Class
        holder.itemView.findViewById<TextView>(R.id.movieTime).text = movies.running_time_mins.toString() //should load movie time from Movie Class
        holder.itemView.findViewById<TextView>(R.id.movieSeats).text = movies.seats_remaining.toString()
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}
class MoviesViewHolder (val v: View): RecyclerView.ViewHolder(v)

