package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.interactor.InteractorModule;
import com.example.mobsoft.mobsoft.interactor.event.EventsInteractor;
import com.example.mobsoft.mobsoft.interactor.user.UsersInteractor;
import com.example.mobsoft.mobsoft.network.NetworkModule;
import com.example.mobsoft.mobsoft.repository.RepositoryModule;
import com.example.mobsoft.mobsoft.ui.UIModule;
import com.example.mobsoft.mobsoft.ui.event.EventActivity;
import com.example.mobsoft.mobsoft.ui.event.EventPresenter;
import com.example.mobsoft.mobsoft.ui.eventCreate.EventCreateActivity;
import com.example.mobsoft.mobsoft.ui.eventCreate.EventCreatePresenter;
import com.example.mobsoft.mobsoft.ui.login.LoginActivity;
import com.example.mobsoft.mobsoft.ui.login.LoginPresenter;
import com.example.mobsoft.mobsoft.ui.main.MainActivity;
import com.example.mobsoft.mobsoft.ui.main.MainPresenter;
import com.example.mobsoft.mobsoft.ui.userEdit.UserEditActivity;
import com.example.mobsoft.mobsoft.ui.userList.UserListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2017. 03. 27..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(EventActivity eventActivity);
    void inject(EventCreateActivity eventCreateActivity);
    void inject(UserEditActivity userEditActivity);
    void inject(UserListActivity userListActivity);
    void inject(EventsInteractor eventsInteractor);
    void inject(UsersInteractor usersInteractor);
    void inject(MainPresenter mainPresenter);
    void inject(EventPresenter eventPresenter);
    void inject(EventCreatePresenter eventCreatePresenter);
    void inject(LoginPresenter loginPresenter);

}