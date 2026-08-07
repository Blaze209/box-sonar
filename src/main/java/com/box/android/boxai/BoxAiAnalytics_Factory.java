package com.box.android.boxai;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAiAnalytics_Factory implements Factory<BoxAiAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAiAnalytics get() {
        return newInstance();
    }

    public static BoxAiAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BoxAiAnalytics newInstance() {
        return new BoxAiAnalytics();
    }

    private static final class InstanceHolder {
        static final BoxAiAnalytics_Factory INSTANCE = new BoxAiAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
