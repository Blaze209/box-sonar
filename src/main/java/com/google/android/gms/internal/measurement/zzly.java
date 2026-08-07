package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzly implements zzlv {
    private static final zzcl<Long> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;
    private static final zzcl<Long> zze;

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final boolean zza() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final boolean zzc() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzcrVar.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzcrVar.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzcrVar.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzcrVar.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }
}
