package com.example.mobsoft.mobsoft.ui.userEdit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobsoft.mobsoft.R;

import javax.inject.Inject;

public class UserEditActivity extends AppCompatActivity implements UserEditScreen {

    @Inject
    UserEditPresenter userEditPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userEditPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        userEditPresenter.detachScreen();
    }

    @Override
    public void getUser(int id) {

    }
}
