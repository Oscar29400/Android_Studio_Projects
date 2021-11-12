package com.osmugo.app2_suma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.osmugo.app2_suma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var text:String? = null
        val data = intent
        var result:Int?=null
        data?.let {

            text = "${data.extras?.get("dato1").toString()}"
            binding.num1.text = text
            text = "${data.extras?.get("dato2").toString()}"
            binding.num2.text = text

            result = data.extras?.get("dato1").toString().toInt() + data.extras?.get("dato2").toString().toInt()

        }
        binding.back.setOnClickListener{
            val intent = Intent().apply{
                putExtra(Intent.EXTRA_RETURN_RESULT,result?:"No hay texto")
            }
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}