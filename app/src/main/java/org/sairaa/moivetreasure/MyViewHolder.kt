package org.sairaa.moivetreasure

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.sairaa.moivetreasure.Model.MovieT

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mAdapterCallBack: MovieListAdapter.MovieAdapterCallback?=null
    val textV:TextView = itemView.findViewById(R.id.textViewItem);
    fun set(movie: MovieT) {
        textV.setText(movie.title)
        textV.setOnClickListener { view: View? ->
            mAdapterCallBack!!.navigateToDetailActivity(movie)
        }

    }

    fun setAdapterCallback(listener: MovieListAdapter.MovieAdapterCallback?) {
        mAdapterCallBack= listener

    }


}
