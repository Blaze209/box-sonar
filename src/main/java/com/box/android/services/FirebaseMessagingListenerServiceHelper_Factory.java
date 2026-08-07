package com.box.android.services;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class FirebaseMessagingListenerServiceHelper_Factory implements Factory<FirebaseMessagingListenerServiceHelper> {
    private final Provider<BoxApiPrivate> apiPrivateProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FirebaseMessagingListenerServiceHelper_Factory(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2, Provider<FeatureFlips> provider3) {
        this.userContextManagerProvider = provider;
        this.apiPrivateProvider = provider2;
        this.featureFlipsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FirebaseMessagingListenerServiceHelper get() {
        return newInstance(this.userContextManagerProvider.get(), this.apiPrivateProvider.get(), this.featureFlipsProvider.get());
    }

    public static FirebaseMessagingListenerServiceHelper_Factory create(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2, Provider<FeatureFlips> provider3) {
        return new FirebaseMessagingListenerServiceHelper_Factory(provider, provider2, provider3);
    }

    public static FirebaseMessagingListenerServiceHelper newInstance(IUserContextManager iUserContextManager, BoxApiPrivate boxApiPrivate, FeatureFlips featureFlips) {
        return new FirebaseMessagingListenerServiceHelper(iUserContextManager, boxApiPrivate, featureFlips);
    }
}
