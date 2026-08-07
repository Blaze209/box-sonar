package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkj implements zzkk {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzkk
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkk
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzb = zzcrVar.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }
}
