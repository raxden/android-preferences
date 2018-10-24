package com.raxdenstudios.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.raxdenstudios.preferences.AdvancedPreferences

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val akp = AdvancedPreferences(this)
        akp.get(key = "", classType = Object::class.java, defaultValue = Object() )
        akp.get("", Object::class.java, Object())
    }
}
