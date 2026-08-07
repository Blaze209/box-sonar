package com.box.android.domain.usecases.notes;

import com.box.android.common.utilities.Clock;
import com.box.android.common.utilities.ResourcesProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class NoteNameGenerator_Factory implements Factory<NoteNameGenerator> {
    private final Provider<Clock> clockProvider;
    private final Provider<ResourcesProvider> resourcesProvider;

    private NoteNameGenerator_Factory(Provider<ResourcesProvider> provider, Provider<Clock> provider2) {
        this.resourcesProvider = provider;
        this.clockProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NoteNameGenerator get() {
        return newInstance(this.resourcesProvider.get(), this.clockProvider.get());
    }

    public static NoteNameGenerator_Factory create(Provider<ResourcesProvider> provider, Provider<Clock> provider2) {
        return new NoteNameGenerator_Factory(provider, provider2);
    }

    public static NoteNameGenerator newInstance(ResourcesProvider resourcesProvider, Clock clock) {
        return new NoteNameGenerator(resourcesProvider, clock);
    }
}
