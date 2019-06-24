package org.sairaa.moivetreasure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.Gson
import org.sairaa.moivetreasure.Model.MovieT

class DetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val movieS = intent.getStringExtra("movie")
        val movieX : MovieT = Gson().fromJson(movieS,MovieT::class.java)

        val actionBar: ActionBar? = this.supportActionBar
        actionBar!!.title= movieX.title
        actionBar.setDisplayHomeAsUpEnabled(true)

//        Toast.makeText(this,movieX.title, Toast.LENGTH_LONG).show()
        val circularProgressDrawable: CircularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val imageV:ImageView = findViewById(R.id.imageMaster)
        val title:TextView = findViewById(R.id.titleMaster)
        val releseDate:TextView = findViewById(R.id.releseDate)
        val generT:TextView = findViewById(R.id.gener)
        val rating:TextView = findViewById(R.id.votePercentage)
        val voteCount: TextView = findViewById(R.id.noOfVotes)
        val castT:TextView = findViewById(R.id.cast)

        Glide.with(this)
            .load(movieX.posterurl)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.ic_blur)
            // read original from cache (if present) otherwise download it and decode it
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .into(imageV);

        title.text=movieX.title
        releseDate.text=getString(R.string.release_date).plus(movieX.releaseDate)
        voteCount.text=movieX.ratings.size.toString().plus(" Votes")

        var ratingValue:Double = 0.0
        for (item: Double in movieX.ratings) ratingValue += item
        ratingValue = ratingValue/movieX.ratings.size
        val number3digits:Double = String.format("%.3f", ratingValue).toDouble()
        val number2digits:Double = String.format("%.2f", number3digits).toDouble()
        val solution:Double = String.format("%.1f", number2digits).toDouble()
        rating.text=solution.toString()

        var genersT:String ="Genres: "
        for(item: String in movieX.genres) genersT += " "+item
        generT.text = genersT

        var castTS:String ="Cast: "
        for(item: String in movieX.actors) castTS += " "+item
        castT.text = castTS
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
