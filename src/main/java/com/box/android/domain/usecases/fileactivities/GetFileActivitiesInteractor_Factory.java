package com.box.android.domain.usecases.fileactivities;

import com.box.android.domain.services.IFileActivitiesService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GetFileActivitiesInteractor_Factory implements Factory<GetFileActivitiesInteractor> {
    private final Provider<IFileActivitiesService> fileActivitiesServiceProvider;

    private GetFileActivitiesInteractor_Factory(Provider<IFileActivitiesService> provider) {
        this.fileActivitiesServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetFileActivitiesInteractor get() {
        return newInstance(this.fileActivitiesServiceProvider.get());
    }

    public static GetFileActivitiesInteractor_Factory create(Provider<IFileActivitiesService> provider) {
        return new GetFileActivitiesInteractor_Factory(provider);
    }

    public static GetFileActivitiesInteractor newInstance(IFileActivitiesService iFileActivitiesService) {
        return new GetFileActivitiesInteractor(iFileActivitiesService);
    }
}
