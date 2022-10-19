package com.example.curriculumvitaev2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CareerAdapter (private var myList: List<CareerData>) : RecyclerView.Adapter<CareerAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.singleitemexp ,parent, false)

        return ViewHolder(view)
    }
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageeed)
        val cName: TextView = itemView.findViewById(R.id.compEd)
        val cAdress: TextView = itemView.findViewById(R.id.added)
        val startDate: TextView=itemView.findViewById(R.id.startDateEd)
        val endDate: TextView=itemView.findViewById(R.id.EndDateEd)
    }
    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = myList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.cName.text = ItemsViewModel.companyName
        holder.cAdress.text = ItemsViewModel.companyAdress
        holder.startDate.text=ItemsViewModel.startDate
        holder.endDate.text=ItemsViewModel.endDate

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return myList.size
    }


}