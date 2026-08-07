package com.box.android.preview.previewtype.boxnote;

import com.box.android.domain.configuration.ConfigManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxNotesUrlBuilder_Factory implements Factory<BoxNotesUrlBuilder> {
    private final Provider<ConfigManager> configManagerProvider;

    private BoxNotesUrlBuilder_Factory(Provider<ConfigManager> provider) {
        this.configManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxNotesUrlBuilder get() {
        return newInstance(this.configManagerProvider.get());
    }

    public static BoxNotesUrlBuilder_Factory create(Provider<ConfigManager> provider) {
        return new BoxNotesUrlBuilder_Factory(provider);
    }

    public static BoxNotesUrlBuilder newInstance(ConfigManager configManager) {
        return new BoxNotesUrlBuilder(configManager);
    }
}
