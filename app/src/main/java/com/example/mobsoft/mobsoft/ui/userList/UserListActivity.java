package com.example.mobsoft.mobsoft.ui.userList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobsoft.mobsoft.R;

import java.util.List;

import javax.inject.Inject;

public class UserListActivity extends AppCompatActivity implements UserListScreen {

    @Inject
    UserListPresenter userListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userListPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        userListPresenter.detachScreen();
    }

    @Override
    public void listUsers(List<String> users) {

    }
}
