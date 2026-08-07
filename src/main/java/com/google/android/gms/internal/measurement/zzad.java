package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzad extends zzx.zza {
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzad(zzx zzxVar, boolean z) {
        super(zzxVar);
        this.zzd = zzxVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.zza
    final void zza() throws RemoteException {
        this.zzd.zzr.setMeasurementEnabled(this.zzc, this.zza);
    }
}
