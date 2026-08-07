package com.box.android.data.persistence;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class FileSystem_Factory implements Factory<FileSystem> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileSystem get() {
        return newInstance();
    }

    public static FileSystem_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FileSystem newInstance() {
        return new FileSystem();
    }

    private static final class InstanceHolder {
        static final FileSystem_Factory INSTANCE = new FileSystem_Factory();

        private InstanceHolder() {
        }
    }
}
