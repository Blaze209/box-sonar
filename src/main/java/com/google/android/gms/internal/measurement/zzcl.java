package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public abstract class zzcl<T> {
    private static Context zzb = null;
    private static boolean zzc = false;
    private static zzcz<zzcy<zzch>> zzd;
    private final zzcr zze;
    private final String zzf;
    private final T zzg;
    private volatile int zzi;
    private volatile T zzj;
    private static final Object zza = new Object();
    private static final AtomicInteger zzh = new AtomicInteger();

    public static void zza(Context context) {
        synchronized (zza) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzb != context) {
                zzbx.zzc();
                zzcu.zza();
                zzcg.zza();
                zzh.incrementAndGet();
                zzb = context;
                zzd = zzdc.zza(zzco.zza);
            }
        }
    }

    abstract T zza(Object obj);

    static void zza() {
        zzh.incrementAndGet();
    }

    private zzcl(zzcr zzcrVar, String str, T t) {
        this.zzi = -1;
        if (zzcrVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zze = zzcrVar;
        this.zzf = str;
        this.zzg = t;
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzf;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf(this.zzf);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    public final String zzb() {
        return zza(this.zze.zzd);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0099  */
    /* JADX WARN: Code duplicated, block: B:38:0x009a A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:17:0x0033, B:19:0x0039, B:21:0x0045, B:25:0x005e, B:27:0x0068, B:45:0x00b9, B:47:0x00c7, B:49:0x00dd, B:50:0x00e0, B:51:0x00e4, B:38:0x009a, B:40:0x00ae, B:44:0x00b7, B:23:0x0056, B:28:0x006d, B:30:0x0076, B:32:0x0088, B:34:0x0093, B:33:0x008d, B:52:0x00e9, B:53:0x00f0, B:54:0x00f1), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ae A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:17:0x0033, B:19:0x0039, B:21:0x0045, B:25:0x005e, B:27:0x0068, B:45:0x00b9, B:47:0x00c7, B:49:0x00dd, B:50:0x00e0, B:51:0x00e4, B:38:0x009a, B:40:0x00ae, B:44:0x00b7, B:23:0x0056, B:28:0x006d, B:30:0x0076, B:32:0x0088, B:34:0x0093, B:33:0x008d, B:52:0x00e9, B:53:0x00f0, B:54:0x00f1), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b7 A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:17:0x0033, B:19:0x0039, B:21:0x0045, B:25:0x005e, B:27:0x0068, B:45:0x00b9, B:47:0x00c7, B:49:0x00dd, B:50:0x00e0, B:51:0x00e4, B:38:0x009a, B:40:0x00ae, B:44:0x00b7, B:23:0x0056, B:28:0x006d, B:30:0x0076, B:32:0x0088, B:34:0x0093, B:33:0x008d, B:52:0x00e9, B:53:0x00f0, B:54:0x00f1), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c7 A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:17:0x0033, B:19:0x0039, B:21:0x0045, B:25:0x005e, B:27:0x0068, B:45:0x00b9, B:47:0x00c7, B:49:0x00dd, B:50:0x00e0, B:51:0x00e4, B:38:0x009a, B:40:0x00ae, B:44:0x00b7, B:23:0x0056, B:28:0x006d, B:30:0x0076, B:32:0x0088, B:34:0x0093, B:33:0x008d, B:52:0x00e9, B:53:0x00f0, B:54:0x00f1), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00dd A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:17:0x0033, B:19:0x0039, B:21:0x0045, B:25:0x005e, B:27:0x0068, B:45:0x00b9, B:47:0x00c7, B:49:0x00dd, B:50:0x00e0, B:51:0x00e4, B:38:0x009a, B:40:0x00ae, B:44:0x00b7, B:23:0x0056, B:28:0x006d, B:30:0x0076, B:32:0x0088, B:34:0x0093, B:33:0x008d, B:52:0x00e9, B:53:0x00f0, B:54:0x00f1), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e0 A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:17:0x0033, B:19:0x0039, B:21:0x0045, B:25:0x005e, B:27:0x0068, B:45:0x00b9, B:47:0x00c7, B:49:0x00dd, B:50:0x00e0, B:51:0x00e4, B:38:0x009a, B:40:0x00ae, B:44:0x00b7, B:23:0x0056, B:28:0x006d, B:30:0x0076, B:32:0x0088, B:34:0x0093, B:33:0x008d, B:52:0x00e9, B:53:0x00f0, B:54:0x00f1), top: B:61:0x000b }] */
    public final T zzc() {
        T tZza;
        Object objZza;
        zzcy<zzch> zzcyVarZza;
        String strZza;
        zzcb zzcbVarZza;
        Object objZza2;
        int i = zzh.get();
        if (this.zzi < i) {
            synchronized (this) {
                if (this.zzi < i) {
                    Context context = zzb;
                    if (context == null) {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                    String str = (String) zzcg.zza(context).zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                    if (!(str != null && zzbw.zzb.matcher(str).matches())) {
                        if (this.zze.zzb != null) {
                            zzcbVarZza = zzcj.zza(zzb, this.zze.zzb) ? zzbx.zza(zzb.getContentResolver(), this.zze.zzb) : null;
                        } else {
                            zzcbVarZza = zzcu.zza(zzb, (String) null);
                        }
                        if (zzcbVarZza != null && (objZza2 = zzcbVarZza.zza(zzb())) != null) {
                            tZza = zza(objZza2);
                        }
                        if (tZza == null) {
                            objZza = zzcg.zza(zzb).zza(zza(this.zze.zzc));
                            if (objZza != null) {
                                tZza = zza(objZza);
                            } else {
                                tZza = null;
                            }
                            if (tZza != null) {
                                tZza = this.zzg;
                            }
                        }
                        zzcyVarZza = zzd.zza();
                        if (zzcyVarZza.zza()) {
                            strZza = zzcyVarZza.zzb().zza(this.zze.zzb, null, this.zze.zzd, this.zzf);
                            if (strZza == null) {
                                tZza = this.zzg;
                            } else {
                                tZza = zza((Object) strZza);
                            }
                        }
                        this.zzj = tZza;
                        this.zzi = i;
                    } else if (Log.isLoggable("PhenotypeFlag", 3)) {
                        String strValueOf = String.valueOf(zzb());
                        Log.d("PhenotypeFlag", strValueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(strValueOf) : new String("Bypass reading Phenotype values for flag: "));
                    }
                    tZza = null;
                    if (tZza == null) {
                        objZza = zzcg.zza(zzb).zza(zza(this.zze.zzc));
                        if (objZza != null) {
                            tZza = zza(objZza);
                        } else {
                            tZza = null;
                        }
                        if (tZza != null) {
                            tZza = this.zzg;
                        }
                    }
                    zzcyVarZza = zzd.zza();
                    if (zzcyVarZza.zza()) {
                        strZza = zzcyVarZza.zzb().zza(this.zze.zzb, null, this.zze.zzd, this.zzf);
                        if (strZza == null) {
                            tZza = this.zzg;
                        } else {
                            tZza = zza((Object) strZza);
                        }
                    }
                    this.zzj = tZza;
                    this.zzi = i;
                }
            }
        }
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Long> zzb(zzcr zzcrVar, String str, long j) {
        return new zzcn(zzcrVar, str, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Boolean> zzb(zzcr zzcrVar, String str, boolean z) {
        return new zzcq(zzcrVar, str, Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<Double> zzb(zzcr zzcrVar, String str, double d) {
        return new zzcp(zzcrVar, str, Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcl<String> zzb(zzcr zzcrVar, String str, String str2) {
        return new zzcs(zzcrVar, str, str2);
    }

    static final /* synthetic */ zzcy zzd() {
        new zzck();
        return zzck.zza(zzb);
    }

    /* synthetic */ zzcl(zzcr zzcrVar, String str, Object obj, zzcn zzcnVar) {
        this(zzcrVar, str, obj);
    }
}
