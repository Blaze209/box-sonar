package com.box.android.data.service.impl.preview.helpers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class FileCanBePreviewedChecker_Factory implements Factory<FileCanBePreviewedChecker> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileCanBePreviewedChecker get() {
        return newInstance();
    }

    public static FileCanBePreviewedChecker_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FileCanBePreviewedChecker newInstance() {
        return new FileCanBePreviewedChecker();
    }

    private static final class InstanceHolder {
        static final FileCanBePreviewedChecker_Factory INSTANCE = new FileCanBePreviewedChecker_Factory();

        private InstanceHolder() {
        }
    }
}
