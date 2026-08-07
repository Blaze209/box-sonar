package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjg implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzix zzc;

    zzjg(zzix zzixVar, zzm zzmVar, boolean z) {
        this.zzc = zzixVar;
        this.zza = zzmVar;
        this.zzb = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfc zzfcVar = this.zzc.zzb;
        if (zzfcVar == null) {
            this.zzc.zzr().zzf().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzfcVar.zza(this.zza);
            if (this.zzb) {
                this.zzc.zzj().zzad();
            }
            this.zzc.zza(zzfcVar, (AbstractSafeParcelable) null, this.zza);
            this.zzc.zzaj();
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to send app launch to the service", e);
        }
    }
}
