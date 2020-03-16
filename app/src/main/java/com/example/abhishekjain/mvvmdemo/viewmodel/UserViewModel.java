package com.example.abhishekjain.mvvmdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.abhishekjain.mvvmdemo.model.response.ResUsers;
import com.example.abhishekjain.mvvmdemo.repository.UserRepository;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository = new UserRepository();

    public LiveData<ResUsers> fetchUserData() {
        return userRepository.getUsers();
    }
}
