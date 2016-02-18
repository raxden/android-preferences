package com.raxdenstudios.preferences;

import android.app.Activity;
import android.content.Context;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by agomez on 18/02/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
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
    public void testStringPreference() throws Exception {
        mPreferences.put("keyString", "valueString");
        mPreferences.commit();

        Assert.assertEquals(mPreferences.get("keyString", ""), "valueString");
    }

}
