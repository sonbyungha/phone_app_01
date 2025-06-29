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

class battery : AppCompatActivity() {

    private lateinit var ivBattery: ImageView
    private lateinit var edtBattery: EditText

    // 상태 중복 출력을 막기 위한 변수
    private var lastBatteryStatus: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.battery_layout)
        ivBattery = findViewById(R.id.ivBattery)
        edtBattery = findViewById(R.id.edtBattery)
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus: Intent? = registerReceiver(br, filter)
        batteryStatus?.let { br.onReceive(this, it) }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(br)
    }

    private val br: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            if (intent.action == Intent.ACTION_BATTERY_CHANGED) {
                val remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                edtBattery.setText("현재 충전량: $remain%\n")

                // 배터리 이미지 업데이트
                val batteryImage = when {
                    remain >= 90 -> R.drawable.battery_100
                    remain >= 70 -> R.drawable.battery_80
                    remain >= 50 -> R.drawable.battery_60
                    remain >= 10 -> R.drawable.battery_20
                    else -> R.drawable.battery_0
                }
                ivBattery.setImageResource(batteryImage)

                // 전원 연결 상태 표시
                val plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0)
                when (plug) {
                    0 -> edtBattery.append("전원 연결: 안됨")
                    BatteryManager.BATTERY_PLUGGED_AC ->
                        edtBattery.append("전원 연결: 어댑터 연결됨")
                    BatteryManager.BATTERY_PLUGGED_USB ->
                        edtBattery.append("전원 연결: USB 연결됨")
                }

                // 배터리 상태 변화 감지 후 메시지 출력
                val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0)
                if (status != lastBatteryStatus) {
                    lastBatteryStatus = status
                    when (status) {
                        BatteryManager.BATTERY_STATUS_CHARGING ->
                            Toast.makeText(applicationContext, "배터리 충전 중", Toast.LENGTH_SHORT).show()

                        BatteryManager.BATTERY_STATUS_NOT_CHARGING ->
                            Toast.makeText(applicationContext, "배터리 충전 X", Toast.LENGTH_SHORT).show()

                        BatteryManager.BATTERY_STATUS_FULL ->
                            Toast.makeText(applicationContext, "배터리 충전 100% 완료", Toast.LENGTH_SHORT).show()

                        BatteryManager.BATTERY_STATUS_DISCHARGING ->
                            Toast.makeText(applicationContext, "배터리 방전 상태", Toast.LENGTH_SHORT).show()

                        BatteryManager.BATTERY_STATUS_UNKNOWN ->
                            Toast.makeText(applicationContext, "배터리 상태 확인 불가", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
