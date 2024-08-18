package com.hackafun.friendy2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hackafun.friendy2.R;
import com.hackafun.friendy2.adapter.ChatAdapter;
import com.hackafun.friendy2.model.Chat;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Sample data
        List<Chat> chatList = new ArrayList<>();
        chatList.add(new Chat("Lo Xian Wan", "You like swimming too? That..."));
        chatList.add(new Chat("Anna Gan", "I really hate this subject LOLL"));
        // Add more sample chats here...

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.chat_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ChatAdapter adapter = new ChatAdapter(chatList, chat -> {
            Intent intent = new Intent(ChatActivity.this, ChatDetailActivity.class);
            // Pass chat information to ChatDetailActivity
            intent.putExtra("CHAT_NAME", chat.getName());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        // Initialize BottomNavigationView and set its onNavigationItemSelectedListener
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_chat:
                        return true;

                    case R.id.nav_home:
                        // Handle home action
                        Intent homeIntent = new Intent(ChatActivity.this, MainEmptyActivity.class);
                        startActivity(homeIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_friends:
                        Intent friendsIntent = new Intent(ChatActivity.this, FriendActivity.class);
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
