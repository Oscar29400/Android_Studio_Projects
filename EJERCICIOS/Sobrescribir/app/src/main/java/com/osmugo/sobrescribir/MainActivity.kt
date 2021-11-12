package com.osmugo.sobrescribir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.osmugo.sobrescribir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val TAG = "SOBREESCRIBIR"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener{
            val intent = Intent(this,sobreescribir::class.java)
            startActivity(intent)
            Log.i(TAG, "Actividad 1 on create")
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Actividad 1 on start")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Actividad 1 on resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Actividad 1 on pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Actividad 1 on stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "Actividad 1 on restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Actividad 1 on destroy")
    }
}