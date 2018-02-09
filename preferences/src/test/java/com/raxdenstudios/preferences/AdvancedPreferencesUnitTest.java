package com.raxdenstudios.preferences;

import android.app.Activity;
import android.content.Context;

import junit.framework.Assert;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by agomez on 18/02/2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class AdvancedPreferencesUnitTest {

    private Context mContext;
    private AdvancedPreferences mPreferences;

    @Before
    public void setUp() {
        mContext = Robolectric.setupActivity(Activity.class);
        mPreferences = new AdvancedPreferences(mContext);
    }

    @Test
    public void testIntegerPreference() throws Exception {
        int testValue = 23;

        mPreferences.put("integer_key", testValue);
        mPreferences.commit();

        Assert.assertEquals(mPreferences.get("integer_key", 0), testValue);
    }

    @Test
    public void testSetStringPreference() throws Exception {
        Set<String> values = new HashSet<>();
        values.add("value_1");
        values.add("value_2");
        values.add("value_3");

        mPreferences.put("set_string_key", values);
        mPreferences.commit();

        Set<String> valuesToCompare = mPreferences.get("set_string_key", new HashSet<String>());

        Assert.assertEquals((String)values.toArray()[0], (String)valuesToCompare.toArray()[0]);
        Assert.assertEquals((String)values.toArray()[1], (String)valuesToCompare.toArray()[1]);
        Assert.assertEquals((String)values.toArray()[2], (String)valuesToCompare.toArray()[2]);
    }

    @Test
    public void testStringPreference() throws Exception {
        String testValue = "valueString";

        mPreferences.put("keyString", testValue);
        mPreferences.commit();

        Assert.assertEquals(mPreferences.get("keyString", ""), testValue);
    }

    @Test
    public void testBooleanPreference() throws Exception {
        boolean testValue = true;

        mPreferences.put("keyBoolean", testValue);
        mPreferences.commit();

        Assert.assertEquals(mPreferences.get("keyBoolean", false), testValue);
    }

    @Test
    public void testLongPreference() throws Exception {
        long testValue = 23;

        mPreferences.put("keyLong", testValue);
        mPreferences.commit();

        Assert.assertEquals(mPreferences.get("keyLong", (long)0), testValue);
    }

    @Test
    public void testFloatPreference() throws Exception {
        float testValue = 23.3f;

        mPreferences.put("keyFloat", testValue);
        mPreferences.commit();

        Assert.assertEquals(mPreferences.get("keyFloat", 0.0f), testValue);
    }

    @Test
    public void testJSONObjectPreference() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key", "value");

        mPreferences.put("keyJSONObject", jsonObject);
        mPreferences.commit();

        Assert.assertEquals(mPreferences.get("keyJSONObject", new JSONObject()).toString(), jsonObject.toString());
    }

    @Test
    public void testJSONArrayPreference() throws Exception {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(23);
        jsonArray.put("key");

        mPreferences.put("keyJSONArray", jsonArray);
        mPreferences.commit();

        Assert.assertEquals(mPreferences.get("keyJSONArray",new JSONArray()).toString(), jsonArray.toString());
    }

    @Test
    public void testObjectPreference() throws Exception {
        TestObject o = new TestObject("test", "value");

        mPreferences.put("keyObject", o);
        mPreferences.commit();

        Assert.assertTrue(mPreferences.get("keyObject", TestObject.class, null).compareTo(o) == 0);
    }

    private static class TestObject implements Comparable<TestObject> {

        private String key;
        private String value;

        public TestObject(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(TestObject another) {
            if (key.equals(another.getKey()) && value.equals(another.getValue())) {
                return 0;
            } else {
                return -1;
            }
        }
    }

}
