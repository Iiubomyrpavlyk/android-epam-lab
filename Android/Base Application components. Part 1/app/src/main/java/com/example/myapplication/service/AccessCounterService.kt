package com.example.myapplication.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

private const val TAG = "AccessCounterService"

class AccessCounterService : Service() {

    val binder = LocalBinder()

    private var _counter: Int = 0

    inner class LocalBinder : Binder() {
        fun getService(): AccessCounterService =  this@AccessCounterService

        val howManyTimesWasAccessed: Int
            get() = ++_counter
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "#onBind")
        return binder
    }
}