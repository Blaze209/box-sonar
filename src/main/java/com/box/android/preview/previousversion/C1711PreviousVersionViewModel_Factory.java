package com.box.android.preview.previousversion;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.preview.previousversion.PreviousVersionViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C1711PreviousVersionViewModel_Factory {
    private final Provider<PreviousVersionEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C1711PreviousVersionViewModel_Factory(Provider<IStoreFactory> provider, Provider<PreviousVersionEnvironment> provider2) {
        this.storeFactoryProvider = provider;
        this.environmentProvider = provider2;
    }

    public PreviousVersionViewModel get(Bundle bundle) {
        return newInstance(bundle, this.storeFactoryProvider.get(), this.environmentProvider.get());
    }

    public static C1711PreviousVersionViewModel_Factory create(Provider<IStoreFactory> provider, Provider<PreviousVersionEnvironment> provider2) {
        return new C1711PreviousVersionViewModel_Factory(provider, provider2);
    }

    public static PreviousVersionViewModel newInstance(Bundle bundle, IStoreFactory iStoreFactory, PreviousVersionEnvironment previousVersionEnvironment) {
        return new PreviousVersionViewModel(bundle, iStoreFactory, previousVersionEnvironment);
    }
}
