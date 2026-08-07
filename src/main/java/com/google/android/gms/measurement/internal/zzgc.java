package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzgc implements ServiceConnection {
    final /* synthetic */ zzfz zza;
    private final String zzb;

    zzgc(zzfz zzfzVar, String str) {
        this.zza = zzfzVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzr().zzi().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzd zzdVarZza = com.google.android.gms.internal.measurement.zzg.zza(iBinder);
            if (zzdVarZza == null) {
                this.zza.zza.zzr().zzi().zza("Install Referrer Service implementation was not found");
            } else {
                this.zza.zza.zzr().zzx().zza("Install Referrer Service connected");
                this.zza.zza.zzq().zza(new zzgb(this, zzdVarZza, this));
            }
        } catch (Exception e) {
            this.zza.zza.zzr().zzi().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzr().zzx().zza("Install Referrer Service disconnected");
    }
}
