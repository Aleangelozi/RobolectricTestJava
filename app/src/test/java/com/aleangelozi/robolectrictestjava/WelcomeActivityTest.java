package com.aleangelozi.robolectrictestjava;

import android.content.Intent;

import com.aleangelozi.robolectrictestjava.ui.login.LoginActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;


@RunWith(RobolectricTestRunner.class)
public class WelcomeActivityTest {
    private WelcomeActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(WelcomeActivity.class);
    }

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        activity.findViewById(R.id.login).performClick();

        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }
}
