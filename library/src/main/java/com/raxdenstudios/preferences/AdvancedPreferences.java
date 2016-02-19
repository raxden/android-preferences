package com.raxdenstudios.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.SharedPreferencesCompat;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

/**
 * Created by agomez on 18/02/2016.
 */
public class AdvancedPreferences {

    private static final String TAG = AdvancedPreferences.class.getSimpleName();

    private SharedPreferences mSettings;
    private SharedPreferences.Editor mEditor;
    private Gson mGson = new Gson();

    public AdvancedPreferences(Context context) {
        mSettings = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mSettings.edit();

    }

    public AdvancedPreferences(Context context, String name, int mode) {
        if (name == null || name.equals("")) {
            name = "defaultSharePreferences";
        }
        mSettings = context.getSharedPreferences(name, mode);
        mEditor = mSettings.edit();
    }

    public Map<String, ?> getAll() {
        return mSettings.getAll();
    }

    public void contains(String key) {
        mSettings.contains(key);
    }

    public void remove(String key) {
        mEditor.remove(key);
    }

    public void clear() {
        mEditor.clear();
    }

    public void commit() {
        mEditor.commit();
    }

    public void apply() {
        SharedPreferencesCompat.EditorCompat.getInstance().apply(mEditor);
    }

    public int get(String key, int defaultValue) {
        return mSettings.getInt(key, defaultValue);
    }

    public Set<String> get(String key, Set<String> defaultValue) {
        return mSettings.getStringSet(key, defaultValue);
    }

    public String get(String key, String defaultValue) {
        return mSettings.getString(key, defaultValue);
    }

    public boolean get(String key, boolean defaultValue) {
        return mSettings.getBoolean(key, defaultValue);
    }

    public long get(String key, long defaultValue) {
        return mSettings.getLong(key, defaultValue);
    }

    public float get(String key, float defaultValue) {
        return mSettings.getFloat(key, defaultValue);
    }

    public JSONObject get(String key, JSONObject defaultValue) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(get(key, ""));
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        if (jsonObject != null) {
            return jsonObject;
        } else {
            return defaultValue;
        }
    }

    public JSONArray get(String key, JSONArray defaultValue) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(get(key, ""));
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        if (jsonArray != null) {
            return jsonArray;
        } else {
            return defaultValue;
        }
    }

    public <T> T get(String key, Class<T> classType, T defaultValue) {
        T object = null;
        String gson = get(key, "");
        if (gson != null && !gson.isEmpty()) {
            try {
                object = mGson.fromJson(gson, classType);
            } catch (JsonSyntaxException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
        if (object != null) {
            return object;
        } else {
            return defaultValue;
        }
    }

    public void put(String key, Integer value) {
        mEditor.putInt(key, value);
    }
    
    public void put(String key, Set<String> value) {
        mEditor.putStringSet(key, value);
    }

    public void put(String key, String value) {
        mEditor.putString(key, value);
    }

    public void put(String key, Boolean value) {
        mEditor.putBoolean(key, value);
    }

    public void put(String key, Long value) {
        mEditor.putLong(key, value);
    }

    public void put(String key, Float value) {
        mEditor.putFloat(key, value);
    }

    public void put(String key, JSONObject value) {
        mEditor.putString(key, value.toString());
    }

    public void put(String key, JSONArray value) {
        mEditor.putString(key, value.toString());
    }

    public void put(String key, Object value) {
        if (value instanceof Integer) put(key, (Integer)value);
        else if (value instanceof Set) put(key, (Set<String>)value);
        else if (value instanceof String) put(key, (String)value);
        else if (value instanceof Boolean) put(key, (Boolean)value);
        else if (value instanceof Long) put(key, (Long)value);
        else if (value instanceof Float) put(key, (Float)value);
        else if (value instanceof JSONObject) put(key, (JSONObject)value);
        else if (value instanceof JSONArray) put(key, (JSONArray)value);
        else {
            put(key, mGson.toJson(value));
        }
    }

    public SharedPreferences.Editor getEditor() {
        return mEditor;
    }

    public SharedPreferences getSharedPreferences() {
        return mSettings;
    }

}
