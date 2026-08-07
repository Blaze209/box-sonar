package com.box.android.observability.appstart;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class AuthenticationAppStartDestinationPage_Factory implements Factory<AuthenticationAppStartDestinationPage> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthenticationAppStartDestinationPage get() {
        return newInstance();
    }

    public static AuthenticationAppStartDestinationPage_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AuthenticationAppStartDestinationPage newInstance() {
        return new AuthenticationAppStartDestinationPage();
    }

    private static final class InstanceHolder {
        static final AuthenticationAppStartDestinationPage_Factory INSTANCE = new AuthenticationAppStartDestinationPage_Factory();

        private InstanceHolder() {
        }
    }
}
