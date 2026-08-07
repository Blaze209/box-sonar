package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzga {
    private final String zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzft zze;

    public zzga(zzft zzftVar, String str, String str2) {
        this.zze = zzftVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = null;
    }

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getString(this.zza, null);
        }
        return this.zzd;
    }

    public final void zza(String str) {
        if (this.zze.zzt().zza(zzap.zzcs) || !zzla.zzc(str, this.zzd)) {
            SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
            editorEdit.putString(this.zza, str);
            editorEdit.apply();
            this.zzd = str;
        }
    }
}
