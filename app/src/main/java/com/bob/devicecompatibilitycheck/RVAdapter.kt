package com.bob.devicecompatibilitycheck

import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val lists: List<String>): RecyclerView.Adapter<StringHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringHolder {
        return StringHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: StringHolder, position: Int) {
        holder.bindHero(lists[position], position, itemCount)
        var entire: LinearLayout = holder.itemView.findViewById(R.id.entire)
        holder.itemView.isFocusable = true
        holder.itemView.setOnFocusChangeListener { _, focused ->
            if (focused) {
                entire.background = holder.itemView.context.getDrawable(R.drawable.border)
            } else {
                entire.background = null
            }
        }
    }

    override fun getItemCount(): Int = lists.size

}

class StringHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvName = view.findViewById<TextView>(R.id.variable_name)
    private val availability = view.findViewById<TextView>(R.id.availability)
    private val pm: PackageManager = view.context.packageManager

    fun bindHero(name: String, position: Int, length: Int) {
        tvName.text = "${position+1}/$length $name"
        availability.text = if (check(name)) {
            "Available"
        } else {
            "Not Available"
        }
    }

    fun check(hardware: String): Boolean{
        return pm.hasSystemFeature(hardware)
    }
}