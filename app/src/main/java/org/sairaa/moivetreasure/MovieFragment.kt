package org.sairaa.moivetreasure

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import org.sairaa.moivetreasure.Model.MovieT


class MovieFragment(comingsoon: List<MovieT>) : Fragment() {


    private var movieDataList: List<MovieT>? = comingsoon

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MovieListAdapter(activity)
            (adapter as MovieListAdapter).updateList(movieDataList)

        }
    }

    // TODO: Rename method, update argument and hook method into UI event







}
