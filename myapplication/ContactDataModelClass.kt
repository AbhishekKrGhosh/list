package com.example.myapplication

class ContactDataModelClass
    (val title: String, var checked: Boolean, val price:Int, val img:Int)
{

        fun isChecked(): Boolean {
            return checked
        }


}