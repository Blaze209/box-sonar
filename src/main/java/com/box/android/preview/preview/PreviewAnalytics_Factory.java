package com.box.android.preview.preview;

import com.box.android.domain.analytics.WopiPropertyBuilder;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewAnalytics_Factory implements Factory<PreviewAnalytics> {
    private final Provider<WopiPropertyBuilder> wopiEventBuilderProvider;

    private PreviewAnalytics_Factory(Provider<WopiPropertyBuilder> provider) {
        this.wopiEventBuilderProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewAnalytics get() {
        return newInstance(this.wopiEventBuilderProvider.get());
    }

    public static PreviewAnalytics_Factory create(Provider<WopiPropertyBuilder> provider) {
        return new PreviewAnalytics_Factory(provider);
    }

    public static PreviewAnalytics newInstance(WopiPropertyBuilder wopiPropertyBuilder) {
        return new PreviewAnalytics(wopiPropertyBuilder);
    }
}
