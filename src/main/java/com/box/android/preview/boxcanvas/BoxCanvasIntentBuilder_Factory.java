package com.box.android.preview.boxcanvas;

import com.box.android.domain.configuration.ConfigManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxCanvasIntentBuilder_Factory implements Factory<BoxCanvasIntentBuilder> {
    private final Provider<CanvasAuthorizer> canvasAuthorizerProvider;
    private final Provider<ConfigManager> configManagerProvider;

    private BoxCanvasIntentBuilder_Factory(Provider<ConfigManager> provider, Provider<CanvasAuthorizer> provider2) {
        this.configManagerProvider = provider;
        this.canvasAuthorizerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxCanvasIntentBuilder get() {
        return newInstance(this.configManagerProvider.get(), this.canvasAuthorizerProvider.get());
    }

    public static BoxCanvasIntentBuilder_Factory create(Provider<ConfigManager> provider, Provider<CanvasAuthorizer> provider2) {
        return new BoxCanvasIntentBuilder_Factory(provider, provider2);
    }

    public static BoxCanvasIntentBuilder newInstance(ConfigManager configManager, CanvasAuthorizer canvasAuthorizer) {
        return new BoxCanvasIntentBuilder(configManager, canvasAuthorizer);
    }
}
