package com.box.android.hubs.hubDetails.presentation;

import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.utils.IBoxUriSupportChecker;
import com.box.android.hubs.hubDetails.domain.HubSpecificUrlHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class HubDetailsEnvironment_Factory implements Factory<HubDetailsEnvironment> {
    private final Provider<IBoxUriSupportChecker> boxUriSupportCheckerProvider;
    private final Provider<IBVEManager> bveManagerProvider;
    private final Provider<HubSpecificUrlHandler> hubsSpecificUrlHandlerProvider;

    private HubDetailsEnvironment_Factory(Provider<IBoxUriSupportChecker> provider, Provider<HubSpecificUrlHandler> provider2, Provider<IBVEManager> provider3) {
        this.boxUriSupportCheckerProvider = provider;
        this.hubsSpecificUrlHandlerProvider = provider2;
        this.bveManagerProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubDetailsEnvironment get() {
        return newInstance(this.boxUriSupportCheckerProvider.get(), this.hubsSpecificUrlHandlerProvider.get(), this.bveManagerProvider.get());
    }

    public static HubDetailsEnvironment_Factory create(Provider<IBoxUriSupportChecker> provider, Provider<HubSpecificUrlHandler> provider2, Provider<IBVEManager> provider3) {
        return new HubDetailsEnvironment_Factory(provider, provider2, provider3);
    }

    public static HubDetailsEnvironment newInstance(IBoxUriSupportChecker iBoxUriSupportChecker, HubSpecificUrlHandler hubSpecificUrlHandler, IBVEManager iBVEManager) {
        return new HubDetailsEnvironment(iBoxUriSupportChecker, hubSpecificUrlHandler, iBVEManager);
    }
}
