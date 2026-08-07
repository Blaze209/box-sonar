package com.box.android.browse.cpl.copymove;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CopyOrMoveViewModel_Factory_Impl implements CopyOrMoveViewModel.Factory {
    private final C0949CopyOrMoveViewModel_Factory delegateFactory;

    CopyOrMoveViewModel_Factory_Impl(C0949CopyOrMoveViewModel_Factory c0949CopyOrMoveViewModel_Factory) {
        this.delegateFactory = c0949CopyOrMoveViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public CopyOrMoveViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<CopyOrMoveViewModel.Factory> create(C0949CopyOrMoveViewModel_Factory c0949CopyOrMoveViewModel_Factory) {
        return InstanceFactory.create(new CopyOrMoveViewModel_Factory_Impl(c0949CopyOrMoveViewModel_Factory));
    }

    public static dagger.internal.Provider<CopyOrMoveViewModel.Factory> createFactoryProvider(C0949CopyOrMoveViewModel_Factory c0949CopyOrMoveViewModel_Factory) {
        return InstanceFactory.create(new CopyOrMoveViewModel_Factory_Impl(c0949CopyOrMoveViewModel_Factory));
    }
}
