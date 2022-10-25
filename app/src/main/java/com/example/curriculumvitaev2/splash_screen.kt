package com.example.curriculumvitaev2
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import android.widget.CheckBox

private val SPLASH_TIME_OUT: Long = 2000
class splash_screen :AppCompatActivity() {
    lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        var check:Boolean=mSharedPref.getBoolean(IS_REMEMBRED, false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (check)

            startActivity(Intent(this, cv_result::class.java))
            else
            {
                startActivity(Intent(this, MainActivity::class.java))

            }
            finish()
        }, SPLASH_TIME_OUT)



    }
}