package com.box.android.di;

import android.content.Context;
import com.box.android.controller.AndroidForWorkController;
import com.box.android.domain.services.IAppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideAndroidForWorkControllerFactory implements Factory<AndroidForWorkController> {
    private final Provider<Context> contextProvider;
    private final Provider<IAppRestrictionsManager> restrictionsManagerProvider;

    private DefaultModule_Companion_ProvideAndroidForWorkControllerFactory(Provider<IAppRestrictionsManager> provider, Provider<Context> provider2) {
        this.restrictionsManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AndroidForWorkController get() {
        return provideAndroidForWorkController(this.restrictionsManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideAndroidForWorkControllerFactory create(Provider<IAppRestrictionsManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideAndroidForWorkControllerFactory(provider, provider2);
    }

    public static AndroidForWorkController provideAndroidForWorkController(IAppRestrictionsManager iAppRestrictionsManager, Context context) {
        return (AndroidForWorkController) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideAndroidForWorkController(iAppRestrictionsManager, context));
    }
}
