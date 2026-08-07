package com.box.android.preview.utils;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.services.ILocalItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewLauncher_Factory implements Factory<PreviewLauncher> {
    private final Provider<Context> contextProvider;
    private final Provider<ILocalItemService> itemServiceProvider;
    private final Provider<PreviewObservability> previewObservabilityProvider;
    private final Provider<PreviewPrefetcher> previewPrefetcherProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private PreviewLauncher_Factory(Provider<PreviewObservability> provider, Provider<ILocalItemService> provider2, Provider<PreviewPrefetcher> provider3, Provider<IUserContextManager> provider4, Provider<Context> provider5) {
        this.previewObservabilityProvider = provider;
        this.itemServiceProvider = provider2;
        this.previewPrefetcherProvider = provider3;
        this.userContextManagerProvider = provider4;
        this.contextProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewLauncher get() {
        return newInstance(this.previewObservabilityProvider.get(), this.itemServiceProvider.get(), this.previewPrefetcherProvider.get(), this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static PreviewLauncher_Factory create(Provider<PreviewObservability> provider, Provider<ILocalItemService> provider2, Provider<PreviewPrefetcher> provider3, Provider<IUserContextManager> provider4, Provider<Context> provider5) {
        return new PreviewLauncher_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PreviewLauncher newInstance(PreviewObservability previewObservability, ILocalItemService iLocalItemService, PreviewPrefetcher previewPrefetcher, IUserContextManager iUserContextManager, Context context) {
        return new PreviewLauncher(previewObservability, iLocalItemService, previewPrefetcher, iUserContextManager, context);
    }
}
