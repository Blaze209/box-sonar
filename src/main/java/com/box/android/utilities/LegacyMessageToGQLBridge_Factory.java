package com.box.android.utilities;

import com.box.android.domain.services.ILegacyBridgeService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class LegacyMessageToGQLBridge_Factory implements Factory<LegacyMessageToGQLBridge> {
    private final Provider<ILegacyBridgeService> legacyBridgeServiceProvider;

    private LegacyMessageToGQLBridge_Factory(Provider<ILegacyBridgeService> provider) {
        this.legacyBridgeServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LegacyMessageToGQLBridge get() {
        return newInstance(this.legacyBridgeServiceProvider.get());
    }

    public static LegacyMessageToGQLBridge_Factory create(Provider<ILegacyBridgeService> provider) {
        return new LegacyMessageToGQLBridge_Factory(provider);
    }

    public static LegacyMessageToGQLBridge newInstance(ILegacyBridgeService iLegacyBridgeService) {
        return new LegacyMessageToGQLBridge(iLegacyBridgeService);
    }
}
