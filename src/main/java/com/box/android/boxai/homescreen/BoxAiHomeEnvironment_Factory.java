package com.box.android.boxai.homescreen;

import com.box.android.boxai.AiCenterSessionInfoProviderImpl;
import com.box.android.boxai.BoxAiAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxAiHomeEnvironment_Factory implements Factory<BoxAiHomeEnvironment> {
    private final Provider<BoxAiAnalytics> analyticsProvider;
    private final Provider<AiCenterSessionInfoProviderImpl> boxAiCenterSessionInfoProviderImplProvider;

    private BoxAiHomeEnvironment_Factory(Provider<BoxAiAnalytics> provider, Provider<AiCenterSessionInfoProviderImpl> provider2) {
        this.analyticsProvider = provider;
        this.boxAiCenterSessionInfoProviderImplProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAiHomeEnvironment get() {
        return newInstance(this.analyticsProvider.get(), this.boxAiCenterSessionInfoProviderImplProvider.get());
    }

    public static BoxAiHomeEnvironment_Factory create(Provider<BoxAiAnalytics> provider, Provider<AiCenterSessionInfoProviderImpl> provider2) {
        return new BoxAiHomeEnvironment_Factory(provider, provider2);
    }

    public static BoxAiHomeEnvironment newInstance(BoxAiAnalytics boxAiAnalytics, AiCenterSessionInfoProviderImpl aiCenterSessionInfoProviderImpl) {
        return new BoxAiHomeEnvironment(boxAiAnalytics, aiCenterSessionInfoProviderImpl);
    }
}
