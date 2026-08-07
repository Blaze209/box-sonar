package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjc implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzix zzd;

    zzjc(zzix zzixVar, AtomicReference atomicReference, zzm zzmVar, boolean z) {
        this.zzd = zzixVar;
        this.zza = atomicReference;
        this.zzb = zzmVar;
        this.zzc = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    zzfc zzfcVar = this.zzd.zzb;
                    if (zzfcVar == null) {
                        this.zzd.zzr().zzf().zza("Failed to get all user properties; not connected to service");
                        this.zza.notify();
                    } else {
                        this.zza.set(zzfcVar.zza(this.zzb, this.zzc));
                        this.zzd.zzaj();
                        this.zza.notify();
                    }
                } catch (RemoteException e) {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; remote exception", e);
                    this.zza.notify();
                }
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
