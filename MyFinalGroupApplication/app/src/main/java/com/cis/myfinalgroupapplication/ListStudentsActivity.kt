package com.cis.myfinalgroupapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListStudentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_students)

        val students_name = resources.getStringArray(R.array.students60)
        val students_id = resources.getStringArray(R.array.student60_id)
        val student_list = mutableListOf<student>()

        for (i in 0..students_name.size-1) {
            student_list.add(student(students_name[i],students_id[i],"วิทยาการคอมพิวเตอร์และสารสนเทศ","วิทยาศาสตร์ประยุกต์และวิศวกรรมสตร์"))
        }
        val listView = findViewById<ListView>(R.id.list_even)
        listView.adapter = ListAdapter(
            this,
            R.layout.student_list,
            student_list
        )

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as student
            //Toast.makeText(this,selectedItem,Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DataStudentActivity::class.java)
            intent.putExtra("name",selectedItem.name)
            intent.putExtra("id",selectedItem.id)
            intent.putExtra("saka",selectedItem.saka)
            intent.putExtra("cana",selectedItem.cana)
            startActivity(intent)
        }
    }
}