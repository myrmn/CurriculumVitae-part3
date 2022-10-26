package com.example.curriculumvitaev2.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.curriculumvitaev2.Data.Education
import com.example.curriculumvitaev2.Data.Experience
import com.example.curriculumvitaev2.dao.EducationDAO
import com.example.curriculumvitaev2.dao.ExperienceDAO


@Database(entities = [Experience::class,Education::class], version = 2)
abstract  class AppDataBase : RoomDatabase() {
    abstract fun expDAO(): ExperienceDAO
    abstract fun eduDAO(): EducationDAO
    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "CV")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return instance!!
        }
    }
}