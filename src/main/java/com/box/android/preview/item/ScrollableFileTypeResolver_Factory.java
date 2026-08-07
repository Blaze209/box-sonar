package com.box.android.preview.item;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class ScrollableFileTypeResolver_Factory implements Factory<ScrollableFileTypeResolver> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ScrollableFileTypeResolver get() {
        return newInstance();
    }

    public static ScrollableFileTypeResolver_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScrollableFileTypeResolver newInstance() {
        return new ScrollableFileTypeResolver();
    }

    private static final class InstanceHolder {
        static final ScrollableFileTypeResolver_Factory INSTANCE = new ScrollableFileTypeResolver_Factory();

        private InstanceHolder() {
        }
    }
}
