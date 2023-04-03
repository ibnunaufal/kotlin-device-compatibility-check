package com.bob.devicecompatibilitycheck

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    var arrayRequirements: List<String> = listOf(
        PackageManager.FEATURE_WIFI,
        PackageManager.FEATURE_NFC,
        PackageManager.FEATURE_BLUETOOTH,
        PackageManager.FEATURE_CAMERA,
        PackageManager.FEATURE_CAMERA_AUTOFOCUS,
        PackageManager.FEATURE_CAMERA_FLASH,
        PackageManager.FEATURE_LOCATION_GPS,
        PackageManager.FEATURE_TOUCHSCREEN,
        PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH,
        PackageManager.FEATURE_LEANBACK,
        PackageManager.FEATURE_TELEVISION,
        PackageManager.FEATURE_TELEPHONY,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hardwareAdapter = RVAdapter(arrayRequirements)

        var str = "Device Name: "

        str += "${Build.BRAND} ${Build.MODEL} \nAndroid: ${Build.VERSION.RELEASE}"

        val tvName: TextView = findViewById(R.id.device_name)
        tvName.text = str

        val rvMain: RecyclerView = findViewById(R.id.rvMain)

        rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = hardwareAdapter
        }
    }
}