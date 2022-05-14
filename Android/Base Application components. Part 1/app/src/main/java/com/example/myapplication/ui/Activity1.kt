package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.databinding.Activity1Binding
import com.example.myapplication.observer.ActivityObserver

private val TAG = "Activity1"

class Activity1 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: Activity1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(ActivityObserver(javaClass.simpleName))

        with(binding) {
            btnBack.setOnClickListener { onBackPressed() }
            btnForward.setOnClickListener(this@Activity1)
        }

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_forward) {
            startActivity(Intent(this, Activity2::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
    }

}