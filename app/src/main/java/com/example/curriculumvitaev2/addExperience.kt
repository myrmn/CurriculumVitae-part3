package com.example.curriculumvitaev2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.curriculumvitaev2.Data.Experience
import com.example.curriculumvitaev2.utils.AppDataBase
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
lateinit var dataBase : AppDataBase

class addExperience : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addexperience)

        var startdate : TextView?=null
        var cn : TextView?=null
        var ca : TextView?=null
        var img : ImageView?=null

        var startdateo : TextInputLayout?=null
        var enddate : TextView?=null
        var enddateo : TextInputLayout?=null
        var submit : Button?=null

        startdate = findViewById<TextView>(R.id.SDexp)
        startdateo = findViewById<TextInputLayout>(R.id.textInputLayout4)
        enddate = findViewById<TextView>(R.id.EDexp)
        enddateo = findViewById<TextInputLayout>(R.id.textInputLayout5)
        submit=findViewById<Button>(R.id.SaveAddExperience)
        ca=findViewById<TextView>(R.id.CAexp)
        cn=findViewById<TextView>(R.id.CNexp)
        img=findViewById<ImageView>(R.id.imageEXP)
        dataBase = AppDataBase.getDatabase(this)


        submit.setOnClickListener {
            var exp= Experience(
                compName = "f",
                compAdd = ca.text.toString(),
                Pic = img.toString(),
                startDate = startdate.text.toString(),
               EndDate = enddate.text.toString()
            )
 addToDataBase(exp)

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
    fun addToDataBase(experience:Experience) {
        try {
            dataBase.expDAO().insert(experience)


        }catch (ex: Exception){
            Toast.makeText(this, "Error adding an experience",Toast.LENGTH_SHORT).show()
        }

    }
    }