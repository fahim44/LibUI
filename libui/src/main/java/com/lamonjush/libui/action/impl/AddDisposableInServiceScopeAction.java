package com.lamonjush.libui.action.impl;

import android.app.Service;

import com.lamonjush.libui.action.base.ServiceAction;
import com.lamonjush.libui.ui.base.BaseService;

import io.reactivex.disposables.Disposable;

public class AddDisposableInServiceScopeAction implements ServiceAction {

    private Disposable disposable;

    public AddDisposableInServiceScopeAction(Disposable disposable) {
        this.disposable = disposable;
    }

    @Override
    public void execute(Service service) {
        if (disposable != null && service instanceof BaseService) {
            ((BaseService) service).getDisposable().add(disposable);
        }
    }
}