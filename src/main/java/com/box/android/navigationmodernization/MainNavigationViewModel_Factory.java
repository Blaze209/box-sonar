package com.box.android.navigationmodernization;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class MainNavigationViewModel_Factory implements Factory<MainNavigationViewModel> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MainNavigationViewModel get() {
        return newInstance();
    }

    public static MainNavigationViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MainNavigationViewModel newInstance() {
        return new MainNavigationViewModel();
    }

    private static final class InstanceHolder {
        static final MainNavigationViewModel_Factory INSTANCE = new MainNavigationViewModel_Factory();

        private InstanceHolder() {
        }
    }
}
