package com.example.curriculumvitaev2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar

private lateinit var btnEducation: Button
private lateinit var btnExperience: Button
class carrerActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carrer_activity)
        val toolbar: Toolbar = findViewById(R.id.app_bar2)
        setSupportActionBar(toolbar)
        btnExperience = findViewById(R.id.btnExperience)
        btnEducation = findViewById(R.id.btnEducation)
        toolbar.setNavigationOnClickListener(){
            finish()

        }
        btnExperience.setOnClickListener(){
            changeFragment(ExperienceFragment(), "Experience")
        }

        btnEducation.setOnClickListener(){
            changeFragment(EducationFragment(), "Education")
        }
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, ExperienceFragment()).commit()

    }
    private fun changeFragment(fragment: Fragment, name: String) {

        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(name).commit()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.careermenu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){


            R.id.addExperienece -> {
                val intent = Intent(this, addExperience::class.java)
                startActivity(intent)
            }

            R.id.addEducation -> {
                val intent = Intent(this, addEducation::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }


}