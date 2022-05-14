package com.example.myapplication.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityServiceBinding
import com.example.myapplication.service.AccessCounterService

private const val TAG = "ServiceActivity"

class ServiceActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityServiceBinding

    private lateinit var service: AccessCounterService
    private var isBound = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, iBinder: IBinder?) {
            Log.d(TAG, "connected to service.")
            val binder = iBinder as AccessCounterService.LocalBinder
            service = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "disconnected from service.")
            isBound = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAccessCount.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        bindService()
        isBound = true
    }

    override fun onStop() {
        super.onStop()
        unbindService()
        isBound = false
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_access_count) {
            if (isBound) {
                val num: Int = service.binder.howManyTimesWasAccessed
                Log.d(TAG, "num = $num")
                Toast.makeText(this, "Was requested $num times", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun bindService() {
        Intent(this, AccessCounterService::class.java).also {
            bindService(it, serviceConnection, Context.BIND_AUTO_CREATE)
        }
    }

    private fun unbindService() {
        Intent(this, AccessCounterService::class.java).also {
            unbindService(serviceConnection)
        }
    }

}