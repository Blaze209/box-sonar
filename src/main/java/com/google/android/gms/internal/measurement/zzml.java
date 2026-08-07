package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzml implements zzmm {
    private static final zzcl<Boolean> zza;
    private static final zzcl<Double> zzb;
    private static final zzcl<Long> zzc;
    private static final zzcl<Long> zzd;
    private static final zzcl<String> zze;

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final long zzc() {
        return zzc.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final long zzd() {
        return zzd.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmm
    public final String zze() {
        return zze.zzc();
    }

    static {
        zzcr zzcrVar = new zzcr(zzcm.zza("com.google.android.gms.measurement"));
        zza = zzcrVar.zza("measurement.test.boolean_flag", false);
        zzb = zzcrVar.zza("measurement.test.double_flag", -3.0d);
        zzc = zzcrVar.zza("measurement.test.int_flag", -2L);
        zzd = zzcrVar.zza("measurement.test.long_flag", -1L);
        zze = zzcrVar.zza("measurement.test.string_flag", "---");
    }
}
