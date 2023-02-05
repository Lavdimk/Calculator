package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input: EditText = findViewById(R.id.id1)

        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btnmbledhja: Button = findViewById(R.id.btn4)
        val btn4: Button = findViewById(R.id.btn5)
        val btn5: Button = findViewById(R.id.btn6)
        val btn6: Button = findViewById(R.id.btn7)
        val btnminus: Button = findViewById(R.id.btn8)
        val btn7: Button = findViewById(R.id.btn9)
        val btn8: Button = findViewById(R.id.btn10)
        val btn9: Button = findViewById(R.id.btn11)
        val btnshumezim: Button = findViewById(R.id.btn12)
        val btnpike: Button = findViewById(R.id.btn13)
        val btn0: Button = findViewById(R.id.btn14)
        val btnclear: Button = findViewById(R.id.btn15)
        val btnpjesetimi: Button = findViewById(R.id.btn16)
        val btnbarabarte:Button=findViewById(R.id.btn17)




        btn1.setOnClickListener {
            input.setText(addToInputValue("1"))
        }
        btn2.setOnClickListener {
            input.setText((addToInputValue("2")))
        }
        btn3.setOnClickListener {
            input.setText((addToInputValue("3")))
        }
        btn4.setOnClickListener {
            input.setText((addToInputValue("4")))
        }
        btn5.setOnClickListener {
            input.setText((addToInputValue("5")))
        }
        btn6.setOnClickListener {
            input.setText((addToInputValue("6")))
        }
        btn7.setOnClickListener {
            input.setText((addToInputValue("7")))
        }
        btn8.setOnClickListener {
            input.setText((addToInputValue("8")))
        }
        btn9.setOnClickListener {
            input.setText((addToInputValue("9")))
        }
        btn0.setOnClickListener {
            input.setText((addToInputValue("0")))
        }
        btnpike.setOnClickListener {
            input.setText((addToInputValue(".")))
        }
        btnmbledhja.setOnClickListener {
            input.setText((addToInputValue("+")))
        }
        btnminus.setOnClickListener {
            input.setText((addToInputValue("-")))
        }
        btnshumezim.setOnClickListener {
            input.setText((addToInputValue("x")))
        }
        btnpjesetimi.setOnClickListener {
            input.setText((addToInputValue("/")))
        }
        btn0.setOnClickListener {
            input.setText(addToInputValue("0"))
        }
        btnbarabarte.setOnClickListener{
            showResults()
        }
        btnclear.setOnClickListener {

            input.setText("")
        }


    }
    private fun getInputExpression():String{
        val input: EditText = findViewById(R.id.id1)
        var expression=input.text.replace(Regex("/"),"/")
        expression=expression.replace(Regex("x"),"*")
        return expression
    }



    private fun addToInputValue(buttonValue: String): String {
        val input: EditText = findViewById(R.id.id1)
        return "${input.text}$buttonValue"
    }
    private fun showResults() {
        val input: EditText = findViewById(R.id.id1)
        try {
            val expression=getInputExpression()
            val result=Expression(expression).calculate()
            if (result.isNaN()){
                input.setText("ERROR ")
            }else{

                input.setText(DecimalFormat("0.##").format(result).toString())
            }


        }
        catch (e:Exception){

        }
    }

}
