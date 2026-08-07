package com.box.android.data.persistence;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ObservabilityDatabaseProvider_Factory implements Factory<ObservabilityDatabaseProvider> {
    private final Provider<Context> contextProvider;
    private final Provider<ObservabilityDatabaseCreator> observabilityDatabaseCreatorProvider;

    private ObservabilityDatabaseProvider_Factory(Provider<ObservabilityDatabaseCreator> observabilityDatabaseCreatorProvider, Provider<Context> contextProvider) {
        this.observabilityDatabaseCreatorProvider = observabilityDatabaseCreatorProvider;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ObservabilityDatabaseProvider get() {
        return newInstance(this.observabilityDatabaseCreatorProvider.get(), this.contextProvider.get());
    }

    public static ObservabilityDatabaseProvider_Factory create(Provider<ObservabilityDatabaseCreator> observabilityDatabaseCreatorProvider, Provider<Context> contextProvider) {
        return new ObservabilityDatabaseProvider_Factory(observabilityDatabaseCreatorProvider, contextProvider);
    }

    public static ObservabilityDatabaseProvider newInstance(ObservabilityDatabaseCreator observabilityDatabaseCreator, Context context) {
        return new ObservabilityDatabaseProvider(observabilityDatabaseCreator, context);
    }
}
