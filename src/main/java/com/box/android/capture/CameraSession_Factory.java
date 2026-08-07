package com.box.android.capture;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CameraSession_Factory implements Factory<CameraSession> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CameraSession get() {
        return newInstance();
    }

    public static CameraSession_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CameraSession newInstance() {
        return new CameraSession();
    }

    private static final class InstanceHolder {
        static final CameraSession_Factory INSTANCE = new CameraSession_Factory();

        private InstanceHolder() {
        }
    }
}
