package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.microsoft.identity.common.internal.broker.SerializedNames;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.3 */
/* JADX INFO: loaded from: classes14.dex */
final class zzg implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zze zza;

    public zzg(zze zzeVar) {
        this.zza = zzeVar;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.OnEventListener, com.google.android.gms.measurement.internal.zzhn
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str == null || str.equals("crash") || !zzd.zzb(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle(SerializedNames.PARAMS, bundle);
        this.zza.zza.onMessageTriggered(3, bundle2);
    }
}
