package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzlb implements zzlc {
    private static final zzcl<Boolean> zza = new zzcr(zzcm.zza("com.google.android.gms.measurement")).zza("measurement.lifecycle.app_background_timestamp_when_backgrounded", true);

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlc
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
