package com.example.abhishekjain.mvvmdemo.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abhishekjain.mvvmdemo.R;
import com.example.abhishekjain.mvvmdemo.adapter.UserAdapter;
import com.example.abhishekjain.mvvmdemo.model.response.ResUserData;
import com.example.abhishekjain.mvvmdemo.model.response.ResUsers;
import com.example.abhishekjain.mvvmdemo.receiver.MyBroadcastReceiver;
import com.example.abhishekjain.mvvmdemo.viewmodel.UserViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvList;

    private UserViewModel userViewModel;
    private UserAdapter adapter;
    private ArrayList<ResUserData> usersLst = new ArrayList<ResUserData>();

    private MyBroadcastReceiver myCustomBroadcastReceiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        registerMvvmReceiver();
        initViewModel();
    }

    private void initView() {
        rvList = findViewById(R.id.rv_list);
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        initAdapter();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);
        adapter = new UserAdapter(this);
        adapter.setUsers(usersLst);
        rvList.setAdapter(adapter);
    }

    private void initViewModel() {
        userViewModel.fetchUserData().observeForever(new Observer<ResUsers>() {
            @Override
            public void onChanged(@Nullable ResUsers resUsers) {
                if (resUsers != null && resUsers.getUsersLst() != null) {
                    usersLst.clear();
                    usersLst.addAll(resUsers.getUsersLst());
                    adapter.setUsers(usersLst);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


    private void registerMvvmReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.mvvm.my_action");
        registerReceiver(myCustomBroadcastReceiver, intentFilter, com.example.abhishekjain.mvvmdemo.Manifest.permission.my_permission, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myCustomBroadcastReceiver);
    }
}
