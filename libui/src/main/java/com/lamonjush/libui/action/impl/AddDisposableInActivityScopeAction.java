package com.lamonjush.libui.action.impl;

import android.app.Activity;

import com.lamonjush.libui.action.base.ActivityAction;
import com.lamonjush.libui.ui.base.BaseActivity;

import io.reactivex.disposables.Disposable;

public class AddDisposableInActivityScopeAction implements ActivityAction {

    private Disposable disposable;

    public AddDisposableInActivityScopeAction(Disposable disposable){
        this.disposable = disposable;
    }

    @Override
    public void execute(Activity activity) {
        if(disposable != null && activity instanceof BaseActivity){
            ((BaseActivity) activity).getDisposable().add(disposable);
        }
    }
}