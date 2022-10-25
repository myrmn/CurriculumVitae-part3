package com.example.curriculumvitaev2

import android.content.Intent
import android.content.SharedPreferences
import android.widget.SeekBar


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
 var remember:CheckBox?=null
const val PREF_NAME = "LOGIN_PREF_CV"
const val IS_REMEMBRED = "IS_REMEMBRED"
const val FULLNAME = "FULLNAME"
const val EMAIL = "EMAIL"
const val AGE = "AGE"
const val GENDER = "GENDER"
const val IMAGE = "IMAGE"
const val ANDROID = "ANDROID"
const val FLUTTER = "FLUTTER"
const val IOS = "IOS"
const val LANGUAGE = "LANGUAGE"
const val HOBBIES = "HOBBIES"

const val ARABIC = "ARABIC"
const val ENGLISH = "ENGLISH"
const val FRENCH = "FRENCH"
const val MUSIC = "MUSIC"
const val SPORT = "SPORT"
const val GAMES = "GAMES"




class step2 :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step2)
        remember = findViewById<CheckBox>(R.id.rememberMe)
        seekBarAndroid = findViewById<SeekBar>(R.id.seekBar_android)
        seekBarIos = findViewById<SeekBar>(R.id.seekBar_ios)
        seekBarFlutter= findViewById<SeekBar>(R.id.seekBar_flutter)
       val   arabic = findViewById<CheckBox>(R.id.checkBox_arabic)
       val   french = findViewById<CheckBox>(R.id.checkbox_french)
     val    english = findViewById<CheckBox>(R.id.checkBox_english)
       val   music = findViewById<CheckBox>(R.id.checkBox_music)
       val   sport = findViewById<CheckBox>(R.id.checkBox_sport)
      val   games = findViewById<CheckBox>(R.id.checkBox_game)
         btnSubmit= findViewById<Button>(R.id.SUBMIT)
        remember=findViewById<CheckBox>(R.id.rememberMe)

        lateinit var mSharedPref: SharedPreferences
        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        val intent = intent
      //  val imageURI= intent.getStringExtra("image")
       var lang=""
       var hb=""
        btnSubmit!!.setOnClickListener {
            var gender = ""
            if (male!!.isChecked) {
                gender = "Male";
            } else {
                gender = "Female"
            }
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




                if (remember!!.isChecked){
                    mSharedPref.edit().apply{
                        putBoolean(IS_REMEMBRED, true)
                        putString(FULLNAME, name?.text.toString())
                        putString(EMAIL, email?.text.toString())
                        putString(GENDER, gender)
                        putString(AGE,age?.text.toString())
                        putString(IMAGE, imageUri.toString())
                        putFloat(ANDROID, seekBarAndroid!!.progress.toFloat())
                        putFloat(IOS, seekBarIos!!.progress.toFloat())
                        putFloat(FLUTTER,
                            seekBarFlutter!!.progress.toFloat())
                        putString(LANGUAGE,lang)
                        putString(HOBBIES,hb)

                    }.apply()

                }else{
                    mSharedPref.edit().clear().apply()
                }

                navigate()
                        }



        }




    private fun navigate() {
        val mainIntent = Intent(this, cv_result::class.java)
        startActivity(mainIntent)    }

}

