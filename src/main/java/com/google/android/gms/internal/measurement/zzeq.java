package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public class zzeq {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzeq zzc;
    private static volatile zzeq zzd;
    private static final zzeq zze = new zzeq(true);
    private final Map<zza, zzfd.zzf<?, ?>> zzf;

    public static zzeq zza() {
        zzeq zzeqVar;
        zzeq zzeqVar2 = zzc;
        if (zzeqVar2 != null) {
            return zzeqVar2;
        }
        synchronized (zzeq.class) {
            zzeqVar = zzc;
            if (zzeqVar == null) {
                zzeqVar = zze;
                zzc = zzeqVar;
            }
        }
        return zzeqVar;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }
    }

    public static zzeq zzb() {
        zzeq zzeqVar = zzd;
        if (zzeqVar != null) {
            return zzeqVar;
        }
        synchronized (zzeq.class) {
            zzeq zzeqVar2 = zzd;
            if (zzeqVar2 != null) {
                return zzeqVar2;
            }
            zzeq zzeqVarZza = zzfb.zza(zzeq.class);
            zzd = zzeqVarZza;
            return zzeqVarZza;
        }
    }

    public final <ContainingType extends zzgo> zzfd.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzfd.zzf) this.zzf.get(new zza(containingtype, i));
    }

    zzeq() {
        this.zzf = new HashMap();
    }

    private zzeq(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
