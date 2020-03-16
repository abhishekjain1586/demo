package com.example.abhishekjain.mvvmdemo.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.abhishekjain.mvvmdemo.model.response.ResUsers;
import com.example.abhishekjain.mvvmdemo.service.ServiceHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    public LiveData<ResUsers> getUsers() {
        final MutableLiveData<ResUsers> usersLiveData = new MutableLiveData<ResUsers>();
        Call<ResUsers> callback = ServiceHelper.getInstance().getClient().getUsers(1, 10);
        callback.enqueue(new Callback<ResUsers>() {
            @Override
            public void onResponse(Call<ResUsers> call, Response<ResUsers> response) {
                if (response != null && response.body() != null) {
                    usersLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResUsers> call, Throwable t) {
                usersLiveData.setValue(null);
            }
        });

        return usersLiveData;
    }
}
