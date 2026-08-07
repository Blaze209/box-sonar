package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkd implements zzke {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzcrVar.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzcrVar.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzcrVar.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
