package org.sairaa.moivetreasure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.sairaa.moivetreasure.Api.MovieApi
import org.sairaa.moivetreasure.Model.MovieData
import org.sairaa.moivetreasure.Model.MovieT
import retrofit2.Call
import retrofit2.Response
import java.util.logging.Logger
import retrofit2.Callback

class MainActivity : AppCompatActivity(),
MovieListAdapter.MovieAdapterCallback{

    val BASE_URL = "https://gist.githubusercontent.com/SkyTreasure/df5c94f75f64fc9af0c8b87e431011bb/raw/ee22cb6b0a76b0cc06e57d77b47fb7234e12fc90/movies.json/"

    private var movieX: MovieData? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressT: TextView = findViewById(R.id.progressText)
        val progressB: ProgressBar = findViewById(R.id.progressBar)
        progressB.visibility = ProgressBar.VISIBLE
        progressT.text = getString(R.string.loadingText)
        progressT.visibility = TextView.VISIBLE
        MovieApi.retrofitService.getProperty().enqueue(object: Callback<MovieData>{

            override fun onFailure(call: Call<MovieData>, t: Throwable) {
                progressT.text = getString(R.string.wrong_text)
                progressB.visibility = ProgressBar.GONE
                Logger.getLogger(MainActivity::class.java.name).warning("failed.."+t.toString()+"/n"+t.localizedMessage+"/n"+t.message.toString())
            }

            override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
                progressB.visibility = ProgressBar.GONE
                progressT.visibility = TextView.GONE
                movieX = response.body()
                Logger.getLogger(MainActivity::class.java.name).warning("Hello.."+movieX.toString())

                val fragmentAdapter = MyPageAdapter(supportFragmentManager,movieX)
                viewPager.adapter = fragmentAdapter

                tabLayout.setupWithViewPager(viewPager)

            }

        })
    }



    override fun navigateToDetailActivity(movie: MovieT) {
        intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("movie", Gson().toJson(movie))
        startActivity(intent)
    }
}
