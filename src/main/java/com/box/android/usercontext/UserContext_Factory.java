package com.box.android.usercontext;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class UserContext_Factory implements Factory<UserContext> {
    private final Provider<Context> appContextProvider;

    private UserContext_Factory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserContext get() {
        return newInstance(this.appContextProvider.get());
    }

    public static UserContext_Factory create(Provider<Context> provider) {
        return new UserContext_Factory(provider);
    }

    public static UserContext newInstance(Context context) {
        return new UserContext(context);
    }
}
