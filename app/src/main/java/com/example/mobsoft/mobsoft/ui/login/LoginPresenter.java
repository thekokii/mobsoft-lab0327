package com.example.mobsoft.mobsoft.ui.login;

import android.util.Log;

import com.example.mobsoft.mobsoft.interactor.event.EventsInteractor;
import com.example.mobsoft.mobsoft.interactor.event.events.GetEventEvent;
import com.example.mobsoft.mobsoft.interactor.user.UsersInteractor;
import com.example.mobsoft.mobsoft.interactor.user.events.GetUserEvent;
import com.example.mobsoft.mobsoft.ui.Presenter;
import com.example.mobsoft.mobsoft.ui.main.MainScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.mobsoft.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    UsersInteractor usersInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public LoginPresenter() {
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getUser(final long id) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                usersInteractor.getUser(id);
            }
        });
    }

    public void onEventMainThread(GetUserEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showMessage(event.getUser().getUsername());
            }
        }
    }
}
