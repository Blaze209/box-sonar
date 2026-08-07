package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzcq extends zzcl<Boolean> {
    zzcq(zzcr zzcrVar, String str, Boolean bool) {
        super(zzcrVar, str, bool, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcl
    final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzbw.zzb.matcher(str).matches()) {
                return true;
            }
            if (zzbw.zzc.matcher(str).matches()) {
                return false;
            }
        }
        String strZzb = super.zzb();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder(String.valueOf(strZzb).length() + 28 + String.valueOf(strValueOf).length()).append("Invalid boolean value for ").append(strZzb).append(": ").append(strValueOf).toString());
        return null;
    }
}
