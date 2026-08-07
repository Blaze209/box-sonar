package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzje implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzix zzc;

    zzje(zzix zzixVar, AtomicReference atomicReference, zzm zzmVar) {
        this.zzc = zzixVar;
        this.zza = atomicReference;
        this.zzb = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    zzfc zzfcVar = this.zzc.zzb;
                    if (zzfcVar == null) {
                        this.zzc.zzr().zzf().zza("Failed to get app instance id");
                        this.zza.notify();
                        return;
                    }
                    this.zza.set(zzfcVar.zzc(this.zzb));
                    String str = (String) this.zza.get();
                    if (str != null) {
                        this.zzc.zzf().zza(str);
                        this.zzc.zzs().zzj.zza(str);
                    }
                    this.zzc.zzaj();
                    this.zza.notify();
                } catch (RemoteException e) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
                    this.zza.notify();
                }
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
