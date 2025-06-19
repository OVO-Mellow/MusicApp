package com.example.musicapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Detail : AppCompatActivity() {

    private lateinit var songListView: TextView
    private lateinit var avgRatingView: TextView
    private lateinit var btnShowSongs: Button
    private lateinit var btnAvgRating: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        songListView = findViewById(R.id.SongList)
        avgRatingView = findViewById(R.id.AverageRating)
        btnShowSongs = findViewById(R.id.btnViewSongs)
        btnAvgRating = findViewById(R.id.btnAvgRating)
        btnBack = findViewById(R.id.btnBack)

        btnShowSongs.setOnClickListener {
            var songData = ""
            for (i in MainActivity2.songTitles.indices) {
                songData += " ${MainActivity2.songTitles[i]} by ${MainActivity2.artistNames[i]}\n"
                songData += " Rating: ${MainActivity2.ratings[i]}/5\n"
                songData += " Comment: ${MainActivity2.comments[i]}\n\n"
            }
            songListView.text = songData
        }
//if and else statements as loop to find out the avarage
        btnAvgRating.setOnClickListener {
            if (MainActivity2.ratings.isNotEmpty()) {
                val avg = MainActivity2.ratings.sum().toDouble() / MainActivity2.ratings.size
                avgRatingView.text = "Average Rating: %.2f".format(avg)
            } else {
                avgRatingView.text = "No ratings available"
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
