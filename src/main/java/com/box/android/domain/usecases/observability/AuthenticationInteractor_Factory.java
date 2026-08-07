package com.box.android.domain.usecases.observability;

import com.box.android.domain.services.IObservabilityService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class AuthenticationInteractor_Factory implements Factory<AuthenticationInteractor> {
    private final Provider<IObservabilityService> observabilityServiceProvider;

    private AuthenticationInteractor_Factory(Provider<IObservabilityService> provider) {
        this.observabilityServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthenticationInteractor get() {
        return newInstance(this.observabilityServiceProvider.get());
    }

    public static AuthenticationInteractor_Factory create(Provider<IObservabilityService> provider) {
        return new AuthenticationInteractor_Factory(provider);
    }

    public static AuthenticationInteractor newInstance(IObservabilityService iObservabilityService) {
        return new AuthenticationInteractor(iObservabilityService);
    }
}
