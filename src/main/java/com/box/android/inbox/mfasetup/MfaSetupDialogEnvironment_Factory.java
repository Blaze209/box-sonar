package com.box.android.inbox.mfasetup;

import android.content.Context;
import com.box.android.common.utilities.Clock;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MfaSetupDialogEnvironment_Factory implements Factory<MfaSetupDialogEnvironment> {
    private final Provider<Clock> clockProvider;
    private final Provider<Context> contextProvider;
    private final Provider<MfaSetupAnalytics> mfaSetupAnalyticsProvider;
    private final Provider<MfaSetupUrlBuilder> mfaSetupUrlBuilderProvider;

    private MfaSetupDialogEnvironment_Factory(Provider<MfaSetupAnalytics> provider, Provider<MfaSetupUrlBuilder> provider2, Provider<Context> provider3, Provider<Clock> provider4) {
        this.mfaSetupAnalyticsProvider = provider;
        this.mfaSetupUrlBuilderProvider = provider2;
        this.contextProvider = provider3;
        this.clockProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MfaSetupDialogEnvironment get() {
        return newInstance(this.mfaSetupAnalyticsProvider.get(), this.mfaSetupUrlBuilderProvider.get(), this.contextProvider.get(), this.clockProvider.get());
    }

    public static MfaSetupDialogEnvironment_Factory create(Provider<MfaSetupAnalytics> provider, Provider<MfaSetupUrlBuilder> provider2, Provider<Context> provider3, Provider<Clock> provider4) {
        return new MfaSetupDialogEnvironment_Factory(provider, provider2, provider3, provider4);
    }

    public static MfaSetupDialogEnvironment newInstance(MfaSetupAnalytics mfaSetupAnalytics, MfaSetupUrlBuilder mfaSetupUrlBuilder, Context context, Clock clock) {
        return new MfaSetupDialogEnvironment(mfaSetupAnalytics, mfaSetupUrlBuilder, context, clock);
    }
}
