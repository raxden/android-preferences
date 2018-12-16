package com.raxdenstudios.preferences

import android.app.Activity
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by Ángel Gómez on 01/05/2018.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class AdvancedPreferencesTest {

    private var preferences: AdvancedPreferences? = null

    @Before
    fun setUp() {
        val context = Robolectric.setupActivity(Activity::class.java)
        preferences = AdvancedPreferences(context)
    }

    @Test
    fun testInt() {
        preferences?.put("integer_key", 23)?.commit()
        Assert.assertEquals(preferences?.get("integer_key", -1), 23)
    }

    @Test
    fun testString() {
        preferences?.put("string_key", "test_23")?.commit()
        Assert.assertEquals(preferences?.get("string_key", "no_value"), "test_23")
    }

    @Test
    fun testBoolean() {
        preferences?.put("boolean_key", true)?.commit()
        Assert.assertEquals(preferences?.get("boolean_key", false), true)
    }

    @Test
    fun testFloat() {
        preferences?.put("float_key", 23.0f)?.commit()
        Assert.assertEquals(preferences?.get("float_key", -0.1f), 23.0f)
    }

    @Test
    fun testLong() {
        preferences?.put("long_key", 23.toLong())?.commit()
        Assert.assertEquals(preferences?.get("long_key", (-1).toLong()), 23.toLong())
    }

    @Test
    fun testSetString() {
        val values = mutableSetOf("test_20", "test_21", "test_22", "test_23")
        preferences?.put("set_string_key", values)?.commit()
        Assert.assertEquals(preferences?.get("set_string_key", mutableSetOf()), values)
    }

    @Test
    fun testJSONObject() {
        val jsonObject = JSONObject("{\"key\": 23}")
        preferences?.put("set_json_object", jsonObject)?.commit()
        Assert.assertEquals(preferences?.get("set_json_object", JSONObject()).toString(), jsonObject.toString())
    }

    @Test
    fun testJSONArray() {
        val jsonArray = JSONArray("[{\"key\": 23}]")
        preferences?.put("set_json_array", jsonArray)?.commit()
        Assert.assertEquals(preferences?.get("set_json_array", JSONArray()).toString(), jsonArray.toString())
    }

    @Test
    fun testObject() {
        val testObject = TestObject("key", "value")
        preferences?.put("set_test_object", testObject)?.commit()
        val ob1 = preferences?.get("set_test_object", TestObject::class.java, TestObject("no_key", "no_value"))
        Assert.assertTrue(ob1?.compareTo(testObject) == 0)
    }

    data class TestObject(val key: String, val value: String) : Comparable<TestObject> {

        override fun compareTo(other: TestObject): Int = when {
            key == other.key && value == other.value -> 0
            else -> -1
        }
    }

}