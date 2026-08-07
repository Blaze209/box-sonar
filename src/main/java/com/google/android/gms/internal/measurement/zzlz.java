package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzlz implements zzma {
    private static final zzcl<Long> zza;
    private static final zzcl<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzma
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzma
    public final long zzb() {
        return zzb.zzc().longValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.id.max_bundles_per_iteration", 0L);
        zzb = zzcrVar.zza("measurement.max_bundles_per_iteration", 1L);
    }
}
