package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzec {
    private final zzen zza;
    private final byte[] zzb;

    private zzec(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzen.zza(bArr);
    }

    public final zzdu zza() {
        this.zza.zzb();
        return new zzee(this.zzb);
    }

    public final zzen zzb() {
        return this.zza;
    }

    /* synthetic */ zzec(int i, zzdx zzdxVar) {
        this(i);
    }
}
