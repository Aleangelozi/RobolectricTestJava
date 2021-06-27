package com.aleangelozi.robolectrictestjava;

import android.content.Intent;

import com.aleangelozi.robolectrictestjava.ui.login.LoginActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;


@RunWith(RobolectricTestRunner.class)
public class WelcomeActivityTest {

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        WelcomeActivity activity = Robolectric.setupActivity(WelcomeActivity.class);
        activity.findViewById(R.id.login).performClick();

        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }
}
