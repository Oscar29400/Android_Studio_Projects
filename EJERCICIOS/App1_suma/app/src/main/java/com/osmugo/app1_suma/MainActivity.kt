package com.osmugo.app1_suma

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.osmugo.app1_suma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            binding.resultado.text = data?.extras?.get(Intent.EXTRA_RETURN_RESULT).toString()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.send.setOnClickListener{
            sendShared()
        }
    }

    private fun sendShared() {
        val suma1: Int = binding.editTextNumber.text.toString().toInt()
        val suma2: Int = binding.editTextNumber2.text.toString().toInt()
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra("dato1",suma1)
            putExtra("dato2",suma2)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent,"Suma")
        myResultLauncher.launch(shareIntent)
    }

}