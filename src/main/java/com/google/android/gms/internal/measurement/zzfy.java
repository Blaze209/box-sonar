package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
abstract class zzfy {
    private static final zzfy zza;
    private static final zzfy zzb;

    private zzfy() {
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);

    static zzfy zza() {
        return zza;
    }

    static zzfy zzb() {
        return zzb;
    }

    static {
        zzfx zzfxVar = null;
        zza = new zzga();
        zzb = new zzfz();
    }
}
