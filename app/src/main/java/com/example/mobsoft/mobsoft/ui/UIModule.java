package com.example.mobsoft.mobsoft.ui;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

import android.content.Context;

import com.example.mobsoft.mobsoft.ui.event.EventPresenter;
import com.example.mobsoft.mobsoft.ui.eventCreate.EventCreatePresenter;
import com.example.mobsoft.mobsoft.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft.ui.userEdit.UserEditPresenter;
import com.example.mobsoft.mobsoft.ui.userList.UserListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public EventPresenter provideEventPresenter() {
        return new EventPresenter();
    }

    @Provides
    @Singleton
    public EventCreatePresenter provideEventCreatePresenter() {
        return new EventCreatePresenter();
    }
    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public UserEditPresenter provideUserEditPresenter() {
        return new UserEditPresenter();
    }

    @Provides
    @Singleton
    public UserListPresenter provideUserListPresenter() {
        return new UserListPresenter();
    }

}