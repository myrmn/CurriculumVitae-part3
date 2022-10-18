package com.example.curriculumvitaev2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class Career : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.career)
        val experienceB = findViewById<Button>(R.id.ExpButton)
        val educationB = findViewById<Button>(R.id.EdButton)
        val exp = ExperienceFragment();
     //   val ed = CarrerFragment();
        experienceB.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                replace(R.id.fragmentC, exp)
                commit()
            }


        }
       /* educationB.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                replace(R.id.fragmentC, ed)
                commit()
            }
*/

        }

}