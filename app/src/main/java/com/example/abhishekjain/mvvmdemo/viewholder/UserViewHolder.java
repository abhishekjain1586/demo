package com.example.abhishekjain.mvvmdemo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abhishekjain.mvvmdemo.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivImage;
    public TextView tvName, tvEmail;

    public UserViewHolder(View itemView) {
        super(itemView);
        ivImage = itemView.findViewById(R.id.iv_image);
        tvName = itemView.findViewById(R.id.tv_name);
        tvEmail = itemView.findViewById(R.id.tv_email);
    }
}
