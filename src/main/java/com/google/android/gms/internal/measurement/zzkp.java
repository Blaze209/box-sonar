package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkp implements zzkq {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.service.fix_gmp_version", false);
        zzb = zzcrVar.zza("measurement.id.service.fix_gmp_version", 0L);
    }
}
