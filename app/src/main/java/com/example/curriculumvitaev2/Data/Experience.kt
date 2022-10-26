package com.example.curriculumvitaev2.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "Experience")
    data class Experience(

@PrimaryKey(autoGenerate = true)
val id: Int=0,

@ColumnInfo(name = "compName")
val compName: String,

@ColumnInfo(name = "compAdd")
val compAdd: String,

@ColumnInfo(name = "startDate")
val startDate: String,

        @ColumnInfo(name = "EndDate")
val EndDate: String,
        @ColumnInfo(name = "Pic")
val Pic: String
)
