package com.example.curriculumvitaev2

import android.content.Intent
import android.widget.SeekBar


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox

private var seekBarAndroid: SeekBar? = null
private var seekBarIos: SeekBar? = null
private var seekBarFlutter: SeekBar? = null
private var btnSubmit: Button? = null
private var arabic: CheckBox? = null
private var french: CheckBox? = null
private var english: CheckBox? = null
private var music: CheckBox? = null
private var sport: CheckBox? = null
private var games: CheckBox? = null

class Skills : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_2)
        val androidSkill = findViewById<SeekBar>(R.id.android)
        val iosSkill = findViewById<SeekBar>(R.id.ios)
        val flutterSkill = findViewById<SeekBar>(R.id.flutter)
        val arabic = findViewById<CheckBox>(R.id.ar)
        val french = findViewById<CheckBox>(R.id.fr)
        val english = findViewById<CheckBox>(R.id.en)
        val music = findViewById<CheckBox>(R.id.music)
        val sport = findViewById<CheckBox>(R.id.sport)
        val games = findViewById<CheckBox>(R.id.games)
        val submit = findViewById<Button>(R.id.submit)

        val intent = intent
        val name = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val genre = intent.getStringExtra("Gender")

        submit.setOnClickListener {
            val intent = Intent(this, Result::class.java)
            val lang = when {
                arabic.isChecked && french.isChecked && english.isChecked -> "Arabic French English"
                arabic.isChecked && french.isChecked -> "Arabic French"
                arabic.isChecked && english.isChecked -> "Arabic English"
                french.isChecked && english.isChecked -> "French English"
                arabic.isChecked -> "Arabic"
                french.isChecked -> "French"
                english.isChecked -> "English"

                else -> "None"
            }
            val hb = when {
                music.isChecked && sport.isChecked && games.isChecked -> "Music Sport Games"
                sport.isChecked && games.isChecked -> "Sport Games"
                sport.isChecked && music.isChecked -> "Sport Music"
                games.isChecked && music.isChecked -> "Games Music"
                games.isChecked -> "Games"
                sport.isChecked -> "Sport"
                music.isChecked -> "Music"
                else -> "None"
            }

            intent.putExtra("Android", androidSkill.progress.toString())
            intent.putExtra("iOS", iosSkill.progress.toString())
            intent.putExtra("Flutter", flutterSkill.progress.toString())
            intent.putExtra("Language", lang)
            intent.putExtra("Hobbies", hb)
            intent.putExtra("Name", name)
            intent.putExtra("Age", age)
            intent.putExtra("Email", mail)
            intent.putExtra("Gender", genre)
            startActivity(intent)
        }
    }







}


