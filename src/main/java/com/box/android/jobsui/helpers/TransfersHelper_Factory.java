package com.box.android.jobsui.helpers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class TransfersHelper_Factory implements Factory<TransfersHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TransfersHelper get() {
        return newInstance();
    }

    public static TransfersHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TransfersHelper newInstance() {
        return new TransfersHelper();
    }

    private static final class InstanceHolder {
        static final TransfersHelper_Factory INSTANCE = new TransfersHelper_Factory();

        private InstanceHolder() {
        }
    }
}
