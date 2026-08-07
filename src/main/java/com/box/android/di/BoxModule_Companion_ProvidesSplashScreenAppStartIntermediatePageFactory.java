package com.box.android.di;

import com.box.android.observability.appstart.AuthenticationAppStartDestinationPage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvidesSplashScreenAppStartIntermediatePageFactory implements Factory<AuthenticationAppStartDestinationPage> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthenticationAppStartDestinationPage get() {
        return providesSplashScreenAppStartIntermediatePage();
    }

    public static BoxModule_Companion_ProvidesSplashScreenAppStartIntermediatePageFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AuthenticationAppStartDestinationPage providesSplashScreenAppStartIntermediatePage() {
        return (AuthenticationAppStartDestinationPage) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.providesSplashScreenAppStartIntermediatePage());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvidesSplashScreenAppStartIntermediatePageFactory INSTANCE = new BoxModule_Companion_ProvidesSplashScreenAppStartIntermediatePageFactory();

        private InstanceHolder() {
        }
    }
}
