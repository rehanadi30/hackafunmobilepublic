package com.hackafun.friendy2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hackafun.friendy2.R;

public class RegisterActivity extends AppCompatActivity {
    Button registerBtn;
    TextView loginTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = findViewById(R.id.registerButton);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatIntent = new Intent(RegisterActivity.this, QueryActivity.class);
                startActivity(chatIntent);
                overridePendingTransition(0, 0);
            }
        });

        loginTv = findViewById(R.id.loginTextView);
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(chatIntent);
                overridePendingTransition(0, 0);
            }
        });
    }
}