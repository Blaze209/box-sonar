package com.nimbusds.jose.util.cache;

import com.nimbusds.jose.shaded.jcip.Immutable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class CachedObject<V> {
    private final long expirationTime;
    private final V object;
    private final long timestamp;

    public static long computeExpirationTime(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public CachedObject(V v, long j, long j2) {
        this.object = (V) Objects.requireNonNull(v);
        this.timestamp = j;
        this.expirationTime = j2;
    }

    public V get() {
        return this.object;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public boolean isValid(long j) {
        return j < this.expirationTime;
    }

    public boolean isExpired(long j) {
        return !isValid(j);
    }
}
