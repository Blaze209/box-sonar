package com.box.android.base.cpl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class ItemNameValidator_Factory implements Factory<ItemNameValidator> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ItemNameValidator get() {
        return newInstance();
    }

    public static ItemNameValidator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ItemNameValidator newInstance() {
        return new ItemNameValidator();
    }

    private static final class InstanceHolder {
        static final ItemNameValidator_Factory INSTANCE = new ItemNameValidator_Factory();

        private InstanceHolder() {
        }
    }
}
