package com.box.android.di;

import android.content.Context;
import com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvidesIMoCoBoxRecentEventsFactory implements Factory<IMoCoBoxRecentEvents> {
    private final Provider<Context> contextProvider;
    private final Provider<BoxExtendedApiFile> fileApiProvider;
    private final Provider<BoxExtendedApiFolder> folderApiProvider;
    private final Provider<BoxApiPrivate> privateApiProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvidesIMoCoBoxRecentEventsFactory(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2, Provider<BoxExtendedApiFile> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<Context> provider5) {
        this.userContextManagerProvider = provider;
        this.privateApiProvider = provider2;
        this.fileApiProvider = provider3;
        this.folderApiProvider = provider4;
        this.contextProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IMoCoBoxRecentEvents get() {
        return providesIMoCoBoxRecentEvents(this.userContextManagerProvider.get(), this.privateApiProvider.get(), this.fileApiProvider.get(), this.folderApiProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvidesIMoCoBoxRecentEventsFactory create(Provider<IUserContextManager> provider, Provider<BoxApiPrivate> provider2, Provider<BoxExtendedApiFile> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<Context> provider5) {
        return new DefaultModule_Companion_ProvidesIMoCoBoxRecentEventsFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static IMoCoBoxRecentEvents providesIMoCoBoxRecentEvents(IUserContextManager iUserContextManager, BoxApiPrivate boxApiPrivate, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, Context context) {
        return (IMoCoBoxRecentEvents) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.providesIMoCoBoxRecentEvents(iUserContextManager, boxApiPrivate, boxExtendedApiFile, boxExtendedApiFolder, context));
    }
}
