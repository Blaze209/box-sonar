package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhz implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhp zzb;

    zzhz(zzhp zzhpVar, Bundle bundle) {
        this.zzb = zzhpVar;
        this.zza = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
