package com.lamonjush.libui.action.base;

import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;

public interface FragmentAction {

    void execute(Fragment fragment);

    default void call(){
        EventBus.getDefault().post(this);
    }
}