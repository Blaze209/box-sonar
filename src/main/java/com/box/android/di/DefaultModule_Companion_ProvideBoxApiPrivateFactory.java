package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiPrivateFactory implements Factory<BoxApiPrivate> {
    private final Provider<BoxExtendedApiCollections> collectionsApiProvider;
    private final Provider<Context> contextProvider;
    private final Provider<BoxExtendedApiFile> fileApiProvider;
    private final Provider<BoxExtendedApiFolder> folderApiProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;
    private final Provider<BoxExtendedApiWeblink> weblinkApiProvider;

    private DefaultModule_Companion_ProvideBoxApiPrivateFactory(Provider<IUserContextManager> provider, Provider<BoxExtendedApiFolder> provider2, Provider<BoxExtendedApiFile> provider3, Provider<BoxExtendedApiWeblink> provider4, Provider<BoxExtendedApiCollections> provider5, Provider<Context> provider6) {
        this.userContextManagerProvider = provider;
        this.folderApiProvider = provider2;
        this.fileApiProvider = provider3;
        this.weblinkApiProvider = provider4;
        this.collectionsApiProvider = provider5;
        this.contextProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiPrivate get() {
        return provideBoxApiPrivate(this.userContextManagerProvider.get(), this.folderApiProvider.get(), this.fileApiProvider.get(), this.weblinkApiProvider.get(), this.collectionsApiProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiPrivateFactory create(Provider<IUserContextManager> provider, Provider<BoxExtendedApiFolder> provider2, Provider<BoxExtendedApiFile> provider3, Provider<BoxExtendedApiWeblink> provider4, Provider<BoxExtendedApiCollections> provider5, Provider<Context> provider6) {
        return new DefaultModule_Companion_ProvideBoxApiPrivateFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static BoxApiPrivate provideBoxApiPrivate(IUserContextManager iUserContextManager, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiWeblink boxExtendedApiWeblink, BoxExtendedApiCollections boxExtendedApiCollections, Context context) {
        return (BoxApiPrivate) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiPrivate(iUserContextManager, boxExtendedApiFolder, boxExtendedApiFile, boxExtendedApiWeblink, boxExtendedApiCollections, context));
    }
}
