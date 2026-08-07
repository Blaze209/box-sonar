package com.box.android.data.datasource.gql.cache.partial;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLPartialModelParser_Factory implements Factory<GQLPartialModelParser> {
    private final Provider<Moshi> moshiProvider;

    private GQLPartialModelParser_Factory(Provider<Moshi> moshiProvider) {
        this.moshiProvider = moshiProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLPartialModelParser get() {
        return newInstance(this.moshiProvider.get());
    }

    public static GQLPartialModelParser_Factory create(Provider<Moshi> moshiProvider) {
        return new GQLPartialModelParser_Factory(moshiProvider);
    }

    public static GQLPartialModelParser newInstance(Moshi moshi) {
        return new GQLPartialModelParser(moshi);
    }
}
