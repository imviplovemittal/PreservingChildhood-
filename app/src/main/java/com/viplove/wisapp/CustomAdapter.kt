package com.viplove.wisapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * Created by viplo on 23-Jan-18.
 */
class CustomAdapter(val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    //var m : MainActivity?=null
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val user : User = userList[position]

        holder?.textViewName?.setText(user.name)
        holder?.textViewDept?.setText(user.dept)
        holder?.button?.setText(user.aval)
        if(user.aval.equals("View")) {
            holder?.button?.setOnClickListener({
                var intent = Intent(MainActivity.Statified.getContext(), StudentDetails::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.putExtra("name", user.name)
                intent.putExtra("dept", user.dept)
                MainActivity.Statified.getContext()?.startActivity(intent)
            })
        }
        else{
            holder?.button?.setOnClickListener({
                var intent = Intent(MainActivity.Statified.getContext(), Invite::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                MainActivity.Statified.getContext()?.startActivity(intent)
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById<TextView>(R.id.name_text)
        val textViewDept = itemView.findViewById<TextView>(R.id.dept_text)
        val button = itemView.findViewById<Button>(R.id.view_button)
    }

}