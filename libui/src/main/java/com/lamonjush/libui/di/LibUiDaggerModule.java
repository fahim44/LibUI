package com.lamonjush.libui.di;

import androidx.lifecycle.ViewModelProvider;

import com.lamonjush.libui.common.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
public interface LibUiDaggerModule {

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}