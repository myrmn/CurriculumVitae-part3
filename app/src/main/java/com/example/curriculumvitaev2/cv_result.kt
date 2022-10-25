package com.example.curriculumvitaev2

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.net.toUri
import androidx.fragment.app.Fragment

class cv_result: AppCompatActivity(){

    private lateinit var btnSkills: Button
    private lateinit var btnHobbies: Button
    private lateinit var btnLanguages: Button
    private lateinit var btnCareer: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.cv_result)

        supportActionBar?.hide()
        btnSkills = findViewById(R.id.btnSkills)

        btnHobbies = findViewById(R.id.btnHobbies)
        btnLanguages = findViewById(R.id.btnLanguages)

        var   n = findViewById<TextView>(R.id.tname)
        var    d = findViewById<TextView>(R.id.temail)
        var    f = findViewById<ImageView>(R.id.pf2)


        lateinit var mSharedPref: SharedPreferences
        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        val nom: String? = mSharedPref.getString(FULLNAME, "")
        val meyl: String? = mSharedPref.getString(EMAIL, "")
        val photo:String?=mSharedPref.getString(IMAGE,"")

n.text=nom
        d.text=meyl

        f.setImageURI(Uri.parse(photo))

        val toolbar: Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener(){
            finish()

        }
        btnSkills.setOnClickListener{
            changeFragment(skillsfragment.newInstance(),"Skills")
        }
        btnHobbies.setOnClickListener{
           changeFragment(hobbiesfragment.newInstance(), "Hobbies")
        }
        btnLanguages.setOnClickListener{
          changeFragment(languagefragment.newInstance(), "Languages")
        }
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,skillsfragment.newInstance()).commit()
        btnCareer = findViewById(R.id.btnCareer)

        btnCareer.setOnClickListener {
            val intent = Intent(this,carrerActivity::class.java)
            startActivity(intent)
        }

    }
    private fun changeFragment(fragment: Fragment, name: String) {


        if (name.isEmpty())

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()

        else

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(name).commit()

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){


            R.id.info -> changeFragment(infofragment(), "info")

            R.id.logout -> {
                getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit().clear().apply()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }}
