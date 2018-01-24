package com.viplove.wisapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_student_details.*

class StudentDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        var name = intent.extras.getString("name")
        var dept = intent.extras.getString("dept")
        stud_name.text = name
        stud_dept.text = dept

        val sdRecyclerView = findViewById<RecyclerView>(R.id.details_recycler_view)
        sdRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val timeTable = ArrayList<TT>()
        timeTable.add(TT("08:00","B","08:50","MicroProcessor","1205","H. Karthikeyan","Batch 2"))
        timeTable.add(TT("08:00","B","08:50","MicroProcessor","1205","H. Karthikeyan","Batch 2"))
        timeTable.add(TT("08:00","B","08:50","MicroProcessor","1205","H. Karthikeyan","Batch 2"))
        timeTable.add(TT("08:00","B","08:50","MicroProcessor","1205","H. Karthikeyan","Batch 2"))
        timeTable.add(TT("08:00","B","08:50","MicroProcessor","1205","H. Karthikeyan","Batch 2"))

        val adapter_sd = TtAdapter(timeTable)
        sdRecyclerView?.adapter = adapter_sd

    }
}
