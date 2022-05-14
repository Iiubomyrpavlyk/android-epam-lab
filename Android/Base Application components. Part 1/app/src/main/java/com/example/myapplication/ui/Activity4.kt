package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.Activity4Binding
import com.example.myapplication.observer.ActivityObserver

class Activity4 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: Activity4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(ActivityObserver(javaClass.simpleName))

        with(binding) {
            btnBack.setOnClickListener { onBackPressed() }
            btnForward.setOnClickListener(this@Activity4)
        }

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_forward) {
            startActivity(Intent(this, Activity1::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            })
        }
    }
}