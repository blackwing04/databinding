package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private  var score =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.tvScore.text="${getString(R.string.score)}$score"
        binding.btLarger.setOnClickListener {
            val x =randNum()
            if (x >7) correct()
            else wrong()
        }
        binding.btSmaller.setOnClickListener {
            val x =randNum()
            when {
                x >7 -> wrong()
                else -> correct()
            }
        }
    }

    private fun randNum() :Int {
        val x = Random.nextInt(0,14)
        binding.tvNum.text =x.toString()
        return  x
    }

    private  fun correct() {
        score++
        binding.tvScore.text="${getString(R.string.score)}$score"
        Toast.makeText(this,R.string.correct,Toast.LENGTH_SHORT).show()
    }

    private  fun wrong() {
        Toast.makeText(this,R.string.wrong,Toast.LENGTH_SHORT).show()
    }
}