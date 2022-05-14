package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.databinding.Activity3Binding
import com.example.myapplication.observer.ActivityObserver

class Activity3 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: Activity3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(ActivityObserver(javaClass.simpleName))

        with(binding) {
            btnBack.setOnClickListener { onBackPressed() }
            btnForward.setOnClickListener(this@Activity3)
        }

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_forward) {
            startActivity(Intent(this, Activity4::class.java))
        }
    }
}