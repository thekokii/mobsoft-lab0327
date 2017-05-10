package com.example.mobsoft.mobsoft;

import android.app.Application;

import com.example.mobsoft.mobsoft.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

public class MobSoftApplication extends Application {
    public static MobSoftApplicationComponent injector;

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
