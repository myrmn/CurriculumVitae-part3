package com.example.curriculumvitaev2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.google.android.material.textfield.TextInputLayout
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*

var name :TextView?=null
var outlineName :TextInputLayout?=null
var email :TextView?=null
var outlineEmail :TextInputLayout?=null
var age :TextView?=null
var outlineAge :TextInputLayout?=null
var next :Button?=null
var male  :RadioButton?=null
var female:RadioButton?=null
var img:ImageView?=null
private val pickImage = 100
private var imageUri: Uri? = null
class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_1)

        val name = findViewById<TextView>(R.id.fullname)
        val outlineName = findViewById<TextInputLayout>(R.id.fullnamelayout)
        val email = findViewById<TextView>(R.id.textInputLayout2)
        val outlineEmail = findViewById<TextInputLayout>(R.id.email)
        val age = findViewById<TextView>(R.id.age)
        val outlineAge = findViewById<TextInputLayout>(R.id.textInputLayout)
        val next = findViewById<Button>(R.id.nextB)
        val male = findViewById<RadioButton>(R.id.Male)
        val female = findViewById<RadioButton>(R.id.Female)
        val GenderGroup = findViewById<RadioGroup>(R.id.gendergroup)
        val groupe = GenderGroup.checkedRadioButtonId
        val FM = findViewById<RadioButton>(groupe)
        next!!.setOnClickListener {
            if(check())
            {

                val fullname = name!!.text.toString()
                val age2 = age!!.text.toString()
                val mail =  email!!.text.toString()
                var gender=""
                if(male!!.isChecked){
                    gender="Male";
                }
                else{
                    gender="Female"
                }

                val intent = Intent(this, Skills::class.java)
                intent.putExtra("Name", fullname)
                intent.putExtra("Email", mail)
                intent.putExtra("Age", age2)
                intent.putExtra("Gender", gender)
                startActivity(intent)
            }
        }
    img!!.setOnClickListener {

        val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startActivityForResult(gallery, pickImage)


    }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {

            imageUri = data?.data
            img?.setImageURI(imageUri)
        }
    }
}    fun check():Boolean {

    if (name!!.text.isEmpty()) {
        outlineName?.error = "Must not be empty!"
        return false;

    } else {
        outlineName?.error = null
    }
    if (email!!.text.isEmpty()) {
        outlineEmail?.error = "Must not be empty!"
        return false;

    } else if (!EMAIL_ADDRESS.matcher(email?.text!!).matches()) {
        outlineEmail?.error = "Check your email!"
        return false
    } else {
        outlineEmail?.error = null

    }
    if (age!!.text.isEmpty()) {
        outlineAge?.error = "Must not be empty!"
        return false;
    } else {
        outlineAge?.error = null
    }
    return true;

}
