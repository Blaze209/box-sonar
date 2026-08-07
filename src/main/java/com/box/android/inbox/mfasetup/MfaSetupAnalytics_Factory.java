package com.box.android.inbox.mfasetup;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class MfaSetupAnalytics_Factory implements Factory<MfaSetupAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MfaSetupAnalytics get() {
        return newInstance();
    }

    public static MfaSetupAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MfaSetupAnalytics newInstance() {
        return new MfaSetupAnalytics();
    }

    private static final class InstanceHolder {
        static final MfaSetupAnalytics_Factory INSTANCE = new MfaSetupAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
