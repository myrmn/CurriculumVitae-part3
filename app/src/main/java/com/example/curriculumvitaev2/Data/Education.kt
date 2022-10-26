package com.example.curriculumvitaev2.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Education")
data class Education(

    @PrimaryKey(autoGenerate = true)
    val id: Int=0,

    @ColumnInfo(name = "uName")
    val uName: String,

    @ColumnInfo(name = "uAdd")
    val uAdd: String,

    @ColumnInfo(name = "startDate")
    val startDate: String,

    @ColumnInfo(name = "EndDate")
    val EndDate: String,
    @ColumnInfo(name = "Pic")
    val Pic: String
)
