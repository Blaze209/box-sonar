package com.box.android.fileactivity.presentation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivitiesLauncher_Factory implements Factory<FileActivitiesLauncher> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActivitiesLauncher get() {
        return newInstance();
    }

    public static FileActivitiesLauncher_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FileActivitiesLauncher newInstance() {
        return new FileActivitiesLauncher();
    }

    private static final class InstanceHolder {
        static final FileActivitiesLauncher_Factory INSTANCE = new FileActivitiesLauncher_Factory();

        private InstanceHolder() {
        }
    }
}
