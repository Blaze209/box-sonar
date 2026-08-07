package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdc {
    public static <T> zzcz<T> zza(zzcz<T> zzczVar) {
        if ((zzczVar instanceof zzde) || (zzczVar instanceof zzdb)) {
            return zzczVar;
        }
        return zzczVar instanceof Serializable ? new zzdb(zzczVar) : new zzde(zzczVar);
    }

    public static <T> zzcz<T> zza(@NullableDecl T t) {
        return new zzdd(t);
    }
}
