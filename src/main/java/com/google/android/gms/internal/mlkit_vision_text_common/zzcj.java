package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzcj extends zzbm {
    final transient Object[] zza;

    private zzcj(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zza = objArr;
    }

    static zzcj zzg(int i, Object[] objArr, zzbl zzblVar) {
        zzaq.zzb(Objects.requireNonNull(objArr[0]), Objects.requireNonNull(objArr[1]));
        return new zzcj(null, objArr, 1);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Object objRequireNonNull;
        if (obj == null) {
            objRequireNonNull = null;
        } else {
            Object[] objArr = this.zza;
            if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                objRequireNonNull = Objects.requireNonNull(objArr[1]);
            } else {
                objRequireNonNull = null;
            }
        }
        if (objRequireNonNull == null) {
            return null;
        }
        return objRequireNonNull;
    }

    @Override // java.util.Map
    public final int size() {
        return 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbf zza() {
        return new zzci(this.zza, 1, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbn zzd() {
        return new zzcg(this, this.zza, 0, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzbm
    final zzbn zze() {
        return new zzch(this, new zzci(this.zza, 0, 1));
    }
}
