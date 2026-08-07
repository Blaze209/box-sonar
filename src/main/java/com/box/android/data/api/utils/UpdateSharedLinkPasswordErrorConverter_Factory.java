package com.box.android.data.api.utils;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class UpdateSharedLinkPasswordErrorConverter_Factory implements Factory<UpdateSharedLinkPasswordErrorConverter> {
    private final Provider<Moshi> moshiProvider;

    private UpdateSharedLinkPasswordErrorConverter_Factory(Provider<Moshi> moshiProvider) {
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateSharedLinkPasswordErrorConverter get() {
        return newInstance(this.moshiProvider.get());
    }

    public static UpdateSharedLinkPasswordErrorConverter_Factory create(Provider<Moshi> moshiProvider) {
        return new UpdateSharedLinkPasswordErrorConverter_Factory(moshiProvider);
    }

    public static UpdateSharedLinkPasswordErrorConverter newInstance(Moshi moshi) {
        return new UpdateSharedLinkPasswordErrorConverter(moshi);
    }
}
