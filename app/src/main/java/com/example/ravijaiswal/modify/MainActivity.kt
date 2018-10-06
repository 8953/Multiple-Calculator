package com.example.ravijaiswal.modify

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener { appendonExpression("1", true) }
        tvTwo.setOnClickListener { appendonExpression("2", true) }
        tvThree.setOnClickListener { appendonExpression("3", true) }
        tvFour.setOnClickListener { appendonExpression("4", true) }
        tvFive.setOnClickListener { appendonExpression("5", true) }
        tvSix.setOnClickListener { appendonExpression("6", true) }
        tvSeven.setOnClickListener { appendonExpression("7", true) }
        tvEight.setOnClickListener { appendonExpression("8", true) }
        tvNine.setOnClickListener { appendonExpression("9", true) }
        tvZero.setOnClickListener { appendonExpression("0", true) }
        tvDot.setOnClickListener { appendonExpression(".", true) }

        //operators
        tvPlus.setOnClickListener { appendonExpression("+", false) }
        tvMinus.setOnClickListener { appendonExpression("-", false) }
        tvMul.setOnClickListener { appendonExpression("*", false) }
        tvDivide.setOnClickListener { appendonExpression("/", false) }
        tvOpen.setOnClickListener { appendonExpression("(", false) }
        tvClose.setOnClickListener { appendonExpression(")", false) }
        tvPercent.setOnClickListener { appendonExpression("%", false) }
        tvMore.setOnClickListener{
                val Intent  = Intent(this,ListActivity::class.java)
        startActivity(Intent)
    }
        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }
        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length - 1)
            }
            tvResult.text = ""
        }
        tvEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()
            } catch (e: Exception) {
                Log.d("Exception", "message : " + e.message)
            }
        }
    }


    fun appendonExpression(string: String,canClear : Boolean){

        if(tvResult.text.isNotEmpty()){
            tvExpression.text=""
        }


        if(canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        }
        else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text=""
        }
    }
}
