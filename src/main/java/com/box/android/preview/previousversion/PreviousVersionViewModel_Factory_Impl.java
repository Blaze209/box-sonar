package com.box.android.preview.previousversion;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviousVersionViewModel_Factory_Impl implements PreviousVersionViewModel.Factory {
    private final C1711PreviousVersionViewModel_Factory delegateFactory;

    PreviousVersionViewModel_Factory_Impl(C1711PreviousVersionViewModel_Factory c1711PreviousVersionViewModel_Factory) {
        this.delegateFactory = c1711PreviousVersionViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public PreviousVersionViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<PreviousVersionViewModel.Factory> create(C1711PreviousVersionViewModel_Factory c1711PreviousVersionViewModel_Factory) {
        return InstanceFactory.create(new PreviousVersionViewModel_Factory_Impl(c1711PreviousVersionViewModel_Factory));
    }

    public static dagger.internal.Provider<PreviousVersionViewModel.Factory> createFactoryProvider(C1711PreviousVersionViewModel_Factory c1711PreviousVersionViewModel_Factory) {
        return InstanceFactory.create(new PreviousVersionViewModel_Factory_Impl(c1711PreviousVersionViewModel_Factory));
    }
}
