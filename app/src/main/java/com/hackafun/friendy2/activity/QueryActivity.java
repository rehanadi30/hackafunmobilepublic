package com.hackafun.friendy2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hackafun.friendy2.R;

public class QueryActivity extends AppCompatActivity {
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        submitBtn = findViewById(R.id.submitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chatIntent = new Intent(QueryActivity.this, ScanningActivity.class);
                startActivity(chatIntent);
                overridePendingTransition(0, 0);
            }
        });
    }
}