package com.sonbyungha.engineertool

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class capacity: AppCompatActivity() {
    lateinit var edit1: EditText
    lateinit var edit2: EditText
    lateinit var btnserial: Button
    lateinit var btnparallel: Button
    lateinit var textResult: TextView
    lateinit var num1: String
    lateinit var num2: String
    var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.capacitorlayout)

        edit1 = findViewById<EditText>(R.id.capacitor1)
        edit2 = findViewById<EditText>(R.id.capacitor2)
        btnserial = findViewById<Button>(R.id.serial_bt)
        btnparallel = findViewById<Button>(R.id.parallel_btn)

        textResult = findViewById<TextView>(R.id.result_capacitor)
    }
        fun caserial(view: View) {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = num1.toDouble() * num2.toDouble() /(num1.toDouble() + num2.toDouble())
            textResult.text = "직렬계산 결과(F): " + result.toString()
        }

        fun caparallel(view: View) {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = num1.toDouble() + num2.toDouble()
            textResult.text = "병렬계산 결과(F) : " + result.toString()

        }

    }