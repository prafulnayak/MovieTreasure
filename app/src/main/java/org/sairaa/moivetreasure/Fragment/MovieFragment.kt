package org.sairaa.moivetreasure.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import org.sairaa.moivetreasure.Model.MovieT
import org.sairaa.moivetreasure.Adapter.MovieListAdapter
import org.sairaa.moivetreasure.R


class MovieFragment(private var movieDataList: List<MovieT>) : Fragment() {


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
            layoutManager = GridLayoutManager(activity,2)
            adapter = MovieListAdapter(activity)
            (adapter as MovieListAdapter).updateList(movieDataList)

        }
    }

}
