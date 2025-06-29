package com.sonbyungha.engineertool

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class amplifier : AppCompatActivity() {

    private lateinit var edit1: EditText
    private lateinit var edit2: EditText
    private lateinit var edit3: EditText
    private lateinit var textResult1: TextView
    private lateinit var textResult2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.amplifier)

        edit1 = findViewById(R.id.amplifier1)
        edit2 = findViewById(R.id.amplifier2)
        edit3 = findViewById(R.id.input_voltage)
        textResult1 = findViewById(R.id.result_a)
        textResult2 = findViewById(R.id.voltage_out)

        findViewById<Button>(R.id.invert_btn).setOnClickListener { inv() }
        findViewById<Button>(R.id.noninvert_btn).setOnClickListener { noninv() }
    }

    private fun inv() {
        val r1 = edit1.text.toString()
        val r2 = edit2.text.toString()
        val vin = edit3.text.toString()

        if (r1.isBlank() || r2.isBlank() || vin.isBlank()) {
            showToast("모든 값을 입력해주세요.")
            return
        }

        try {
            val R1 = r1.toDouble()
            val R2 = r2.toDouble()
            val Vin = vin.toDouble()

            val gain = -R1 / R2
            val Vout = gain * Vin

            textResult1.text = "반전 증폭기 이득 : $gain"
            textResult2.text = "반전 증폭기 출력(V) : $Vout"

        } catch (e: NumberFormatException) {
            showToast("숫자 형식이 올바르지 않습니다.")
        }
    }

    private fun noninv() {
        val r1 = edit1.text.toString()
        val r2 = edit2.text.toString()
        val vin = edit3.text.toString()

        if (r1.isBlank() || r2.isBlank() || vin.isBlank()) {
            showToast("모든 값을 입력해주세요.")
            return
        }

        try {
            val R1 = r1.toDouble()
            val R2 = r2.toDouble()
            val Vin = vin.toDouble()

            val gain = 1 + (R1 / R2)
            val Vout = gain * Vin

            textResult1.text = "비반전 증폭기 이득: $gain"
            textResult2.text = "비반전 증폭기 출력(V) : $Vout"

        } catch (e: NumberFormatException) {
            showToast("숫자 형식이 올바르지 않습니다.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
