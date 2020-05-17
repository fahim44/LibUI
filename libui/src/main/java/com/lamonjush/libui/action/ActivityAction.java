package com.lamonjush.libui.action;

import android.app.Activity;

import org.greenrobot.eventbus.EventBus;

public interface ActivityAction {

    void execute(Activity activity);

    default void call() {
        EventBus.getDefault().post(this);
    }
}
