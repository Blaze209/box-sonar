package com.box.android.data.datasource.gql;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLRequestParser_Factory implements Factory<GQLRequestParser> {
    private final Provider<Moshi> moshiProvider;

    private GQLRequestParser_Factory(Provider<Moshi> moshiProvider) {
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLRequestParser get() {
        return newInstance(this.moshiProvider.get());
    }

    public static GQLRequestParser_Factory create(Provider<Moshi> moshiProvider) {
        return new GQLRequestParser_Factory(moshiProvider);
    }

    public static GQLRequestParser newInstance(Moshi moshi) {
        return new GQLRequestParser(moshi);
    }
}
