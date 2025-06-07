package com.sonbyungha.engineertool

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class music: AppCompatActivity() {
    lateinit var mPlayer: MediaPlayer
    lateinit var btnPlay: Button
    lateinit var btnStop: Button
    lateinit var textViewMP3: TextView
    lateinit var progBarMP3: ProgressBar
    lateinit var mp3List: ArrayList<String>
    lateinit var selectedMP3: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.music_classic)
        mp3List = ArrayList()
        mp3List.add("classic1.mp3")
        mp3List.add("classic2.mp3")
        mp3List.add("classic3.mp3")
        mp3List.add("paperplane.mp3")
        var listViewMP3 = findViewById<ListView>(R.id.listViewMP3)
        var adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_single_choice, mp3List)
        listViewMP3.choiceMode = ListView.CHOICE_MODE_SINGLE
        listViewMP3.adapter = adapter
        listViewMP3.setItemChecked(0, true)
        title = "클래식 음악 제공"

        listViewMP3.setOnItemClickListener{arg0, arg1, position, arg3 ->
            selectedMP3 = mp3List[position]
        }
        selectedMP3 = mp3List[0]
        btnPlay = findViewById<Button>(R.id.btnPlay)
        btnStop = findViewById<Button>(R.id.btnStop)
        textViewMP3 = findViewById<TextView>(R.id.textViewMP3)
        progBarMP3 = findViewById<ProgressBar>(R.id.progBar)
        btnPlay.setOnClickListener {
            when(selectedMP3){
                mp3List[0] -> mPlayer = MediaPlayer.create(this, R.raw.classic1)
                mp3List[1] -> mPlayer = MediaPlayer.create(this, R.raw.classic2)
                mp3List[2] -> mPlayer = MediaPlayer.create(this, R.raw.classic3)
                mp3List[3] -> mPlayer = MediaPlayer.create(this, R.raw.paperplane)
            }
            mPlayer.start()
            btnPlay.isClickable = false
            btnStop.isClickable = true
            textViewMP3.text="실행중인 음악:$selectedMP3"
            progBarMP3.visibility = View.VISIBLE
        }
        btnStop.setOnClickListener {
            mPlayer.stop()
            mPlayer.reset()
            btnPlay.isClickable = true
            btnStop.isClickable = false
            textViewMP3.text="실행중인 음악 : "
            progBarMP3.visibility = View.INVISIBLE
        }
        btnStop.isClickable = false

    }
}