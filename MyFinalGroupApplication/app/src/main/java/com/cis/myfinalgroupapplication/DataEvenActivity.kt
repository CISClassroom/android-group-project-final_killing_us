package com.cis.myfinalgroupapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_add_even.*
import kotlinx.android.synthetic.main.activity_data_even.*

class DataEvenActivity : AppCompatActivity() {
    lateinit var mDatabase: DatabaseReference
    lateinit var adapter: ToDoItemAdapter
    private var listViewItems: ListView? = null
    var toDoItemList: MutableList<AddEven>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_even)

        //เชื่อมหน้า
        var name = getIntent().getStringExtra("name")
        val goadd: Button = findViewById(R.id.add)
        goadd.setOnClickListener {
            var i = Intent(this, AddEvenActivity::class.java)
            i.putExtra("name",name)
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)



        }
        listViewItems = findViewById<View>(R.id.list_even) as ListView
        toDoItemList = mutableListOf<AddEven>()
        adapter = ToDoItemAdapter(this, toDoItemList!!)
        listViewItems!!.setAdapter(adapter)

        mDatabase = FirebaseDatabase.getInstance().reference

        mDatabase.child("Event").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = dataSnapshot.children.iterator()
                var name = getIntent().getStringExtra("name")
                // Check if current database contains any collection
                if (items.hasNext()) {
                    while (items.hasNext()) {
                        val toDoListindex = items.next()
                        val map = toDoListindex.getValue() as HashMap<String, Any>
                        if (map.get("studentss") == name) {
                            // add data to object
                            val todoItem = AddEven.create()
                            todoItem.id_e = map.get("id_e") as String?
                            todoItem.name_e = map.get("name_e") as String?
                            todoItem.unit_e = map.get("unit_e") as String?
                            toDoItemList!!.add(todoItem);
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
            }
        })
    }
}

