package com.box.android.browse.cpl.copymove;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.browse.cpl.copymove.CopyOrMoveViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C0949CopyOrMoveViewModel_Factory {
    private final Provider<CopyOrMoveEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C0949CopyOrMoveViewModel_Factory(Provider<CopyOrMoveEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    public CopyOrMoveViewModel get(Bundle bundle) {
        return newInstance(bundle, this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static C0949CopyOrMoveViewModel_Factory create(Provider<CopyOrMoveEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new C0949CopyOrMoveViewModel_Factory(provider, provider2);
    }

    public static CopyOrMoveViewModel newInstance(Bundle bundle, CopyOrMoveEnvironment copyOrMoveEnvironment, IStoreFactory iStoreFactory) {
        return new CopyOrMoveViewModel(bundle, copyOrMoveEnvironment, iStoreFactory);
    }
}
