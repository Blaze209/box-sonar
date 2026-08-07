package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzkg implements zzcz<zzkf> {
    private static zzkg zza = new zzkg();
    private final zzcz<zzkf> zzb;

    public static boolean zzb() {
        return ((zzkf) zza.zza()).zza();
    }

    private zzkg(zzcz<zzkf> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zzkg() {
        this(zzdc.zza(new zzki()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zzkf zza() {
        return this.zzb.zza();
    }
}
