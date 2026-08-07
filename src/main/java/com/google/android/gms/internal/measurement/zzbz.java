package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzbz extends ContentObserver {
    private final /* synthetic */ zzbx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbz(zzbx zzbxVar, Handler handler) {
        super(null);
        this.zza = zzbxVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
