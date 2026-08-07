package com.google.android.gms.internal.mlkit_common;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzag {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    zzag(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    final IllegalArgumentException zza() {
        Object obj = this.zzc;
        Object obj2 = this.zzb;
        Object obj3 = this.zza;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + SimpleComparison.EQUAL_TO_OPERATION + String.valueOf(obj2) + " and " + String.valueOf(obj3) + SimpleComparison.EQUAL_TO_OPERATION + String.valueOf(obj));
    }
}
