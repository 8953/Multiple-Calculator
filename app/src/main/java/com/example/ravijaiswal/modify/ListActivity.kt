package com.example.ravijaiswal.modify

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        btn_Scientific.setOnClickListener {
            val Intent = Intent(this, scientificActivity::class.java)
            startActivity(Intent)
        }

            btn_Temp.setOnClickListener {
                val Intent = Intent(this, TempatureActivity::class.java)
                startActivity(Intent)
            }

        btn_back.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }


        }
    }

