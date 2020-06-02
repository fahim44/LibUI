package com.lamonjush.libui.ui.base;

import com.lamonjush.libui.action.base.FragmentAction;
import com.lamonjush.libui.util.ViewUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseFragment extends BaseDaggerFragment {

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onActionEvent(FragmentAction action) {
        action.execute(this);
    }

    public CompositeDisposable getDisposable() {
        return disposable;
    }
}

