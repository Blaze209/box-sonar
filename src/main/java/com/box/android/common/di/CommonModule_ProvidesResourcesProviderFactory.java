package com.box.android.common.di;

import com.box.android.common.utilities.ResourcesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes10.dex */
public final class CommonModule_ProvidesResourcesProviderFactory implements Factory<ResourcesProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ResourcesProvider get() {
        return providesResourcesProvider();
    }

    public static CommonModule_ProvidesResourcesProviderFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ResourcesProvider providesResourcesProvider() {
        return (ResourcesProvider) Preconditions.checkNotNullFromProvides(CommonModule.INSTANCE.providesResourcesProvider());
    }

    private static final class InstanceHolder {
        static final CommonModule_ProvidesResourcesProviderFactory INSTANCE = new CommonModule_ProvidesResourcesProviderFactory();

        private InstanceHolder() {
        }
    }
}
