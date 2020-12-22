package com.example.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CategoryList1() : AppCompatActivity() {
    var count : String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list1)
        val intent = Intent(this,MainActivity::class.java)
        val button1 : Button = findViewById(R.id.button1)
        val button2 : Button = findViewById(R.id.button2)
        val button3 : Button = findViewById(R.id.button3)
        val button4 : Button = findViewById(R.id.button4)
        val button5 : Button = findViewById(R.id.button5)
        val button6 : Button = findViewById(R.id.button6)
        val button7 : Button = findViewById(R.id.button7)
        button1.setOnClickListener{
            intent.putExtra("type","1")
            startActivity(intent)
        }
        button2.setOnClickListener{
            intent.putExtra("type","2")
            startActivity(intent)
        }
        button3.setOnClickListener{
            intent.putExtra("type","3")
            startActivity(intent)
        }
        button4.setOnClickListener{
            intent.putExtra("type","4")
            startActivity(intent)
        }
        button5.setOnClickListener{
            intent.putExtra("type","5")
            startActivity(intent)
        }
        button6.setOnClickListener{
            intent.putExtra("type","6")
            startActivity(intent)
        }
        button7.setOnClickListener{
            intent.putExtra("type","7")
            startActivity(intent)
        }
    }

}