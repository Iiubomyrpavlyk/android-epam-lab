package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMenuBinding
import com.example.myapplication.ui.Activity1
import com.example.myapplication.ui.ServiceActivity

class MenuActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
           btnFirstPart.setOnClickListener(this@MenuActivity)
           btnSecondPart.setOnClickListener(this@MenuActivity)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_first_part -> startActivity(Intent(this, Activity1::class.java))
            R.id.btn_second_part -> startActivity(Intent(this, ServiceActivity::class.java))
        }
    }

}