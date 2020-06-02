package com.lamonjush.libui.action.base;

import android.app.Service;

import org.greenrobot.eventbus.EventBus;

public interface ServiceAction {
    void execute(Service service);

    default void call() {
        EventBus.getDefault().post(this);
    }
}