package com.example.bmicalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weightText= findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etheight)
        val calButton = findViewById<Button>(R.id.btnCalculate)

        calButton.setOnClickListener {
            // accept user input
            val weight= weightText.text.toString()
            val height = heightText.text.toString()
//our BMI logic

            if (validateInput(weight,height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
                val bm12digits = String.format("%2f", bmi).toFloat()
                displayResults(bm12digits)
            }

      }
}

    private fun validateInput(weight:String?, height:String?):Boolean{

        return when{
            weight.isNullOrEmpty()->{
                Toast.makeText(this, "weight is empty", Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this, "weight is empty", Toast.LENGTH_LONG).show()

            return false

            }
            else ->
                return true
        }
    }


    private fun displayResults(bmi:Float){
val resultIndex = findViewById<TextView>(R.id.tvIndex)
        val resultDescription= findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvInfo)


        resultIndex.text= bmi.toString()
        info.text= "normal range is 18.5 - 24.9"

 var resultText =""
        var color = 0

        when {
            bmi< 18.50 -> {
                resultText="underweight"
                color = R.color.underweight
            }
            bmi in 18.50..24.99->{
                resultText= "Healthy"
                color= R.color.Normal
            }
bmi in 25.0 ..29.99 -> {
    resultText ="Overweight"
    color=R.color.Overweight
}
            bmi > 29.99->{
                resultText="Obese"
                color=R.color.obese
            }
        }

resultDescription.setTextColor(ContextCompat.getColor(this, color))
        resultDescription.text=resultText
    }
    }

