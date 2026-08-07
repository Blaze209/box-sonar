package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzln implements zzlo {
    private static final zzcl<Boolean> zza = new zzcr(zzcm.zza("com.google.android.gms.measurement")).zza("measurement.ga.ga_app_id", false);

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
