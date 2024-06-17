package com.example.tangxiao

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FoodAdapter(activity: Activity,private val resourceId:Int,data:List<Food>):ArrayAdapter<Food>(activity,resourceId,data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val foodImage: ImageView = view.findViewById(R.id.imageView1)
            val foodName: TextView = view.findViewById(R.id.textView1)
            viewHolder = ViewHolder(foodImage, foodName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val food = getItem(position) // 获取当前项的Fruit实例
        if (food != null) {
            viewHolder.foodImage.setImageResource(food.imgId)
            viewHolder.foodName.text = food.name
        }
        return view
    }

    inner class ViewHolder(val foodImage: ImageView, val foodName: TextView)
}