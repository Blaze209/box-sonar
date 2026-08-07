package com.box.android.preview.previewtype.gif;

import com.box.android.domain.metrics.preview.PreviewObservability;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class GifPreviewEnvironment_Factory implements Factory<GifPreviewEnvironment> {
    private final Provider<PreviewObservability> observabilityProvider;

    private GifPreviewEnvironment_Factory(Provider<PreviewObservability> provider) {
        this.observabilityProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GifPreviewEnvironment get() {
        return newInstance(this.observabilityProvider.get());
    }

    public static GifPreviewEnvironment_Factory create(Provider<PreviewObservability> provider) {
        return new GifPreviewEnvironment_Factory(provider);
    }

    public static GifPreviewEnvironment newInstance(PreviewObservability previewObservability) {
        return new GifPreviewEnvironment(previewObservability);
    }
}
