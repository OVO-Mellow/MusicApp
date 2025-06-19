package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicapp.R


class MainActivity2 : AppCompatActivity() {

    // arrays for the edit texts
    companion object {
        val songTitles = ArrayList<String>()
        val artistNames = ArrayList<String>()
        val ratings = ArrayList<Int>()
        val comments = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val titleInput = findViewById<EditText>(R.id.SongTitle)
        val artistInput = findViewById<EditText>(R.id.Artist)
        val ratingInput = findViewById<EditText>(R.id.Rating)
        val commentInput = findViewById<EditText>(R.id.Comment)

        val btnAdd = findViewById<Button>(R.id.btnAddSong)
        val btnDetails = findViewById<Button>(R.id.btnToDetails)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnAdd.setOnClickListener {
            val title = titleInput.text.toString()
            val artist = artistInput.text.toString()
            val rating = ratingInput.text.toString().toIntOrNull()
            val comment = commentInput.text.toString()

            //If and else statements for edit text
            if (title.isNotEmpty() && artist.isNotEmpty() && rating != null && rating in 1..5) {
                songTitles.add(title)
                artistNames.add(artist)
                ratings.add(rating)
                comments.add(comment)
                Toast.makeText(this, "added to playlist", Toast.LENGTH_SHORT).show()
                titleInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()
            } else {
                Toast.makeText(this, "input info", Toast.LENGTH_SHORT).show()
            }
        }

        btnDetails.setOnClickListener {
            val intent = Intent(this, Detail::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finish() //once user is done he or she can leave the app
        }
    }
}
