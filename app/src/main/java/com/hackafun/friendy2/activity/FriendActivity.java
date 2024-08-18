package com.hackafun.friendy2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hackafun.friendy2.R;
import com.hackafun.friendy2.adapter.FriendAdapter;
import com.hackafun.friendy2.model.Friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 import com.squareup.picasso.Picasso; // If using Picasso

public class FriendActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FriendAdapter friendAdapter;
    private List<Friend> friendList;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        // Initialize views
        ImageView mapIcon = findViewById(R.id.map_icon);
        ImageView profileIcon = findViewById(R.id.profile_icon);
        recyclerView = findViewById(R.id.recycler_view);

        // Optionally, set up map icon click listener
        mapIcon.setOnClickListener(v -> {
            // Handle map icon click
            Intent intent = new Intent(FriendActivity.this, MapActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });

        // Initialize RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create or fetch friend list
        try {
            friendList = getFriendsList(); // Replace with your method to fetch friend data
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        friendAdapter = new FriendAdapter(friendList);
        recyclerView.setAdapter(friendAdapter);

        // Initialize BottomNavigationView and set its onNavigationItemSelectedListener
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_chat:
                        Intent chatIntent = new Intent(FriendActivity.this, ChatActivity.class);
                        startActivity(chatIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_home:
                        // Handle home action
                        Intent friendsIntent = new Intent(FriendActivity.this, MainEmptyActivity.class);
                        startActivity(friendsIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_friends:
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private List<Friend> getFriendsList() throws ParseException {
        // Replace with your actual data fetching logic
        List<Friend> friends = new ArrayList<>();
        // Example data
        String dateString1 = "17/08/2024";
        String dateString2 = "16/08/2024";
        String dateString3 = "11/08/2024";
        friends.add(new Friend(1, "Anna Gan", dateString1, 88, "https://cdn.discordapp.com/attachments/1274359491738992663/1274584634633748520/monster2_cartoon.PNG?ex=66c2c8f1&is=66c17771&hm=3ec215f84fbc6f4d0d436326db5033363142fee0f56e4ddb081ddf3a1dfad204&"));
        friends.add(new Friend(2, "Lo Xian Wan", dateString2, 64, "https://cdn.discordapp.com/attachments/1274359491738992663/1274569168066449491/iu.jpeg?ex=66c2ba8a&is=66c1690a&hm=bf1f0f132f5dcca64e401966602b3eb2f0dec7bf2f0ec0e825e82ddbcffaabbe&"));
        friends.add(new Friend(3, "Rehan", dateString3, 55, "https://cdn.discordapp.com/attachments/1274359491738992663/1274584634268586084/monster1_cartoon.PNG?ex=66c2c8f1&is=66c17771&hm=e63111717baaa973b63ef63478318232c15f2a63b4cac665ce0cd8fe26deff90&"));
        // Add more friends
        return friends;
    }
}
