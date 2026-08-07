package com.box.android.cpl.mainphone;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class MainPhoneBrowseToolbarHelper_Factory implements Factory<MainPhoneBrowseToolbarHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MainPhoneBrowseToolbarHelper get() {
        return newInstance();
    }

    public static MainPhoneBrowseToolbarHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MainPhoneBrowseToolbarHelper newInstance() {
        return new MainPhoneBrowseToolbarHelper();
    }

    private static final class InstanceHolder {
        static final MainPhoneBrowseToolbarHelper_Factory INSTANCE = new MainPhoneBrowseToolbarHelper_Factory();

        private InstanceHolder() {
        }
    }
}
