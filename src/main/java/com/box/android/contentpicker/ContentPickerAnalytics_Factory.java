package com.box.android.contentpicker;

import com.box.android.domain.analytics.AiCenterSessionInfoProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class ContentPickerAnalytics_Factory implements Factory<ContentPickerAnalytics> {
    private final Provider<AiCenterSessionInfoProvider> aiCenterSessionInfoProvider;
    private final Provider<ContentPickerEventPropertyBuilder> contentPickerEventPropertyBuilderProvider;

    private ContentPickerAnalytics_Factory(Provider<ContentPickerEventPropertyBuilder> provider, Provider<AiCenterSessionInfoProvider> provider2) {
        this.contentPickerEventPropertyBuilderProvider = provider;
        this.aiCenterSessionInfoProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ContentPickerAnalytics get() {
        return newInstance(this.contentPickerEventPropertyBuilderProvider.get(), this.aiCenterSessionInfoProvider.get());
    }

    public static ContentPickerAnalytics_Factory create(Provider<ContentPickerEventPropertyBuilder> provider, Provider<AiCenterSessionInfoProvider> provider2) {
        return new ContentPickerAnalytics_Factory(provider, provider2);
    }

    public static ContentPickerAnalytics newInstance(ContentPickerEventPropertyBuilder contentPickerEventPropertyBuilder, AiCenterSessionInfoProvider aiCenterSessionInfoProvider) {
        return new ContentPickerAnalytics(contentPickerEventPropertyBuilder, aiCenterSessionInfoProvider);
    }
}
