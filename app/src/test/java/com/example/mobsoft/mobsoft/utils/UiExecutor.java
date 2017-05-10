package com.example.mobsoft.mobsoft.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class UiExecutor implements Executor {

    private Handler mHandler;

    public UiExecutor() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mHandler.post(command);
    }
}
