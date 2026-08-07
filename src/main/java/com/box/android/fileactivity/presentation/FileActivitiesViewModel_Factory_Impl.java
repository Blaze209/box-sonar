package com.box.android.fileactivity.presentation;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class FileActivitiesViewModel_Factory_Impl implements FileActivitiesViewModel.Factory {
    private final C1639FileActivitiesViewModel_Factory delegateFactory;

    FileActivitiesViewModel_Factory_Impl(C1639FileActivitiesViewModel_Factory c1639FileActivitiesViewModel_Factory) {
        this.delegateFactory = c1639FileActivitiesViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public FileActivitiesViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<FileActivitiesViewModel.Factory> create(C1639FileActivitiesViewModel_Factory c1639FileActivitiesViewModel_Factory) {
        return InstanceFactory.create(new FileActivitiesViewModel_Factory_Impl(c1639FileActivitiesViewModel_Factory));
    }

    public static dagger.internal.Provider<FileActivitiesViewModel.Factory> createFactoryProvider(C1639FileActivitiesViewModel_Factory c1639FileActivitiesViewModel_Factory) {
        return InstanceFactory.create(new FileActivitiesViewModel_Factory_Impl(c1639FileActivitiesViewModel_Factory));
    }
}
