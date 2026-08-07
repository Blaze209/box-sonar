package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzda<T> extends zzcy<T> {
    private final T zza;

    zzda(T t) {
        this.zza = t;
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final T zzb() {
        return this.zza;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzda) {
            return this.zza.equals(((zzda) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        return new StringBuilder(String.valueOf(strValueOf).length() + 13).append("Optional.of(").append(strValueOf).append(")").toString();
    }
}
