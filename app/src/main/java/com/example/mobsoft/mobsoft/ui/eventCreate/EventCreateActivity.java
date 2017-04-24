package com.example.mobsoft.mobsoft.ui.eventCreate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobsoft.mobsoft.R;

import javax.inject.Inject;

public class EventCreateActivity extends AppCompatActivity implements EventCreateScreen {
    @Inject
    EventCreatePresenter eventCreatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventCreatePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventCreatePresenter.detachScreen();
    }

    @Override
    public void showEvent() {

    }

    @Override
    public void showMessage(String title) {

    }
}
