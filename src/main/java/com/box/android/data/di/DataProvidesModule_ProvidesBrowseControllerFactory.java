package com.box.android.data.di;

import android.content.Context;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiSearch;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidesBrowseControllerFactory implements Factory<IBrowseController> {
    private final Provider<ThreadPoolExecutor> apiExecutorProvider;
    private final Provider<Context> contextProvider;
    private final Provider<BoxExtendedApiFile> fileApiProvider;
    private final Provider<BoxExtendedApiFolder> folderApiProvider;
    private final DataProvidesModule module;
    private final Provider<BoxExtendedApiSearch> searchApiProvider;
    private final Provider<ThreadPoolExecutor> thumbnailExecutorProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DataProvidesModule_ProvidesBrowseControllerFactory(DataProvidesModule module, Provider<IUserContextManager> userContextManagerProvider, Provider<BoxExtendedApiFile> fileApiProvider, Provider<BoxExtendedApiFolder> folderApiProvider, Provider<BoxExtendedApiSearch> searchApiProvider, Provider<Context> contextProvider, Provider<ThreadPoolExecutor> apiExecutorProvider, Provider<ThreadPoolExecutor> thumbnailExecutorProvider) {
        this.module = module;
        this.userContextManagerProvider = userContextManagerProvider;
        this.fileApiProvider = fileApiProvider;
        this.folderApiProvider = folderApiProvider;
        this.searchApiProvider = searchApiProvider;
        this.contextProvider = contextProvider;
        this.apiExecutorProvider = apiExecutorProvider;
        this.thumbnailExecutorProvider = thumbnailExecutorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IBrowseController get() {
        return providesBrowseController(this.module, this.userContextManagerProvider.get(), this.fileApiProvider.get(), this.folderApiProvider.get(), this.searchApiProvider.get(), this.contextProvider.get(), this.apiExecutorProvider.get(), this.thumbnailExecutorProvider.get());
    }

    public static DataProvidesModule_ProvidesBrowseControllerFactory create(DataProvidesModule module, Provider<IUserContextManager> userContextManagerProvider, Provider<BoxExtendedApiFile> fileApiProvider, Provider<BoxExtendedApiFolder> folderApiProvider, Provider<BoxExtendedApiSearch> searchApiProvider, Provider<Context> contextProvider, Provider<ThreadPoolExecutor> apiExecutorProvider, Provider<ThreadPoolExecutor> thumbnailExecutorProvider) {
        return new DataProvidesModule_ProvidesBrowseControllerFactory(module, userContextManagerProvider, fileApiProvider, folderApiProvider, searchApiProvider, contextProvider, apiExecutorProvider, thumbnailExecutorProvider);
    }

    public static IBrowseController providesBrowseController(DataProvidesModule instance, IUserContextManager userContextManager, BoxExtendedApiFile fileApi, BoxExtendedApiFolder folderApi, BoxExtendedApiSearch searchApi, Context context, ThreadPoolExecutor apiExecutor, ThreadPoolExecutor thumbnailExecutor) {
        return (IBrowseController) Preconditions.checkNotNullFromProvides(instance.providesBrowseController(userContextManager, fileApi, folderApi, searchApi, context, apiExecutor, thumbnailExecutor));
    }
}
