package com.hackafun.friendy2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hackafun.friendy2.R;
import com.hackafun.friendy2.model.FriendMatchingModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    List<FriendMatchingModel> friendMatchingModelList = new ArrayList<>();
    int iterator = 0;
    ImageView iv;
    TextView match, similarity, distance, desc;

    ImageButton yesBtn, noBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addDummyUsers();

        iv = findViewById(R.id.profile_image);
        match = findViewById(R.id.match_percentage);
        similarity = findViewById(R.id.similarityLabel);
        distance = findViewById(R.id.distanceLabel);
        desc = findViewById(R.id.profile_description);

        Picasso.get()
                .load(friendMatchingModelList.get(iterator).getImageUri())
                .placeholder(R.drawable.baseline_person_2_24)  // Optional: placeholder image
                .error(R.drawable.baseline_person_2_24)  // Optional: error image
                .into(iv);
        match.setText(String.valueOf(friendMatchingModelList.get(iterator).getMatch()) + "% matched");
        similarity.setText("Min Similarity: " + String.valueOf(friendMatchingModelList.get(iterator).getSimilarity()));
        distance.setText("Min Distance: " + String.valueOf(friendMatchingModelList.get(iterator).getDistance()));
        desc.setText(String.valueOf(friendMatchingModelList.get(iterator).getDesc()));

        yesBtn = findViewById(R.id.like_button);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });

        noBtn = findViewById(R.id.dislike_button);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });

        // Initialize BottomNavigationView and set its onNavigationItemSelectedListener
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(-1);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_chat:
                        Intent chatIntent = new Intent(MainActivity.this, ChatActivity.class);
                        startActivity(chatIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_home:
                        // Handle home action
                        return true;

                    case R.id.nav_friends:
                        Intent friendsIntent = new Intent(MainActivity.this, FriendActivity.class);
                        startActivity(friendsIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    public void addDummyUsers() {
        friendMatchingModelList.add(new FriendMatchingModel(1, "asdd", 88, "Hi, I love football", "", 89, 210, "https://cdn.discordapp.com/attachments/1274359491738992663/1274584633731711050/IU_cartoon.PNG?ex=66c2c8f1&is=66c17771&hm=586d578865919950481bd50ec70342c48c04c1036d5061ed777ef35d8f96422f&"));
        friendMatchingModelList.add(new FriendMatchingModel(2, "dsasd", 76, "Hi, I love piano", "", 89, 210, "https://cdn.discordapp.com/attachments/1274359491738992663/1274584633983504384/lady_gaga_cartoon.PNG?ex=66c2c8f1&is=66c17771&hm=d0cec2657307f3cef3426c017b3b59b15848bd145a55bfef3e84e434a3e44226&"));
        friendMatchingModelList.add(new FriendMatchingModel(3, "vbf", 64, "Hi, I love programming", "", 89, 210, "https://cdn.discordapp.com/attachments/1274359491738992663/1274584634268586084/monster1_cartoon.PNG?ex=66c2c8f1&is=66c17771&hm=e63111717baaa973b63ef63478318232c15f2a63b4cac665ce0cd8fe26deff90&"));
        friendMatchingModelList.add(new FriendMatchingModel(4, "pksado", 34, "Hi, I love hockey", "", 89, 210, "https://cdn.discordapp.com/attachments/1274359491738992663/1274584634927218699/monster3_cartoon.PNG?ex=66c2c8f1&is=66c17771&hm=6b8dc87bf82073bb2b088c5622f63980ec7785a6487ac5fe6c3a02388ebf7313&"));
        friendMatchingModelList.add(new FriendMatchingModel(5, "ljasfnv", 12, "Hi, I love rose", "", 89, 210, "https://cdn.discordapp.com/attachments/1274359491738992663/1274584635187396618/my_cartoon.PNG?ex=66c2c8f1&is=66c17771&hm=bacad80606ccd149174f4a6daf182dc29e8bb9084d69645757b2117c426564f9&"));
    }

    public void click() {
        if (iterator == friendMatchingModelList.size()-1){
            Intent intent = new Intent(MainActivity.this, MainEmptyActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        } else {
            iterator += 1;
            Picasso.get()
                    .load(friendMatchingModelList.get(iterator).getImageUri())
                    .placeholder(R.drawable.baseline_person_2_24)  // Optional: placeholder image
                    .error(R.drawable.baseline_person_2_24)  // Optional: error image
                    .into(iv);
            match.setText(String.valueOf(friendMatchingModelList.get(iterator).getMatch()) + "% matched");
            similarity.setText("Min Similarity: " + String.valueOf(friendMatchingModelList.get(iterator).getSimilarity()));
            distance.setText("Min Distance: " + String.valueOf(friendMatchingModelList.get(iterator).getDistance()));
            desc.setText(String.valueOf(friendMatchingModelList.get(iterator).getDesc()));
        }
    }
}