package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.curriculumvitaev2.Data.Education
import com.example.curriculumvitaev2.Data.Experience
import com.example.curriculumvitaev2.utils.AppDataBase
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout

class addEducation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addeducation)

        var startdate : TextView?=null
        var cn : TextView?=null
        var ca : TextView?=null
        var img : ImageView?=null

        var startdateo : TextInputLayout?=null
        var enddate : TextView?=null
        var enddateo : TextInputLayout?=null
        var submit : Button?=null

        startdate = findViewById<TextView>(R.id.SDed)
        enddate = findViewById<TextView>(R.id.endDateed)
        submit=findViewById<Button>(R.id.SaveAddEducation)
        ca=findViewById<TextView>(R.id.CAed)
        cn=findViewById<TextView>(R.id.CNed)
        img=findViewById<ImageView>(R.id.imageED)
        dataBase = AppDataBase.getDatabase(this)


        submit.setOnClickListener {
            var ed= Education(
                uName = cn.text.toString(),
                uAdd = ca.text.toString(),
                Pic = img.toString(),
                startDate = startdate.text.toString(),
                EndDate = enddate.text.toString()
            )
            addToDataBase(ed)

            val intent = Intent(this, EducationFragment::class.java)
            startActivity(intent)
        }



        startdate.setOnClickListener {
            val sd= displayDatepicker("Select start date")
            sd.addOnPositiveButtonClickListener {
                var display=""+sd.headerText
                startdate.text=display

            }
            sd.show(supportFragmentManager, "");


        }
        enddate.setOnClickListener {
            displayDatepicker("Select end date")
            val ed= displayDatepicker("Select start date")
            ed.addOnPositiveButtonClickListener {
                var display=""+ed.headerText
                enddate.text=display

            }
            ed.show(supportFragmentManager, "");
        }




    }

    private fun displayDatepicker(Text:String): MaterialDatePicker<Long>
    {
        val date=  MaterialDatePicker
            .Builder
            .datePicker()
            .setTitleText(Text)
            .build()
        return date

    }
    fun addToDataBase(education: Education) {
        try {
            dataBase.eduDAO().insert(education)

        }catch (ex: Exception){
            Toast.makeText(this, "Error adding an experience", Toast.LENGTH_SHORT).show()
        }

    }



    }
