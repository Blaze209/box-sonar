package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjd implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzn zzb;
    private final /* synthetic */ zzix zzc;

    zzjd(zzix zzixVar, zzm zzmVar, com.google.android.gms.internal.measurement.zzn zznVar) {
        this.zzc = zzixVar;
        this.zza = zzmVar;
        this.zzb = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                zzfc zzfcVar = this.zzc.zzb;
                if (zzfcVar == null) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id");
                    this.zzc.zzp().zza(this.zzb, (String) null);
                    return;
                }
                String strZzc = zzfcVar.zzc(this.zza);
                if (strZzc != null) {
                    this.zzc.zzf().zza(strZzc);
                    this.zzc.zzs().zzj.zza(strZzc);
                }
                this.zzc.zzaj();
                this.zzc.zzp().zza(this.zzb, strZzc);
            } catch (RemoteException e) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
                this.zzc.zzp().zza(this.zzb, (String) null);
            }
        } catch (Throwable th) {
            this.zzc.zzp().zza(this.zzb, (String) null);
            throw th;
        }
    }
}
