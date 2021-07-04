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
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;


@RunWith(RobolectricTestRunner.class)
public class WelcomeActivityTest {
    private WelcomeActivity welcomeActivity;
    private LoginActivity loginActivity;

    @Before
    public void setup() {
        welcomeActivity = Robolectric.setupActivity(WelcomeActivity.class);
        loginActivity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void welcomeActivity_ShouldNotBeNull() {
        assertNotNull(welcomeActivity);
        welcomeActivity.finish();
    }

    @Test
    public void loginActivity_ShouldNotBeNull() {
        assertNotNull(loginActivity);
    }

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        welcomeActivity.findViewById(R.id.login).performClick();

        Intent expectedIntent = new Intent(welcomeActivity, LoginActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }
}
