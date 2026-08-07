package com.box.android.modelcontroller;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MoCoBatchOperations_Factory implements Factory<MoCoBatchOperations> {
    private final Provider<Context> contextProvider;
    private final Provider<BoxExtendedApiFile> fileApiProvider;
    private final Provider<BoxExtendedApiFolder> folderApiProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;
    private final Provider<BoxExtendedApiWeblink> weblinkApiProvider;

    private MoCoBatchOperations_Factory(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<BoxExtendedApiFile> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<BoxExtendedApiWeblink> provider5) {
        this.contextProvider = provider;
        this.userContextManagerProvider = provider2;
        this.fileApiProvider = provider3;
        this.folderApiProvider = provider4;
        this.weblinkApiProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MoCoBatchOperations get() {
        return newInstance(this.contextProvider.get(), this.userContextManagerProvider.get(), this.fileApiProvider.get(), this.folderApiProvider.get(), this.weblinkApiProvider.get());
    }

    public static MoCoBatchOperations_Factory create(Provider<Context> provider, Provider<IUserContextManager> provider2, Provider<BoxExtendedApiFile> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<BoxExtendedApiWeblink> provider5) {
        return new MoCoBatchOperations_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MoCoBatchOperations newInstance(Context context, IUserContextManager iUserContextManager, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink) {
        return new MoCoBatchOperations(context, iUserContextManager, boxExtendedApiFile, boxExtendedApiFolder, boxExtendedApiWeblink);
    }
}
