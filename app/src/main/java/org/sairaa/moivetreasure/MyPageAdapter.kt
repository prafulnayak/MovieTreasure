package org.sairaa.moivetreasure

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.sairaa.moivetreasure.Model.MovieData

class MyPageAdapter(
    fragmentManager: FragmentManager,
    movieY: MovieData?
):FragmentPagerAdapter(fragmentManager) {

    private val movieX = movieY

    override fun getItem(position: Int): Fragment {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return when (position) {
            0 -> MovieFragment(movieX!!.comingsoon)
            1 -> RunningMovieFragment(movieX!!.movieintheaters)
            else -> {
                return IndianMovieFragemnt(movieX!!.indianmovies)
            }
        }
    }

    override fun getCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    fun addFragment(fm:Fragment,title:String){
    }
}
