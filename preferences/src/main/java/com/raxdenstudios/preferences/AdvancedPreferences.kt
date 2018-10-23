package com.raxdenstudios.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by Ángel Gómez on 29/04/2018.
 */
class AdvancedPreferences(sharedPreferences: SharedPreferences, gson: Gson) {

    private val sharedPreferences: SharedPreferences = sharedPreferences
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    private val gson: Gson = gson

    constructor(context: Context, gson: Gson = Gson()) : this(PreferenceManager.getDefaultSharedPreferences(context), gson)

    constructor(context: Context, name: String = "defaultSharePreferences", mode: Int = Context.MODE_PRIVATE, gson: Gson = Gson()) : this(context.getSharedPreferences(name, mode), gson)

    fun contains(key: String): Boolean = sharedPreferences.contains(key)

    fun remove(key: String): SharedPreferences.Editor = editor.remove(key)

    fun clear(): SharedPreferences.Editor = editor.clear()

    fun commit(): Boolean = editor.commit()

    fun apply() = editor.apply()

    fun getAll(): Map<String, Any?> = sharedPreferences.all.toMap()

    fun get(key: String, defaultValue: Int): Int = sharedPreferences.getInt(key, defaultValue)

    fun get(key: String, defaultValue: String): String = sharedPreferences.getString(key, defaultValue)

    fun get(key: String, defaultValue: Boolean): Boolean = sharedPreferences.getBoolean(key, defaultValue)

    fun get(key: String, defaultValue: Float): Float = sharedPreferences.getFloat(key, defaultValue)

    fun get(key: String, defaultValue: Long): Long = sharedPreferences.getLong(key, defaultValue)

    fun get(key: String, defaultValue: Set<String>): Set<String> = sharedPreferences.getStringSet(key, defaultValue)

    fun get(key: String, defaultValue: JSONObject): JSONObject = sharedPreferences.getString(key, null)?.let { JSONObject(it) }
            ?: defaultValue

    fun get(key: String, defaultValue: JSONArray): JSONArray = sharedPreferences.getString(key, null)?.let { JSONArray(it) }
            ?: defaultValue

    fun <T : Any> get(key: String, classType: Class<T>, defaultValue: T): T = sharedPreferences.getString(key, null)?.let { gson.fromJson(it, classType) }
            ?: defaultValue

    fun put(key: String, value: Int): SharedPreferences.Editor = editor.putInt(key, value)

    fun put(key: String, value: String): SharedPreferences.Editor = editor.putString(key, value)

    fun put(key: String, value: Boolean): SharedPreferences.Editor = editor.putBoolean(key, value)

    fun put(key: String, value: Float): SharedPreferences.Editor = editor.putFloat(key, value)

    fun put(key: String, value: Long): SharedPreferences.Editor = editor.putLong(key, value)

    fun put(key: String, value: Set<String>): SharedPreferences.Editor = editor.putStringSet(key, value)

    fun put(key: String, value: JSONObject): SharedPreferences.Editor = editor.putString(key, value.toString())

    fun put(key: String, value: JSONArray): SharedPreferences.Editor = editor.putString(key, value.toString())

    fun put(key: String, value: Any): SharedPreferences.Editor {
        when (value) {
            is Int -> editor.putInt(key, value)
            is String -> editor.putString(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            is Set<*> -> editor.putStringSet(key, value as Set<String>)
            is JSONObject -> editor.putString(key, value.toString())
            is JSONArray -> editor.putString(key, value.toString())
            else -> editor.putString(key, gson.toJson(value).toString())
        }
        return editor
    }

}