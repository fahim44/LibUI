package com.lamonjush.libui.ui.base;

import com.lamonjush.libui.action.base.ActivityAction;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends BaseDaggerActivity {

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onActionEvent(ActivityAction action) {
        action.execute(this);
    }

    public CompositeDisposable getDisposable() {
        return disposable;
    }
}
