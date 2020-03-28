package com.cis.myfinalgroupapplication

import android.content.Context as Context1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class ListAdapter(var mCtx: Context1, var resource:Int, var items:List<student>)
    : ArrayAdapter<student>( mCtx , resource , items ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //super.getView(position, convertView, parent)

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

        val view: View = layoutInflater.inflate(resource, null)
        var tvStudentName : TextView = view.findViewById(R.id.textView14)
        var tvStudentID : TextView = view.findViewById(R.id.textView15)


        var student: student = items[position]

        tvStudentName.text = student.name
        tvStudentID.text = student.id

        return view
    }
}

class ToDoItemAdapter(context: android.content.Context, toDoItemList: MutableList<AddEven>) : BaseAdapter() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var itemList = toDoItemList


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // create object from view
        val id: String = itemList.get(position).id_e as String
        val name: String = itemList.get(position).name_e as String
        val unit: String = itemList.get(position).unit_e as String
        val view: View
        val vh: ListRowHolder

        // get list view
        if (convertView == null) {
            view = mInflater.inflate(R.layout.list_e, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }

        // add text to view
        vh.label1.text = id
        vh.label2.text = name
        vh.label3.text = unit

        return view
    }

    override fun getItem(index: Int): Any {
        return itemList.get(index)
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getCount(): Int {
        return itemList.size
    }

    private class ListRowHolder(row: View?) {
        val label1: TextView = row!!.findViewById<TextView>(R.id.textView) as TextView
        val label2: TextView = row!!.findViewById<TextView>(R.id.textView3) as TextView
        val label3: TextView = row!!.findViewById<TextView>(R.id.textView5) as TextView
    }
}