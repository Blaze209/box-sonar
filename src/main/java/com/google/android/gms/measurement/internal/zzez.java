package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzez<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzex<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzez(String str, V v, V v2, zzex<V> zzexVar) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzexVar;
    }

    public final String zza() {
        return this.zza;
    }

    public final V zza(V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzfa.zza == null) {
            return this.zzc;
        }
        zzw zzwVar = zzfa.zza;
        synchronized (zzf) {
            if (zzw.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
            try {
                for (zzez zzezVar : zzap.zzdh) {
                    if (zzw.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V vZza = null;
                    try {
                        zzex<V> zzexVar = zzezVar.zzb;
                        if (zzexVar != null) {
                            vZza = zzexVar.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zzf) {
                        zzezVar.zzh = vZza;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzex<V> zzexVar2 = this.zzb;
            if (zzexVar2 == null) {
                zzw zzwVar2 = zzfa.zza;
                return this.zzc;
            }
            try {
                return zzexVar2.zza();
            } catch (IllegalStateException unused3) {
                zzw zzwVar3 = zzfa.zza;
                return this.zzc;
            } catch (SecurityException unused4) {
                zzw zzwVar4 = zzfa.zza;
                return this.zzc;
            }
        }
    }
}
