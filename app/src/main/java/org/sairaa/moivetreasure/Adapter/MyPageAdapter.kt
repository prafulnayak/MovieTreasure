package org.sairaa.moivetreasure.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.sairaa.moivetreasure.Fragment.IndianMovieFragemnt
import org.sairaa.moivetreasure.Fragment.MovieFragment
import org.sairaa.moivetreasure.Fragment.RunningMovieFragment
import org.sairaa.moivetreasure.Model.MovieData

class MyPageAdapter(
    fragmentManager: FragmentManager,
    private val movieX: MovieData?
):FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MovieFragment(movieX!!.comingsoon)
            1 -> RunningMovieFragment(movieX!!.movieintheaters)
            else -> {
                return IndianMovieFragemnt(movieX!!.indianmovies)
            }
        }
    }

    override fun getCount(): Int {

        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Coming Soon"
            1 -> "Movie In "
            else -> {
                return "Indian Movie"
            }
        }
    }
}
