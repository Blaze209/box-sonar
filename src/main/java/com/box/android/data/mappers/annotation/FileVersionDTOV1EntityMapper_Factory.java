package com.box.android.data.mappers.annotation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class FileVersionDTOV1EntityMapper_Factory implements Factory<FileVersionDTOV1EntityMapper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileVersionDTOV1EntityMapper get() {
        return newInstance();
    }

    public static FileVersionDTOV1EntityMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FileVersionDTOV1EntityMapper newInstance() {
        return new FileVersionDTOV1EntityMapper();
    }

    private static final class InstanceHolder {
        static final FileVersionDTOV1EntityMapper_Factory INSTANCE = new FileVersionDTOV1EntityMapper_Factory();

        private InstanceHolder() {
        }
    }
}
