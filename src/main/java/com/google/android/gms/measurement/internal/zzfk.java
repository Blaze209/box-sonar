package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfk extends zzhi {
    private char zza;
    private long zzb;
    private String zzc;
    private final zzfm zzd;
    private final zzfm zze;
    private final zzfm zzf;
    private final zzfm zzg;
    private final zzfm zzh;
    private final zzfm zzi;
    private final zzfm zzj;
    private final zzfm zzk;
    private final zzfm zzl;

    zzfk(zzgo zzgoVar) {
        super(zzgoVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzfm(this, 6, false, false);
        this.zze = new zzfm(this, 6, true, false);
        this.zzf = new zzfm(this, 6, false, true);
        this.zzg = new zzfm(this, 5, false, false);
        this.zzh = new zzfm(this, 5, true, false);
        this.zzi = new zzfm(this, 5, false, true);
        this.zzj = new zzfm(this, 4, false, false);
        this.zzk = new zzfm(this, 3, false, false);
        this.zzl = new zzfm(this, 2, false, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzhi
    protected final boolean zze() {
        return false;
    }

    public final zzfm zzf() {
        return this.zzd;
    }

    public final zzfm zzg() {
        return this.zze;
    }

    public final zzfm zzh() {
        return this.zzf;
    }

    public final zzfm zzi() {
        return this.zzg;
    }

    public final zzfm zzj() {
        return this.zzh;
    }

    public final zzfm zzk() {
        return this.zzi;
    }

    public final zzfm zzv() {
        return this.zzj;
    }

    public final zzfm zzw() {
        return this.zzk;
    }

    public final zzfm zzx() {
        return this.zzl;
    }

    protected static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzfl(str);
    }

    protected final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zza(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzgh zzghVarZzg = this.zzx.zzg();
        if (zzghVarZzg == null) {
            zza(6, "Scheduler not set. Not logging error/warn");
            return;
        }
        if (!zzghVarZzg.zzz()) {
            zza(6, "Scheduler not initialized. Not logging error/warn");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= 9) {
            i = 8;
        }
        zzghVarZzg.zza(new zzfj(this, i, str, obj, obj2, obj3));
    }

    protected final boolean zza(int i) {
        return Log.isLoggable(zzad(), i);
    }

    protected final void zza(int i, String str) {
        Log.println(i, zzad(), str);
    }

    private final String zzad() {
        String str;
        String strZzs;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzx.zzs() != null) {
                    strZzs = this.zzx.zzs();
                } else {
                    zzt().zzu();
                    strZzs = "FA";
                }
                this.zzc = strZzs;
            }
            str = this.zzc;
        }
        return str;
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strZza = zza(z, obj);
        String strZza2 = zza(z, obj2);
        String strZza3 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strZza)) {
            sb.append(str2);
            sb.append(strZza);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strZza2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strZza2);
        }
        if (!TextUtils.isEmpty(strZza3)) {
            sb.append(str3);
            sb.append(strZza3);
        }
        return sb.toString();
    }

    private static String zza(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) >= 100) {
                String str = String.valueOf(obj).charAt(0) == '-' ? CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR : "";
                String strValueOf = String.valueOf(Math.abs(l.longValue()));
                return new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, strValueOf.length() - 1))).append("...").append(str).append(Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d)).toString();
            }
            return String.valueOf(obj);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String strZzb = zzb(zzgo.class.getCanonicalName());
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzb(className).equals(strZzb)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
            }
            return sb.toString();
        }
        if (obj instanceof zzfl) {
            return ((zzfl) obj).zza;
        }
        return z ? CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR : String.valueOf(obj);
    }

    private static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public final String zzy() {
        Pair<String, Long> pairZza = zzs().zzb.zza();
        if (pairZza == null || pairZza == zzft.zza) {
            return null;
        }
        String strValueOf = String.valueOf(pairZza.second);
        String str = (String) pairZza.first;
        return new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(str).length()).append(strValueOf).append(":").append(str).toString();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzfi zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzgh zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzfk zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzft zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
