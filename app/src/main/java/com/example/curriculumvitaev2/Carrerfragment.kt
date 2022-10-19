package com.example.curriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [carrerfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class carrerfragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var EdList: List<CareerData>

        EdList= listOf(
            CareerData(R.drawable.ic_logo_esprit,"Esprit","Ghazela","today","tmrw"),
            CareerData(R.drawable.ic_logo_harvard,"Harvard","USA","today","tmrw"),
            CareerData(R.drawable.ic_logo_cambridge,"Cambridge","UK","today","tmrw"),

            )
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_carrerfragment, container, false)
        val recyclerview = view?.findViewById<RecyclerView>(R.id.EdRecycler)
        recyclerview?.layoutManager = LinearLayoutManager(context)
        val adapter = CareerAdapter(EdList)
        recyclerview?.adapter=adapter
        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment carrerfragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            carrerfragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}