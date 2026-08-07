package com.box.android.preview.preview;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewActivityIntentHandler_Factory implements Factory<PreviewActivityIntentHandler> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewActivityIntentHandler get() {
        return newInstance();
    }

    public static PreviewActivityIntentHandler_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PreviewActivityIntentHandler newInstance() {
        return new PreviewActivityIntentHandler();
    }

    private static final class InstanceHolder {
        static final PreviewActivityIntentHandler_Factory INSTANCE = new PreviewActivityIntentHandler_Factory();

        private InstanceHolder() {
        }
    }
}
