package com.example.curriculumvitaev2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FinalResult: AppCompatActivity() {

    private lateinit var btnSkills: Button
    private lateinit var btnHobbies: Button
    private lateinit var btnLanguages: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.finalresult)

        supportActionBar?.hide()
        btnSkills = findViewById(R.id.btnSkills)

        btnHobbies = findViewById(R.id.btnHobbies)
        btnLanguages = findViewById(R.id.btnLanguages)
        var bundle : Bundle?=intent.extras
        var fullname = bundle!!.getString("Name")
        var email = bundle!!.getString("Email")
        var android = bundle!!.getFloat("Android")
        var ios = bundle!!.getFloat("iOS")
        var flutter = bundle!!.getFloat("Flutter")
        var Language= bundle!!.getString("Language")
        var hobbies= bundle!!.getString("Hobbies")
        var imageid:Int = bundle!!.getInt("image")
        val prof: ImageView = findViewById(R.id.profile)
        val name : TextView = findViewById(R.id.cvname)
        name.setText( fullname)

        val temail : TextView = findViewById(R.id.temail)
        temail.setText(email)

        val fragmentskills=SkillsFragment.newInstance((android/100).toString(),(ios/100).toString(),(flutter/100).toString())
        val fragmentlanguage=LanguageFragment.newInstance(Language.toString(),"")
        val fragmenthobbies=HobbiesFragment.newInstance(hobbies.toString(),"")
        // Attaching the layout to the toolbar object
        btnSkills.setOnClickListener{
            changeFragment(fragmentskills,"Skills")
        }
        btnHobbies.setOnClickListener{
            changeFragment(fragmenthobbies, "Hobbies")
        }
        btnLanguages.setOnClickListener{
            changeFragment(fragmentlanguage, "Languages")
        }
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragmentskills).commit()


    }
    private fun changeFragment(fragment: Fragment, name: String) {


        if (name.isEmpty())

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()

        else

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(name).commit()

    }


}