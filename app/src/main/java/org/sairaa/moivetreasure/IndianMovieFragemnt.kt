package org.sairaa.moivetreasure

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_indian_movie_fragemnt.*
import org.sairaa.moivetreasure.Model.MovieT


class IndianMovieFragemnt(indianmovies: List<MovieT>) : Fragment() {

    private var movieDataList: List<MovieT>? = indianmovies

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_indian_movie_fragemnt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewI.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MovieListAdapter(activity)
            (adapter as MovieListAdapter).updateList(movieDataList)

        }


    }


}
