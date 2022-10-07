package com.neilkrishna.basicapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.room.Room
import com.neilkrishna.basicapplication.databinding.ActivityAddPeopleInfoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddPeopleInfoActivity : AppCompatActivity() {
    lateinit var database: PersonDatabase
    private lateinit var binding: ActivityAddPeopleInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPeopleInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database=PersonDatabase.getDatabase(this)
        binding.btnAddPersonInfo.setOnClickListener{

            addPerson()}

    }

    private fun addPerson() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = binding.etAge.text.toString()
        val gender = binding.etGender.text.toString()
        val email = binding.etEmail.text.toString()

        if(firstName.isNotEmpty() && lastName.isNotEmpty() && age.isNotEmpty()  && gender.isNotEmpty() && email.isNotEmpty()    ) {
            val person = Person(0, firstName, lastName, age.toInt(), gender, email)

            GlobalScope.launch(Dispatchers.IO)
            {
                database.personDao().insertPerson(person)
            }

            binding.etAge.text.clear()
            binding.etGender.text.clear()
            binding.etEmail.text.clear()
            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()
            Toast.makeText(this@AddPeopleInfoActivity,"Successfully written",Toast.LENGTH_SHORT).show()
        }else Toast.makeText(this@AddPeopleInfoActivity,"PLease Enter Data",Toast.LENGTH_SHORT).show()

    }


}