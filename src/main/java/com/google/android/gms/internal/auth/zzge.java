package com.google.android.gms.internal.auth;

import com.box.androidsdk.content.BoxApiMetadata;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* JADX INFO: loaded from: classes13.dex */
final class zzge {
    private static final zzge zza = new zzge();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgi zzb = new zzfo();

    private zzge() {
    }

    public static zzge zza() {
        return zza;
    }

    public final zzgh zzb(Class cls) {
        zzez.zzf(cls, "messageType");
        zzgh zzghVar = (zzgh) this.zzc.get(cls);
        if (zzghVar != null) {
            return zzghVar;
        }
        zzgh zzghVarZza = this.zzb.zza(cls);
        zzez.zzf(cls, "messageType");
        zzez.zzf(zzghVarZza, BoxApiMetadata.BOX_API_METADATA_SCHEMA);
        zzgh zzghVar2 = (zzgh) this.zzc.putIfAbsent(cls, zzghVarZza);
        return zzghVar2 == null ? zzghVarZza : zzghVar2;
    }
}
