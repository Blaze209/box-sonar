package com.box.android.data.di;

import com.box.android.data.observability.RumInstrumentation;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.services.ISessionManager;
import com.box.android.domain.services.RumService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideRumServiceFactory implements Factory<RumService> {
    private final Provider<IBVEManager> bveManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RumInstrumentation> rumInstrumentationProvider;
    private final Provider<ISessionManager> sessionManagerProvider;

    private DataProvidesModule_ProvideRumServiceFactory(DataProvidesModule module, Provider<ISessionManager> sessionManagerProvider, Provider<IBVEManager> bveManagerProvider, Provider<RumInstrumentation> rumInstrumentationProvider) {
        this.module = module;
        this.sessionManagerProvider = sessionManagerProvider;
        this.bveManagerProvider = bveManagerProvider;
        this.rumInstrumentationProvider = rumInstrumentationProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RumService get() {
        return provideRumService(this.module, this.sessionManagerProvider.get(), this.bveManagerProvider.get(), this.rumInstrumentationProvider.get());
    }

    public static DataProvidesModule_ProvideRumServiceFactory create(DataProvidesModule module, Provider<ISessionManager> sessionManagerProvider, Provider<IBVEManager> bveManagerProvider, Provider<RumInstrumentation> rumInstrumentationProvider) {
        return new DataProvidesModule_ProvideRumServiceFactory(module, sessionManagerProvider, bveManagerProvider, rumInstrumentationProvider);
    }

    public static RumService provideRumService(DataProvidesModule instance, ISessionManager sessionManager, IBVEManager bveManager, RumInstrumentation rumInstrumentation) {
        return (RumService) Preconditions.checkNotNullFromProvides(instance.provideRumService(sessionManager, bveManager, rumInstrumentation));
    }
}
