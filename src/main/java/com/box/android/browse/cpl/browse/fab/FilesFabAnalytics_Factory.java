package com.box.android.browse.cpl.browse.fab;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class FilesFabAnalytics_Factory implements Factory<FilesFabAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesFabAnalytics get() {
        return newInstance();
    }

    public static FilesFabAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FilesFabAnalytics newInstance() {
        return new FilesFabAnalytics();
    }

    private static final class InstanceHolder {
        static final FilesFabAnalytics_Factory INSTANCE = new FilesFabAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
