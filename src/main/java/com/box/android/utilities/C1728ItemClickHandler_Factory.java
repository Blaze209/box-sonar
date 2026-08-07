package com.box.android.utilities;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.utilities.ItemClickHandler_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C1728ItemClickHandler_Factory {
    private final Provider<IBaseModelController> baseModelControllerProvider;
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<Context> contextProvider;
    private final Provider<IPreviewLauncher> previewLauncherProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C1728ItemClickHandler_Factory(Provider<IUserContextManager> provider, Provider<IPreviewLauncher> provider2, Provider<IBaseModelController> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<Context> provider5) {
        this.userContextManagerProvider = provider;
        this.previewLauncherProvider = provider2;
        this.baseModelControllerProvider = provider3;
        this.boxExtendedApiFolderProvider = provider4;
        this.contextProvider = provider5;
    }

    public ItemClickHandler get(AppCompatActivity appCompatActivity) {
        return newInstance(this.userContextManagerProvider.get(), this.previewLauncherProvider.get(), this.baseModelControllerProvider.get(), this.boxExtendedApiFolderProvider.get(), this.contextProvider.get(), appCompatActivity);
    }

    public static C1728ItemClickHandler_Factory create(Provider<IUserContextManager> provider, Provider<IPreviewLauncher> provider2, Provider<IBaseModelController> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<Context> provider5) {
        return new C1728ItemClickHandler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ItemClickHandler newInstance(IUserContextManager iUserContextManager, IPreviewLauncher iPreviewLauncher, IBaseModelController iBaseModelController, BoxExtendedApiFolder boxExtendedApiFolder, Context context, AppCompatActivity appCompatActivity) {
        return new ItemClickHandler(iUserContextManager, iPreviewLauncher, iBaseModelController, boxExtendedApiFolder, context, appCompatActivity);
    }
}
