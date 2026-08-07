package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdk extends zzdf {
    zzdk() {
    }

    @Override // com.google.android.gms.internal.measurement.zzdf
    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }
}
