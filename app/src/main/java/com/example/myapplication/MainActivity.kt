package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.localScoreLiveData.observe(this, Observer {
            localScoreValue ->
            binding.localScore.text = localScoreValue.toString()
        })

        viewModel.visitScoreLiveData.observe(this, Observer {
                    localVisitValue ->
            binding.visitScore.text = localVisitValue.toString()
        })


        binding.btnMinus.setOnClickListener { localMinus() }
        binding.btnPlus.setOnClickListener { localPlus() }
        binding.btnPlus2.setOnClickListener { localPlus2() }

        binding.btnVisitMinus.setOnClickListener { visitMinus() }
        binding.btnVisitPlus.setOnClickListener { visitPlus() }
        binding.btnVisitPlus2.setOnClickListener { visitPlus2() }

        binding.reload.setOnClickListener { reload() }
        binding.next.setOnClickListener { next() }

    }

    private fun localMinus() {
        viewModel.localMinus()
    }

    private fun localPlus() {
        viewModel.localPlus()
    }

    private fun localPlus2() {
        viewModel.localPlus2()
    }



    private fun visitMinus() {
        viewModel.visitMinus()
    }

    private fun visitPlus() {
        viewModel.visitPlus()
    }

    private fun visitPlus2() {
        viewModel.visitPlus2()
    }


    private fun reload(){
        viewModel.reload()
    }

    private fun next(){
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("LOCAL_KEY", viewModel.localScoreLiveData.value)
        intent.putExtra("VISIT_KEY", viewModel.visitScoreLiveData.value)

        startActivity(intent)
    }

}