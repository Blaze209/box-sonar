package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdy implements zzea {
    private zzdy() {
    }

    @Override // com.google.android.gms.internal.measurement.zzea
    public final byte[] zza(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    /* synthetic */ zzdy(zzdx zzdxVar) {
        this();
    }
}
