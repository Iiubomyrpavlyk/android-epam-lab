package com.example.myapplication.observer

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner


class ActivityObserver(private val activityName: String) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(activityName, "created")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(activityName, "started")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(activityName, "resumed")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(activityName, "paused")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(activityName, "stopped")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(activityName, "destroyed")
    }

}