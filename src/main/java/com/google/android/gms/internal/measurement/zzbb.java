package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzbb extends zzx.zza {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbb(zzx zzxVar, Bundle bundle) {
        super(zzxVar);
        this.zzd = zzxVar;
        this.zzc = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.zza
    final void zza() throws RemoteException {
        this.zzd.zzr.setConditionalUserProperty(this.zzc, this.zza);
    }
}
