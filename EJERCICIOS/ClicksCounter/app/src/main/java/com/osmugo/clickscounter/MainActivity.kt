package com.osmugo.clickscounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var counter = 0

    private val tvClicksCounter:TextView by lazy { findViewById(R.id.ClicksCounter) }
    private val btnIncreaseCounter:TextView by lazy { findViewById(R.id.IncreaseCounter) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnIncreaseCounter.setOnClickListener(){
            counter++;
            tvClicksCounter.setText("You have clicked $counter times")
        }
    }
}