package com.box.android.preview;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxThumbnailRequests_Factory implements Factory<BoxThumbnailRequests> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxThumbnailRequests get() {
        return newInstance();
    }

    public static BoxThumbnailRequests_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BoxThumbnailRequests newInstance() {
        return new BoxThumbnailRequests();
    }

    private static final class InstanceHolder {
        static final BoxThumbnailRequests_Factory INSTANCE = new BoxThumbnailRequests_Factory();

        private InstanceHolder() {
        }
    }
}
