package com.example.mobsoft.mobsoft.ui.eventCreate;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.event.EventsInteractor;
import com.example.mobsoft.mobsoft.interactor.event.events.GetEventEvent;
import com.example.mobsoft.mobsoft.interactor.event.events.SaveEventEvent;
import com.example.mobsoft.mobsoft.model.Event;
import com.example.mobsoft.mobsoft.ui.Presenter;
import com.example.mobsoft.mobsoft.ui.login.LoginScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class EventCreatePresenter extends Presenter<EventCreateScreen> {

    @Inject
    EventsInteractor eventsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public EventCreatePresenter() {
    }

    @Override
    public void attachScreen(EventCreateScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void setEvent(final Event ev) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                eventsInteractor.saveEvent(ev);
            }
        });
    }

    public void onEventMainThread(SaveEventEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showMessage(event.getEvent().getTitle());
            }
        }
    }
}
