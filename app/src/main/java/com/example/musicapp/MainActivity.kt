package com.example.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//this button is to move from the welcome screen to the 1st assignment screen
        val getStartedButton: Button = findViewById(R.id.startButton)

//i used the intent function in order to call it
        getStartedButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


    }
    }
