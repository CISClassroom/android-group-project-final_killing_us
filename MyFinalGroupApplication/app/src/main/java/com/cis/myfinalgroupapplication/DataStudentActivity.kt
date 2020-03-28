package com.cis.myfinalgroupapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data_student.*

class DataStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_student)

        var name = getIntent().getStringExtra("name")
        var id = getIntent().getStringExtra("id")
        var saka = getIntent().getStringExtra("saka")
        var cana = getIntent().getStringExtra("cana")

        stu_name.text = name
        stu_id.text = id
        stu_saka.text = saka
        stu_cana.text = cana

        btn_en.setOnClickListener {
            val  intent = Intent(this,DataEvenActivity::class.java)
            intent.putExtra("name",name)
            startActivity(intent)
        }


    }
}
