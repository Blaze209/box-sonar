package com.box.android.di;

import android.content.Context;
import com.box.android.localrepo.LevelDBKeyValueStore;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideLevelDBKeyValueStoreFactory implements Factory<LevelDBKeyValueStore> {
    private final Provider<Context> contextProvider;

    private BoxModule_Companion_ProvideLevelDBKeyValueStoreFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LevelDBKeyValueStore get() {
        return provideLevelDBKeyValueStore(this.contextProvider.get());
    }

    public static BoxModule_Companion_ProvideLevelDBKeyValueStoreFactory create(Provider<Context> provider) {
        return new BoxModule_Companion_ProvideLevelDBKeyValueStoreFactory(provider);
    }

    public static LevelDBKeyValueStore provideLevelDBKeyValueStore(Context context) {
        return (LevelDBKeyValueStore) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideLevelDBKeyValueStore(context));
    }
}
