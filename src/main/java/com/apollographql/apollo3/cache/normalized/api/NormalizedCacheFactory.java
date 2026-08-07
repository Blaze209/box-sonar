package com.apollographql.apollo3.cache.normalized.api;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NormalizedCacheFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000J\b\u0010\u0006\u001a\u00020\u0007H&J\u0006\u0010\b\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;", "", "()V", "nextFactory", "chain", "factory", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "createChain", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class NormalizedCacheFactory {
    private NormalizedCacheFactory nextFactory;

    public abstract NormalizedCache create();

    public final NormalizedCache createChain() {
        NormalizedCacheFactory normalizedCacheFactory = this.nextFactory;
        if (normalizedCacheFactory != null) {
            return create().chain(normalizedCacheFactory.createChain());
        }
        return create();
    }

    public final NormalizedCacheFactory chain(NormalizedCacheFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        NormalizedCacheFactory normalizedCacheFactory = this;
        while (true) {
            NormalizedCacheFactory normalizedCacheFactory2 = normalizedCacheFactory.nextFactory;
            if (normalizedCacheFactory2 != null) {
                Intrinsics.checkNotNull(normalizedCacheFactory2);
                normalizedCacheFactory = normalizedCacheFactory2;
            } else {
                normalizedCacheFactory.nextFactory = factory;
                return this;
            }
        }
    }
}
