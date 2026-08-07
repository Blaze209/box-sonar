package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
abstract class zzif {
    zzif() {
    }

    abstract int zza(int i, byte[] bArr, int i2, int i3);

    abstract int zza(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract String zzb(byte[] bArr, int i, int i2) throws zzfo;

    final boolean zza(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
