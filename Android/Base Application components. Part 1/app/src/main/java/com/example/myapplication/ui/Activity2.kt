package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.databinding.Activity2Binding
import com.example.myapplication.observer.ActivityObserver

class Activity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(ActivityObserver(javaClass.simpleName))

        with(binding) {
            btnBack.setOnClickListener { onBackPressed() }
            btnForward.setOnClickListener(this@Activity2)
        }

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_forward) {
            startActivity(Intent(this, Activity3::class.java))
        }
    }
}