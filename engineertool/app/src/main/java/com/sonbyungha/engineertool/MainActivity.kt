package com.sonbyungha.engineertool

import android.app.TabActivity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout

@Suppress("deprecation")
class MainActivity : TabActivity() {
    lateinit var baseLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost

        //탭의 이름 변경
        var tabSpecCaculator = tabHost.newTabSpec("Caculator").setIndicator("계산기능")
        tabSpecCaculator.setContent(R.id.Caculator)
        tabHost.addTab(tabSpecCaculator)

        var tabSpecImformation = tabHost.newTabSpec("Imformation").setIndicator("정보")
        tabSpecImformation.setContent(R.id.Imformation)
        tabHost.addTab(tabSpecImformation)

        var tabSpecMenu = tabHost.newTabSpec("options").setIndicator("기타기능")
        tabSpecMenu.setContent(R.id.options)
        tabHost.addTab(tabSpecMenu)

        tabHost.currentTab = 0

        var buttonNewActivity = findViewById<Button>(R.id.caculator_register)
        buttonNewActivity.setOnClickListener {
            var intent = Intent(applicationContext, Resistance1::class.java)
            startActivity(intent)

        }
        var buttonamplifier = findViewById<Button>(R.id.amp)
        buttonamplifier.setOnClickListener {
            var intent = Intent(applicationContext, amplifier::class.java)
            startActivity(intent)
        }

        var btncapacitor = findViewById<Button>(R.id.capacitor)
        btncapacitor.setOnClickListener {
            var intent = Intent(applicationContext, capacity::class.java)
            startActivity(intent)
        }
        var buttoninductor =findViewById<Button>(R.id.btninductor)
        buttoninductor.setOnClickListener {
            var intent = Intent(applicationContext, inductor::class.java)
            startActivity(intent)
        }

        var buttontable1 = findViewById<Button>(R.id.mark_table)
        buttontable1.setOnClickListener {
            var intent = Intent(applicationContext, mark_table::class.java)
            startActivity(intent)
        }
        var buttontable2 = findViewById<Button>(R.id.circuit_table)
        buttontable2.setOnClickListener {
            var intent = Intent(applicationContext, circuit_table1::class.java)
            startActivity(intent)
        }
        var buttontable3 = findViewById<Button>(R.id.circuit_table2)
        buttontable3.setOnClickListener {
            var intent = Intent(applicationContext, circuit_table2::class.java)
            startActivity(intent)
        }
        var btnusb =findViewById<Button>(R.id.usb)
        btnusb.setOnClickListener {
            var intent = Intent(applicationContext, usb::class.java)
            startActivity(intent)
        }
        var btnhdmI = findViewById<Button>(R.id.hdmi)
        btnhdmI.setOnClickListener {
            var intent = Intent(applicationContext, hdmI::class.java)
            startActivity(intent)
        }
        var buttonsimpletable= findViewById<Button>(R.id.btnsimpletable)
        buttonsimpletable.setOnClickListener {
            var intent =Intent(applicationContext, simpletable::class.java)
            startActivity(intent)
        }
        var batterycheck = findViewById<ImageButton>(R.id.batterycheck)
        batterycheck.setOnClickListener{
            var intent = Intent(applicationContext, battery::class.java)
            startActivity(intent)
        }
        var buttonMusic = findViewById<ImageButton>(R.id.music)
        buttonMusic.setOnClickListener{
            var intent = Intent(applicationContext, music::class.java)
            startActivity(intent)
        }
        var btnGoogle = findViewById<Button>(R.id.webGoogle)
        btnGoogle.setOnClickListener{
            var uri= Uri.parse("https://www.google.co.kr")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        var btnexample = findViewById<Button>(R.id.webexample)
        btnexample.setOnClickListener{
            var uri= Uri.parse("http://www.ktword.co.kr/abbr_view.php?m_temp1=3773")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}