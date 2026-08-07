package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzjq implements zzjn {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Long> zzd;

    @Override // com.google.android.gms.internal.measurement.zzjn
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjn
    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.sdk.dynamite.allow_remote_dynamite", false);
        zzb = zzcrVar.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzcrVar.zza("measurement.sdk.dynamite.use_dynamite2", false);
        zzd = zzcrVar.zza("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }
}
