package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkc implements zzjz {
    private static final zzcl<Boolean> zza = new zzcr(zzcm.zza("com.google.android.gms.measurement")).zza("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.zzjz
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzjz
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
