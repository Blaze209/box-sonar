package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjq implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzn zze;
    private final /* synthetic */ zzix zzf;

    zzjq(zzix zzixVar, String str, String str2, boolean z, zzm zzmVar, com.google.android.gms.internal.measurement.zzn zznVar) {
        this.zzf = zzixVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzmVar;
        this.zze = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            try {
                zzfc zzfcVar = this.zzf.zzb;
                if (zzfcVar == null) {
                    this.zzf.zzr().zzf().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                    this.zzf.zzp().zza(this.zze, bundle);
                } else {
                    Bundle bundleZza = zzla.zza(zzfcVar.zza(this.zza, this.zzb, this.zzc, this.zzd));
                    this.zzf.zzaj();
                    this.zzf.zzp().zza(this.zze, bundleZza);
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to get user properties; remote exception", this.zza, e);
                this.zzf.zzp().zza(this.zze, bundle);
            }
        } catch (Throwable th) {
            this.zzf.zzp().zza(this.zze, bundle);
            throw th;
        }
    }
}
