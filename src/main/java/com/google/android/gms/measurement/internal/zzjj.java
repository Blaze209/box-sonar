package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjj implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzan zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzix zzf;

    zzjj(zzix zzixVar, boolean z, boolean z2, zzan zzanVar, zzm zzmVar, String str) {
        this.zzf = zzixVar;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzanVar;
        this.zzd = zzmVar;
        this.zze = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfc zzfcVar = this.zzf.zzb;
        if (zzfcVar == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzfcVar, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    zzfcVar.zza(this.zzc, this.zzd);
                } else {
                    zzfcVar.zza(this.zzc, this.zze, this.zzf.zzr().zzy());
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
