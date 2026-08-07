package com.box.android.domain.configuration;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class UserSessionInfo_Factory implements Factory<UserSessionInfo> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserSessionInfo get() {
        return newInstance();
    }

    public static UserSessionInfo_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static UserSessionInfo newInstance() {
        return new UserSessionInfo();
    }

    private static final class InstanceHolder {
        static final UserSessionInfo_Factory INSTANCE = new UserSessionInfo_Factory();

        private InstanceHolder() {
        }
    }
}
