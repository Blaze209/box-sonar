package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzgg<K, V> {
    static <K, V> void zza(zzen zzenVar, zzgf<K, V> zzgfVar, K k, V v) throws IOException {
        zzew.zza(zzenVar, zzgfVar.zza, 1, k);
        zzew.zza(zzenVar, zzgfVar.zzc, 2, v);
    }

    static <K, V> int zza(zzgf<K, V> zzgfVar, K k, V v) {
        return zzew.zza(zzgfVar.zza, 1, k) + zzew.zza(zzgfVar.zzc, 2, v);
    }
}
