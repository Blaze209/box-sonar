package com.box.android.inbox;

import com.box.android.inbox.mfasetup.MfaSetupAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MfaCallbackIntentHandler_Factory implements Factory<MfaCallbackIntentHandler> {
    private final Provider<MfaSetupAnalytics> mfaSetupAnalyticsProvider;

    private MfaCallbackIntentHandler_Factory(Provider<MfaSetupAnalytics> provider) {
        this.mfaSetupAnalyticsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MfaCallbackIntentHandler get() {
        return newInstance(this.mfaSetupAnalyticsProvider.get());
    }

    public static MfaCallbackIntentHandler_Factory create(Provider<MfaSetupAnalytics> provider) {
        return new MfaCallbackIntentHandler_Factory(provider);
    }

    public static MfaCallbackIntentHandler newInstance(MfaSetupAnalytics mfaSetupAnalytics) {
        return new MfaCallbackIntentHandler(mfaSetupAnalytics);
    }
}
