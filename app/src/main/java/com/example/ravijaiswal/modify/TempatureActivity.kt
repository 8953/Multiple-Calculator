package com.example.ravijaiswal.modify

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tempature.*
import java.util.*
import android.content.Intent
import android.util.Log
import android.widget.*
import com.example.ravijaiswal.modify.R.id.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_scientific.*
import net.objecthunter.exp4j.ExpressionBuilder

class TempatureActivity : AppCompatActivity() {
    lateinit var typeSpin: Spinner
    val types = arrayOf("Celsius (°C)","Fahrenheit (°F)","Kelvin (°K)","Rankine (°R)", "Reaumur (°Re)")
    lateinit var option3 : Spinner
      lateinit var result3  :TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tempature)

       tvMore2.setOnClickListener {
            val Intent = Intent(this, ListActivity::class.java)
            startActivity(Intent)
        }

   option3 = findViewById<View>(R.id.sp_temp) as Spinner
 result3 = findViewById<View>(R.id.tv_result3) as TextView
        var options3 = arrayOf("Celsius (°C)","Fahrenheit (°F)","Kelvin (°K)","Rankine (°R)","Reaumur (°Re)")
        option3.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options3)

        option3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


        override fun onNothingSelected(parent: AdapterView<*>?) {
            tv_result3.text = " Please select a option : "
        }


        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            tv_result3.text = options3.get(position)

        }

    }


    val convert = findViewById<View>(R.id.convert) as Button
    typeSpin = findViewById<View>(R.id.sp_temp) as Spinner
    val typeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types)
    typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    typeSpin!!.setAdapter(typeAdapter)
    convert.setOnClickListener {
        view: View? -> convertFunc()
    }
}
private fun convertFunc() {
    val temperatureTxt = findViewById<View>(R.id.tvExpression2) as EditText
    val temperature = temperatureTxt.text.toString().trim()
    val tempNo = Integer.parseInt(temperature)
    val format = typeSpin.selectedItem.toString().trim()
    /*val answer1 = findViewById<View>(R.id.answer1) as TextView
    val answer2 = findViewById<View>(R.id.answer2) as TextView
    val ans1 = findViewById<View>(R.id.ans1) as TextView
    val ans2 = findViewById<View>(R.id.ans2) as TextView*/

    val tv_result31 = findViewById<View>(R.id.tv_result31) as TextView
    val tv_result32 = findViewById<View>(R.id.tv_result32) as TextView
    val tv_result33 = findViewById<View>(R.id.tv_result33) as TextView
    val tv_result34 = findViewById<View>(R.id.tv_result34) as TextView

    val tv_result311 = findViewById<View>(R.id.tv_result311) as TextView
    val tv_result321 = findViewById<View>(R.id.tv_result321) as TextView
    val tv_result331 = findViewById<View>(R.id.tv_result331) as TextView
    val tv_result341 = findViewById<View>(R.id.tv_result341) as TextView


    if (!temperature.isEmpty()) {
        if (format == "Celsius (°C)") {
            tv_result31.text = "Fahrenheit (°F)"
            tv_result32.text = "Kelvin (°K)"
            tv_result33.text = "Rankine (°R)"
            tv_result34.text = "Reaumur (°Re)"
            //values
            tv_result311.text = ((tempNo - 32) * 5 / 9).toString()
            tv_result321.text = ((tempNo - 32) * 5 / 9 + 273.15).toString()
            tv_result331.text = ((tempNo) + 459.67).toString()
            tv_result341.text = ((tempNo - 32) * 4 / 9).toString()
        }else if (format == "Kelvin (°K)") {
           /* ans1.text = "Fahrenheit"
            ans2.text = "Celsius"
            answer1.text = ((tempNo - 273.15) * 9/5 + 32	).toString()
            answer2.text = (tempNo - 273.15	).toString()*/
            tv_result31.text = "Fahrenheit (°F)"
            tv_result32.text = "Celsius (°C)"
            tv_result33.text = "Rankine (°R)"
            tv_result34.text = "Reaumur (°Re)"
            //values
            tv_result311.text = ((tempNo - 273.15) * 9/5 + 32).toString()
            tv_result321.text = (tempNo - 273.15).toString()
            tv_result331.text = ((tempNo) + 459.67).toString()
            tv_result341.text = ((tempNo - 32) * 4 / 9).toString()



        }else if (format == "Fahrenheit (°F)") {
           /* ans1.text = "Celsius"
            ans2.text = "Kelvin"
            answer1.text = ((tempNo - 52) * 5/9).toString()
            answer2.text = ((tempNo - 32) * 5/9 + 273.15).toString()*/
            tv_result31.text = "Celsius (°C)"
            tv_result32.text = "Kelvin (°K)"
            tv_result33.text = "Rankine (°R)"
            tv_result34.text = "Reaumur (°Re)"
            //values
            tv_result311.text = ((tempNo - 52) * 5/9).toString()
            tv_result321.text = ((tempNo - 32) * 5/9 + 273.15).toString()
            tv_result331.text = ((tempNo) + 459.67).toString()
            tv_result341.text = ((tempNo - 32) * 4 / 9).toString()
        }else if (format == "Rankine (°R)") {
            /* ans1.text = "Celsius"
             ans2.text = "Kelvin"
             answer1.text = ((tempNo - 52) * 5/9).toString()
             answer2.text = ((tempNo - 32) * 5/9 + 273.15).toString()*/
            tv_result31.text = "Fahrenheit (°F)"
            tv_result32.text = "Kelvin (°K)"
            tv_result33.text = "Celsius (°C)"
            tv_result34.text = "Reaumur (°Re)"
            //values
            tv_result311.text = ((tempNo - 32) * 5 / 9).toString()
            tv_result321.text = ((tempNo - 32) * 5 / 9 + 273.15).toString()
            tv_result331.text = ((tempNo) + 459.67).toString()
            tv_result341.text = ((tempNo - 32) * 4 / 9).toString()
        }else if (format == "Reaumur (°Re)") {
            /* ans1.text = "Celsius"
             ans2.text = "Kelvin"
             answer1.text = ((tempNo - 52) * 5/9).toString()
             answer2.text = ((tempNo - 32) * 5/9 + 273.15).toString()*/
            tv_result31.text = "Fahrenheit (°F)"
            tv_result32.text = "Kelvin (°K)"
            tv_result33.text = "Rankine (°R)"
            tv_result34.text = "Celsius (°C)"
            //values
            tv_result311.text = ((tempNo - 32) * 5 / 9).toString()
            tv_result321.text = ((tempNo - 32) * 5 / 9 + 273.15).toString()
            tv_result331.text = ((tempNo) + 459.67).toString()
            tv_result341.text = ((tempNo - 32) * 4 / 9).toString()
        }

    }

}
}
