package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzgf {
    private zzge zza;

    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public final void onMAMReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzge(this);
        }
        this.zza.zza(context, intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }
}
