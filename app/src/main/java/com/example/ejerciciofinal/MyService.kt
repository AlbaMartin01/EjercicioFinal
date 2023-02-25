package com.example.ejerciciofinal

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

private var posicion: Int = 0

class MyService : Service() {
    private lateinit var mMediaPlayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    override fun onCreate() {
        mMediaPlayer = MediaPlayer.create(applicationContext, R.raw.musica_epica)
        mMediaPlayer.setLooping(true)
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }
    override fun onStart(intent: Intent?, startId: Int) {
        mMediaPlayer.seekTo(posicion)
        mMediaPlayer.start()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        mMediaPlayer.pause()
        posicion = mMediaPlayer.currentPosition
        mMediaPlayer.seekTo(posicion)
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

}
