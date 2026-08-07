package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzcw<T> extends zzcy<T> {
    static final zzcw<Object> zza = new zzcw<>();

    private zzcw() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final T zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
