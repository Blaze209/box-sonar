package com.box.android.domain.usecases.browse;

import com.box.android.domain.services.IRecentsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RecentsViewInteractor_Factory implements Factory<RecentsViewInteractor> {
    private final Provider<IRecentsService> recentsServiceProvider;

    private RecentsViewInteractor_Factory(Provider<IRecentsService> provider) {
        this.recentsServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentsViewInteractor get() {
        return newInstance(this.recentsServiceProvider.get());
    }

    public static RecentsViewInteractor_Factory create(Provider<IRecentsService> provider) {
        return new RecentsViewInteractor_Factory(provider);
    }

    public static RecentsViewInteractor newInstance(IRecentsService iRecentsService) {
        return new RecentsViewInteractor(iRecentsService);
    }
}
