package org.sairaa.moivetreasure.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_indian_movie_fragemnt.*
import org.sairaa.moivetreasure.Model.MovieT
import org.sairaa.moivetreasure.Adapter.MovieListAdapter
import org.sairaa.moivetreasure.R


class IndianMovieFragemnt(private var movieDataList: List<MovieT>) : Fragment() {

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
            layoutManager = GridLayoutManager(activity,2)
            adapter = MovieListAdapter(activity)
            (adapter as MovieListAdapter).updateList(movieDataList)

        }


    }


}
