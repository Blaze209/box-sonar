package com.box.android.preview.previewtype.audio.playlist;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C1703PreviewPlaylistViewModel_Factory {
    private final Provider<PreviewPlaylistEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C1703PreviewPlaylistViewModel_Factory(Provider<IStoreFactory> provider, Provider<PreviewPlaylistEnvironment> provider2) {
        this.storeFactoryProvider = provider;
        this.environmentProvider = provider2;
    }

    public PreviewPlaylistViewModel get(Bundle bundle) {
        return newInstance(bundle, this.storeFactoryProvider.get(), this.environmentProvider.get());
    }

    public static C1703PreviewPlaylistViewModel_Factory create(Provider<IStoreFactory> provider, Provider<PreviewPlaylistEnvironment> provider2) {
        return new C1703PreviewPlaylistViewModel_Factory(provider, provider2);
    }

    public static PreviewPlaylistViewModel newInstance(Bundle bundle, IStoreFactory iStoreFactory, PreviewPlaylistEnvironment previewPlaylistEnvironment) {
        return new PreviewPlaylistViewModel(bundle, iStoreFactory, previewPlaylistEnvironment);
    }
}
