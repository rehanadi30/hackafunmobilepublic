package com.hackafun.friendy2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackafun.friendy2.R;
import com.hackafun.friendy2.model.Friend;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {

    private final List<Friend> friendsList;

    public FriendAdapter(List<Friend> friendsList) {
        this.friendsList = friendsList;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        Friend friend = friendsList.get(position);

        Picasso.get()
                .load(friend.getImageUri())
                .placeholder(R.drawable.baseline_person_2_24)  // Optional: placeholder image
                .error(R.drawable.baseline_person_2_24)  // Optional: error image
                .into(holder.profilePicture);
        holder.usernameTextView.setText(friend.getUsername());
        holder.addedOnTextView.setText("Added On: " + friend.getAddedOn());
        holder.similarityTextView.setText("Similarity: " + String.valueOf(friend.getSimilarity()) + "%");
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder {
        ImageView profilePicture;
        TextView usernameTextView;
        TextView addedOnTextView;
        TextView similarityTextView;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePicture = itemView.findViewById(R.id.profile_picture);
            usernameTextView = itemView.findViewById(R.id.text_name);
            addedOnTextView = itemView.findViewById(R.id.text_addedon);
            similarityTextView = itemView.findViewById(R.id.text_similarity);
        }
    }
}

