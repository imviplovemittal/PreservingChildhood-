package com.viplove.wisapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_layout.*

class MainActivity : AppCompatActivity() {
    object Statified
    {
        var mContext: Context? = null
        fun getContext() : Context? {
            return Statified.mContext
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Statified.mContext = baseContext

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val searchButton = findViewById<Button>(R.id.button)
        recyclerView?.visibility = View.INVISIBLE

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val users = ArrayList<User>()
        users.add(User("Viplove Mittal","Software Engineering","View"))
        users.add(User("Absar","Software Engineering","View"))
        users.add(User("Harsh","Software Engineering","View"))
        users.add(User("Prakhar","Computer Science Engineering","Invite"))
        users.add(User("Himanshu","Software Engineering","View"))

        val adapter = CustomAdapter(users)
        recyclerView?.adapter = adapter

        searchButton?.setOnClickListener(clickListener)


    }
    val clickListener = View.OnClickListener{view ->
        when(view.getId()){
            R.id.button -> {
                if(name_editText.text.equals(null) || date_editText.text.equals(null)) {
                    Toast.makeText(this,"Info not found!!!",Toast.LENGTH_SHORT).show()
                }
                else{
                    recyclerView.visibility = View.VISIBLE
                }
                //name_editText.setText("Viplove")
            }
        }
    }

    /*companion object {
        var mContext: Context ? = this as Context
        fun getContext() : Context?{
            return mContext
        }
    }*/
}
