package com.box.android.domain.usecases.observability;

import com.box.android.domain.services.IObservabilityService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CreateLogArchiveInteractor_Factory implements Factory<CreateLogArchiveInteractor> {
    private final Provider<IObservabilityService> observabilityServiceProvider;

    private CreateLogArchiveInteractor_Factory(Provider<IObservabilityService> provider) {
        this.observabilityServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateLogArchiveInteractor get() {
        return newInstance(this.observabilityServiceProvider.get());
    }

    public static CreateLogArchiveInteractor_Factory create(Provider<IObservabilityService> provider) {
        return new CreateLogArchiveInteractor_Factory(provider);
    }

    public static CreateLogArchiveInteractor newInstance(IObservabilityService iObservabilityService) {
        return new CreateLogArchiveInteractor(iObservabilityService);
    }
}
