package com.example.curriculumvitaev2.dao

import androidx.room.*
import com.example.curriculumvitaev2.Data.Experience


@Dao
interface ExperienceDAO {
    @Insert
    fun insert(champ: Experience)

    @Update
    fun update(champ: Experience)

    @Delete
    fun delete(champ: Experience)

    @Query("SELECT * FROM Experience")
    fun getAllChamps(): List<Experience>
}