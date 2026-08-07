package com.box.android.data.utilities;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxUriSupportChecker_Factory implements Factory<BoxUriSupportChecker> {
    private final Provider<Context> appContextProvider;

    private BoxUriSupportChecker_Factory(Provider<Context> appContextProvider) {
        this.appContextProvider = appContextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxUriSupportChecker get() {
        return newInstance(this.appContextProvider.get());
    }

    public static BoxUriSupportChecker_Factory create(Provider<Context> appContextProvider) {
        return new BoxUriSupportChecker_Factory(appContextProvider);
    }

    public static BoxUriSupportChecker newInstance(Context appContext) {
        return new BoxUriSupportChecker(appContext);
    }
}
