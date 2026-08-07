package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.3 */
/* JADX INFO: loaded from: classes14.dex */
final class zzf implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zzc zza;

    public zzf(zzc zzcVar) {
        this.zza = zzcVar;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.OnEventListener, com.google.android.gms.measurement.internal.zzhn
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(BoxConvertedPushNotificationDevice.EVENTS, zzd.zze(str2));
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
