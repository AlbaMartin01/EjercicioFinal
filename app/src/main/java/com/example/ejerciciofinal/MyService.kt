package com.example.ejerciciofinal

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {
    private lateinit var mMediaPlayer: MediaPlayer
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        Toast.makeText(this, " Service created", Toast.LENGTH_SHORT).show()
        mMediaPlayer = MediaPlayer.create(applicationContext, R.raw.musica_epica)
        //mMediaPlayer.setLooping(false);
        mMediaPlayer.start()
    }

    override fun onStart(intent: Intent, startid: Int) {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show()
        mMediaPlayer!!.start()
    }

    override fun onDestroy() {
        Toast.makeText(this, "Service stopped", Toast.LENGTH_SHORT).show()
        mMediaPlayer!!.stop()
    }
}