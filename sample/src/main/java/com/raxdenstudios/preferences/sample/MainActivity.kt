package com.raxdenstudios.preferences.sample

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.edit
import com.raxdenstudios.preferences.AdvancedPreferences
import com.rs.preferences.sample.R

class MainActivity : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val versionName = packageManager.getPackageInfo(packageName, 0).versionName
    findViewById<TextView>(R.id.text_view).text = "${applicationContext.packageName} $versionName"

    val akp = AdvancedPreferences.Default(this)
    akp.get(key = "", defaultValue = Object())
    akp.get("", Object())
  }
}
