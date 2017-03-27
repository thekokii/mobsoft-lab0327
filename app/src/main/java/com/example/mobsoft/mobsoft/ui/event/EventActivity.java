package com.example.mobsoft.mobsoft.ui.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobsoft.mobsoft.R;

public class EventActivity extends AppCompatActivity implements EventScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }

    @Override
    public void navigateToUser() {

    }

    @Override
    public void getEvent(int id) {

    }
}
