package com.box.android.utilities;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes13.dex */
public final class PresentationRouter_Factory implements Factory<PresentationRouter> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PresentationRouter get() {
        return newInstance();
    }

    public static PresentationRouter_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PresentationRouter newInstance() {
        return new PresentationRouter();
    }

    private static final class InstanceHolder {
        static final PresentationRouter_Factory INSTANCE = new PresentationRouter_Factory();

        private InstanceHolder() {
        }
    }
}
