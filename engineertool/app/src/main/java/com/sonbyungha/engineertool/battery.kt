package com.sonbyungha.engineertool

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class battery : AppCompatActivity(){
    lateinit var ivBattery: ImageView
    lateinit var edtBattery: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.battert_layout)
        ivBattery = findViewById<ImageView>(R.id.ivBattery)
        edtBattery = findViewById<EditText>(R.id.edtBattery)
    }
    override fun onPause(){
        super.onPause()
        unregisterReceiver(br)
    }
    override fun onResume() {
        super.onResume()
        var iFilter = IntentFilter()
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(br, iFilter)
    }

    var br: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            var action = intent.action
            if (action == Intent.ACTION_BATTERY_CHANGED) {
                var remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                edtBattery.setText("현재 충전량: $remain\n")
                if (remain >= 90)
                    ivBattery.setImageResource(R.drawable.battery_100)
                else if (remain >= 70)
                    ivBattery.setImageResource(R.drawable.battery_80)
                else if (remain >= 50)
                    ivBattery.setImageResource(R.drawable.battery_60)
                else if (remain >= 10)
                    ivBattery.setImageResource(R.drawable.battery_20)
                else
                    ivBattery.setImageResource(R.drawable.battery_0)

                var plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0)
                when(plug){
                    0 -> edtBattery.append("전원 연결: 안됨")
                    BatteryManager.BATTERY_PLUGGED_AC ->
                        edtBattery.append("전원 연결: 어뎁터 연결됨")
                    BatteryManager.BATTERY_PLUGGED_USB ->
                        edtBattery.append("전원 연결: USB 연결됨")
                }
                var status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0)
                when(status){
                    BatteryManager.BATTERY_STATUS_CHARGING->
                        Toast.makeText(applicationContext, "배터리 충전 중", Toast.LENGTH_SHORT).show()

                    BatteryManager.BATTERY_STATUS_NOT_CHARGING->
                        Toast.makeText(applicationContext, "배터리 충전 X", Toast.LENGTH_SHORT).show()

                    BatteryManager.BATTERY_STATUS_FULL->
                        Toast.makeText(applicationContext, "배터리 충전 100% 완료", Toast.LENGTH_SHORT).show()

                    BatteryManager.BATTERY_STATUS_DISCHARGING->
                        Toast.makeText(applicationContext, "배터리 방전 상태", Toast.LENGTH_SHORT).show()

                    BatteryManager.BATTERY_STATUS_UNKNOWN ->
                        Toast.makeText(applicationContext, "배터리 상태 확인 불가", Toast.LENGTH_SHORT).show()

                }
            }
        }

    }
}



