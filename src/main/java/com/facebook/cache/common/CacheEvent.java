package com.facebook.cache.common;

import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes13.dex */
public interface CacheEvent {
    @Nullable
    CacheKey getCacheKey();

    long getCacheLimit();

    long getCacheSize();

    @Nullable
    CacheEventListener.EvictionReason getEvictionReason();

    @Nullable
    IOException getException();

    long getItemSize();

    @Nullable
    String getResourceId();
}
