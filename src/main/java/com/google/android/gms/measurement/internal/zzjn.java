package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjn implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzm zzf;
    private final /* synthetic */ zzix zzg;

    zzjn(zzix zzixVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzm zzmVar) {
        this.zzg = zzixVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                try {
                    zzfc zzfcVar = this.zzg.zzb;
                    if (zzfcVar == null) {
                        this.zzg.zzr().zzf().zza("(legacy) Failed to get user properties; not connected to service", zzfk.zza(this.zzb), this.zzc, this.zzd);
                        this.zza.set(Collections.emptyList());
                        this.zza.notify();
                    } else {
                        if (TextUtils.isEmpty(this.zzb)) {
                            this.zza.set(zzfcVar.zza(this.zzc, this.zzd, this.zze, this.zzf));
                        } else {
                            this.zza.set(zzfcVar.zza(this.zzb, this.zzc, this.zzd, this.zze));
                        }
                        this.zzg.zzaj();
                        this.zza.notify();
                    }
                } catch (RemoteException e) {
                    this.zzg.zzr().zzf().zza("(legacy) Failed to get user properties; remote exception", zzfk.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                }
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
