package com.box.android.data.service.impl.preview;

import com.box.android.domain.preview.PreviewerTypeResolver;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewerMappingsService_Factory implements Factory<PreviewerMappingsService> {
    private final Provider<PreviewerTypeResolver> previewerTypeResolverProvider;

    private PreviewerMappingsService_Factory(Provider<PreviewerTypeResolver> previewerTypeResolverProvider) {
        this.previewerTypeResolverProvider = previewerTypeResolverProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewerMappingsService get() {
        return newInstance(this.previewerTypeResolverProvider.get());
    }

    public static PreviewerMappingsService_Factory create(Provider<PreviewerTypeResolver> previewerTypeResolverProvider) {
        return new PreviewerMappingsService_Factory(previewerTypeResolverProvider);
    }

    public static PreviewerMappingsService newInstance(PreviewerTypeResolver previewerTypeResolver) {
        return new PreviewerMappingsService(previewerTypeResolver);
    }
}
