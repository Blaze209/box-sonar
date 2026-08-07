package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzhb implements zzgm {
    private final zzgo zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzhb(zzgo zzgoVar, String str, Object[] objArr) {
        this.zza = zzgoVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final zzgo zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final int zza() {
        return (this.zzd & 1) == 1 ? zzfd.zze.zzh : zzfd.zze.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }
}
