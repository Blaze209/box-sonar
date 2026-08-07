package com.box.android.updates.force;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class ForceUpdateCoordinator_Factory implements Factory<ForceUpdateCoordinator> {
    private final Provider<Context> appContextProvider;
    private final Provider<ForceUpdateEvaluator> forceUpdateEvaluatorProvider;

    private ForceUpdateCoordinator_Factory(Provider<ForceUpdateEvaluator> provider, Provider<Context> provider2) {
        this.forceUpdateEvaluatorProvider = provider;
        this.appContextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateCoordinator get() {
        return newInstance(this.forceUpdateEvaluatorProvider.get(), this.appContextProvider.get());
    }

    public static ForceUpdateCoordinator_Factory create(Provider<ForceUpdateEvaluator> provider, Provider<Context> provider2) {
        return new ForceUpdateCoordinator_Factory(provider, provider2);
    }

    public static ForceUpdateCoordinator newInstance(ForceUpdateEvaluator forceUpdateEvaluator, Context context) {
        return new ForceUpdateCoordinator(forceUpdateEvaluator, context);
    }
}
