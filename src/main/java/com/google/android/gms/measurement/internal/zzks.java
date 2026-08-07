package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.collection.SieveCacheKt;
import com.box.android.utilities.DeviceIdStorage;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public class zzks implements zzhh {
    private static volatile zzks zza;
    private zzgi zzb;
    private zzfo zzc;
    private zzac zzd;
    private zzfr zze;
    private zzko zzf;
    private zzn zzg;
    private final zzkw zzh;
    private zzir zzi;
    private final zzgo zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
    class zza implements zzae {
        com.google.android.gms.internal.measurement.zzbr.zzg zza;
        List<Long> zzb;
        List<com.google.android.gms.internal.measurement.zzbr.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzae
        public final void zza(com.google.android.gms.internal.measurement.zzbr.zzg zzgVar) {
            Preconditions.checkNotNull(zzgVar);
            this.zza = zzgVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzae
        public final boolean zza(long j, com.google.android.gms.internal.measurement.zzbr.zzc zzcVar) {
            Preconditions.checkNotNull(zzcVar);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzcVar)) {
                return false;
            }
            long jZzbn = this.zzd + ((long) zzcVar.zzbn());
            if (jZzbn >= Math.max(0, zzap.zzh.zza(null).intValue())) {
                return false;
            }
            this.zzd = jZzbn;
            this.zzc.add(zzcVar);
            this.zzb.add(Long.valueOf(j));
            return this.zzc.size() < Math.max(1, zzap.zzi.zza(null).intValue());
        }

        private static long zza(com.google.android.gms.internal.measurement.zzbr.zzc zzcVar) {
            return ((zzcVar.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzks zzksVar, zzkr zzkrVar) {
            this();
        }
    }

    public static zzks zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzks.class) {
                if (zza == null) {
                    zza = new zzks(new zzkx(context));
                }
            }
        }
        return zza;
    }

    private zzks(zzkx zzkxVar) {
        this(zzkxVar, null);
    }

    private zzks(zzkx zzkxVar, zzgo zzgoVar) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkxVar);
        zzgo zzgoVarZza = zzgo.zza(zzkxVar.zza, (com.google.android.gms.internal.measurement.zzv) null);
        this.zzj = zzgoVarZza;
        this.zzx = -1L;
        zzkw zzkwVar = new zzkw(this);
        zzkwVar.zzal();
        this.zzh = zzkwVar;
        zzfo zzfoVar = new zzfo(this);
        zzfoVar.zzal();
        this.zzc = zzfoVar;
        zzgi zzgiVar = new zzgi(this);
        zzgiVar.zzal();
        this.zzb = zzgiVar;
        zzgoVarZza.zzq().zza(new zzkr(this, zzkxVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzkx zzkxVar) {
        this.zzj.zzq().zzd();
        zzac zzacVar = new zzac(this);
        zzacVar.zzal();
        this.zzd = zzacVar;
        this.zzj.zzb().zza(this.zzb);
        zzn zznVar = new zzn(this);
        zznVar.zzal();
        this.zzg = zznVar;
        zzir zzirVar = new zzir(this);
        zzirVar.zzal();
        this.zzi = zzirVar;
        zzko zzkoVar = new zzko(this);
        zzkoVar.zzal();
        this.zzf = zzkoVar;
        this.zze = new zzfr(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    protected final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final zzw zzu() {
        return this.zzj.zzu();
    }

    public final zzx zzb() {
        return this.zzj.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final zzfk zzr() {
        return this.zzj.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final zzgh zzq() {
        return this.zzj.zzq();
    }

    public final zzgi zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzfo zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzac zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    private final zzfr zzt() {
        zzfr zzfrVar = this.zze;
        if (zzfrVar != null) {
            return zzfrVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzko zzv() {
        zzb(this.zzf);
        return this.zzf;
    }

    public final zzn zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzir zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzkw zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzfi zzi() {
        return this.zzj.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final Context zzn() {
        return this.zzj.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final zzla zzj() {
        return this.zzj.zzi();
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzkp zzkpVar) {
        if (zzkpVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzkpVar.zzaj()) {
            return;
        }
        String strValueOf = String.valueOf(zzkpVar.getClass());
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 27).append("Component not initialized: ").append(strValueOf).toString());
    }

    private final long zzx() {
        long jCurrentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzft zzftVarZzc = this.zzj.zzc();
        zzftVarZzc.zzaa();
        zzftVarZzc.zzd();
        long jZza = zzftVarZzc.zzg.zza();
        if (jZza == 0) {
            jZza = ((long) zzftVarZzc.zzp().zzh().nextInt(86400000)) + 1;
            zzftVarZzc.zzg.zza(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v3 com.google.android.gms.measurement.internal.zzm, still in use, count: 2, list:
          (r2v3 com.google.android.gms.measurement.internal.zzm) from 0x00be: MOVE (r19v0 com.google.android.gms.measurement.internal.zzm) = (r2v3 com.google.android.gms.measurement.internal.zzm)
          (r2v3 com.google.android.gms.measurement.internal.zzm) from 0x00ab: MOVE (r19v4 com.google.android.gms.measurement.internal.zzm) = (r2v3 com.google.android.gms.measurement.internal.zzm)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    final void zza(com.google.android.gms.measurement.internal.zzan r32, java.lang.String r33) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(com.google.android.gms.measurement.internal.zzan, java.lang.String):void");
    }

    final void zza(zzan zzanVar, zzm zzmVar) {
        List<zzv> listZza;
        List<zzv> listZza2;
        List<zzv> listZza3;
        zzan zzanVar2 = zzanVar;
        Preconditions.checkNotNull(zzmVar);
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzw();
        zzk();
        String str = zzmVar.zza;
        long j = zzanVar2.zzd;
        if (zzh().zza(zzanVar2, zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            if (this.zzj.zzb().zze(str, zzap.zzbl) && zzmVar.zzu != null) {
                if (zzmVar.zzu.contains(zzanVar2.zza)) {
                    Bundle bundleZzb = zzanVar2.zzb.zzb();
                    bundleZzb.putLong("ga_safelisted", 1L);
                    zzanVar2 = new zzan(zzanVar2.zza, new zzam(bundleZzb), zzanVar2.zzc, zzanVar2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzanVar2.zza, zzanVar2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzac zzacVarZze = zze();
                Preconditions.checkNotEmpty(str);
                zzacVarZze.zzd();
                zzacVarZze.zzak();
                char c = 2;
                int i = 0;
                if (j < 0) {
                    zzacVarZze.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzfk.zza(str), Long.valueOf(j));
                    listZza = Collections.emptyList();
                } else {
                    listZza = zzacVarZze.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzv zzvVar : listZza) {
                    if (zzvVar != null) {
                        if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzap.zzcz)) {
                            this.zzj.zzr().zzx().zza("User property timed out", zzvVar.zza, this.zzj.zzj().zzc(zzvVar.zzc.zza), zzvVar.zzc.zza());
                        } else {
                            this.zzj.zzr().zzw().zza("User property timed out", zzvVar.zza, this.zzj.zzj().zzc(zzvVar.zzc.zza), zzvVar.zzc.zza());
                        }
                        if (zzvVar.zzg != null) {
                            zzb(new zzan(zzvVar.zzg, j), zzmVar);
                        }
                        zze().zze(str, zzvVar.zzc.zza);
                        i = i;
                    }
                }
                int i2 = i;
                zzac zzacVarZze2 = zze();
                Preconditions.checkNotEmpty(str);
                zzacVarZze2.zzd();
                zzacVarZze2.zzak();
                if (j < 0) {
                    zzacVarZze2.zzr().zzi().zza("Invalid time querying expired conditional properties", zzfk.zza(str), Long.valueOf(j));
                    listZza2 = Collections.emptyList();
                } else {
                    String[] strArr = new String[2];
                    strArr[i2] = str;
                    strArr[1] = String.valueOf(j);
                    listZza2 = zzacVarZze2.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", strArr);
                }
                ArrayList arrayList = new ArrayList(listZza2.size());
                for (zzv zzvVar2 : listZza2) {
                    if (zzvVar2 != null) {
                        if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzap.zzcz)) {
                            this.zzj.zzr().zzx().zza("User property expired", zzvVar2.zza, this.zzj.zzj().zzc(zzvVar2.zzc.zza), zzvVar2.zzc.zza());
                        } else {
                            this.zzj.zzr().zzw().zza("User property expired", zzvVar2.zza, this.zzj.zzj().zzc(zzvVar2.zzc.zza), zzvVar2.zzc.zza());
                        }
                        zze().zzb(str, zzvVar2.zzc.zza);
                        if (zzvVar2.zzk != null) {
                            arrayList.add(zzvVar2.zzk);
                        }
                        zze().zze(str, zzvVar2.zzc.zza);
                        c = c;
                    }
                }
                char c2 = c;
                int size = arrayList.size();
                int i3 = i2;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    zzb(new zzan((zzan) obj, j), zzmVar);
                }
                zzac zzacVarZze3 = zze();
                String str2 = zzanVar2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzacVarZze3.zzd();
                zzacVarZze3.zzak();
                if (j < 0) {
                    zzacVarZze3.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzfk.zza(str), zzacVarZze3.zzo().zza(str2), Long.valueOf(j));
                    listZza3 = Collections.emptyList();
                } else {
                    String[] strArr2 = new String[3];
                    strArr2[i2] = str;
                    strArr2[1] = str2;
                    strArr2[c2] = String.valueOf(j);
                    listZza3 = zzacVarZze3.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", strArr2);
                }
                ArrayList arrayList2 = new ArrayList(listZza3.size());
                for (zzv zzvVar3 : listZza3) {
                    if (zzvVar3 != null) {
                        zzkz zzkzVar = zzvVar3.zzc;
                        zzlb zzlbVar = new zzlb(zzvVar3.zza, zzvVar3.zzb, zzkzVar.zza, j, zzkzVar.zza());
                        if (zze().zza(zzlbVar)) {
                            if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzap.zzcz)) {
                                this.zzj.zzr().zzx().zza("User property triggered", zzvVar3.zza, this.zzj.zzj().zzc(zzlbVar.zzc), zzlbVar.zze);
                            } else {
                                this.zzj.zzr().zzw().zza("User property triggered", zzvVar3.zza, this.zzj.zzj().zzc(zzlbVar.zzc), zzlbVar.zze);
                            }
                        } else {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzfk.zza(zzvVar3.zza), this.zzj.zzj().zzc(zzlbVar.zzc), zzlbVar.zze);
                        }
                        if (zzvVar3.zzi != null) {
                            arrayList2.add(zzvVar3.zzi);
                        }
                        zzvVar3.zzc = new zzkz(zzlbVar);
                        zzvVar3.zze = true;
                        zze().zza(zzvVar3);
                    }
                }
                zzb(zzanVar2, zzmVar);
                int size2 = arrayList2.size();
                int i4 = i2;
                while (i4 < size2) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    zzb(new zzan((zzan) obj2, j), zzmVar);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:268:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:99:0x02ec  */
    private final void zzb(zzan zzanVar, zzm zzmVar) {
        long jLongValue;
        int i;
        boolean z;
        zzlb zzlbVar;
        long jZza;
        zzaj zzajVarZza;
        boolean z2;
        List<Integer> listZzf;
        zzlb zzlbVarZzc;
        zzg zzgVarZzb;
        Preconditions.checkNotNull(zzmVar);
        Preconditions.checkNotEmpty(zzmVar.zza);
        long jNanoTime = System.nanoTime();
        zzw();
        zzk();
        String str = zzmVar.zza;
        if (zzh().zza(zzanVar, zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            if (zzc().zzb(str, zzanVar.zza)) {
                this.zzj.zzr().zzi().zza("Dropping blacklisted event. appId", zzfk.zza(str), this.zzj.zzj().zza(zzanVar.zza));
                boolean z3 = zzc().zzg(str) || zzc().zzh(str);
                if (!z3 && !"_err".equals(zzanVar.zza)) {
                    this.zzj.zzi().zza(str, 11, "_ev", zzanVar.zza, 0);
                }
                if (!z3 || (zzgVarZzb = zze().zzb(str)) == null || Math.abs(this.zzj.zzm().currentTimeMillis() - Math.max(zzgVarZzb.zzu(), zzgVarZzb.zzt())) <= zzap.zzy.zza(null).longValue()) {
                    return;
                }
                this.zzj.zzr().zzw().zza("Fetching config for blacklisted app");
                zza(zzgVarZzb);
                return;
            }
            if (this.zzj.zzr().zza(2)) {
                this.zzj.zzr().zzx().zza("Logging event", this.zzj.zzj().zza(zzanVar));
            }
            zze().zzf();
            try {
                zzc(zzmVar);
                boolean z4 = FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzanVar.zza) || ((com.google.android.gms.internal.measurement.zzjp.zzb() && this.zzj.zzb().zza(zzap.zzdf)) && ("purchase".equals(zzanVar.zza) || "refund".equals(zzanVar.zza)));
                if ("_iap".equals(zzanVar.zza) || z4) {
                    String strZzd = zzanVar.zzb.zzd(FirebaseAnalytics.Param.CURRENCY);
                    if (z4) {
                        double dDoubleValue = zzanVar.zzb.zzc("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            dDoubleValue = zzanVar.zzb.zzb("value").longValue() * 1000000.0d;
                        }
                        if (dDoubleValue <= 9.223372036854776E18d && dDoubleValue >= -9.223372036854776E18d) {
                            jLongValue = Math.round(dDoubleValue);
                            if (com.google.android.gms.internal.measurement.zzjp.zzb() && this.zzj.zzb().zza(zzap.zzdf) && "refund".equals(zzanVar.zza)) {
                                jLongValue = -jLongValue;
                            }
                        } else {
                            this.zzj.zzr().zzi().zza("Data lost. Currency value is too big. appId", zzfk.zza(str), Double.valueOf(dDoubleValue));
                            zze().b_();
                            zze().zzh();
                            return;
                        }
                    } else {
                        jLongValue = zzanVar.zzb.zzb("value").longValue();
                    }
                    if (TextUtils.isEmpty(strZzd)) {
                        i = 0;
                        z = true;
                    } else {
                        String upperCase = strZzd.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String strValueOf = String.valueOf("_ltv_");
                            String strValueOf2 = String.valueOf(upperCase);
                            String strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                            zzlb zzlbVarZzc2 = zze().zzc(str, strConcat);
                            if (zzlbVarZzc2 == null || !(zzlbVarZzc2.zze instanceof Long)) {
                                i = 0;
                                long j = jLongValue;
                                z = true;
                                zzac zzacVarZze = zze();
                                int iZzb = this.zzj.zzb().zzb(str, zzap.zzad) - 1;
                                Preconditions.checkNotEmpty(str);
                                zzacVarZze.zzd();
                                zzacVarZze.zzak();
                                try {
                                    zzacVarZze.c_().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(iZzb)});
                                } catch (SQLiteException e) {
                                    zzacVarZze.zzr().zzf().zza("Error pruning currencies. appId", zzfk.zza(str), e);
                                }
                                zzlbVar = new zzlb(str, zzanVar.zzc, strConcat, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
                            } else {
                                i = 0;
                                z = true;
                                zzlbVar = new zzlb(str, zzanVar.zzc, strConcat, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzlbVarZzc2.zze).longValue() + jLongValue));
                            }
                            if (!zze().zza(zzlbVar)) {
                                this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property. appId", zzfk.zza(str), this.zzj.zzj().zzc(zzlbVar.zzc), zzlbVar.zze);
                                this.zzj.zzi().zza(str, 9, (String) null, (String) null, 0);
                            }
                        } else {
                            i = 0;
                            z = true;
                        }
                    }
                } else {
                    i = 0;
                    z = true;
                }
                boolean zZza = zzla.zza(zzanVar.zza);
                boolean zEquals = "_err".equals(zzanVar.zza);
                if (com.google.android.gms.internal.measurement.zzjp.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzap.zzdb)) {
                    this.zzj.zzi();
                    jZza = zzla.zza(zzanVar.zzb) + 1;
                } else {
                    jZza = 1;
                }
                int i2 = i;
                zzab zzabVarZza = zze().zza(zzx(), str, jZza, true, zZza, false, zEquals, false);
                long jIntValue = zzabVarZza.zzb - ((long) zzap.zzj.zza(null).intValue());
                if (jIntValue > 0) {
                    if (jIntValue % 1000 == 1) {
                        this.zzj.zzr().zzf().zza("Data loss. Too many events logged. appId, count", zzfk.zza(str), Long.valueOf(zzabVarZza.zzb));
                    }
                    zze().b_();
                    zze().zzh();
                    return;
                }
                if (zZza) {
                    long jIntValue2 = zzabVarZza.zza - ((long) zzap.zzl.zza(null).intValue());
                    if (jIntValue2 > 0) {
                        if (jIntValue2 % 1000 == 1) {
                            this.zzj.zzr().zzf().zza("Data loss. Too many public events logged. appId, count", zzfk.zza(str), Long.valueOf(zzabVarZza.zza));
                        }
                        this.zzj.zzi().zza(str, 16, "_ev", zzanVar.zza, 0);
                        zze().b_();
                        zze().zzh();
                        return;
                    }
                }
                if (zEquals) {
                    long jMax = zzabVarZza.zzd - ((long) Math.max(i2, Math.min(1000000, this.zzj.zzb().zzb(zzmVar.zza, zzap.zzk))));
                    if (jMax > 0) {
                        if (jMax == 1) {
                            this.zzj.zzr().zzf().zza("Too many error events logged. appId, count", zzfk.zza(str), Long.valueOf(zzabVarZza.zzd));
                        }
                        zze().b_();
                        zze().zzh();
                        return;
                    }
                }
                Bundle bundleZzb = zzanVar.zzb.zzb();
                this.zzj.zzi().zza(bundleZzb, "_o", zzanVar.zzc);
                if (this.zzj.zzi().zzf(str)) {
                    this.zzj.zzi().zza(bundleZzb, "_dbg", (Object) 1L);
                    this.zzj.zzi().zza(bundleZzb, "_r", (Object) 1L);
                }
                if ("_s".equals(zzanVar.zza) && this.zzj.zzb().zze(zzmVar.zza, zzap.zzas) && (zzlbVarZzc = zze().zzc(zzmVar.zza, "_sno")) != null && (zzlbVarZzc.zze instanceof Long)) {
                    this.zzj.zzi().zza(bundleZzb, "_sno", zzlbVarZzc.zze);
                }
                if ("_s".equals(zzanVar.zza) && this.zzj.zzb().zze(zzmVar.zza, zzap.zzaw) && !this.zzj.zzb().zze(zzmVar.zza, zzap.zzas)) {
                    zzb(new zzkz("_sno", 0L, null), zzmVar);
                }
                long jZzc = zze().zzc(str);
                if (jZzc > 0) {
                    this.zzj.zzr().zzi().zza("Data lost. Too many events stored on disk, deleted. appId", zzfk.zza(str), Long.valueOf(jZzc));
                }
                zzak zzakVar = new zzak(this.zzj, zzanVar.zzc, str, zzanVar.zza, zzanVar.zzd, 0L, bundleZzb);
                zzaj zzajVarZza2 = zze().zza(str, zzakVar.zzb);
                if (zzajVarZza2 == null) {
                    if (zze().zzh(str) >= this.zzj.zzb().zza(str) && zZza) {
                        this.zzj.zzr().zzf().zza("Too many event names used, ignoring event. appId, name, supported count", zzfk.zza(str), this.zzj.zzj().zza(zzakVar.zzb), Integer.valueOf(this.zzj.zzb().zza(str)));
                        this.zzj.zzi().zza(str, 8, (String) null, (String) null, 0);
                        zze().zzh();
                        return;
                    }
                    zzajVarZza = new zzaj(str, zzakVar.zzb, 0L, 0L, zzakVar.zzc, 0L, null, null, null, null);
                } else {
                    zzakVar = zzakVar.zza(this.zzj, zzajVarZza2.zzf);
                    zzajVarZza = zzajVarZza2.zza(zzakVar.zzc);
                }
                zzak zzakVar2 = zzakVar;
                zze().zza(zzajVarZza);
                zzw();
                zzk();
                Preconditions.checkNotNull(zzakVar2);
                Preconditions.checkNotNull(zzmVar);
                Preconditions.checkNotEmpty(zzakVar2.zza);
                Preconditions.checkArgument(zzakVar2.zza.equals(zzmVar.zza));
                com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVarZza = com.google.android.gms.internal.measurement.zzbr.zzg.zzbf().zza(1).zza("android");
                if (!TextUtils.isEmpty(zzmVar.zza)) {
                    zzaVarZza.zzf(zzmVar.zza);
                }
                if (!TextUtils.isEmpty(zzmVar.zzd)) {
                    zzaVarZza.zze(zzmVar.zzd);
                }
                if (!TextUtils.isEmpty(zzmVar.zzc)) {
                    zzaVarZza.zzg(zzmVar.zzc);
                }
                if (zzmVar.zzj != SieveCacheKt.NodeMetaAndPreviousMask) {
                    zzaVarZza.zzh((int) zzmVar.zzj);
                }
                zzaVarZza.zzf(zzmVar.zze);
                if (!TextUtils.isEmpty(zzmVar.zzb)) {
                    zzaVarZza.zzk(zzmVar.zzb);
                }
                if (zzll.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzap.zzch)) {
                    if (TextUtils.isEmpty(zzaVarZza.zzl()) && !TextUtils.isEmpty(zzmVar.zzv)) {
                        zzaVarZza.zzp(zzmVar.zzv);
                    }
                    if (TextUtils.isEmpty(zzaVarZza.zzl()) && TextUtils.isEmpty(zzaVarZza.zzo()) && !TextUtils.isEmpty(zzmVar.zzr)) {
                        zzaVarZza.zzo(zzmVar.zzr);
                    }
                } else if (this.zzj.zzb().zza(zzap.zzbh)) {
                    if (TextUtils.isEmpty(zzaVarZza.zzl()) && !TextUtils.isEmpty(zzmVar.zzr)) {
                        zzaVarZza.zzo(zzmVar.zzr);
                    }
                } else if (!TextUtils.isEmpty(zzmVar.zzr)) {
                    zzaVarZza.zzo(zzmVar.zzr);
                }
                if (zzmVar.zzf != 0) {
                    zzaVarZza.zzh(zzmVar.zzf);
                }
                zzaVarZza.zzk(zzmVar.zzt);
                if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzbe) && (listZzf = zzh().zzf()) != null) {
                    zzaVarZza.zzd(listZzf);
                }
                Pair<String, Boolean> pairZza = this.zzj.zzc().zza(zzmVar.zza);
                if (pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                    if (zzmVar.zzo) {
                        zzaVarZza.zzh((String) pairZza.first);
                        if (pairZza.second != null) {
                            zzaVarZza.zza(((Boolean) pairZza.second).booleanValue());
                        }
                    }
                } else if (!this.zzj.zzx().zza(this.zzj.zzn()) && zzmVar.zzp) {
                    String string = Settings.Secure.getString(this.zzj.zzn().getContentResolver(), DeviceIdStorage.ANDROID_ID_SHARED_PREFS_KEY);
                    if (string == null) {
                        this.zzj.zzr().zzi().zza("null secure ID. appId", zzfk.zza(zzaVarZza.zzj()));
                        string = AbstractJsonLexerKt.NULL;
                    } else if (string.isEmpty()) {
                        this.zzj.zzr().zzi().zza("empty secure ID. appId", zzfk.zza(zzaVarZza.zzj()));
                    }
                    zzaVarZza.zzm(string);
                }
                this.zzj.zzx().zzaa();
                com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVarZzc = zzaVarZza.zzc(Build.MODEL);
                this.zzj.zzx().zzaa();
                zzaVarZzc.zzb(Build.VERSION.RELEASE).zzf((int) this.zzj.zzx().zzf()).zzd(this.zzj.zzx().zzg()).zzj(zzmVar.zzl);
                if (this.zzj.zzab()) {
                    zzaVarZza.zzj();
                    if (!TextUtils.isEmpty(null)) {
                        zzaVarZza.zzn(null);
                    }
                }
                zzg zzgVarZzb2 = zze().zzb(zzmVar.zza);
                if (zzgVarZzb2 == null) {
                    zzgVarZzb2 = new zzg(this.zzj, zzmVar.zza);
                    zzgVarZzb2.zza(this.zzj.zzi().zzk());
                    zzgVarZzb2.zzf(zzmVar.zzk);
                    zzgVarZzb2.zzb(zzmVar.zzb);
                    zzgVarZzb2.zze(this.zzj.zzc().zzb(zzmVar.zza));
                    zzgVarZzb2.zzg(0L);
                    zzgVarZzb2.zza(0L);
                    zzgVarZzb2.zzb(0L);
                    zzgVarZzb2.zzg(zzmVar.zzc);
                    zzgVarZzb2.zzc(zzmVar.zzj);
                    zzgVarZzb2.zzh(zzmVar.zzd);
                    zzgVarZzb2.zzd(zzmVar.zze);
                    zzgVarZzb2.zze(zzmVar.zzf);
                    zzgVarZzb2.zza(zzmVar.zzh);
                    zzgVarZzb2.zzp(zzmVar.zzl);
                    zzgVarZzb2.zzf(zzmVar.zzt);
                    zze().zza(zzgVarZzb2);
                }
                if (!TextUtils.isEmpty(zzgVarZzb2.zzd())) {
                    zzaVarZza.zzi(zzgVarZzb2.zzd());
                }
                if (!TextUtils.isEmpty(zzgVarZzb2.zzi())) {
                    zzaVarZza.zzl(zzgVarZzb2.zzi());
                }
                List<zzlb> listZza = zze().zza(zzmVar.zza);
                for (int i3 = 0; i3 < listZza.size(); i3++) {
                    com.google.android.gms.internal.measurement.zzbr.zzk.zza zzaVarZza2 = com.google.android.gms.internal.measurement.zzbr.zzk.zzj().zza(listZza.get(i3).zzc).zza(listZza.get(i3).zzd);
                    zzh().zza(zzaVarZza2, listZza.get(i3).zze);
                    zzaVarZza.zza(zzaVarZza2);
                }
                try {
                    long jZza2 = zze().zza((com.google.android.gms.internal.measurement.zzbr.zzg) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZza.zzu()));
                    zzac zzacVarZze2 = zze();
                    if (zzakVar2.zze != null) {
                        Iterator<String> it = zzakVar2.zze.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if ("_r".equals(it.next())) {
                                }
                            } else {
                                boolean zZzc = zzc().zzc(zzakVar2.zza, zzakVar2.zzb);
                                zzab zzabVarZza2 = zze().zza(zzx(), zzakVar2.zza, false, false, false, false, false);
                                if (!zZzc || zzabVarZza2.zze >= this.zzj.zzb().zzb(zzakVar2.zza)) {
                                    z2 = false;
                                }
                            }
                            z2 = true;
                        }
                    } else {
                        z2 = false;
                    }
                    if (zzacVarZze2.zza(zzakVar2, jZza2, z2)) {
                        this.zzm = 0L;
                    }
                } catch (IOException e2) {
                    this.zzj.zzr().zzf().zza("Data loss. Failed to insert raw event metadata. appId", zzfk.zza(zzaVarZza.zzj()), e2);
                }
                zze().b_();
                if ((!com.google.android.gms.internal.measurement.zzky.zzb() || !this.zzj.zzb().zze(zzmVar.zza, zzap.zzcz)) && this.zzj.zzr().zza(2)) {
                    this.zzj.zzr().zzx().zza("Event recorded", this.zzj.zzj().zza(zzakVar2));
                }
                zze().zzh();
                zzz();
                this.zzj.zzr().zzx().zza("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
            } catch (Throwable th) {
                zze().zzh();
                throw th;
            }
        }
    }

    final void zzl() {
        zzg zzgVarZzb;
        String strZzad;
        zzw();
        zzk();
        this.zzs = true;
        try {
            this.zzj.zzu();
            Boolean boolZzag = this.zzj.zzw().zzag();
            if (boolZzag == null) {
                this.zzj.zzr().zzi().zza("Upload data called on the client side before use of service was decided");
                this.zzs = false;
                zzaa();
                return;
            }
            if (boolZzag.booleanValue()) {
                this.zzj.zzr().zzf().zza("Upload called in the client side when service should be used");
                this.zzs = false;
                zzaa();
                return;
            }
            if (this.zzm > 0) {
                zzz();
                this.zzs = false;
                zzaa();
                return;
            }
            zzw();
            if (this.zzv != null) {
                this.zzj.zzr().zzx().zza("Uploading requested multiple times");
                this.zzs = false;
                zzaa();
                return;
            }
            if (!zzd().zzf()) {
                this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                zzz();
                this.zzs = false;
                zzaa();
                return;
            }
            long jCurrentTimeMillis = this.zzj.zzm().currentTimeMillis();
            int iZzb = zzlx.zzb() ? this.zzj.zzb().zzb(null, zzap.zzao) : 1;
            if (iZzb > 1) {
                long jZzk = jCurrentTimeMillis - zzx.zzk();
                for (int i = 0; i < iZzb && zza((String) null, jZzk); i++) {
                }
            } else {
                zza((String) null, jCurrentTimeMillis - zzx.zzk());
            }
            long jZza = this.zzj.zzc().zzc.zza();
            if (jZza != 0) {
                this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jZza)));
            }
            String strD_ = zze().d_();
            if (!TextUtils.isEmpty(strD_)) {
                if (this.zzx == -1) {
                    this.zzx = zze().zzaa();
                }
                List<Pair<com.google.android.gms.internal.measurement.zzbr.zzg, Long>> listZza = zze().zza(strD_, this.zzj.zzb().zzb(strD_, zzap.zzf), Math.max(0, this.zzj.zzb().zzb(strD_, zzap.zzg)));
                if (!listZza.isEmpty()) {
                    Iterator<Pair<com.google.android.gms.internal.measurement.zzbr.zzg, Long>> it = listZza.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            strZzad = null;
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzbr.zzg zzgVar = (com.google.android.gms.internal.measurement.zzbr.zzg) it.next().first;
                        if (!TextUtils.isEmpty(zzgVar.zzad())) {
                            strZzad = zzgVar.zzad();
                            break;
                        }
                    }
                    if (strZzad != null) {
                        for (int i2 = 0; i2 < listZza.size(); i2++) {
                            com.google.android.gms.internal.measurement.zzbr.zzg zzgVar2 = (com.google.android.gms.internal.measurement.zzbr.zzg) listZza.get(i2).first;
                            if (!TextUtils.isEmpty(zzgVar2.zzad()) && !zzgVar2.zzad().equals(strZzad)) {
                                listZza = listZza.subList(0, i2);
                                break;
                            }
                        }
                    }
                    com.google.android.gms.internal.measurement.zzbr.zzf.zza zzaVarZzb = com.google.android.gms.internal.measurement.zzbr.zzf.zzb();
                    int size = listZza.size();
                    ArrayList arrayList = new ArrayList(listZza.size());
                    boolean zZzf = this.zzj.zzb().zzf(strD_);
                    for (int i3 = 0; i3 < size; i3++) {
                        com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVarZzbm = ((com.google.android.gms.internal.measurement.zzbr.zzg) listZza.get(i3).first).zzbm();
                        com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVar = zzaVarZzbm;
                        com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVar2 = zzaVarZzbm;
                        arrayList.add((Long) listZza.get(i3).second);
                        com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVarZza = zzaVar2.zzg(this.zzj.zzb().zze()).zza(jCurrentTimeMillis);
                        this.zzj.zzu();
                        zzaVarZza.zzb(false);
                        if (!zZzf) {
                            zzaVar2.zzn();
                        }
                        if (this.zzj.zzb().zze(strD_, zzap.zzbg)) {
                            zzaVar2.zzl(zzh().zza(((com.google.android.gms.internal.measurement.zzbr.zzg) ((com.google.android.gms.internal.measurement.zzfd) zzaVar2.zzu())).zzbi()));
                        }
                        zzaVarZzb.zza(zzaVar2);
                    }
                    String strZza = this.zzj.zzr().zza(2) ? zzh().zza((com.google.android.gms.internal.measurement.zzbr.zzf) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzb.zzu())) : null;
                    zzh();
                    byte[] bArrZzbi = ((com.google.android.gms.internal.measurement.zzbr.zzf) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzb.zzu())).zzbi();
                    String strZza2 = zzap.zzp.zza(null);
                    try {
                        URL url = new URL(strZza2);
                        Preconditions.checkArgument(!arrayList.isEmpty());
                        if (this.zzv != null) {
                            this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                        } else {
                            this.zzv = new ArrayList(arrayList);
                        }
                        this.zzj.zzc().zzd.zza(jCurrentTimeMillis);
                        String strZzx = MsalUtils.QUERY_STRING_SYMBOL;
                        if (size > 0) {
                            strZzx = zzaVarZzb.zza(0).zzx();
                        }
                        this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", strZzx, Integer.valueOf(bArrZzbi.length), strZza);
                        this.zzr = true;
                        zzfo zzfoVarZzd = zzd();
                        zzku zzkuVar = new zzku(this, strD_);
                        zzfoVarZzd.zzd();
                        zzfoVarZzd.zzak();
                        Preconditions.checkNotNull(url);
                        Preconditions.checkNotNull(bArrZzbi);
                        Preconditions.checkNotNull(zzkuVar);
                        zzfoVarZzd.zzq().zzb(new zzfs(zzfoVarZzd, strD_, url, bArrZzbi, null, zzkuVar));
                    } catch (MalformedURLException unused) {
                        this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzfk.zza(strD_), strZza2);
                    }
                }
            } else {
                this.zzx = -1L;
                String strZza3 = zze().zza(jCurrentTimeMillis - zzx.zzk());
                if (!TextUtils.isEmpty(strZza3) && (zzgVarZzb = zze().zzb(strZza3)) != null) {
                    zza(zzgVarZzb);
                }
            }
            this.zzs = false;
            zzaa();
        } catch (Throwable th) {
            this.zzs = false;
            zzaa();
            throw th;
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r14v37 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v37 ??, new type: android.database.sqlite.SQLiteDatabase
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v37 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v37 ??, new type: android.database.sqlite.SQLiteDatabase
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v136 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v136 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v136 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v136 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v137 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v137 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v140 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v140 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r50v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r50v0 'this'  ??, new type: com.google.android.gms.measurement.internal.zzks
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v0 ??, new type: com.google.android.gms.measurement.internal.zzac
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v0 ??, new type: com.google.android.gms.measurement.internal.zzac
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v103 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v103 ??, new type: android.database.Cursor
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v103 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v103 ??, new type: android.database.Cursor
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r50v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r50v0 'this'  ??, new type: com.google.android.gms.measurement.internal.zzks
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v136 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private final boolean zza(java.lang.String r51, long r52) {
        /*
            Method dump skipped, instruction units count: 3967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(java.lang.String, long):boolean");
    }

    private static void zza(com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVar) {
        zzaVar.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zzaVar.zzb(); i++) {
            com.google.android.gms.internal.measurement.zzbr.zzc zzcVarZzb = zzaVar.zzb(i);
            if (zzcVarZzb.zze() < zzaVar.zzf()) {
                zzaVar.zzb(zzcVarZzb.zze());
            }
            if (zzcVarZzb.zze() > zzaVar.zzg()) {
                zzaVar.zzc(zzcVarZzb.zze());
            }
        }
    }

    private final void zza(com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVar, long j, boolean z) {
        String str;
        zzlb zzlbVar;
        String str2;
        if (!z) {
            str = "_lte";
        } else {
            str = "_se";
        }
        String str3 = str;
        zzlb zzlbVarZzc = zze().zzc(zzaVar.zzj(), str3);
        if (zzlbVarZzc == null || zzlbVarZzc.zze == null) {
            zzlbVar = new zzlb(zzaVar.zzj(), "auto", str3, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzlbVar = new zzlb(zzaVar.zzj(), "auto", str3, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzlbVarZzc.zze).longValue() + j));
        }
        com.google.android.gms.internal.measurement.zzbr.zzk zzkVar = (com.google.android.gms.internal.measurement.zzbr.zzk) ((com.google.android.gms.internal.measurement.zzfd) com.google.android.gms.internal.measurement.zzbr.zzk.zzj().zza(str3).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzlbVar.zze).longValue()).zzu());
        int iZza = zzkw.zza(zzaVar, str3);
        if (iZza >= 0) {
            zzaVar.zza(iZza, zzkVar);
        } else {
            zzaVar.zza(zzkVar);
        }
        if (j > 0) {
            zze().zza(zzlbVar);
            if (!z) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzj.zzb().zze(zzaVar.zzj(), zzap.zzcz)) {
                this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", str2, zzlbVar.zze);
            } else {
                this.zzj.zzr().zzw().zza("Updated engagement user property. scope, value", str2, zzlbVar.zze);
            }
        }
    }

    private final boolean zza(com.google.android.gms.internal.measurement.zzbr.zzc.zza zzaVar, com.google.android.gms.internal.measurement.zzbr.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        com.google.android.gms.internal.measurement.zzbr.zze zzeVarZza = zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) ((com.google.android.gms.internal.measurement.zzfd) zzaVar.zzu()), "_sc");
        String strZzd = zzeVarZza == null ? null : zzeVarZza.zzd();
        zzh();
        com.google.android.gms.internal.measurement.zzbr.zze zzeVarZza2 = zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) ((com.google.android.gms.internal.measurement.zzfd) zzaVar2.zzu()), "_pc");
        String strZzd2 = zzeVarZza2 != null ? zzeVarZza2.zzd() : null;
        if (strZzd2 == null || !strZzd2.equals(strZzd)) {
            return false;
        }
        zzb(zzaVar, zzaVar2);
        return true;
    }

    private final void zzb(com.google.android.gms.internal.measurement.zzbr.zzc.zza zzaVar, com.google.android.gms.internal.measurement.zzbr.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.zzd()));
        zzh();
        com.google.android.gms.internal.measurement.zzbr.zze zzeVarZza = zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) ((com.google.android.gms.internal.measurement.zzfd) zzaVar.zzu()), "_et");
        if (!zzeVarZza.zze() || zzeVarZza.zzf() <= 0) {
            return;
        }
        long jZzf = zzeVarZza.zzf();
        zzh();
        com.google.android.gms.internal.measurement.zzbr.zze zzeVarZza2 = zzkw.zza((com.google.android.gms.internal.measurement.zzbr.zzc) ((com.google.android.gms.internal.measurement.zzfd) zzaVar2.zzu()), "_et");
        if (zzeVarZza2 != null && zzeVarZza2.zzf() > 0) {
            jZzf += zzeVarZza2.zzf();
        }
        zzh().zza(zzaVar2, "_et", Long.valueOf(jZzf));
        zzh().zza(zzaVar, "_fr", (Object) 1L);
    }

    private static void zza(com.google.android.gms.internal.measurement.zzbr.zzc.zza zzaVar, String str) {
        List<com.google.android.gms.internal.measurement.zzbr.zze> listZza = zzaVar.zza();
        for (int i = 0; i < listZza.size(); i++) {
            if (str.equals(listZza.get(i).zzb())) {
                zzaVar.zzb(i);
                return;
            }
        }
    }

    private static void zza(com.google.android.gms.internal.measurement.zzbr.zzc.zza zzaVar, int i, String str) {
        List<com.google.android.gms.internal.measurement.zzbr.zze> listZza = zzaVar.zza();
        for (int i2 = 0; i2 < listZza.size(); i2++) {
            if ("_err".equals(listZza.get(i2).zzb())) {
                return;
            }
        }
        zzaVar.zza((com.google.android.gms.internal.measurement.zzbr.zze) ((com.google.android.gms.internal.measurement.zzfd) com.google.android.gms.internal.measurement.zzbr.zze.zzk().zza("_err").zza(Long.valueOf(i).longValue()).zzu())).zza((com.google.android.gms.internal.measurement.zzbr.zze) ((com.google.android.gms.internal.measurement.zzfd) com.google.android.gms.internal.measurement.zzbr.zze.zzk().zza("_ev").zzb(str).zzu()));
    }

    final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0L);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long l : list) {
                        try {
                            zzac zzacVarZze = zze();
                            long jLongValue = l.longValue();
                            zzacVarZze.zzd();
                            zzacVarZze.zzak();
                            try {
                                if (zzacVarZze.c_().delete(SemanticAttributes.MessagingDestinationKindValues.QUEUE, "rowid=?", new String[]{String.valueOf(jLongValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                zzacVarZze.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            List<Long> list2 = this.zzw;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzw = null;
                    if (zzd().zzf() && zzy()) {
                        zzl();
                    } else {
                        this.zzx = -1L;
                        zzz();
                    }
                    this.zzm = 0L;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i == 503 || i == 429) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zza(zzg zzgVar) {
        zzks zzksVar;
        ArrayMap arrayMap;
        zzw();
        if (zzll.zzb() && this.zzj.zzb().zze(zzgVar.zzc(), zzap.zzch)) {
            if (TextUtils.isEmpty(zzgVar.zze()) && TextUtils.isEmpty(zzgVar.zzg()) && TextUtils.isEmpty(zzgVar.zzf())) {
                zza(zzgVar.zzc(), 204, null, null, null);
                return;
            }
            zzksVar = this;
        } else {
            zzksVar = this;
            if (TextUtils.isEmpty(zzgVar.zze()) && TextUtils.isEmpty(zzgVar.zzf())) {
                zzksVar.zza(zzgVar.zzc(), 204, null, null, null);
                return;
            }
        }
        String strZza = zzksVar.zzj.zzb().zza(zzgVar);
        try {
            URL url = new URL(strZza);
            zzksVar.zzj.zzr().zzx().zza("Fetching remote configuration", zzgVar.zzc());
            com.google.android.gms.internal.measurement.zzbo.zzb zzbVarZza = zzksVar.zzc().zza(zzgVar.zzc());
            String strZzb = zzksVar.zzc().zzb(zzgVar.zzc());
            if (zzbVarZza == null || TextUtils.isEmpty(strZzb)) {
                arrayMap = null;
            } else {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", strZzb);
            }
            zzksVar.zzq = true;
            zzfo zzfoVarZzd = zzksVar.zzd();
            String strZzc = zzgVar.zzc();
            zzkt zzktVar = new zzkt(zzksVar);
            zzfoVarZzd.zzd();
            zzfoVarZzd.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzktVar);
            zzfoVarZzd.zzq().zzb(new zzfs(zzfoVarZzd, strZzc, url, null, arrayMap, zzktVar));
        } catch (MalformedURLException unused) {
            zzksVar.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzfk.zza(zzgVar.zzc()), strZza);
        }
    }

    final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzw();
        zzk();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzq = false;
                zzaa();
                throw th2;
            }
        }
        this.zzj.zzr().zzx().zza("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zze().zzf();
        try {
            zzg zzgVarZzb = zze().zzb(str);
            boolean z = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzgVarZzb == null) {
                this.zzj.zzr().zzi().zza("App does not exist in onConfigFetched. appId", zzfk.zza(str));
            } else if (z || i == 404) {
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i == 404 || i == 304) {
                    if (zzc().zza(str) == null && !zzc().zza(str, null, null)) {
                        zze().zzh();
                        this.zzq = false;
                        zzaa();
                        return;
                    }
                } else if (!zzc().zza(str, bArr, str2)) {
                    zze().zzh();
                    this.zzq = false;
                    zzaa();
                    return;
                }
                zzgVarZzb.zzh(this.zzj.zzm().currentTimeMillis());
                zze().zza(zzgVarZzb);
                if (i == 404) {
                    this.zzj.zzr().zzk().zza("Config not found. Using empty config. appId", str);
                } else {
                    this.zzj.zzr().zzx().zza("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (zzd().zzf() && zzy()) {
                    zzl();
                } else {
                    zzz();
                }
            } else {
                zzgVarZzb.zzi(this.zzj.zzm().currentTimeMillis());
                zze().zza(zzgVarZzb);
                this.zzj.zzr().zzx().zza("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzc().zzc(str);
                this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
                if (i == 503 || i == 429) {
                    this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
                }
                zzz();
            }
            zze().b_();
            zze().zzh();
            this.zzq = false;
            zzaa();
        } catch (Throwable th3) {
            zze().zzh();
            throw th3;
        }
    }

    private final void zzz() {
        long jMax;
        long jMax2;
        zzw();
        zzk();
        if (this.zzm > 0) {
            long jAbs = 3600000 - Math.abs(this.zzj.zzm().elapsedRealtime() - this.zzm);
            if (jAbs > 0) {
                this.zzj.zzr().zzx().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzt().zzb();
                zzv().zzf();
                return;
            }
            this.zzm = 0L;
        }
        if (!this.zzj.zzah() || !zzy()) {
            this.zzj.zzr().zzx().zza("Nothing to upload or uploading impossible");
            zzt().zzb();
            zzv().zzf();
            return;
        }
        long jCurrentTimeMillis = this.zzj.zzm().currentTimeMillis();
        long jMax3 = Math.max(0L, zzap.zzz.zza(null).longValue());
        boolean z = zze().zzz() || zze().zzk();
        if (z) {
            String strZzv = this.zzj.zzb().zzv();
            if (!TextUtils.isEmpty(strZzv) && !".none.".equals(strZzv)) {
                jMax = Math.max(0L, zzap.zzu.zza(null).longValue());
            } else {
                jMax = Math.max(0L, zzap.zzt.zza(null).longValue());
            }
        } else {
            jMax = Math.max(0L, zzap.zzs.zza(null).longValue());
        }
        long jZza = this.zzj.zzc().zzc.zza();
        long jZza2 = this.zzj.zzc().zzd.zza();
        long j = 0;
        long jMax4 = Math.max(zze().zzw(), zze().zzx());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jAbs3, jAbs4);
            long jMin = jAbs2 + jMax3;
            if (z && jMax5 > 0) {
                jMin = Math.min(jAbs2, jMax5) + jMax;
            }
            jMax2 = !zzh().zza(jMax5, jMax) ? jMax5 + jMax : jMin;
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    if (i >= Math.min(20, Math.max(0, zzap.zzab.zza(null).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    jMax2 += Math.max(j, zzap.zzaa.zza(null).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                    i++;
                    j = 0;
                }
            }
            j = 0;
        }
        if (jMax2 == j) {
            this.zzj.zzr().zzx().zza("Next upload time is 0");
            zzt().zzb();
            zzv().zzf();
            return;
        }
        if (!zzd().zzf()) {
            this.zzj.zzr().zzx().zza("No network");
            zzt().zza();
            zzv().zzf();
            return;
        }
        long jZza3 = this.zzj.zzc().zze.zza();
        long jMax6 = Math.max(0L, zzap.zzq.zza(null).longValue());
        if (!zzh().zza(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzt().zzb();
        long jCurrentTimeMillis2 = jMax2 - this.zzj.zzm().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            jCurrentTimeMillis2 = Math.max(0L, zzap.zzv.zza(null).longValue());
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        this.zzj.zzr().zzx().zza("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzv().zza(jCurrentTimeMillis2);
    }

    final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.zzn.clear();
    }

    private final Boolean zzb(zzg zzgVar) {
        try {
            if (zzgVar.zzm() != SieveCacheKt.NodeMetaAndPreviousMask) {
                if (zzgVar.zzm() == Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzgVar.zzc(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzgVar.zzc(), 0).versionName;
                if (zzgVar.zzl() != null && zzgVar.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    final void zzo() {
        zzw();
        zzk();
        if (this.zzl) {
            return;
        }
        this.zzl = true;
        if (zzab()) {
            int iZza = zza(this.zzu);
            int iZzaf = this.zzj.zzy().zzaf();
            zzw();
            if (iZza > iZzaf) {
                this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzaf));
            } else if (iZza < iZzaf) {
                if (zza(iZzaf, this.zzu)) {
                    this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzaf));
                } else {
                    this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(iZza), Integer.valueOf(iZzaf));
                }
            }
        }
    }

    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (this.zzj.zzb().zza(zzap.zzcf) && (fileLock = this.zzt) != null && fileLock.isValid()) {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
        try {
            FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzu = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzt = fileLockTryLock;
            if (fileLockTryLock != null) {
                this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                return true;
            }
            this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
            return false;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int i = fileChannel.read(byteBufferAllocate);
            if (i == 4) {
                byteBufferAllocate.flip();
                return byteBufferAllocate.getInt();
            }
            if (i != -1) {
                this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(i));
            }
            return 0;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(i);
        byteBufferAllocate.flip();
        try {
            fileChannel.truncate(0L);
            this.zzj.zzb().zza(zzap.zzcu);
            fileChannel.write(byteBufferAllocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    final void zza(zzm zzmVar) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzac zzacVarZze = zze();
        String str = zzmVar.zza;
        Preconditions.checkNotEmpty(str);
        zzacVarZze.zzd();
        zzacVarZze.zzak();
        try {
            SQLiteDatabase sQLiteDatabaseC_ = zzacVarZze.c_();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseC_.delete("apps", "app_id=?", strArr) + sQLiteDatabaseC_.delete(BoxConvertedPushNotificationDevice.EVENTS, "app_id=?", strArr) + sQLiteDatabaseC_.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseC_.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseC_.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseC_.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseC_.delete(SemanticAttributes.MessagingDestinationKindValues.QUEUE, "app_id=?", strArr) + sQLiteDatabaseC_.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseC_.delete("main_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                zzacVarZze.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzacVarZze.zzr().zzf().zza("Error resetting analytics data. appId, error", zzfk.zza(str), e);
        }
        if (com.google.android.gms.internal.measurement.zzkn.zzb() && this.zzj.zzb().zza(zzap.zzcm)) {
            if (zzmVar.zzh) {
                zzb(zzmVar);
            }
        } else {
            zzm zzmVarZza = zza(this.zzj.zzn(), zzmVar.zza, zzmVar.zzb, zzmVar.zzh, zzmVar.zzo, zzmVar.zzp, zzmVar.zzm, zzmVar.zzr, zzmVar.zzv);
            if (zzmVar.zzh) {
                zzb(zzmVarZza);
            }
        }
    }

    private final zzm zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3, String str4) {
        String installerPackageName;
        String str5;
        int i;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzr().zzf().zza("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            installerPackageName = MAMPackageManagement.getInstallerPackageName(packageManager, str);
        } catch (IllegalArgumentException unused) {
            this.zzj.zzr().zzf().zza("Error retrieving installer package name. appId", zzfk.zza(str));
            installerPackageName = "Unknown";
        }
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        String str6 = installerPackageName;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo == null) {
                str5 = "Unknown";
                i = Integer.MIN_VALUE;
            } else {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    applicationLabel.toString();
                }
                String str7 = packageInfo.versionName;
                i = packageInfo.versionCode;
                str5 = str7;
            }
            return new zzm(str, str2, str5, i, str6, this.zzj.zzb().zze(), this.zzj.zzi().zza(context, str), (String) null, z, false, "", 0L, j, 0, z2, z3, false, str3, (Boolean) null, 0L, (List<String>) null, (zzll.zzb() && this.zzj.zzb().zze(str, zzap.zzch)) ? str4 : null);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.zzj.zzr().zzf().zza("Error retrieving newly installed package info. appId, appName", zzfk.zza(str), "Unknown");
            return null;
        }
    }

    final void zza(zzkz zzkzVar, zzm zzmVar) {
        long jLongValue;
        zzaj zzajVarZza;
        zzw();
        zzk();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            int iZzc = this.zzj.zzi().zzc(zzkzVar.zza);
            int length = 0;
            if (iZzc != 0) {
                this.zzj.zzi();
                this.zzj.zzi().zza(zzmVar.zza, iZzc, "_ev", zzla.zza(zzkzVar.zza, 24, true), zzkzVar.zza != null ? zzkzVar.zza.length() : 0);
                return;
            }
            int iZzb = this.zzj.zzi().zzb(zzkzVar.zza, zzkzVar.zza());
            if (iZzb != 0) {
                this.zzj.zzi();
                String strZza = zzla.zza(zzkzVar.zza, 24, true);
                Object objZza = zzkzVar.zza();
                if (objZza != null && ((objZza instanceof String) || (objZza instanceof CharSequence))) {
                    length = String.valueOf(objZza).length();
                }
                this.zzj.zzi().zza(zzmVar.zza, iZzb, "_ev", strZza, length);
                return;
            }
            Object objZzc = this.zzj.zzi().zzc(zzkzVar.zza, zzkzVar.zza());
            if (objZzc == null) {
                return;
            }
            if ("_sid".equals(zzkzVar.zza) && this.zzj.zzb().zze(zzmVar.zza, zzap.zzas)) {
                long j = zzkzVar.zzb;
                String str = zzkzVar.zze;
                zzlb zzlbVarZzc = zze().zzc(zzmVar.zza, "_sno");
                if (zzlbVarZzc != null && (zzlbVarZzc.zze instanceof Long)) {
                    jLongValue = ((Long) zzlbVarZzc.zze).longValue();
                } else {
                    if (zzlbVarZzc != null) {
                        this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzlbVarZzc.zze);
                    }
                    if (!this.zzj.zzb().zze(zzmVar.zza, zzap.zzav) || (zzajVarZza = zze().zza(zzmVar.zza, "_s")) == null) {
                        jLongValue = 0;
                    } else {
                        jLongValue = zzajVarZza.zzc;
                        this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                    }
                }
                zza(new zzkz("_sno", j, Long.valueOf(jLongValue + 1), str), zzmVar);
            }
            zzlb zzlbVar = new zzlb(zzmVar.zza, zzkzVar.zze, zzkzVar.zza, zzkzVar.zzb, objZzc);
            if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzap.zzcz)) {
                this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzlbVar.zzc), objZzc);
            } else {
                this.zzj.zzr().zzw().zza("Setting user property", this.zzj.zzj().zzc(zzlbVar.zzc), objZzc);
            }
            zze().zzf();
            try {
                zzc(zzmVar);
                boolean zZza = zze().zza(zzlbVar);
                zze().b_();
                if (zZza) {
                    if (!com.google.android.gms.internal.measurement.zzky.zzb() || !this.zzj.zzb().zze(zzmVar.zza, zzap.zzcz)) {
                        this.zzj.zzr().zzw().zza("User property set", this.zzj.zzj().zzc(zzlbVar.zzc), zzlbVar.zze);
                    }
                } else {
                    this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzlbVar.zzc), zzlbVar.zze);
                    this.zzj.zzi().zza(zzmVar.zza, 9, (String) null, (String) null, 0);
                }
            } finally {
                zze().zzh();
            }
        }
    }

    final void zzb(zzkz zzkzVar, zzm zzmVar) {
        zzw();
        zzk();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzbc)) {
                if ("_npa".equals(zzkzVar.zza) && zzmVar.zzs != null) {
                    this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                    zza(new zzkz("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzmVar.zzs.booleanValue() ? 1L : 0L), "auto"), zzmVar);
                    return;
                }
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkzVar.zza));
                zze().zzf();
                try {
                    zzc(zzmVar);
                    zze().zzb(zzmVar.zza, zzkzVar.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkzVar.zza));
                    return;
                } finally {
                    zze().zzh();
                }
            }
            this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkzVar.zza));
            zze().zzf();
            try {
                zzc(zzmVar);
                zze().zzb(zzmVar.zza, zzkzVar.zza);
                zze().b_();
                this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkzVar.zza));
            } finally {
                zze().zzh();
            }
        }
    }

    final void zza(zzkp zzkpVar) {
        this.zzo++;
    }

    final void zzp() {
        this.zzp++;
    }

    final zzgo zzs() {
        return this.zzj;
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0222  */
    /* JADX WARN: Code duplicated, block: B:80:0x0227 A[Catch: all -> 0x04d5, TryCatch #1 {all -> 0x04d5, blocks: (B:28:0x00b6, B:30:0x00c6, B:32:0x00d4, B:34:0x00de, B:36:0x00e2, B:40:0x00f3, B:42:0x0104, B:49:0x0127, B:51:0x0135, B:53:0x014e, B:54:0x0176, B:56:0x01be, B:59:0x01d1, B:63:0x01e9, B:65:0x01f4, B:70:0x0206, B:72:0x020e, B:74:0x0214, B:78:0x0224, B:80:0x0227, B:81:0x024a, B:83:0x024f, B:89:0x0270, B:93:0x0283, B:95:0x02a4, B:96:0x02b2, B:98:0x02e3, B:100:0x02eb, B:102:0x02ef, B:103:0x02f2, B:105:0x0313, B:143:0x03f0, B:144:0x03f3, B:155:0x0465, B:157:0x0475, B:159:0x048f, B:160:0x0496, B:164:0x04c6, B:107:0x032c, B:112:0x0359, B:114:0x0361, B:116:0x036b, B:120:0x037f, B:124:0x038d, B:128:0x0398, B:121:0x0385, B:129:0x03a4, B:134:0x03d1, B:136:0x03d9, B:138:0x03e1, B:140:0x03e7, B:132:0x03b9, B:110:0x0340, B:147:0x040e, B:149:0x0441, B:151:0x0449, B:153:0x044d, B:154:0x0450, B:161:0x04aa, B:163:0x04ae, B:86:0x025f, B:44:0x010e, B:47:0x0116), top: B:172:0x00b6, inners: #0, #2, #3 }] */
    final void zzb(zzm zzmVar) {
        int i;
        long j;
        long j2;
        zzaj zzajVarZza;
        String str;
        long j3;
        long j4;
        PackageInfo packageInfo;
        long j5;
        boolean z;
        long j6;
        int i2;
        int i3;
        zzlb zzlbVarZzc;
        zzw();
        zzk();
        Preconditions.checkNotNull(zzmVar);
        Preconditions.checkNotEmpty(zzmVar.zza);
        if (zze(zzmVar)) {
            zzg zzgVarZzb = zze().zzb(zzmVar.zza);
            if (zzgVarZzb != null && TextUtils.isEmpty(zzgVarZzb.zze()) && !TextUtils.isEmpty(zzmVar.zzb)) {
                zzgVarZzb.zzh(0L);
                zze().zza(zzgVarZzb);
                zzc().zzd(zzmVar.zza);
            }
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            long jCurrentTimeMillis = zzmVar.zzm;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = this.zzj.zzm().currentTimeMillis();
            }
            long j7 = jCurrentTimeMillis;
            if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzbc)) {
                this.zzj.zzx().zzi();
            }
            int i4 = zzmVar.zzn;
            if (i4 == 0 || i4 == 1) {
                i = 0;
            } else {
                i = 0;
                this.zzj.zzr().zzi().zza("Incorrect app type, assuming installed app. appId, appType", zzfk.zza(zzmVar.zza), Integer.valueOf(i4));
                i4 = 0;
            }
            zze().zzf();
            try {
                if (!this.zzj.zzb().zze(zzmVar.zza, zzap.zzbc) || ((zzlbVarZzc = zze().zzc(zzmVar.zza, "_npa")) != null && !"auto".equals(zzlbVarZzc.zzb))) {
                    j = 1;
                } else if (zzmVar.zzs != null) {
                    j = 1;
                    zzkz zzkzVar = new zzkz("_npa", j7, Long.valueOf(zzmVar.zzs.booleanValue() ? 1L : 0L), "auto");
                    if (zzlbVarZzc == null || !zzlbVarZzc.zze.equals(zzkzVar.zzc)) {
                        zza(zzkzVar, zzmVar);
                    }
                } else {
                    j = 1;
                    if (zzlbVarZzc != null) {
                        zzb(new zzkz("_npa", j7, null, "auto"), zzmVar);
                    }
                }
                zzg zzgVarZzb2 = zze().zzb(zzmVar.zza);
                ApplicationInfo applicationInfo = null;
                if (zzgVarZzb2 != null) {
                    this.zzj.zzi();
                    j2 = j;
                    if (zzla.zza(zzmVar.zzb, zzgVarZzb2.zze(), zzmVar.zzr, zzgVarZzb2.zzf())) {
                        this.zzj.zzr().zzi().zza("New GMP App Id passed in. Removing cached database data. appId", zzfk.zza(zzgVarZzb2.zzc()));
                        zzac zzacVarZze = zze();
                        String strZzc = zzgVarZzb2.zzc();
                        zzacVarZze.zzak();
                        zzacVarZze.zzd();
                        Preconditions.checkNotEmpty(strZzc);
                        try {
                            SQLiteDatabase sQLiteDatabaseC_ = zzacVarZze.c_();
                            String[] strArr = new String[1];
                            strArr[i] = strZzc;
                            int iDelete = sQLiteDatabaseC_.delete(BoxConvertedPushNotificationDevice.EVENTS, "app_id=?", strArr) + sQLiteDatabaseC_.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseC_.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseC_.delete("apps", "app_id=?", strArr) + sQLiteDatabaseC_.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseC_.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseC_.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseC_.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseC_.delete("audience_filter_values", "app_id=?", strArr);
                            if (iDelete > 0) {
                                zzacVarZze.zzr().zzx().zza("Deleted application data. app, records", strZzc, Integer.valueOf(iDelete));
                            }
                        } catch (SQLiteException e) {
                            zzacVarZze.zzr().zzf().zza("Error deleting application data. appId, error", zzfk.zza(strZzc), e);
                        }
                        zzgVarZzb2 = null;
                    }
                } else {
                    j2 = j;
                }
                if (zzgVarZzb2 != null) {
                    if (zzgVarZzb2.zzm() != SieveCacheKt.NodeMetaAndPreviousMask) {
                        j6 = -2147483648L;
                        if (zzgVarZzb2.zzm() != zzmVar.zzj) {
                            i2 = 1;
                        }
                        if (zzgVarZzb2.zzm() == j6 || zzgVarZzb2.zzl() == null || zzgVarZzb2.zzl().equals(zzmVar.zzc)) {
                            i3 = i;
                        } else {
                            i3 = 1;
                        }
                        if ((i2 | i3) != 0) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", zzgVarZzb2.zzl());
                            zzan zzanVar = new zzan("_au", new zzam(bundle), "auto", j7);
                            j7 = j7;
                            zza(zzanVar, zzmVar);
                        }
                    } else {
                        j6 = -2147483648L;
                    }
                    i2 = i;
                    if (zzgVarZzb2.zzm() == j6) {
                        i3 = i;
                    } else {
                        i3 = i;
                    }
                    if ((i2 | i3) != 0) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("_pv", zzgVarZzb2.zzl());
                        zzan zzanVar2 = new zzan("_au", new zzam(bundle2), "auto", j7);
                        j7 = j7;
                        zza(zzanVar2, zzmVar);
                    }
                }
                zzc(zzmVar);
                if (i4 == 0) {
                    zzajVarZza = zze().zza(zzmVar.zza, "_f");
                } else {
                    zzajVarZza = i4 == 1 ? zze().zza(zzmVar.zza, "_v") : null;
                }
                if (zzajVarZza == null) {
                    long j8 = ((j7 / 3600000) + j2) * 3600000;
                    if (i4 == 0) {
                        zza(new zzkz("_fot", j7, Long.valueOf(j8), "auto"), zzmVar);
                        if (this.zzj.zzb().zze(zzmVar.zzb, zzap.zzaq)) {
                            zzw();
                            this.zzj.zzf().zza(zzmVar.zza);
                        }
                        zzw();
                        zzk();
                        Bundle bundle3 = new Bundle();
                        long j9 = j2;
                        bundle3.putLong("_c", j9);
                        bundle3.putLong("_r", j9);
                        bundle3.putLong("_uwa", 0L);
                        bundle3.putLong("_pfo", 0L);
                        bundle3.putLong("_sys", 0L);
                        bundle3.putLong("_sysu", 0L);
                        if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzba)) {
                            j4 = 1;
                            bundle3.putLong("_et", 1L);
                        } else {
                            j4 = 1;
                        }
                        if (zzmVar.zzq) {
                            bundle3.putLong("_dac", j4);
                        }
                        zzac zzacVarZze2 = zze();
                        String str2 = zzmVar.zza;
                        Preconditions.checkNotEmpty(str2);
                        zzacVarZze2.zzd();
                        zzacVarZze2.zzak();
                        long jZzh = zzacVarZze2.zzh(str2, "first_open_count");
                        if (this.zzj.zzn().getPackageManager() == null) {
                            this.zzj.zzr().zzf().zza("PackageManager is null, first open report might be inaccurate. appId", zzfk.zza(zzmVar.zza));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzmVar.zza, i);
                            } catch (PackageManager.NameNotFoundException e2) {
                                this.zzj.zzr().zzf().zza("Package info is null, first open report might be inaccurate. appId", zzfk.zza(zzmVar.zza), e2);
                                packageInfo = null;
                            }
                            if (packageInfo != null && packageInfo.firstInstallTime != 0) {
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    if (!this.zzj.zzb().zza(zzap.zzcn) || jZzh == 0) {
                                        bundle3.putLong("_uwa", 1L);
                                    }
                                    z = false;
                                } else {
                                    z = true;
                                }
                                zza(new zzkz("_fi", j7, Long.valueOf(z ? 1L : 0L), "auto"), zzmVar);
                            }
                            try {
                                applicationInfo = Wrappers.packageManager(this.zzj.zzn()).getApplicationInfo(zzmVar.zza, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                this.zzj.zzr().zzf().zza("Application info is null, first open report might be inaccurate. appId", zzfk.zza(zzmVar.zza), e3);
                            }
                            ApplicationInfo applicationInfo2 = applicationInfo;
                            if (applicationInfo2 != null) {
                                if ((applicationInfo2.flags & 1) != 0) {
                                    j5 = 1;
                                    bundle3.putLong("_sys", 1L);
                                } else {
                                    j5 = 1;
                                }
                                if ((applicationInfo2.flags & 128) != 0) {
                                    bundle3.putLong("_sysu", j5);
                                }
                            }
                        }
                        if (jZzh >= 0) {
                            bundle3.putLong("_pfo", jZzh);
                        }
                        long j10 = j7;
                        j7 = j10;
                        zza(new zzan("_f", new zzam(bundle3), "auto", j10), zzmVar);
                        str = "_et";
                    } else {
                        str = "_et";
                        if (i4 == 1) {
                            zza(new zzkz("_fvt", j7, Long.valueOf(j8), "auto"), zzmVar);
                            zzw();
                            zzk();
                            Bundle bundle4 = new Bundle();
                            bundle4.putLong("_c", 1L);
                            bundle4.putLong("_r", 1L);
                            if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzba)) {
                                j3 = 1;
                                bundle4.putLong(str, 1L);
                            } else {
                                j3 = 1;
                            }
                            if (zzmVar.zzq) {
                                bundle4.putLong("_dac", j3);
                            }
                            long j11 = j7;
                            j7 = j11;
                            zza(new zzan("_v", new zzam(bundle4), "auto", j11), zzmVar);
                        }
                    }
                    if (!this.zzj.zzb().zze(zzmVar.zza, zzap.zzbb)) {
                        Bundle bundle5 = new Bundle();
                        bundle5.putLong(str, 1L);
                        if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzba)) {
                            bundle5.putLong("_fr", 1L);
                        }
                        zza(new zzan("_e", new zzam(bundle5), "auto", j7), zzmVar);
                    }
                } else if (zzmVar.zzi) {
                    zza(new zzan("_cd", new zzam(new Bundle()), "auto", j7), zzmVar);
                }
                zze().b_();
                zze().zzh();
            } catch (Throwable th) {
                zze().zzh();
                throw th;
            }
        }
    }

    private final zzm zza(String str) {
        zzg zzgVarZzb = zze().zzb(str);
        if (zzgVarZzb == null || TextUtils.isEmpty(zzgVarZzb.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzb = zzb(zzgVarZzb);
        if (boolZzb != null && !boolZzb.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzfk.zza(str));
            return null;
        }
        return new zzm(str, zzgVarZzb.zze(), zzgVarZzb.zzl(), zzgVarZzb.zzm(), zzgVarZzb.zzn(), zzgVarZzb.zzo(), zzgVarZzb.zzp(), (String) null, zzgVarZzb.zzr(), false, zzgVarZzb.zzi(), zzgVarZzb.zzae(), 0L, 0, zzgVarZzb.zzaf(), zzgVarZzb.zzag(), false, zzgVarZzb.zzf(), zzgVarZzb.zzah(), zzgVarZzb.zzq(), zzgVarZzb.zzai(), (zzll.zzb() && this.zzj.zzb().zze(str, zzap.zzch)) ? zzgVarZzb.zzg() : null);
    }

    final void zza(zzv zzvVar) {
        zzm zzmVarZza = zza(zzvVar.zza);
        if (zzmVarZza != null) {
            zza(zzvVar, zzmVarZza);
        }
    }

    final void zza(zzv zzvVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzvVar);
        Preconditions.checkNotEmpty(zzvVar.zza);
        Preconditions.checkNotNull(zzvVar.zzb);
        Preconditions.checkNotNull(zzvVar.zzc);
        Preconditions.checkNotEmpty(zzvVar.zzc.zza);
        zzw();
        zzk();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            zzv zzvVar2 = new zzv(zzvVar);
            boolean z = false;
            zzvVar2.zze = false;
            zze().zzf();
            try {
                zzv zzvVarZzd = zze().zzd(zzvVar2.zza, zzvVar2.zzc.zza);
                if (zzvVarZzd != null && !zzvVarZzd.zzb.equals(zzvVar2.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzvVar2.zzc.zza), zzvVar2.zzb, zzvVarZzd.zzb);
                }
                if (zzvVarZzd != null && zzvVarZzd.zze) {
                    zzvVar2.zzb = zzvVarZzd.zzb;
                    zzvVar2.zzd = zzvVarZzd.zzd;
                    zzvVar2.zzh = zzvVarZzd.zzh;
                    zzvVar2.zzf = zzvVarZzd.zzf;
                    zzvVar2.zzi = zzvVarZzd.zzi;
                    zzvVar2.zze = zzvVarZzd.zze;
                    zzvVar2.zzc = new zzkz(zzvVar2.zzc.zza, zzvVarZzd.zzc.zzb, zzvVar2.zzc.zza(), zzvVarZzd.zzc.zze);
                } else if (TextUtils.isEmpty(zzvVar2.zzf)) {
                    zzvVar2.zzc = new zzkz(zzvVar2.zzc.zza, zzvVar2.zzd, zzvVar2.zzc.zza(), zzvVar2.zzc.zze);
                    z = true;
                    zzvVar2.zze = true;
                }
                if (zzvVar2.zze) {
                    zzkz zzkzVar = zzvVar2.zzc;
                    zzlb zzlbVar = new zzlb(zzvVar2.zza, zzvVar2.zzb, zzkzVar.zza, zzkzVar.zzb, zzkzVar.zza());
                    if (zze().zza(zzlbVar)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzvVar2.zza, this.zzj.zzj().zzc(zzlbVar.zzc), zzlbVar.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzfk.zza(zzvVar2.zza), this.zzj.zzj().zzc(zzlbVar.zzc), zzlbVar.zze);
                    }
                    if (z && zzvVar2.zzi != null) {
                        zzb(new zzan(zzvVar2.zzi, zzvVar2.zzd), zzmVar);
                    }
                }
                if (zze().zza(zzvVar2)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzvVar2.zza, this.zzj.zzj().zzc(zzvVar2.zzc.zza), zzvVar2.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzfk.zza(zzvVar2.zza), this.zzj.zzj().zzc(zzvVar2.zzc.zza), zzvVar2.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    final void zzb(zzv zzvVar) {
        zzm zzmVarZza = zza(zzvVar.zza);
        if (zzmVarZza != null) {
            zzb(zzvVar, zzmVarZza);
        }
    }

    final void zzb(zzv zzvVar, zzm zzmVar) {
        Preconditions.checkNotNull(zzvVar);
        Preconditions.checkNotEmpty(zzvVar.zza);
        Preconditions.checkNotNull(zzvVar.zzc);
        Preconditions.checkNotEmpty(zzvVar.zzc.zza);
        zzw();
        zzk();
        if (zze(zzmVar)) {
            if (!zzmVar.zzh) {
                zzc(zzmVar);
                return;
            }
            zze().zzf();
            try {
                zzc(zzmVar);
                zzv zzvVarZzd = zze().zzd(zzvVar.zza, zzvVar.zzc.zza);
                if (zzvVarZzd != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzvVar.zza, this.zzj.zzj().zzc(zzvVar.zzc.zza));
                    zze().zze(zzvVar.zza, zzvVar.zzc.zza);
                    if (zzvVarZzd.zze) {
                        zze().zzb(zzvVar.zza, zzvVar.zzc.zza);
                    }
                    if (zzvVar.zzk != null) {
                        zzb(this.zzj.zzi().zza(zzvVar.zza, zzvVar.zzk.zza, zzvVar.zzk.zzb != null ? zzvVar.zzk.zzb.zzb() : null, zzvVarZzd.zzb, zzvVar.zzk.zzd, true, false), zzmVar);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzfk.zza(zzvVar.zza), this.zzj.zzj().zzc(zzvVar.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0046  */
    /* JADX WARN: Code duplicated, block: B:15:0x0058  */
    /* JADX WARN: Code duplicated, block: B:40:0x00de  */
    /* JADX WARN: Code duplicated, block: B:48:0x0104  */
    /* JADX WARN: Code duplicated, block: B:51:0x0112  */
    /* JADX WARN: Code duplicated, block: B:59:0x013c  */
    /* JADX WARN: Code duplicated, block: B:62:0x014a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Code duplicated, block: B:76:0x0192  */
    /* JADX WARN: Code duplicated, block: B:78:0x0195  */
    private final zzg zza(zzm zzmVar, zzg zzgVar, String str) {
        boolean z;
        boolean z2 = true;
        if (zzgVar == null) {
            zzgVar = new zzg(this.zzj, zzmVar.zza);
            zzgVar.zza(this.zzj.zzi().zzk());
            zzgVar.zze(str);
        } else {
            if (str.equals(zzgVar.zzh())) {
                z = false;
            } else {
                zzgVar.zze(str);
                zzgVar.zza(this.zzj.zzi().zzk());
            }
            if (!TextUtils.equals(zzmVar.zzb, zzgVar.zze())) {
                zzgVar.zzb(zzmVar.zzb);
                z = true;
            }
            if (!TextUtils.equals(zzmVar.zzr, zzgVar.zzf())) {
                zzgVar.zzc(zzmVar.zzr);
                z = true;
            }
            if (zzll.zzb() && this.zzj.zzb().zze(zzgVar.zzc(), zzap.zzch) && !TextUtils.equals(zzmVar.zzv, zzgVar.zzg())) {
                zzgVar.zzd(zzmVar.zzv);
                z = true;
            }
            if (!TextUtils.isEmpty(zzmVar.zzk) && !zzmVar.zzk.equals(zzgVar.zzi())) {
                zzgVar.zzf(zzmVar.zzk);
                z = true;
            }
            if (zzmVar.zze != 0 && zzmVar.zze != zzgVar.zzo()) {
                zzgVar.zzd(zzmVar.zze);
                z = true;
            }
            if (!TextUtils.isEmpty(zzmVar.zzc) && !zzmVar.zzc.equals(zzgVar.zzl())) {
                zzgVar.zzg(zzmVar.zzc);
                z = true;
            }
            if (zzmVar.zzj != zzgVar.zzm()) {
                zzgVar.zzc(zzmVar.zzj);
                z = true;
            }
            if (zzmVar.zzd != null && !zzmVar.zzd.equals(zzgVar.zzn())) {
                zzgVar.zzh(zzmVar.zzd);
                z = true;
            }
            if (zzmVar.zzf != zzgVar.zzp()) {
                zzgVar.zze(zzmVar.zzf);
                z = true;
            }
            if (zzmVar.zzh != zzgVar.zzr()) {
                zzgVar.zza(zzmVar.zzh);
                z = true;
            }
            if (!TextUtils.isEmpty(zzmVar.zzg) && !zzmVar.zzg.equals(zzgVar.zzac())) {
                zzgVar.zzi(zzmVar.zzg);
                z = true;
            }
            if (zzmVar.zzl != zzgVar.zzae()) {
                zzgVar.zzp(zzmVar.zzl);
                z = true;
            }
            if (zzmVar.zzo != zzgVar.zzaf()) {
                zzgVar.zzb(zzmVar.zzo);
                z = true;
            }
            if (zzmVar.zzp != zzgVar.zzag()) {
                zzgVar.zzc(zzmVar.zzp);
                z = true;
            }
            if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzbc) && zzmVar.zzs != zzgVar.zzah()) {
                zzgVar.zza(zzmVar.zzs);
                z = true;
            }
            if (zzmVar.zzt != 0 || zzmVar.zzt == zzgVar.zzq()) {
                z2 = z;
            } else {
                zzgVar.zzf(zzmVar.zzt);
            }
            if (z2) {
                zze().zza(zzgVar);
            }
            return zzgVar;
        }
        z = true;
        if (!TextUtils.equals(zzmVar.zzb, zzgVar.zze())) {
            zzgVar.zzb(zzmVar.zzb);
            z = true;
        }
        if (!TextUtils.equals(zzmVar.zzr, zzgVar.zzf())) {
            zzgVar.zzc(zzmVar.zzr);
            z = true;
        }
        if (zzll.zzb()) {
            zzgVar.zzd(zzmVar.zzv);
            z = true;
        }
        if (!TextUtils.isEmpty(zzmVar.zzk)) {
            zzgVar.zzf(zzmVar.zzk);
            z = true;
        }
        if (zzmVar.zze != 0) {
            zzgVar.zzd(zzmVar.zze);
            z = true;
        }
        if (!TextUtils.isEmpty(zzmVar.zzc)) {
            zzgVar.zzg(zzmVar.zzc);
            z = true;
        }
        if (zzmVar.zzj != zzgVar.zzm()) {
            zzgVar.zzc(zzmVar.zzj);
            z = true;
        }
        if (zzmVar.zzd != null) {
            zzgVar.zzh(zzmVar.zzd);
            z = true;
        }
        if (zzmVar.zzf != zzgVar.zzp()) {
            zzgVar.zze(zzmVar.zzf);
            z = true;
        }
        if (zzmVar.zzh != zzgVar.zzr()) {
            zzgVar.zza(zzmVar.zzh);
            z = true;
        }
        if (!TextUtils.isEmpty(zzmVar.zzg)) {
            zzgVar.zzi(zzmVar.zzg);
            z = true;
        }
        if (zzmVar.zzl != zzgVar.zzae()) {
            zzgVar.zzp(zzmVar.zzl);
            z = true;
        }
        if (zzmVar.zzo != zzgVar.zzaf()) {
            zzgVar.zzb(zzmVar.zzo);
            z = true;
        }
        if (zzmVar.zzp != zzgVar.zzag()) {
            zzgVar.zzc(zzmVar.zzp);
            z = true;
        }
        if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzbc)) {
            zzgVar.zza(zzmVar.zzs);
            z = true;
        }
        if (zzmVar.zzt != 0) {
            z2 = z;
        } else {
            z2 = z;
        }
        if (z2) {
            zze().zza(zzgVar);
        }
        return zzgVar;
    }

    final zzg zzc(zzm zzmVar) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzmVar);
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzg zzgVarZzb = zze().zzb(zzmVar.zza);
        String strZzb = this.zzj.zzc().zzb(zzmVar.zza);
        if (com.google.android.gms.internal.measurement.zzks.zzb() && this.zzj.zzb().zza(zzap.zzcp)) {
            if (zzgVarZzb == null) {
                zzgVarZzb = new zzg(this.zzj, zzmVar.zza);
                zzgVarZzb.zza(this.zzj.zzi().zzk());
                zzgVarZzb.zze(strZzb);
            } else if (!strZzb.equals(zzgVarZzb.zzh())) {
                zzgVarZzb.zze(strZzb);
                zzgVarZzb.zza(this.zzj.zzi().zzk());
            }
            zzgVarZzb.zzb(zzmVar.zzb);
            zzgVarZzb.zzc(zzmVar.zzr);
            if (zzll.zzb() && this.zzj.zzb().zze(zzgVarZzb.zzc(), zzap.zzch)) {
                zzgVarZzb.zzd(zzmVar.zzv);
            }
            if (!TextUtils.isEmpty(zzmVar.zzk)) {
                zzgVarZzb.zzf(zzmVar.zzk);
            }
            if (zzmVar.zze != 0) {
                zzgVarZzb.zzd(zzmVar.zze);
            }
            if (!TextUtils.isEmpty(zzmVar.zzc)) {
                zzgVarZzb.zzg(zzmVar.zzc);
            }
            zzgVarZzb.zzc(zzmVar.zzj);
            if (zzmVar.zzd != null) {
                zzgVarZzb.zzh(zzmVar.zzd);
            }
            zzgVarZzb.zze(zzmVar.zzf);
            zzgVarZzb.zza(zzmVar.zzh);
            if (!TextUtils.isEmpty(zzmVar.zzg)) {
                zzgVarZzb.zzi(zzmVar.zzg);
            }
            zzgVarZzb.zzp(zzmVar.zzl);
            zzgVarZzb.zzb(zzmVar.zzo);
            zzgVarZzb.zzc(zzmVar.zzp);
            if (this.zzj.zzb().zze(zzmVar.zza, zzap.zzbc)) {
                zzgVarZzb.zza(zzmVar.zzs);
            }
            zzgVarZzb.zzf(zzmVar.zzt);
            if (zzgVarZzb.zza()) {
                zze().zza(zzgVarZzb);
            }
            return zzgVarZzb;
        }
        return zza(zzmVar, zzgVarZzb, strZzb);
    }

    final String zzd(zzm zzmVar) {
        try {
            return (String) this.zzj.zzq().zza(new zzkv(this, zzmVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzfk.zza(zzmVar.zza), e);
            return null;
        }
    }

    final void zza(boolean z) {
        zzz();
    }

    private final boolean zze(zzm zzmVar) {
        if (zzll.zzb() && this.zzj.zzb().zze(zzmVar.zza, zzap.zzch)) {
            return (TextUtils.isEmpty(zzmVar.zzb) && TextUtils.isEmpty(zzmVar.zzv) && TextUtils.isEmpty(zzmVar.zzr)) ? false : true;
        }
        return (TextUtils.isEmpty(zzmVar.zzb) && TextUtils.isEmpty(zzmVar.zzr)) ? false : true;
    }
}
