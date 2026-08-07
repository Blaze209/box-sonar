package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzlh implements zzli {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Long> zzc;

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.collection.efficient_engagement_reporting_enabled_2", false);
        zzb = zzcrVar.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzcrVar.zza("measurement.id.collection.efficient_engagement_reporting_enabled_2", 0L);
    }
}
