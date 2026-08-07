package com.box.android.preview.preview;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import com.box.android.preview.utils.PreviewPrefetcher;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.preview.preview.PreviewViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C1700PreviewViewModel_Factory {
    private final Provider<PreviewEnvironment> previewEnvironmentProvider;
    private final Provider<PreviewPrefetcher> previewPrefetcherProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C1700PreviewViewModel_Factory(Provider<PreviewEnvironment> provider, Provider<PreviewPrefetcher> provider2, Provider<IStoreFactory> provider3) {
        this.previewEnvironmentProvider = provider;
        this.previewPrefetcherProvider = provider2;
        this.storeFactoryProvider = provider3;
    }

    public PreviewViewModel get(Bundle bundle) {
        return newInstance(bundle, this.previewEnvironmentProvider.get(), this.previewPrefetcherProvider.get(), this.storeFactoryProvider.get());
    }

    public static C1700PreviewViewModel_Factory create(Provider<PreviewEnvironment> provider, Provider<PreviewPrefetcher> provider2, Provider<IStoreFactory> provider3) {
        return new C1700PreviewViewModel_Factory(provider, provider2, provider3);
    }

    public static PreviewViewModel newInstance(Bundle bundle, PreviewEnvironment previewEnvironment, PreviewPrefetcher previewPrefetcher, IStoreFactory iStoreFactory) {
        return new PreviewViewModel(bundle, previewEnvironment, previewPrefetcher, iStoreFactory);
    }
}
