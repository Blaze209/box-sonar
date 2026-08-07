package com.box.android.base.presentation.message;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxMessageDispatcher_Factory implements Factory<BoxMessageDispatcher> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxMessageDispatcher get() {
        return newInstance();
    }

    public static BoxMessageDispatcher_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BoxMessageDispatcher newInstance() {
        return new BoxMessageDispatcher();
    }

    private static final class InstanceHolder {
        static final BoxMessageDispatcher_Factory INSTANCE = new BoxMessageDispatcher_Factory();

        private InstanceHolder() {
        }
    }
}
