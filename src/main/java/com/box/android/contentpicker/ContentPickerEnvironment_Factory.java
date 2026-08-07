package com.box.android.contentpicker;

import com.box.android.base.presentation.multiselect.SelectionManager;
import com.box.android.domain.services.IClientSettingsService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class ContentPickerEnvironment_Factory implements Factory<ContentPickerEnvironment> {
    private final Provider<IClientSettingsService> clientSettingsServiceProvider;
    private final Provider<ContentPickerAnalytics> contentPickerAnalyticsProvider;
    private final Provider<SelectionManager> selectionManagerProvider;

    private ContentPickerEnvironment_Factory(Provider<SelectionManager> provider, Provider<IClientSettingsService> provider2, Provider<ContentPickerAnalytics> provider3) {
        this.selectionManagerProvider = provider;
        this.clientSettingsServiceProvider = provider2;
        this.contentPickerAnalyticsProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ContentPickerEnvironment get() {
        return newInstance(this.selectionManagerProvider.get(), this.clientSettingsServiceProvider.get(), this.contentPickerAnalyticsProvider.get());
    }

    public static ContentPickerEnvironment_Factory create(Provider<SelectionManager> provider, Provider<IClientSettingsService> provider2, Provider<ContentPickerAnalytics> provider3) {
        return new ContentPickerEnvironment_Factory(provider, provider2, provider3);
    }

    public static ContentPickerEnvironment newInstance(SelectionManager selectionManager, IClientSettingsService iClientSettingsService, ContentPickerAnalytics contentPickerAnalytics) {
        return new ContentPickerEnvironment(selectionManager, iClientSettingsService, contentPickerAnalytics);
    }
}
