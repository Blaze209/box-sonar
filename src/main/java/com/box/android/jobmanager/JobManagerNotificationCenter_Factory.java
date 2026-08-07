package com.box.android.jobmanager;

import android.content.Context;
import com.box.android.coreservices.api.ShareController;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class JobManagerNotificationCenter_Factory implements Factory<JobManagerNotificationCenter> {
    private final Provider<IBaseModelController> baseModelControllerProvider;
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<Context> contextProvider;
    private final Provider<ShareController> shareControllerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private JobManagerNotificationCenter_Factory(Provider<Context> provider, Provider<IBaseModelController> provider2, Provider<ShareController> provider3, Provider<IUserContextManager> provider4, Provider<BoxExtendedApiFolder> provider5) {
        this.contextProvider = provider;
        this.baseModelControllerProvider = provider2;
        this.shareControllerProvider = provider3;
        this.userContextManagerProvider = provider4;
        this.boxExtendedApiFolderProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobManagerNotificationCenter get() {
        return newInstance(this.contextProvider.get(), this.baseModelControllerProvider.get(), this.shareControllerProvider.get(), this.userContextManagerProvider.get(), this.boxExtendedApiFolderProvider.get());
    }

    public static JobManagerNotificationCenter_Factory create(Provider<Context> provider, Provider<IBaseModelController> provider2, Provider<ShareController> provider3, Provider<IUserContextManager> provider4, Provider<BoxExtendedApiFolder> provider5) {
        return new JobManagerNotificationCenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static JobManagerNotificationCenter newInstance(Context context, IBaseModelController iBaseModelController, ShareController shareController, IUserContextManager iUserContextManager, BoxExtendedApiFolder boxExtendedApiFolder) {
        return new JobManagerNotificationCenter(context, iBaseModelController, shareController, iUserContextManager, boxExtendedApiFolder);
    }
}
