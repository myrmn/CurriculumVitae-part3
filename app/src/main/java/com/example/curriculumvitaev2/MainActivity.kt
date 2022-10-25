package com.example.curriculumvitaev2

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


var name :TextView?=null
var oName :TextInputLayout?=null
var email :TextView?=null
var oEmail :TextInputLayout?=null
var age :TextView?=null
var oAge :TextInputLayout?=null
var nextB :Button?=null
var male  :RadioButton?=null
var female:RadioButton?=null
val pickImage = 100
var imageUri: Uri? = null
var genderr:RadioGroup?=null
class MainActivity : AppCompatActivity() {
    private lateinit var imageview: ImageView


    companion object {

        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var mSharedPref: SharedPreferences
        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        name = findViewById<TextView>(R.id.NameInput)
        oName = findViewById<TextInputLayout>(R.id.outlined_username)
        email = findViewById<TextView>(R.id.emailInput)
        oEmail = findViewById<TextInputLayout>(R.id.outlined_email)
        age = findViewById<TextView>(R.id.ageInput)
        oAge = findViewById<TextInputLayout>(R.id.outlined_age)
        nextB = findViewById<Button>(R.id.next)
 genderr=findViewById<RadioGroup>(R.id.GenderGroup)
        male = findViewById<RadioButton>(R.id.male)
        female = findViewById<RadioButton>(R.id.female)


        val pickImage = 100
        imageview = findViewById(R.id.pf1)
        imageview.setOnClickListener {
            val gallery = Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)

        }
        nextB!!.setOnClickListener {
            if (check()) {

                val fullname = name!!.text.toString()
                val age2 = age!!.text.toString()
                val mail = email!!.text.toString()
                var gender = ""
                if (male!!.isChecked) {
                    gender = "Male";
                } else {
                    gender = "Female"
                }

                val intent = Intent(this, step2::class.java)
                startActivity(intent)
            }


        }
    }

    fun check(): Boolean {
        var c1 = false
        var c2 = false;
        var
                c3 = false
        if (name!!.text.isEmpty()) {
            oName?.error = "Must not be empty!"

        } else {
            oName?.error = null
            c1 = true
        }
        if (email!!.text.isEmpty()) {
            oEmail?.error = "Must not be empty!"

        } else if (!EMAIL_ADDRESS.matcher(email?.text!!).matches()) {
            oEmail?.error = "Check your email!"
        } else {
            oEmail?.error = null
            c2 = true;

        }
        if (age!!.text.isEmpty()) {
            oAge?.error = "Must not be empty!"

        } else {
            oAge?.error = null
            c3 = true;
        }
        if (imageUri==null) {
            Toast.makeText(this, "select an image !", Toast.LENGTH_SHORT).show()
        }
        if (c1 && c2 && c3 && imageUri!=null) {
            return true
        } else return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            getContentResolver().takePersistableUriPermission(
                imageUri!!,Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
            imageview.setImageURI(imageUri)
        }


    }

}