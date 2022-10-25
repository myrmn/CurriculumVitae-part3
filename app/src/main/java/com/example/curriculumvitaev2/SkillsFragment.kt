package com.example.curriculumvitaev2

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.google.android.material.slider.Slider


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [skillsfragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class skillsfragment : Fragment() {
    lateinit var mSharedPref: SharedPreferences

    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         var remember: CheckBox?=null

        // Inflate the layout for this fragment
    val view= inflater.inflate(R.layout.fragment_skillsfragment, container, false)
        val android: Slider = view.findViewById(R.id.seekBar_android1)
        //android.value= arguments?.getFloat( ARG_PARAM1)!!
        val ios: Slider = view.findViewById(R.id.seekBar_ios1)
        //ios.value= arguments?.getFloat( ARG_PARAM2)!!
        val flutter: Slider = view.findViewById(R.id.seekBar_flutter1)
       // flutter.value= arguments?.getFloat( ARG_PARAM3)!!
        val preferences = this.requireActivity().getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        var check:Boolean=preferences.getBoolean(IS_REMEMBRED, true)


if (check)
{
    var a=preferences.getFloat(ANDROID, 0F)/100
    var i=preferences.getFloat(IOS, 0F)/100
    var f=preferences.getFloat(FLUTTER, 0F)/100
    android.value=a
    ios.value=i
    flutter.value=f
}


    return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment skillsfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            skillsfragment().apply {


            }
    }
}