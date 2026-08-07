package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
class zzfr extends MAMBroadcastReceiver {
    private static final String zza = "com.google.android.gms.measurement.internal.zzfr";
    private final zzks zzb;
    private boolean zzc;
    private boolean zzd;

    zzfr(zzks zzksVar) {
        Preconditions.checkNotNull(zzksVar);
        this.zzb = zzksVar;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(Context context, Intent intent) {
        this.zzb.zzk();
        String action = intent.getAction();
        this.zzb.zzr().zzx().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zZzf = this.zzb.zzd().zzf();
            if (this.zzd != zZzf) {
                this.zzd = zZzf;
                this.zzb.zzq().zza(new zzfu(this, zZzf));
                return;
            }
            return;
        }
        this.zzb.zzr().zzi().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zza() {
        this.zzb.zzk();
        this.zzb.zzq().zzd();
        if (this.zzc) {
            return;
        }
        this.zzb.zzn().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzd = this.zzb.zzd().zzf();
        this.zzb.zzr().zzx().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
        this.zzc = true;
    }

    public final void zzb() {
        this.zzb.zzk();
        this.zzb.zzq().zzd();
        this.zzb.zzq().zzd();
        if (this.zzc) {
            this.zzb.zzr().zzx().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzn().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzr().zzf().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
