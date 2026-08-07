package com.box.android.routers;

import com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability;
import com.box.android.preview.utils.PreviewLauncher;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxPreviewRouter_Factory implements Factory<BoxPreviewRouter> {
    private final Provider<PreviewLauncher> previewLauncherProvider;
    private final Provider<PreviousVersionPreviewObservability> previousVersionPreviewObservabilityProvider;

    private BoxPreviewRouter_Factory(Provider<PreviewLauncher> provider, Provider<PreviousVersionPreviewObservability> provider2) {
        this.previewLauncherProvider = provider;
        this.previousVersionPreviewObservabilityProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxPreviewRouter get() {
        return newInstance(this.previewLauncherProvider.get(), this.previousVersionPreviewObservabilityProvider.get());
    }

    public static BoxPreviewRouter_Factory create(Provider<PreviewLauncher> provider, Provider<PreviousVersionPreviewObservability> provider2) {
        return new BoxPreviewRouter_Factory(provider, provider2);
    }

    public static BoxPreviewRouter newInstance(PreviewLauncher previewLauncher, PreviousVersionPreviewObservability previousVersionPreviewObservability) {
        return new BoxPreviewRouter(previewLauncher, previousVersionPreviewObservability);
    }
}
