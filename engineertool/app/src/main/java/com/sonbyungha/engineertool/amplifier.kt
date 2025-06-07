package com.sonbyungha.engineertool

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class amplifier : AppCompatActivity() {
    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var edit3 : EditText
    lateinit var btninv : Button
    lateinit var btnnoninv : Button
    lateinit var textResult1 : TextView
    lateinit var textResult2 : TextView
    lateinit var num1 : String
    lateinit var num2 : String
    lateinit var num3 : String
    var result1: Double? = null
    var result2: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.amplifier)
        edit1 = findViewById<EditText>(R.id.amplifier1)
        edit2 = findViewById<EditText>(R.id.amplifier2)
        edit3 = findViewById<EditText>(R.id.input_voltage)
        btninv= findViewById<Button>(R.id.invert_btn)
        btnnoninv = findViewById<Button>(R.id.noninvert_btn)
        textResult1 = findViewById<TextView>(R.id.result_a)
        textResult2 = findViewById<TextView>(R.id.voltage_out)
    }
    fun inv(view: View)
    {
        num1 = edit1.text.toString()
        num2 = edit2.text.toString()
        num3 = edit3.text.toString()
        result1 = -num1.toDouble() / num2.toDouble()
        result2 = -num1.toDouble() / num2.toDouble()*num3.toDouble()
        textResult1.text ="반전 증폭기 이득 : " +result1.toString()
        textResult2.text ="반전 증폭기 출력(V) : " +result2.toString()
    }
    fun noninv(view: View)
    {
        num1 = edit1.text.toString()
        num2 = edit2.text.toString()
        result1 =  1 + (num1.toDouble() / num2.toDouble())
        result2 = ((num1.toDouble() / num2.toDouble())+1)*num3.toDouble()
        textResult1.text ="비반전 증폭기 이득: " +result1.toString()
        textResult2.text ="비반전 증폭기 출력(V) : " +result2.toString()
    }
}