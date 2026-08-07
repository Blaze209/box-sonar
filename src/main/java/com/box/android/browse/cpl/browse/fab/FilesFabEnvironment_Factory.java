package com.box.android.browse.cpl.browse.fab;

import com.box.android.browse.cpl.browse.fab.newfile.NewFileMenuUtils;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FilesFabEnvironment_Factory implements Factory<FilesFabEnvironment> {
    private final Provider<FilesFabAnalytics> analyticsProvider;
    private final Provider<FabManager> fabManagerProvider;
    private final Provider<NewFileMenuUtils> newFileMenuUtilsProvider;
    private final Provider<UploadHelper> uploadHelperProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private FilesFabEnvironment_Factory(Provider<FabManager> provider, Provider<IUserContextManager> provider2, Provider<UploadHelper> provider3, Provider<NewFileMenuUtils> provider4, Provider<FilesFabAnalytics> provider5) {
        this.fabManagerProvider = provider;
        this.userContextManagerProvider = provider2;
        this.uploadHelperProvider = provider3;
        this.newFileMenuUtilsProvider = provider4;
        this.analyticsProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FilesFabEnvironment get() {
        return newInstance(this.fabManagerProvider.get(), this.userContextManagerProvider.get(), this.uploadHelperProvider.get(), this.newFileMenuUtilsProvider.get(), this.analyticsProvider.get());
    }

    public static FilesFabEnvironment_Factory create(Provider<FabManager> provider, Provider<IUserContextManager> provider2, Provider<UploadHelper> provider3, Provider<NewFileMenuUtils> provider4, Provider<FilesFabAnalytics> provider5) {
        return new FilesFabEnvironment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static FilesFabEnvironment newInstance(FabManager fabManager, IUserContextManager iUserContextManager, UploadHelper uploadHelper, NewFileMenuUtils newFileMenuUtils, FilesFabAnalytics filesFabAnalytics) {
        return new FilesFabEnvironment(fabManager, iUserContextManager, uploadHelper, newFileMenuUtils, filesFabAnalytics);
    }
}
