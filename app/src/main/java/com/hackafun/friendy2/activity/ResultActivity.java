package com.hackafun.friendy2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hackafun.friendy2.R;

public class ResultActivity extends AppCompatActivity {
    Button retakeBtn, submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        retakeBtn = findViewById(R.id.retakeButton);
        retakeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatIntent = new Intent(ResultActivity.this, ScanningActivity.class);
                startActivity(chatIntent);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        submitBtn = findViewById(R.id.submitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatIntent = new Intent(ResultActivity.this, MainEmptyActivity.class);
                startActivity(chatIntent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }
}