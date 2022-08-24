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

        //Declare views
        val weightText= findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etheight)
        val calButton = findViewById<Button>(R.id.btnCalculate)
//onclick of the CALCULATE button,this happens
        calButton.setOnClickListener {
            // accept user input
            val weight= weightText.text.toString()
            val height = heightText.text.toString()
//our BMI logic
            //if the values in the ValidateInput() are not true then proceed
            if (validateInput(weight,height)) {
                //bmi = weight/heigh/100 *height/ 100
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                //format the ouptput  to be a 2decimal value
                val bm12digits = String.format("%2f", bmi).toFloat()
                displayResults(bm12digits)
            }

      }
}

    private fun validateInput(weight:String?, height:String?):Boolean{
//when the value of the weight editext is null, show a toast message
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

//function to display the results on the text view
    private fun displayResults(bmi:Float){
    //initialize the views
val resultIndex = findViewById<TextView>(R.id.tvIndex)
        val resultDescription= findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvInfo)


        resultIndex.text= bmi.toString()
        info.text= "normal range is 18.5 - 24.9" // this is constant text
//create a variable and initialise to blank
 var resultText =""
        var color = 0

        when {
            //when the value of bmi is lesd than 18.5 then change the value of the color and result text
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
//set the change of text to display on the textview and change of color on the respective text
resultDescription.setTextColor(ContextCompat.getColor(this, color))
        resultDescription.text=resultText
    }
    }

