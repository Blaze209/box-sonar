package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzax extends zzx.zza {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzhn zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzax(zzx zzxVar, com.google.android.gms.measurement.internal.zzhn zzhnVar) {
        super(zzxVar);
        this.zzd = zzxVar;
        this.zzc = zzhnVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.zza
    final void zza() throws RemoteException {
        Pair pair;
        int i = 0;
        while (true) {
            if (i >= this.zzd.zzf.size()) {
                pair = null;
                break;
            } else {
                if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                    pair = (Pair) this.zzd.zzf.get(i);
                    break;
                }
                i++;
            }
        }
        if (pair == null) {
            Log.w(this.zzd.zzc, "OnEventListener had not been registered.");
        } else {
            this.zzd.zzr.unregisterOnMeasurementEventListener((zzs) pair.second);
            this.zzd.zzf.remove(pair);
        }
    }
}
