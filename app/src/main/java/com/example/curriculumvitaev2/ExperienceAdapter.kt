package com.example.curriculumvitaev2

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculumvitaev2.Data.Experience
lateinit var delete: ImageView

class ExperienceAdapter(val ExpList: MutableList<Experience>) : RecyclerView.Adapter<ExperienceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.experience_single_item, parent, false)

        delete=rootView.findViewById(R.id.deleteEXP)


        return ExperienceViewHolder(rootView)

    }
    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        holder.ExpPic.setImageResource( R.drawable.ic_logo_amazon)
        holder.ExpName.setText(ExpList[position].compName)
        holder.ExpLoc.setText(ExpList[position].compAdd)
        holder.ExpFirstDate.setText(ExpList[position].startDate)
        holder.ExpLastdate.setText(ExpList[position].EndDate)
      //  holder.ExpDesc.setText(ExpList[position].)

delete.setOnClickListener {
    dataBase.expDAO().delete(ExpList[position])
    ExpList.removeAt(position)
    notifyDataSetChanged()
}

    }

    override fun getItemCount(): Int = ExpList.size

}