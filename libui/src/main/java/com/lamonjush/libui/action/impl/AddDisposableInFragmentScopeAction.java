package com.lamonjush.libui.action.impl;

import androidx.fragment.app.Fragment;

import com.lamonjush.libui.action.base.FragmentAction;
import com.lamonjush.libui.ui.base.BaseFragment;

import io.reactivex.disposables.Disposable;

public class AddDisposableInFragmentScopeAction implements FragmentAction {

    private Disposable disposable;

    public AddDisposableInFragmentScopeAction(Disposable disposable) {
        this.disposable = disposable;
    }

    @Override
    public void execute(Fragment fragment) {
        if (disposable != null && fragment instanceof BaseFragment) {
            ((BaseFragment) fragment).getDisposable().add(disposable);
        }
    }
}
