package com.raxdenstudios.preferences

import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class AdvancedPreferencesTest {

  private lateinit var defaultPreferences: AdvancedPreferences

  @Before
  fun setUp() {
    val context: Context = ApplicationProvider.getApplicationContext()
    defaultPreferences = AdvancedPreferences.Default(context)
  }

  @Test
  fun testInt() {
    defaultPreferences.edit(true) { put("integer_key", 23) }
    assertEquals(
      23,
      defaultPreferences.get("integer_key", -1)
    )
  }

  @Test
  fun testString() {
    defaultPreferences.edit(true) { put("string_key", "test_23") }
    assertEquals(
      "test_23",
      defaultPreferences.get("string_key", "no_value")
    )
  }

  @Test
  fun testBoolean() {
    defaultPreferences.edit(true) { put("boolean_key", true) }
    assertEquals(
      true,
      defaultPreferences.get("boolean_key", false)
    )
  }

  @Test
  fun testFloat() {
    defaultPreferences.edit(true) { put("float_key", 23.0f) }
    assertEquals(
      23.0f,
      defaultPreferences.get("float_key", -0.1f)
    )
  }

  @Test
  fun testLong() {
    defaultPreferences.edit(true) { put("long_key", 23L) }
    assertEquals(
      23L,
      defaultPreferences.get("long_key", -1L)
    )
  }

  @Test
  fun testSetString() {
    defaultPreferences.edit(true) {
      put("set_string_key", setOf("test_20", "test_21", "test_22", "test_23"))
    }
    assertEquals(
      setOf("test_20", "test_21", "test_22", "test_23"),
      defaultPreferences.get("set_string_key", emptySet<String>())
    )
  }

  @Test
  fun testJSONObject() {
    defaultPreferences.edit(true) {
      put("set_json_object", JSONObject("{\"key\": 23}"))
    }
    assertEquals(
      JSONObject("{\"key\": 23}").toString(),
      defaultPreferences.get("set_json_object", JSONObject().toString())
    )
  }

  @Test
  fun testJSONArray() {
    defaultPreferences.edit(true) {
      put("set_json_array", JSONArray("[{\"key\": 23}]"))
    }
    assertEquals(
      JSONArray("[{\"key\": 23}]").toString(),
      defaultPreferences.get("set_json_array", JSONArray().toString())
    )
  }

  @Test
  fun testObject() {
      defaultPreferences.edit(true) {
          put("set_test_object", TestObject("key", "value"))
      }
      assertEquals(
          TestObject("key", "value"),
          defaultPreferences.get("set_test_object", TestObject("empty", "empty"))
      )
  }

  @Test
  fun `contains value`() {
    defaultPreferences.edit(true) {
      put("string_key_23", "test_23")
    }

    assertEquals(
      true,
      defaultPreferences.contains("string_key_23")
    )
  }

  @Test
  fun `remove value`() {
    defaultPreferences.edit(true) {
      put("string_key_23", "test_23")
      put("string_key_24", "test_24")
      remove("string_key_24")
    }

    assertEquals(
      "test_23",
      defaultPreferences.get("string_key_23", "no_value")
    )
    assertEquals(
      "no_value",
      defaultPreferences.get("string_key_24", "no_value")
    )
  }

  @Test
  fun `clear all preferences`() {
    defaultPreferences.edit(true) {
      put("string_key_23", "test_23")
      put("string_key_24", "test_24")
      put("string_key_25", "test_25")
      put("string_key_26", "test_26")
    }
    defaultPreferences.edit(true) {
      clear()
    }

    assertEquals(false, defaultPreferences.contains("string_key_23"))
    assertEquals(false, defaultPreferences.contains("string_key_24"))
    assertEquals(false, defaultPreferences.contains("string_key_25"))
    assertEquals(false, defaultPreferences.contains("string_key_26"))
  }

  @Test
  fun `get all`() {
    defaultPreferences.edit(true) {
      put("string_key", "string")
      put("integer_key", 23)
      put("float_key", 12f)
      put("long_key", 42L)
    }

    assertEquals(
      mapOf(
        "string_key" to "string",
        "integer_key" to 23,
        "float_key" to 12f,
        "long_key" to 42L
      ),
      defaultPreferences.getAll())
  }

  data class TestObject(val key: String, val value: String) : Comparable<TestObject> {

    override fun compareTo(other: TestObject): Int = when {
      key == other.key && value == other.value -> 0
      else -> -1
    }
  }
}
