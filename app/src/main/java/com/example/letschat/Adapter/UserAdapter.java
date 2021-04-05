package com.example.letschat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.letschat.ChatsActivity;
import com.example.letschat.R;
import com.example.letschat.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.ViewHolder>{
    ArrayList<Users> list;
    Context context;

    public UserAdapter(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users user = list.get(position);
        Picasso.get().load(user.getProfile()).error(R.drawable.icons8_user_male_50px_1).placeholder(R.drawable.avatar).into(holder.profile_img);
        holder.name.setText(user.getName());
        holder.last_msg.setText(user.getLastMessage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ChatsActivity.class);
                i.putExtra("userId", user.getUserId());
                i.putExtra("name", user.getName());
                i.putExtra("profile", user.getProfile());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView profile_img;
        TextView name,last_msg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_img = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            last_msg = itemView.findViewById(R.id.message);
        }
    }
}
