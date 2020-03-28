package com.cis.myfinalgroupapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_even.*
import kotlinx.android.synthetic.main.activity_add_even.btn_en
import kotlinx.android.synthetic.main.activity_data_student.*

class AddEvenActivity : AppCompatActivity() {

    lateinit var mDatabase: DatabaseReference
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_even)


        //2
        auth = FirebaseAuth.getInstance()
        // Id = auth.currentUser!!.uid
        mDatabase = FirebaseDatabase.getInstance().reference
        btn_en.setOnClickListener {
            AddData("String")
        }
    }
    fun AddData(data: String) {
        var name = getIntent().getStringExtra("name")
        var newData: AddEven = AddEven.create()
        val obj = mDatabase.child("Event").push()

        newData.studentss = name.toString()
        newData.id_e = editText2.text.toString()
        newData.name_e = editText3.text.toString()
        newData.unit_e = editText4.text.toString()

//        newData.EvenId = obj.key
        obj.setValue(newData)

        Toast.makeText(applicationContext, "Note save successfully", Toast.LENGTH_LONG).show()
        var i = Intent(this, DataEvenActivity::class.java)
        i.putExtra("name",name)
        startActivity(i)
        finish()
    }
}
