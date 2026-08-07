package com.box.android.capture.imagecapture.logic;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class ImageCaptureHelper_Factory implements Factory<ImageCaptureHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ImageCaptureHelper get() {
        return newInstance();
    }

    public static ImageCaptureHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ImageCaptureHelper newInstance() {
        return new ImageCaptureHelper();
    }

    private static final class InstanceHolder {
        static final ImageCaptureHelper_Factory INSTANCE = new ImageCaptureHelper_Factory();

        private InstanceHolder() {
        }
    }
}
