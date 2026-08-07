package com.box.android.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideAppFlavorStringFactory implements Factory<String> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public String get() {
        return provideAppFlavorString();
    }

    public static BoxModule_Companion_ProvideAppFlavorStringFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideAppFlavorString() {
        return (String) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideAppFlavorString());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideAppFlavorStringFactory INSTANCE = new BoxModule_Companion_ProvideAppFlavorStringFactory();

        private InstanceHolder() {
        }
    }
}
