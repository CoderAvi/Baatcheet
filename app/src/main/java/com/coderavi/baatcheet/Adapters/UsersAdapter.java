package com.coderavi.baatcheet.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.coderavi.baatcheet.Activities.ChatActivity;
import com.coderavi.baatcheet.Models.user;
import com.coderavi.baatcheet.R;
import com.coderavi.baatcheet.databinding.RowConversationBinding;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{



    Context context;
    ArrayList<user> users;
    public UsersAdapter(Context context, ArrayList<user> users) {
        this.context = context;
        this.users = users;

    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_conversation,parent,false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        user user = users.get(position);

        holder.binding.username.setText(user.getName());
        Glide.with(context).load(user.getProfileImage())
                .placeholder(R.drawable.avatar)
                .into(holder.binding.profile);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , ChatActivity.class);
                intent.putExtra("name",user.getName());
                intent.putExtra("uid",user.getUid());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        RowConversationBinding binding;

        public UsersViewHolder(@NonNull View itemview) {
            super(itemview);
            binding = RowConversationBinding.bind(itemview);
        }
    }


}
