package com.box.android.data.mappers.annotation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivityStatusDTOEntityMapper_Factory implements Factory<FileActivityStatusDTOEntityMapper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActivityStatusDTOEntityMapper get() {
        return newInstance();
    }

    public static FileActivityStatusDTOEntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FileActivityStatusDTOEntityMapper newInstance() {
        return new FileActivityStatusDTOEntityMapper();
    }

    private static final class InstanceHolder {
        static final FileActivityStatusDTOEntityMapper_Factory INSTANCE = new FileActivityStatusDTOEntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
