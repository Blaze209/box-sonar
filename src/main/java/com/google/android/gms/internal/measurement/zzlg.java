package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzlg implements zzld {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Boolean> zzb;
    private static final zzcl<Boolean> zzc;

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.client.sessions.check_on_reset_and_enable", false);
        zzb = zzcrVar.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zzcrVar.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }
}
