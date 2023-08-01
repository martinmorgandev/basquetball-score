package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)


        var winLocal= intent.extras!!.getInt("LOCAL_KEY")
        var winVisit = intent.extras!!.getInt("VISIT_KEY")

        if(winLocal > winVisit){
            //binding.winner.text = winLocal.toString()
            binding.winner.text = "Gano el local"
        }else if( winVisit > winLocal){
            binding.winner.text = "Gano el visitante"
        }else{
            binding.winner.text = "empate"
        }

        binding.winLocal.text = winLocal.toString()
        binding.winVisit.text = winVisit.toString()




    }

}