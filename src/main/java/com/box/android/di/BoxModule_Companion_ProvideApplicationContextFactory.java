package com.box.android.di;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideApplicationContextFactory implements Factory<Context> {
    private final Provider<Application> applicationProvider;

    private BoxModule_Companion_ProvideApplicationContextFactory(Provider<Application> provider) {
        this.applicationProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Context get() {
        return provideApplicationContext(this.applicationProvider.get());
    }

    public static BoxModule_Companion_ProvideApplicationContextFactory create(Provider<Application> provider) {
        return new BoxModule_Companion_ProvideApplicationContextFactory(provider);
    }

    public static Context provideApplicationContext(Application application) {
        return (Context) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideApplicationContext(application));
    }
}
