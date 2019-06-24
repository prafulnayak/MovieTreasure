package org.sairaa.moivetreasure

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import org.sairaa.moivetreasure.Model.MovieT

public class MovieListAdapter(
    activity: FragmentActivity?
) : RecyclerView.Adapter<MyViewHolder>() {

    var movieList:List<MovieT>? = null
    private var listener: MovieAdapterCallback? = null

    private val context: FragmentActivity? = activity



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        if (context != null) {
            onAttach(context)
        }
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MyViewHolder(view)
    }

    fun onAttach(context: Context) {

        if (context is MovieAdapterCallback) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListenerI")
        }
    }

    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return this.movieList?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val movie:MovieT = this.movieList!![position]
        holder.set(movie)
        holder.setAdapterCallback(listener);
    }

    fun updateList(movies: List<MovieT>?){
        movieList= movies
        notifyDataSetChanged()
    }
    public interface MovieAdapterCallback{
        fun navigateToDetailActivity(movie:MovieT)
    }

}
