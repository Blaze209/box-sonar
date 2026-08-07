package com.box.android.base.utilities;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class ScreenshotCapture_Factory implements Factory<ScreenshotCapture> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ScreenshotCapture get() {
        return newInstance();
    }

    public static ScreenshotCapture_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScreenshotCapture newInstance() {
        return new ScreenshotCapture();
    }

    private static final class InstanceHolder {
        static final ScreenshotCapture_Factory INSTANCE = new ScreenshotCapture_Factory();

        private InstanceHolder() {
        }
    }
}
