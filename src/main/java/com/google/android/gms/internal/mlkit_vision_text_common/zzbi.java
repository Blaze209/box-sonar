package com.google.android.gms.internal.mlkit_vision_text_common;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzbi extends zzz {
    private final zzbk zza;

    zzbi(zzbk zzbkVar, int i) {
        super(zzbkVar.size(), i);
        this.zza = zzbkVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzz
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
