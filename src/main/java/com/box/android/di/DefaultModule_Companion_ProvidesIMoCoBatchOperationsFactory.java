package com.box.android.di;

import com.box.android.coreservices.modelcontroller.IMoCoBatchOperations;
import com.box.android.modelcontroller.MoCoBatchOperations;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvidesIMoCoBatchOperationsFactory implements Factory<IMoCoBatchOperations> {
    private final Provider<MoCoBatchOperations> mocoProvider;

    private DefaultModule_Companion_ProvidesIMoCoBatchOperationsFactory(Provider<MoCoBatchOperations> provider) {
        this.mocoProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IMoCoBatchOperations get() {
        return providesIMoCoBatchOperations(this.mocoProvider.get());
    }

    public static DefaultModule_Companion_ProvidesIMoCoBatchOperationsFactory create(Provider<MoCoBatchOperations> provider) {
        return new DefaultModule_Companion_ProvidesIMoCoBatchOperationsFactory(provider);
    }

    public static IMoCoBatchOperations providesIMoCoBatchOperations(MoCoBatchOperations moCoBatchOperations) {
        return (IMoCoBatchOperations) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.providesIMoCoBatchOperations(moCoBatchOperations));
    }
}
