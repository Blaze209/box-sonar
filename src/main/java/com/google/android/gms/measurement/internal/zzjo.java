package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjo implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzn zzd;
    private final /* synthetic */ zzix zze;

    zzjo(zzix zzixVar, String str, String str2, zzm zzmVar, com.google.android.gms.internal.measurement.zzn zznVar) {
        this.zze = zzixVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzmVar;
        this.zzd = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                zzfc zzfcVar = this.zze.zzb;
                if (zzfcVar == null) {
                    this.zze.zzr().zzf().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                    this.zze.zzp().zza(this.zzd, arrayList);
                } else {
                    ArrayList<Bundle> arrayListZzb = zzla.zzb(zzfcVar.zza(this.zza, this.zzb, this.zzc));
                    this.zze.zzaj();
                    this.zze.zzp().zza(this.zzd, arrayListZzb);
                }
            } catch (RemoteException e) {
                this.zze.zzr().zzf().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
                this.zze.zzp().zza(this.zzd, arrayList);
            }
        } catch (Throwable th) {
            this.zze.zzp().zza(this.zzd, arrayList);
            throw th;
        }
    }
}
