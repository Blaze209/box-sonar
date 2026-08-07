package com.box.android.preview.iteminformation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class ItemInformationAnalytics_Factory implements Factory<ItemInformationAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemInformationAnalytics get() {
        return newInstance();
    }

    public static ItemInformationAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ItemInformationAnalytics newInstance() {
        return new ItemInformationAnalytics();
    }

    private static final class InstanceHolder {
        static final ItemInformationAnalytics_Factory INSTANCE = new ItemInformationAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
