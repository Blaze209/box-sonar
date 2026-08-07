package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjb implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzix zzb;

    zzjb(zzix zzixVar, zzm zzmVar) {
        this.zzb = zzixVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfc zzfcVar = this.zzb.zzb;
        if (zzfcVar == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzfcVar.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzaj();
    }
}
