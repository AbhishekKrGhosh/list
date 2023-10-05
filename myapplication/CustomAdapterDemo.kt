package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CustomAdapterDemo(
    context: Context,
    var resource: Int,
    var objects: MutableList<ContactDataModelClass>
) : ArrayAdapter<ContactDataModelClass>(context, resource, objects)
{
    lateinit var cb:CheckBox
    fun isChecked(position: Int): Boolean {
        return objects.get(position).checked
    }
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {



        val layoutInflater=LayoutInflater.from(context)
        val view:View=layoutInflater.inflate(resource, null)
        val imageView:ImageView=view.findViewById(R.id.imageView2)
        val title: TextView =view.findViewById(R.id.textView2)
        val cb: CheckBox = view.findViewById(R.id.checkBox)
        val button: Button = view.findViewById(R.id.button)
        val description:TextView=view.findViewById(R.id.textView)
        val mItem: ContactDataModelClass=objects[position]
        imageView.setImageDrawable(context.resources.getDrawable(mItem.img))
        title.text = mItem.title
        description.text= mItem.price.toString()
        button.tag=position
        button.setOnClickListener {
            val itemselected = objects.get(button.tag as Int)
            objects.remove(itemselected)
            notifyDataSetChanged()
        }
        cb.setChecked(objects.get(position).checked)
        cb.setTag(position)
        var itemStr = objects.get(position).title
        cb.setOnClickListener(View.OnClickListener {
            val newState: Boolean = !objects.get(position).isChecked()
            objects.get(position).checked = newState
            Toast.makeText(
                context,itemStr+
                        "Selected with state   : "+newState ,
                Toast.LENGTH_LONG
            ).show()
        })
        cb.setChecked(isChecked(position))

        return view

    }




}