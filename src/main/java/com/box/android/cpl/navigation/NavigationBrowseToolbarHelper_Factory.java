package com.box.android.cpl.navigation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class NavigationBrowseToolbarHelper_Factory implements Factory<NavigationBrowseToolbarHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NavigationBrowseToolbarHelper get() {
        return newInstance();
    }

    public static NavigationBrowseToolbarHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NavigationBrowseToolbarHelper newInstance() {
        return new NavigationBrowseToolbarHelper();
    }

    private static final class InstanceHolder {
        static final NavigationBrowseToolbarHelper_Factory INSTANCE = new NavigationBrowseToolbarHelper_Factory();

        private InstanceHolder() {
        }
    }
}
