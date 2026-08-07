package com.box.android.preview.preview.previewbar.bottombar;

import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.services.IBoxAiService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BottomBarEnvironment_Factory implements Factory<BottomBarEnvironment> {
    private final Provider<IBoxAiService> boxAiServiceProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;

    private BottomBarEnvironment_Factory(Provider<FileActionsManager> provider, Provider<IBoxAiService> provider2) {
        this.fileActionsManagerProvider = provider;
        this.boxAiServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BottomBarEnvironment get() {
        return newInstance(this.fileActionsManagerProvider.get(), this.boxAiServiceProvider.get());
    }

    public static BottomBarEnvironment_Factory create(Provider<FileActionsManager> provider, Provider<IBoxAiService> provider2) {
        return new BottomBarEnvironment_Factory(provider, provider2);
    }

    public static BottomBarEnvironment newInstance(FileActionsManager fileActionsManager, IBoxAiService iBoxAiService) {
        return new BottomBarEnvironment(fileActionsManager, iBoxAiService);
    }
}
