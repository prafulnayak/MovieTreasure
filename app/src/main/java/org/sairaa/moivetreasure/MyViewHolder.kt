package org.sairaa.moivetreasure

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import org.sairaa.moivetreasure.Model.MovieT

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mAdapterCallBack: MovieListAdapter.MovieAdapterCallback?=null
    val titleT:TextView = itemView.findViewById(R.id.textViewitem);
    val ratingT:TextView = itemView.findViewById(R.id.textViewRating);
    val imageM:ImageView = itemView.findViewById(R.id.imageView);

    var circularProgressDrawable: CircularProgressDrawable = CircularProgressDrawable(itemView.context)  //= new CircularProgressDrawable(mCtx);

//    circularProgressDrawable..setStrokeWidth(5f);
//    circularProgressDrawable.setCenterRadius(30f);
//    circularProgressDrawable.start();

    fun set(movie: MovieT) {
        titleT.setText(movie.title)
        ratingT.setText(movie.imdbRating)
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
