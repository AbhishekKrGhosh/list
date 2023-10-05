package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView=findViewById<ListView>(R.id.listView)
        var list= mutableListOf<ContactDataModelClass>()
        val bt1: Button = findViewById(R.id.button2)


        list.add(ContactDataModelClass("Milk", false,30, R.drawable.images))
        list.add(ContactDataModelClass("Soap", false,50, R.drawable.images))
        list.add(ContactDataModelClass("Bag", false,900, R.drawable.images))
        list.add(ContactDataModelClass("Book", false,350, R.drawable.images))
        list.add(ContactDataModelClass("Pen", false,10, R.drawable.images))
        listView.adapter=CustomAdapterDemo(this, R.layout.activity_customlookfile, list)

        bt1.setOnClickListener{
            var str = "check items: "
            val cnt: Int = list.count()
            for(i in 0 until cnt){
                var a = CustomAdapterDemo(this, R.layout.activity_customlookfile,list)
                if(a.isChecked(i)){
                    var n = list[i].title
                    str += """$i . $n """.trimIndent()
                }
            }
                Toast.makeText(this,
                str,
                Toast.LENGTH_LONG).show()
        }

    }
}


