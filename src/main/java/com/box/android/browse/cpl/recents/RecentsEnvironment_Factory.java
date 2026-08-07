package com.box.android.browse.cpl.recents;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class RecentsEnvironment_Factory implements Factory<RecentsEnvironment> {
    private final Provider<ActionableRecentViewEnvironment> actionableItemsListEnvironmentProvider;

    private RecentsEnvironment_Factory(Provider<ActionableRecentViewEnvironment> provider) {
        this.actionableItemsListEnvironmentProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentsEnvironment get() {
        return newInstance(this.actionableItemsListEnvironmentProvider.get());
    }

    public static RecentsEnvironment_Factory create(Provider<ActionableRecentViewEnvironment> provider) {
        return new RecentsEnvironment_Factory(provider);
    }

    public static RecentsEnvironment newInstance(ActionableRecentViewEnvironment actionableRecentViewEnvironment) {
        return new RecentsEnvironment(actionableRecentViewEnvironment);
    }
}
