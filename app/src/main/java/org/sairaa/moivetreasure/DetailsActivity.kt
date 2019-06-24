package org.sairaa.moivetreasure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import org.sairaa.moivetreasure.Model.MovieT

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val movieS = intent.getStringExtra("movie")
        val movieX : MovieT = Gson().fromJson(movieS,MovieT::class.java)
        Toast.makeText(this,movieX.title, Toast.LENGTH_LONG).show()

    }
}
