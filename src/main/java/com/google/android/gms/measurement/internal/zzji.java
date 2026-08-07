package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzji implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzn zzc;
    private final /* synthetic */ zzix zzd;

    zzji(zzix zzixVar, zzan zzanVar, String str, com.google.android.gms.internal.measurement.zzn zznVar) {
        this.zzd = zzixVar;
        this.zza = zzanVar;
        this.zzb = str;
        this.zzc = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                zzfc zzfcVar = this.zzd.zzb;
                if (zzfcVar == null) {
                    this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
                    this.zzd.zzp().zza(this.zzc, (byte[]) null);
                } else {
                    byte[] bArrZza = zzfcVar.zza(this.zza, this.zzb);
                    this.zzd.zzaj();
                    this.zzd.zzp().zza(this.zzc, bArrZza);
                }
            } catch (RemoteException e) {
                this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e);
                this.zzd.zzp().zza(this.zzc, (byte[]) null);
            }
        } catch (Throwable th) {
            this.zzd.zzp().zza(this.zzc, (byte[]) null);
            throw th;
        }
    }
}
