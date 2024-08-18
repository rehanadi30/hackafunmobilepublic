package com.hackafun.friendy2.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hackafun.friendy2.R;

public class LoginActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if user is already logged in
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(KEY_LOGGED_IN, false);

        if (isLoggedIn) {
            // User is logged in, redirect to MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(0,0);
            finish(); // Close the LoginActivity
        } else {
            // User is not logged in, continue with the login screen
            setContentView(R.layout.activity_login);
            // Additional login setup if needed

            Button buttonLogin = findViewById(R.id.loginButton);
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent chatIntent = new Intent(LoginActivity.this, MainEmptyActivity.class);
                    startActivity(chatIntent);
                    overridePendingTransition(0, 0);
                    finish();
                }
            });

            TextView register = findViewById(R.id.createAccountTextView);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent chatIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(chatIntent);
                    overridePendingTransition(0, 0);
                }
            });
        }
    }
}
