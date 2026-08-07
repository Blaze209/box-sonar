package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zznn implements zzcz<zznq> {
    private static zznn zza = new zznn();
    private final zzcz<zznq> zzb;

    public static boolean zzb() {
        return ((zznq) zza.zza()).zza();
    }

    private zznn(zzcz<zznq> zzczVar) {
        this.zzb = zzdc.zza((zzcz) zzczVar);
    }

    public zznn() {
        this(zzdc.zza(new zznp()));
    }

    @Override // com.google.android.gms.internal.measurement.zzcz
    public final /* synthetic */ zznq zza() {
        return this.zzb.zza();
    }
}
