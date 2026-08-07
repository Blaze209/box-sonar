package com.box.android.data.di;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideMoshiFactory implements Factory<Moshi> {
    private final DataProvidesModule module;

    private DataProvidesModule_ProvideMoshiFactory(DataProvidesModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Moshi get() {
        return provideMoshi(this.module);
    }

    public static DataProvidesModule_ProvideMoshiFactory create(DataProvidesModule module) {
        return new DataProvidesModule_ProvideMoshiFactory(module);
    }

    public static Moshi provideMoshi(DataProvidesModule instance) {
        return (Moshi) Preconditions.checkNotNullFromProvides(instance.provideMoshi());
    }
}
