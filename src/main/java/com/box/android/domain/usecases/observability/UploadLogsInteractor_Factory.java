package com.box.android.domain.usecases.observability;

import com.box.android.domain.services.IObservabilityService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UploadLogsInteractor_Factory implements Factory<UploadLogsInteractor> {
    private final Provider<AuthenticationInteractor> authenticationInteractorProvider;
    private final Provider<IObservabilityService> observabilityServiceProvider;

    private UploadLogsInteractor_Factory(Provider<IObservabilityService> provider, Provider<AuthenticationInteractor> provider2) {
        this.observabilityServiceProvider = provider;
        this.authenticationInteractorProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadLogsInteractor get() {
        return newInstance(this.observabilityServiceProvider.get(), this.authenticationInteractorProvider.get());
    }

    public static UploadLogsInteractor_Factory create(Provider<IObservabilityService> provider, Provider<AuthenticationInteractor> provider2) {
        return new UploadLogsInteractor_Factory(provider, provider2);
    }

    public static UploadLogsInteractor newInstance(IObservabilityService iObservabilityService, AuthenticationInteractor authenticationInteractor) {
        return new UploadLogsInteractor(iObservabilityService, authenticationInteractor);
    }
}
