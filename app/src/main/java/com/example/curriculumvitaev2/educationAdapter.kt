package com.example.curriculumvitaev2

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculumvitaev2.Data.Education
lateinit var delete2: ImageView

class educationAdapter(val EducationList : MutableList<Education>) : RecyclerView.Adapter<educationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): educationViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.education_single_item,parent,false)
        delete2=rootView.findViewById(R.id.deleteU)

        return educationViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: educationViewHolder, position: Int) {
      //  holder.EduPic.setImageURI(Uri.parse(EducationList[position].Pic))
        holder.EduPic.setImageResource(R.drawable.ic_logo_esprit)
        holder.EduName.setText(EducationList[position].uName)
        holder.EduLoc.setText(EducationList[position].uAdd)
        holder.EduFirstDate.setText(EducationList[position].startDate)
        holder.EduLastdate.setText(EducationList[position].EndDate)

        delete2.setOnClickListener {
            dataBase.eduDAO().delete(EducationList[position])
            EducationList.removeAt(position)
            notifyDataSetChanged()
        }


    }

    override fun getItemCount(): Int =EducationList.size
}