package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzlw implements zzcz<zzlv> {
    private static zzlw zza = new zzlw();
    private final zzcz<zzlv> zzb;

    public static boolean zzb() {
        return ((zzlv) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlv) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzlv) zza.zza()).zzc();
    }

    private zzlw(zzcz<zzlv> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzlw() {
        this(zzdc.zza(new zzly()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzlv zza() {
        return this.zzb.zza();
    }
}
