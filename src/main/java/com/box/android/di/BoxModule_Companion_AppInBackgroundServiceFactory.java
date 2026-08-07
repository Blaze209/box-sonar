package com.box.android.di;

import com.box.android.domain.services.IAppInBackgroundService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_AppInBackgroundServiceFactory implements Factory<IAppInBackgroundService> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IAppInBackgroundService get() {
        return appInBackgroundService();
    }

    public static BoxModule_Companion_AppInBackgroundServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IAppInBackgroundService appInBackgroundService() {
        return (IAppInBackgroundService) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.appInBackgroundService());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_AppInBackgroundServiceFactory INSTANCE = new BoxModule_Companion_AppInBackgroundServiceFactory();

        private InstanceHolder() {
        }
    }
}
