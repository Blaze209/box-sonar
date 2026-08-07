package com.box.android.capture.audiorecording.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class RecorderServiceManager_Factory implements Factory<RecorderServiceManager> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecorderServiceManager get() {
        return newInstance();
    }

    public static RecorderServiceManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RecorderServiceManager newInstance() {
        return new RecorderServiceManager();
    }

    private static final class InstanceHolder {
        static final RecorderServiceManager_Factory INSTANCE = new RecorderServiceManager_Factory();

        private InstanceHolder() {
        }
    }
}
