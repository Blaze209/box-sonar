package com.box.android.preview.preview;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewViewModel_Factory_Impl implements PreviewViewModel.Factory {
    private final C1700PreviewViewModel_Factory delegateFactory;

    PreviewViewModel_Factory_Impl(C1700PreviewViewModel_Factory c1700PreviewViewModel_Factory) {
        this.delegateFactory = c1700PreviewViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public PreviewViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<PreviewViewModel.Factory> create(C1700PreviewViewModel_Factory c1700PreviewViewModel_Factory) {
        return InstanceFactory.create(new PreviewViewModel_Factory_Impl(c1700PreviewViewModel_Factory));
    }

    public static dagger.internal.Provider<PreviewViewModel.Factory> createFactoryProvider(C1700PreviewViewModel_Factory c1700PreviewViewModel_Factory) {
        return InstanceFactory.create(new PreviewViewModel_Factory_Impl(c1700PreviewViewModel_Factory));
    }
}
