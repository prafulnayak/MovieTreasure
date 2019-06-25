package org.sairaa.moivetreasure.Adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import org.sairaa.moivetreasure.Model.MovieT
import org.sairaa.moivetreasure.R

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var mAdapterCallBack: MovieListAdapter.MovieAdapterCallback?=null
    private val titleT:TextView = itemView.findViewById(R.id.textViewitem);
    private val ratingT:TextView = itemView.findViewById(R.id.textViewRating);
    private val imageM:ImageView = itemView.findViewById(R.id.imageView);

    private var circularProgressDrawable: CircularProgressDrawable = CircularProgressDrawable(itemView.context)


    fun set(movie: MovieT) {
        titleT.text = movie.title
        ratingT.text = movie.imdbRating
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(itemView.context)
            .load(movie.posterurl)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.ic_blur)
            // read original from cache (if present) otherwise download it and decode it
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .into(imageM);
        itemView.setOnClickListener { view: View? ->
            mAdapterCallBack!!.navigateToDetailActivity(movie)
        }

    }

    fun setAdapterCallback(listener: MovieListAdapter.MovieAdapterCallback?) {
        mAdapterCallBack= listener

    }


}
