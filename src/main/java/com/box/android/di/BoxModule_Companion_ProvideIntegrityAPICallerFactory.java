package com.box.android.di;

import com.box.android.clientadmin.integrity.IntegrityAPICaller;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideIntegrityAPICallerFactory implements Factory<IntegrityAPICaller> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IntegrityAPICaller get() {
        return provideIntegrityAPICaller();
    }

    public static BoxModule_Companion_ProvideIntegrityAPICallerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IntegrityAPICaller provideIntegrityAPICaller() {
        return (IntegrityAPICaller) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideIntegrityAPICaller());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideIntegrityAPICallerFactory INSTANCE = new BoxModule_Companion_ProvideIntegrityAPICallerFactory();

        private InstanceHolder() {
        }
    }
}
