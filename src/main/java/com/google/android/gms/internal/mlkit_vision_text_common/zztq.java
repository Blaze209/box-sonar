package com.google.android.gms.internal.mlkit_vision_text_common;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zztq extends zztu {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zztq(String str, boolean z, int i, zztp zztpVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zztu) {
            zztu zztuVar = (zztu) obj;
            if (this.zza.equals(zztuVar.zzb()) && this.zzb == zztuVar.zzc() && this.zzc == zztuVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        return this.zzc ^ (((iHashCode * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003);
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.zza + ", enableFirelog=" + this.zzb + ", firelogEventType=" + this.zzc + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zztu
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zztu
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zztu
    public final boolean zzc() {
        return this.zzb;
    }
}
