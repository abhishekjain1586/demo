package com.example.abhishekjain.mvvmdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abhishekjain.mvvmdemo.R;
import com.example.abhishekjain.mvvmdemo.model.response.ResUserData;
import com.example.abhishekjain.mvvmdemo.viewholder.UserViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<ResUserData> usersLst = new ArrayList<ResUserData>();
    private Context mContext;
    public UserAdapter(Context context) {
        mContext = context;
    }

    public void setUsers(List<ResUserData> usersLst) {
        this.usersLst.clear();
        this.usersLst.addAll(usersLst);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        UserViewHolder viewHolder = new UserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        ResUserData user = usersLst.get(position);
        holder.tvName.setText(user.getFirst_name() + " " + user.getLast_name());
        holder.tvEmail.setText(user.getEmail());
        if (!TextUtils.isEmpty(user.getAvatar())) {
            holder.ivImage.setVisibility(View.VISIBLE);
            Picasso.with(mContext).load(user.getAvatar()).resize(128, 128).centerInside().into(holder.ivImage);
        } else {
            holder.ivImage.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return usersLst.size();
    }
}
