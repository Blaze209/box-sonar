package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzmk implements zzmh {
    private static final zzcl<Boolean> zza = new zzcr(zzcm.zza("com.google.android.gms.measurement")).zza("measurement.config.string.always_update_disk_on_set", true);

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
