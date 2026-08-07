package com.box.android.preview.item.labels;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.preview.item.labels.offline.PreviewOfflineLabelEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class ItemPreviewLabelsEnvironment_Factory implements Factory<ItemPreviewLabelsEnvironment> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<PreviewOfflineLabelEnvironment> offlineLabelEnvironmentProvider;

    private ItemPreviewLabelsEnvironment_Factory(Provider<PreviewOfflineLabelEnvironment> provider, Provider<FeatureFlips> provider2) {
        this.offlineLabelEnvironmentProvider = provider;
        this.featureFlipsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemPreviewLabelsEnvironment get() {
        return newInstance(this.offlineLabelEnvironmentProvider.get(), this.featureFlipsProvider.get());
    }

    public static ItemPreviewLabelsEnvironment_Factory create(Provider<PreviewOfflineLabelEnvironment> provider, Provider<FeatureFlips> provider2) {
        return new ItemPreviewLabelsEnvironment_Factory(provider, provider2);
    }

    public static ItemPreviewLabelsEnvironment newInstance(PreviewOfflineLabelEnvironment previewOfflineLabelEnvironment, FeatureFlips featureFlips) {
        return new ItemPreviewLabelsEnvironment(previewOfflineLabelEnvironment, featureFlips);
    }
}
