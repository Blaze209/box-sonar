package com.box.android.data.di;

import com.box.android.data.api.requests.BoxAiRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.service.impl.BVEManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideBoxAiRequestFactory implements Factory<BoxAiRequest> {
    private final Provider<BVEManager> bveManagerProvider;
    private final DataProvidesModule module;
    private final Provider<RequestFactory> requestFactoryProvider;

    private DataProvidesModule_ProvideBoxAiRequestFactory(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<BVEManager> bveManagerProvider) {
        this.module = module;
        this.requestFactoryProvider = requestFactoryProvider;
        this.bveManagerProvider = bveManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAiRequest get() {
        return provideBoxAiRequest(this.module, this.requestFactoryProvider.get(), this.bveManagerProvider.get());
    }

    public static DataProvidesModule_ProvideBoxAiRequestFactory create(DataProvidesModule module, Provider<RequestFactory> requestFactoryProvider, Provider<BVEManager> bveManagerProvider) {
        return new DataProvidesModule_ProvideBoxAiRequestFactory(module, requestFactoryProvider, bveManagerProvider);
    }

    public static BoxAiRequest provideBoxAiRequest(DataProvidesModule instance, RequestFactory requestFactory, BVEManager bveManager) {
        return (BoxAiRequest) Preconditions.checkNotNullFromProvides(instance.provideBoxAiRequest(requestFactory, bveManager));
    }
}
