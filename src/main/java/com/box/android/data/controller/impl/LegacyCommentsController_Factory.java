package com.box.android.data.controller.impl;

import android.content.Context;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class LegacyCommentsController_Factory implements Factory<LegacyCommentsController> {
    private final Provider<IBaseModelController> baseMocoProvider;
    private final Provider<Context> contextProvider;
    private final Provider<BoxExtendedApiFile> fileApiProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private LegacyCommentsController_Factory(Provider<Context> contextProvider, Provider<IBaseModelController> baseMocoProvider, Provider<BoxExtendedApiFile> fileApiProvider, Provider<IUserContextManager> userContextManagerProvider) {
        this.contextProvider = contextProvider;
        this.baseMocoProvider = baseMocoProvider;
        this.fileApiProvider = fileApiProvider;
        this.userContextManagerProvider = userContextManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LegacyCommentsController get() {
        return newInstance(this.contextProvider.get(), this.baseMocoProvider.get(), this.fileApiProvider.get(), this.userContextManagerProvider.get());
    }

    public static LegacyCommentsController_Factory create(Provider<Context> contextProvider, Provider<IBaseModelController> baseMocoProvider, Provider<BoxExtendedApiFile> fileApiProvider, Provider<IUserContextManager> userContextManagerProvider) {
        return new LegacyCommentsController_Factory(contextProvider, baseMocoProvider, fileApiProvider, userContextManagerProvider);
    }

    public static LegacyCommentsController newInstance(Context context, IBaseModelController baseMoco, BoxExtendedApiFile fileApi, IUserContextManager userContextManager) {
        return new LegacyCommentsController(context, baseMoco, fileApi, userContextManager);
    }
}
