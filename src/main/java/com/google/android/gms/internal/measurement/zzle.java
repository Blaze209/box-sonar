package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzle implements zzcz<zzld> {
    private static zzle zza = new zzle();
    private final zzcz<zzld> zzb;

    public static boolean zzb() {
        return ((zzld) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzld) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzld) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzld) zza.zza()).zzd();
    }

    private zzle(zzcz<zzld> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzle() {
        this(zzdc.zza(new zzlg()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzld zza() {
        return this.zzb.zza();
    }
}
