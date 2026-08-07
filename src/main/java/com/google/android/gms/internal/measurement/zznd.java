package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zznd implements zzne {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;
    private static final zzcl<Boolean> zzd;

    @Override // com.google.android.gms.internal.measurement.zzne
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzne
    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzne
    public final boolean zzc() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.client.sessions.background_sessions_enabled", true);
        zzb = zzcrVar.zza("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zzc = zzcrVar.zza("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zzd = zzcrVar.zza("measurement.client.sessions.session_id_enabled", true);
    }
}
