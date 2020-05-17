package com.lamonjush.libui.ui.base;

import com.lamonjush.libui.action.FragmentAction;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseFragment extends BaseDaggerFragment {

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
}

