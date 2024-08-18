package com.hackafun.friendy2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hackafun.friendy2.R;

public class MainEmptyActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    Button filterBtn, findFriendsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_empty);

        findFriendsBtn = findViewById(R.id.find_friends_button);
        findFriendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainEmptyActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            }
        });

        // Initialize BottomNavigationView and set its onNavigationItemSelectedListener
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_chat:
                        Intent chatIntent = new Intent(MainEmptyActivity.this, ChatActivity.class);
                        startActivity(chatIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_home:
                        // Handle home action
                        return true;

                    case R.id.nav_friends:
                        Intent friendsIntent = new Intent(MainEmptyActivity.this, FriendActivity.class);
                        startActivity(friendsIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    default:
                        return false;
                }
            }
        });

    }
}