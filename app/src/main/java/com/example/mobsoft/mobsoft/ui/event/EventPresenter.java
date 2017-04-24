package com.example.mobsoft.mobsoft.ui.event;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.event.EventsInteractor;
import com.example.mobsoft.mobsoft.interactor.event.events.GetEventEvent;
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

public class EventPresenter extends Presenter<EventScreen> {

    @Inject
    EventsInteractor eventsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public EventPresenter() {
    }

    @Override
    public void attachScreen(EventScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }


    public void getEvent(final long id) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                eventsInteractor.getEvent(id);
            }
        });
    }

    public void onEventMainThread(GetEventEvent event) {
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
