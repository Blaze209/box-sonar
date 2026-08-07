package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjm implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzv zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ zzv zze;
    private final /* synthetic */ zzix zzf;

    zzjm(zzix zzixVar, boolean z, boolean z2, zzv zzvVar, zzm zzmVar, zzv zzvVar2) {
        this.zzf = zzixVar;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzvVar;
        this.zzd = zzmVar;
        this.zze = zzvVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfc zzfcVar = this.zzf.zzb;
        if (zzfcVar == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzfcVar, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzfcVar.zza(this.zzc, this.zzd);
                } else {
                    zzfcVar.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
