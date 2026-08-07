package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzak {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzam zze;
    private final String zzf;

    private zzak(zzgo zzgoVar, String str, String str2, String str3, long j, long j2, zzam zzamVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzamVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgoVar.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId, name", zzfk.zza(str2), zzfk.zza(str3));
        }
        this.zze = zzamVar;
    }

    zzak(zzgo zzgoVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzam zzamVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgoVar.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId", zzfk.zza(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzgoVar.zzr().zzf().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object objZza = zzgoVar.zzi().zza(next, bundle2.get(next));
                    if (objZza == null) {
                        zzgoVar.zzr().zzi().zza("Param value can't be null", zzgoVar.zzj().zzb(next));
                        it.remove();
                    } else {
                        zzgoVar.zzi().zza(bundle2, next, objZza);
                    }
                }
            }
            zzamVar = new zzam(bundle2);
        } else {
            zzamVar = new zzam(new Bundle());
        }
        this.zze = zzamVar;
    }

    final zzak zza(zzgo zzgoVar, long j) {
        return new zzak(zzgoVar, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String strValueOf = String.valueOf(this.zze);
        return new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(strValueOf).length()).append("Event{appId='").append(str).append("', name='").append(str2).append("', params=").append(strValueOf).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
