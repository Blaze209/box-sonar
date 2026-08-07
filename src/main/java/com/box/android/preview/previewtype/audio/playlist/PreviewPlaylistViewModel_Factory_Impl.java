package com.box.android.preview.previewtype.audio.playlist;

import android.os.Bundle;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewPlaylistViewModel_Factory_Impl implements PreviewPlaylistViewModel.Factory {
    private final C1703PreviewPlaylistViewModel_Factory delegateFactory;

    PreviewPlaylistViewModel_Factory_Impl(C1703PreviewPlaylistViewModel_Factory c1703PreviewPlaylistViewModel_Factory) {
        this.delegateFactory = c1703PreviewPlaylistViewModel_Factory;
    }

    @Override // com.box.android.common.utilities.ViewModelAssistedFactory
    public PreviewPlaylistViewModel create(Bundle bundle) {
        return this.delegateFactory.get(bundle);
    }

    public static Provider<PreviewPlaylistViewModel.Factory> create(C1703PreviewPlaylistViewModel_Factory c1703PreviewPlaylistViewModel_Factory) {
        return InstanceFactory.create(new PreviewPlaylistViewModel_Factory_Impl(c1703PreviewPlaylistViewModel_Factory));
    }

    public static dagger.internal.Provider<PreviewPlaylistViewModel.Factory> createFactoryProvider(C1703PreviewPlaylistViewModel_Factory c1703PreviewPlaylistViewModel_Factory) {
        return InstanceFactory.create(new PreviewPlaylistViewModel_Factory_Impl(c1703PreviewPlaylistViewModel_Factory));
    }
}
