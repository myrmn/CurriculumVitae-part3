package com.example.curriculumvitaev2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_1)


        handler = Handler()
        handler.postDelayed(
            {
                val intent = Intent(applicationContext,Info::class.java)
                startActivity(intent)
                finish()

            },3000)





    }
}