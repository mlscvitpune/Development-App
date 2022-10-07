package com.neilkrishna.basicapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDAO {
    @Insert
     fun insertPerson(person : Person)

    @Query("SELECT * FROM person")
    fun getPerson() : LiveData<List<Person>>


}