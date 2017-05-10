package com.example.mobsoft.mobsoft.ui.main;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.event.EventsInteractor;
import com.example.mobsoft.mobsoft.interactor.event.events.GetEventsEvent;
import com.example.mobsoft.mobsoft.model.Event;
import com.example.mobsoft.mobsoft.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    EventsInteractor eventsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MainPresenter() {
    }

    public void getEvents() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                eventsInteractor.getEvents();
            }
        });
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

/*
    public void getEvents() {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                eventsInteractor.getEvents();
            }
        });
    }*/

    public void onEventMainThread(GetEventsEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                for(Event t : event.getEvent()){
                    screen.showMessage(t.getTitle());
                }
            }
        }
    }

}