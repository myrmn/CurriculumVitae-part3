package com.example.curriculumvitaev2.dao

import androidx.room.*
import com.example.curriculumvitaev2.Data.Education
import com.example.curriculumvitaev2.Data.Experience

@Dao
interface EducationDAO {
    @Insert
    fun insert(champ: Education)

    @Update
    fun update(champ: Education)

    @Delete
    fun delete(champ: Education)

    @Query("SELECT * FROM Education")
    fun getAllUniversities(): List<Education>
}