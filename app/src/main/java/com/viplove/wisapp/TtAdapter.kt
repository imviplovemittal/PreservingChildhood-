package com.viplove.wisapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by viplo on 23-Jan-18.
 */
class TtAdapter(val userList: ArrayList<TT>): RecyclerView.Adapter<TtAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: TtAdapter.ViewHolder?, position: Int) {
        val tt : TT = userList[position]
        holder?.sTime?.setText(tt.sTime)
        holder?.slot?.setText(tt.slot)
        holder?.eTime?.setText(tt.eTime)
        holder?.sub?.setText(tt.subNmae)
        holder?.room?.setText(tt.roomno)
        holder?.faculty?.setText(tt.faculty)
        holder?.batch?.setText(tt.batch)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TtAdapter.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.sd_list_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        var sTime = itemView.findViewById<TextView>(R.id.sTimeText)
        var slot = itemView.findViewById<TextView>(R.id.slotText)
        var eTime = itemView.findViewById<TextView>(R.id.eTimeText)
        var sub = itemView.findViewById<TextView>(R.id.subText)
        var room = itemView.findViewById<TextView>(R.id.rnoText)
        var faculty = itemView.findViewById<TextView>(R.id.facText)
        var batch =itemView.findViewById<TextView>(R.id.batchText)
    }
}