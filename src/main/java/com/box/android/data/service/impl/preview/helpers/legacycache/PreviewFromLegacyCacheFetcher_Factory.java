package com.box.android.data.service.impl.preview.helpers.legacycache;

import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.controller.IPreviewController;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewFromLegacyCacheFetcher_Factory implements Factory<PreviewFromLegacyCacheFetcher> {
    private final Provider<LocalItemService> itemServiceProvider;
    private final Provider<IPreviewController> legacyPreviewControllerProvider;
    private final Provider<PreviewerTypeLegacyCacheMapper> previewerTypeLegacyCacheMapperProvider;

    private PreviewFromLegacyCacheFetcher_Factory(Provider<LocalItemService> itemServiceProvider, Provider<PreviewerTypeLegacyCacheMapper> previewerTypeLegacyCacheMapperProvider, Provider<IPreviewController> legacyPreviewControllerProvider) {
        this.itemServiceProvider = itemServiceProvider;
        this.previewerTypeLegacyCacheMapperProvider = previewerTypeLegacyCacheMapperProvider;
        this.legacyPreviewControllerProvider = legacyPreviewControllerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewFromLegacyCacheFetcher get() {
        return newInstance(this.itemServiceProvider.get(), this.previewerTypeLegacyCacheMapperProvider.get(), this.legacyPreviewControllerProvider.get());
    }

    public static PreviewFromLegacyCacheFetcher_Factory create(Provider<LocalItemService> itemServiceProvider, Provider<PreviewerTypeLegacyCacheMapper> previewerTypeLegacyCacheMapperProvider, Provider<IPreviewController> legacyPreviewControllerProvider) {
        return new PreviewFromLegacyCacheFetcher_Factory(itemServiceProvider, previewerTypeLegacyCacheMapperProvider, legacyPreviewControllerProvider);
    }

    public static PreviewFromLegacyCacheFetcher newInstance(LocalItemService itemService, PreviewerTypeLegacyCacheMapper previewerTypeLegacyCacheMapper, IPreviewController legacyPreviewController) {
        return new PreviewFromLegacyCacheFetcher(itemService, previewerTypeLegacyCacheMapper, legacyPreviewController);
    }
}
