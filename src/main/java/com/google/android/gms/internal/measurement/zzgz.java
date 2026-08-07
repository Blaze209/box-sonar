package com.google.android.gms.internal.measurement;

import com.box.androidsdk.content.BoxApiMetadata;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzgz {
    private static final zzgz zza = new zzgz();
    private final ConcurrentMap<Class<?>, zzhd<?>> zzc = new ConcurrentHashMap();
    private final zzhg zzb = new zzgb();

    public static zzgz zza() {
        return zza;
    }

    public final <T> zzhd<T> zza(Class<T> cls) {
        zzff.zza(cls, "messageType");
        zzhd<T> zzhdVarZza = (zzhd) this.zzc.get(cls);
        if (zzhdVarZza == null) {
            zzhdVarZza = this.zzb.zza(cls);
            zzff.zza(cls, "messageType");
            zzff.zza(zzhdVarZza, BoxApiMetadata.BOX_API_METADATA_SCHEMA);
            zzhd<T> zzhdVar = (zzhd) this.zzc.putIfAbsent(cls, zzhdVarZza);
            if (zzhdVar != null) {
                return zzhdVar;
            }
        }
        return zzhdVarZza;
    }

    public final <T> zzhd<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzgz() {
    }
}
