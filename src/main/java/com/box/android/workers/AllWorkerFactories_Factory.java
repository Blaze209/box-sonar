package com.box.android.workers;

import com.box.android.domain.services.IJobWorkerFactory;
import com.box.android.observability.WorkManagerWorkerFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AllWorkerFactories_Factory implements Factory<AllWorkerFactories> {
    private final Provider<IJobWorkerFactory> jobWorkerFactoryProvider;
    private final Provider<WorkManagerWorkerFactory> workManagerWorkerFactoryProvider;

    private AllWorkerFactories_Factory(Provider<WorkManagerWorkerFactory> provider, Provider<IJobWorkerFactory> provider2) {
        this.workManagerWorkerFactoryProvider = provider;
        this.jobWorkerFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AllWorkerFactories get() {
        return newInstance(this.workManagerWorkerFactoryProvider.get(), this.jobWorkerFactoryProvider.get());
    }

    public static AllWorkerFactories_Factory create(Provider<WorkManagerWorkerFactory> provider, Provider<IJobWorkerFactory> provider2) {
        return new AllWorkerFactories_Factory(provider, provider2);
    }

    public static AllWorkerFactories newInstance(WorkManagerWorkerFactory workManagerWorkerFactory, IJobWorkerFactory iJobWorkerFactory) {
        return new AllWorkerFactories(workManagerWorkerFactory, iJobWorkerFactory);
    }
}
