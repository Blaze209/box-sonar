package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.3 */
/* JADX INFO: loaded from: classes14.dex */
public final class zze implements zza {
    private AnalyticsConnector.AnalyticsConnectorListener zza;
    private AppMeasurement zzb;
    private zzg zzc;

    public zze(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = appMeasurement;
        zzg zzgVar = new zzg(this);
        this.zzc = zzgVar;
        this.zzb.registerOnMeasurementEventListener(zzgVar);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }
}
