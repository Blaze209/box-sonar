package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjf implements Runnable {
    private final /* synthetic */ zzit zza;
    private final /* synthetic */ zzix zzb;

    zzjf(zzix zzixVar, zzit zzitVar) {
        this.zzb = zzixVar;
        this.zza = zzitVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfc zzfcVar = this.zzb.zzb;
        if (zzfcVar == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzit zzitVar = this.zza;
            if (zzitVar == null) {
                zzfcVar.zza(0L, (String) null, (String) null, this.zzb.zzn().getPackageName());
            } else {
                zzfcVar.zza(zzitVar.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzn().getPackageName());
            }
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e);
        }
    }
}
