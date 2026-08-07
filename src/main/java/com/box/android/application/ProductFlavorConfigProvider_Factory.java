package com.box.android.application;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class ProductFlavorConfigProvider_Factory implements Factory<ProductFlavorConfigProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ProductFlavorConfigProvider get() {
        return newInstance();
    }

    public static ProductFlavorConfigProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ProductFlavorConfigProvider newInstance() {
        return new ProductFlavorConfigProvider();
    }

    private static final class InstanceHolder {
        static final ProductFlavorConfigProvider_Factory INSTANCE = new ProductFlavorConfigProvider_Factory();

        private InstanceHolder() {
        }
    }
}
