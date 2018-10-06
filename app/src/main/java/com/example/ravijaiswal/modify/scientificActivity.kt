package com.example.ravijaiswal.modify

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_scientific.*
import net.objecthunter.exp4j.ExpressionBuilder

class scientificActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scientific)        //Numbers
        tvOne1.setOnClickListener { appendonExpression("1", true) }
        tvTwo1.setOnClickListener { appendonExpression("2", true) }
        tvThree1.setOnClickListener { appendonExpression("3", true) }
        tvFour1.setOnClickListener { appendonExpression("4", true) }
        tvFive1.setOnClickListener { appendonExpression("5", true) }
        tvSix1.setOnClickListener { appendonExpression("6", true) }
        tvSeven1.setOnClickListener { appendonExpression("7", true) }
        tvEight1.setOnClickListener { appendonExpression("8", true) }
        tvNine1.setOnClickListener { appendonExpression("9", true) }
        tvZero1.setOnClickListener { appendonExpression("0", true) }
        tvDot1.setOnClickListener { appendonExpression(".", true) }

        //operators
         tvPlus1.setOnClickListener { appendonExpression("+", false) }
          tvMinus1.setOnClickListener { appendonExpression("-", false) }
          tvMul1.setOnClickListener { appendonExpression("*", false) }
          tvDivide1.setOnClickListener { appendonExpression("/", false) }
          tvOpen1.setOnClickListener { appendonExpression("(", false) }
          tvClose1.setOnClickListener { appendonExpression(")", false) }
          tvPi1.setOnClickListener { appendonExpression("pi", false) }

          tvExcli1.setOnClickListener { appendonExpression("pi", false) }
          tvSin1.setOnClickListener { appendonExpression("sin(", false) }
          tvCos1.setOnClickListener { appendonExpression("cos(", false) }
          tvTan1.setOnClickListener { appendonExpression("tan(", false) }
          tvLn1.setOnClickListener { appendonExpression("lg(", false) }
          tvLg1.setOnClickListener { appendonExpression("lg(", false) }
          tvPower1.setOnClickListener { appendonExpression("^", false) }
          tvRoot1.setOnClickListener { appendonExpression("^", false) }
          tvE1.setOnClickListener { appendonExpression("e", false) }

          tvMore1.setOnClickListener{
              val Intent  = Intent(this,ListActivity::class.java)
              startActivity(Intent)
          }
          tvClear1.setOnClickListener {
              tvExpression1.text = ""
              tvResult1.text = ""
          }
          tvBack1.setOnClickListener {
              val string = tvExpression1.text.toString()
              if (string.isNotEmpty()) {
                  tvExpression1.text = string.substring(0, string.length - 1)
              }
              tvResult1.text = ""
          }
          tvEquals1.setOnClickListener {
              try {
                  val expression1 = ExpressionBuilder(tvExpression1.text.toString()).build()
                  val result1 = expression1.evaluate()
                  val longResult = result1.toLong()
                  if (result1 == longResult.toDouble())
                      tvResult1.text = longResult.toString()
                  else
                      tvResult1.text = result1.toString()
              } catch (e: Exception) {
                  Log.d("Exception", "message : " + e.message)
                  tvResult1.text="Error"
              }
          }
    }


    fun appendonExpression(string: String,canClear : Boolean){

        if(tvResult1.text.isNotEmpty()){
            tvExpression1.text=""
        }


        if(canClear) {
            tvResult1.text = ""
            tvExpression1.append(string)
        }
        else{
            tvExpression1.append(tvResult1.text)
            tvExpression1.append(string)
            tvResult1.text=""
        }
    }
}
