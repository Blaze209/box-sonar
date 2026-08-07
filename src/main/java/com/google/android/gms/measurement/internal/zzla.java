package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.j256.ormlite.field.FieldType;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzla extends zzhi {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private SecureRandom zzb;
    private final AtomicLong zzc;
    private int zzd;
    private Integer zze;

    zzla(zzgo zzgoVar) {
        super(zzgoVar);
        this.zze = null;
        this.zzc = new AtomicLong(0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzhi
    protected final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzhi
    protected final void f_() {
        zzd();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                zzr().zzi().zza("Utils falling back to Random for random id");
            }
        }
        this.zzc.set(jNextLong);
    }

    public final long zzg() {
        long andIncrement;
        long j;
        if (this.zzc.get() == 0) {
            synchronized (this.zzc) {
                long jNextLong = new Random(System.nanoTime() ^ zzm().currentTimeMillis()).nextLong();
                int i = this.zzd + 1;
                this.zzd = i;
                j = jNextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzc) {
            this.zzc.compareAndSet(-1L, 1L);
            andIncrement = this.zzc.getAndIncrement();
        }
        return andIncrement;
    }

    final SecureRandom zzh() {
        zzd();
        if (this.zzb == null) {
            this.zzb = new SecureRandom();
        }
        return this.zzb;
    }

    static boolean zza(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    final Bundle zza(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter2 = uri.getQueryParameter("utm_campaign");
                queryParameter3 = uri.getQueryParameter("utm_source");
                queryParameter4 = uri.getQueryParameter("utm_medium");
                queryParameter = uri.getQueryParameter("gclid");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
            }
            if (TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN, queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("source", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("gclid", queryParameter);
            }
            String queryParameter5 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("content", queryParameter6);
            }
            String queryParameter7 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("anid", queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzr().zzi().zza("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    final boolean zza(String str, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzr().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            zzr().zzh().zza("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzr().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final boolean zzb(String str, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzr().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            zzr().zzh().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzr().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final boolean zza(String str, String[] strArr, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        for (String str3 : zza) {
            if (str2.startsWith(str3)) {
                zzr().zzh().zza("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zza(str2, strArr)) {
            return true;
        }
        zzr().zzh().zza("Name is reserved. Type, name", str, str2);
        return false;
    }

    final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzr().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        zzr().zzh().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    final int zzb(String str) {
        if (!zzb("event", str)) {
            return 2;
        }
        if (zza("event", zzhj.zza, str)) {
            return !zza("event", 40, str) ? 2 : 0;
        }
        return 13;
    }

    final int zzc(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (zza("user property", zzhl.zza, str)) {
            return !zza("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    private final int zzg(String str) {
        if (!zza("event param", str)) {
            return 3;
        }
        if (zza("event param", (String[]) null, str)) {
            return !zza("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private final int zzh(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (zza("event param", (String[]) null, str)) {
            return !zza("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private static boolean zzb(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    private final boolean zza(String str, String str2, int i, Object obj) {
        int size;
        if (obj instanceof Parcelable[]) {
            size = ((Parcelable[]) obj).length;
        } else {
            if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            }
            return true;
        }
        if (size > i) {
            zzr().zzk().zza("Parameter array is too long; discarded. Value kind, name, array length", str, str2, Integer.valueOf(size));
            return false;
        }
        return true;
    }

    private final boolean zzb(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i) {
                zzr().zzk().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int iZzg;
        int iZza;
        if (bundle == null) {
            return;
        }
        boolean zZza = zzt().zza(zzap.zzde);
        int i = zZza ? 10 : 25;
        int i2 = 0;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list == 0 || !list.contains(str4)) {
                iZzg = z ? zzg(str4) : 0;
                if (iZzg == 0) {
                    iZzg = zzh(str4);
                }
            } else {
                iZzg = 0;
            }
            if (iZzg != 0) {
                zza(bundle, iZzg, str4, str4, iZzg == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (zzb(bundle.get(str4))) {
                    zzr().zzk().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str4);
                    iZza = 22;
                } else {
                    iZza = zza(str, str2, str4, bundle.get(str4), bundle, list, z, false);
                }
                if (iZza != 0 && !"_ev".equals(str4)) {
                    zza(bundle, iZza, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (zza(str4) && ((!zZza || !zza(str4, zzhm.zzd)) && (i2 = i2 + 1) > i)) {
                    zzr().zzh().zza(new StringBuilder(63).append("Child bundles can't contain more than ").append(i).append(" custom params").toString(), zzo().zza(str2), zzo().zza(bundle));
                    zza(bundle, zZza ? 23 : 5);
                    bundle.remove(str4);
                }
            }
        }
    }

    final boolean zza(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (zzi(str)) {
                return true;
            }
            if (this.zzx.zzl()) {
                zzr().zzh().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzfk.zza(str));
            }
            return false;
        }
        if (zzll.zzb() && zzt().zza(zzap.zzch) && !TextUtils.isEmpty(str3)) {
            return true;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (zzi(str2)) {
                return true;
            }
            zzr().zzh().zza("Invalid admob_app_id. Analytics disabled.", zzfk.zza(str2));
            return false;
        }
        if (this.zzx.zzl()) {
            zzr().zzh().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return !TextUtils.isEmpty(str4);
            }
            return !str3.equals(str4);
        }
        if (zIsEmpty || !zIsEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    private static boolean zzi(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final Object zza(int i, Object obj, boolean z, boolean z2) {
        Bundle bundleZza;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zza(String.valueOf(obj), i, z);
        }
        if (!com.google.android.gms.internal.measurement.zzjp.zzb() || !zzt().zza(zzap.zzdd) || !zzt().zza(zzap.zzdc) || !z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if ((parcelable instanceof Bundle) && (bundleZza = zza((Bundle) parcelable)) != null && !bundleZza.isEmpty()) {
                arrayList.add(bundleZza);
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x009a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x009d  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:69:0x0102  */
    /* JADX WARN: Code duplicated, block: B:71:0x010b  */
    /* JADX WARN: Code duplicated, block: B:74:0x0127 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0139 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:80:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    private final int zza(String str, String str2, String str3, Object obj, Bundle bundle, List<String> list, boolean z, boolean z2) {
        int i;
        boolean z3;
        ArrayList arrayList;
        int size;
        Object obj2;
        Parcelable[] parcelableArr;
        int length;
        Parcelable parcelable;
        zzd();
        int i2 = 0;
        if (com.google.android.gms.internal.measurement.zzjp.zzb() && zzt().zza(zzap.zzde)) {
            if (zzb(obj)) {
                if (!z2) {
                    return 21;
                }
                if (!zza(str3, zzhm.zzc)) {
                    return 20;
                }
                if (!zza("param", str3, 200, obj)) {
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr2 = (Parcelable[]) obj;
                        if (parcelableArr2.length > 200) {
                            bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr2, 200));
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        if (arrayList2.size() > 200) {
                            bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList2.subList(0, 200)));
                        }
                    }
                    i = 17;
                }
            }
            if (zzb("param", str3, ((zzt().zze(str, zzap.zzap) || !zze(str2)) && !zze(str3)) ? 100 : 256, obj)) {
                return i;
            }
            if (z2) {
                return 4;
            }
            if (com.google.android.gms.internal.measurement.zzjp.zzb() || !zzt().zza(zzap.zzdd)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (obj instanceof Bundle) {
                if (z3) {
                    zza(str, str2, str3, (Bundle) obj, list, z);
                }
                return i;
            }
            if (obj instanceof Parcelable[]) {
                parcelableArr = (Parcelable[]) obj;
                length = parcelableArr.length;
                while (i2 < length) {
                    parcelable = parcelableArr[i2];
                    if (!(parcelable instanceof Bundle)) {
                        zzr().zzk().zza("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                        return 4;
                    }
                    if (z3) {
                        zza(str, str2, str3, (Bundle) parcelable, list, z);
                    }
                    i2++;
                }
                return i;
            }
            if (obj instanceof ArrayList) {
                return 4;
            }
            arrayList = (ArrayList) obj;
            size = arrayList.size();
            while (i2 < size) {
                obj2 = arrayList.get(i2);
                i2++;
                if (!(obj2 instanceof Bundle)) {
                    zzr().zzk().zza("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str3);
                    return 4;
                }
                if (z3) {
                    zza(str, str2, str3, (Bundle) obj2, list, z);
                }
            }
            return i;
        }
        if (z2 && !zza("param", str3, 1000, obj)) {
            return 17;
        }
        i = 0;
        if (zzb("param", str3, ((zzt().zze(str, zzap.zzap) || !zze(str2)) && !zze(str3)) ? 100 : 256, obj)) {
            return i;
        }
        if (z2) {
            return 4;
        }
        if (com.google.android.gms.internal.measurement.zzjp.zzb()) {
            z3 = false;
        } else {
            z3 = false;
        }
        if (obj instanceof Bundle) {
            if (z3) {
                zza(str, str2, str3, (Bundle) obj, list, z);
            }
            return i;
        }
        if (obj instanceof Parcelable[]) {
            parcelableArr = (Parcelable[]) obj;
            length = parcelableArr.length;
            while (i2 < length) {
                parcelable = parcelableArr[i2];
                if (!(parcelable instanceof Bundle)) {
                    zzr().zzk().zza("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                    return 4;
                }
                if (z3) {
                    zza(str, str2, str3, (Bundle) parcelable, list, z);
                }
                i2++;
            }
            return i;
        }
        if (obj instanceof ArrayList) {
            return 4;
        }
        arrayList = (ArrayList) obj;
        size = arrayList.size();
        while (i2 < size) {
            obj2 = arrayList.get(i2);
            i2++;
            if (!(obj2 instanceof Bundle)) {
                zzr().zzk().zza("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str3);
                return 4;
            }
            if (z3) {
                zza(str, str2, str3, (Bundle) obj2, list, z);
            }
        }
        return i;
    }

    final Object zza(String str, Object obj) {
        if ("_ev".equals(str)) {
            return zza(256, obj, true, true);
        }
        return zza(zze(str) ? 256 : 100, obj, false, true);
    }

    static Bundle[] zza(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    final Bundle zza(String str, String str2, Bundle bundle, List<String> list, boolean z, boolean z2) {
        Set<String> setKeySet;
        int iZzg;
        boolean z3 = com.google.android.gms.internal.measurement.zzjp.zzb() && zzt().zza(zzap.zzde);
        boolean zZza = z3 ? zza(str2, zzhj.zzc) : z2;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        String str3 = str;
        if (zzt().zze(str3, zzap.zzbk)) {
            setKeySet = new TreeSet<>(bundle.keySet());
        } else {
            setKeySet = bundle.keySet();
        }
        int i = 0;
        for (String str4 : setKeySet) {
            if (list == 0 || !list.contains(str4)) {
                iZzg = z ? zzg(str4) : 0;
                if (iZzg == 0) {
                    iZzg = zzh(str4);
                }
            } else {
                iZzg = 0;
            }
            if (iZzg != 0) {
                zza(bundle2, iZzg, str4, str4, iZzg == 3 ? str4 : null);
                bundle2.remove(str4);
            } else {
                int iZza = zza(str3, str2, str4, bundle.get(str4), bundle2, list, z, zZza);
                if (z3 && iZza == 17) {
                    zza(bundle2, iZza, str4, str4, (Object) false);
                } else if (iZza != 0 && !"_ev".equals(str4)) {
                    zza(bundle2, iZza, iZza == 21 ? str2 : str4, str4, bundle.get(str4));
                    bundle2.remove(str4);
                }
                if (zza(str4) && (i = i + 1) > 25) {
                    zzr().zzh().zza(new StringBuilder(48).append("Event can't contain more than 25 params").toString(), zzo().zza(str2), zzo().zza(bundle));
                    zza(bundle2, 5);
                    bundle2.remove(str4);
                }
            }
            str3 = str;
        }
        return bundle2;
    }

    private static void zza(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zza(bundle, i)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if (obj != null) {
                    if ((obj instanceof String) || (obj instanceof CharSequence)) {
                        bundle.putLong("_el", String.valueOf(obj).length());
                    }
                }
            }
        }
    }

    private static boolean zza(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    private final int zzj(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if (FieldType.FOREIGN_ID_FIELD_SUFFIX.equals(str)) {
            return 256;
        }
        return (zzt().zza(zzap.zzce) && "_lgclid".equals(str)) ? 100 : 36;
    }

    final int zzb(String str, Object obj) {
        boolean zZzb;
        if ("_ldl".equals(str)) {
            zZzb = zzb("user property referrer", str, zzj(str), obj);
        } else {
            zZzb = zzb("user property", str, zzj(str), obj);
        }
        return zZzb ? 0 : 7;
    }

    final Object zzc(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzj(str), obj, true, false);
        }
        return zza(zzj(str), obj, false, false);
    }

    final void zza(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (com.google.android.gms.internal.measurement.zzjp.zzb() && zzt().zza(zzap.zzdd) && zzt().zza(zzap.zzdc) && (obj instanceof Bundle[])) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            zzr().zzk().zza("Not putting event parameter. Invalid value type. name, type", zzo().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza((String) null, i, str, str2, i2);
    }

    final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zza(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        this.zzx.zzu();
        this.zzx.zzh().zza("auto", "_err", bundle);
    }

    static MessageDigest zzi() {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
        }
        return j;
    }

    static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return zzb(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    private static boolean zzb(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = MAMPackageManagement.getServiceInfo(packageManager, new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    final boolean zzd(String str) {
        zzd();
        if (Wrappers.packageManager(zzn()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzr().zzw().zza("Permission not granted", str);
        return false;
    }

    static boolean zze(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzc(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    static boolean zza(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    static boolean zza(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    final boolean zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strZzv = zzt().zzv();
        zzu();
        return strZzv.equals(str);
    }

    final Bundle zza(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objZza = zza(str, bundle.get(str));
                if (objZza == null) {
                    zzr().zzk().zza("Param value can't be null", zzo().zzb(str));
                } else {
                    zza(bundle2, str, objZza);
                }
            }
        }
        return bundle2;
    }

    final zzan zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzb(str2) != 0) {
            zzr().zzf().zza("Invalid conditional property event name", zzo().zzc(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        return new zzan(str2, new zzam(zza(zza(str, str2, bundle2, CollectionUtils.listOf("_o"), false, false))), str3, j);
    }

    final long zza(Context context, String str) {
        zzd();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigestZzi = zzi();
        if (messageDigestZzi == null) {
            zzr().zzf().zza("Could not get MD5 instance");
            return -1L;
        }
        if (packageManager == null) {
            return 0L;
        }
        try {
            if (zzc(context, str)) {
                return 0L;
            }
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(zzn().getPackageName(), 64);
            if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return zza(messageDigestZzi.digest(packageInfo.signatures[0].toByteArray()));
            }
            zzr().zzi().zza("Could not get signatures");
            return -1L;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Package name not found", e);
            return 0L;
        }
    }

    private final boolean zzc(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            zzr().zzf().zza("Error obtaining certificate", e2);
            return true;
        }
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static Bundle zzb(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    private static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (zzc(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public final int zzj() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zzn()) / 1000);
        }
        return this.zze.intValue();
    }

    public final int zza(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzn(), 12451000);
    }

    public static long zza(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    final String zzk() {
        byte[] bArr = new byte[16];
        zzh().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzr().zzi().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzx.zzr().zzi().zza("Error returning string value to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzx.zzr().zzi().zza("Error returning long value to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzx.zzr().zzi().zza("Error returning int value to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzx.zzr().zzi().zza("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzx.zzr().zzi().zza("Error returning boolean value to wrapper", e);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar, Bundle bundle) {
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzx.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    public static Bundle zza(List<zzkz> list) {
        Bundle bundle = new Bundle();
        if (list != null) {
            for (zzkz zzkzVar : list) {
                if (zzkzVar.zzd != null) {
                    bundle.putString(zzkzVar.zza, zzkzVar.zzd);
                } else if (zzkzVar.zzc != null) {
                    bundle.putLong(zzkzVar.zza, zzkzVar.zzc.longValue());
                } else if (zzkzVar.zzf != null) {
                    bundle.putDouble(zzkzVar.zza, zzkzVar.zzf.doubleValue());
                }
            }
        }
        return bundle;
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zznVar.zza(bundle);
        } catch (RemoteException e) {
            this.zzx.zzr().zzi().zza("Error returning bundle list to wrapper", e);
        }
    }

    public static ArrayList<Bundle> zzb(List<zzv> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzv zzvVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzvVar.zza);
            bundle.putString("origin", zzvVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzvVar.zzd);
            bundle.putString("name", zzvVar.zzc.zza);
            zzhk.zza(bundle, zzvVar.zzc.zza());
            bundle.putBoolean("active", zzvVar.zze);
            if (zzvVar.zzf != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzvVar.zzf);
            }
            if (zzvVar.zzg != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzvVar.zzg.zza);
                if (zzvVar.zzg.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzvVar.zzg.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzvVar.zzh);
            if (zzvVar.zzi != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzvVar.zzi.zza);
                if (zzvVar.zzi.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzvVar.zzi.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzvVar.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzvVar.zzj);
            if (zzvVar.zzk != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzvVar.zzk.zza);
                if (zzvVar.zzk.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzvVar.zzk.zzb.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public final URL zza(long j, String str, String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j), Integer.valueOf(zzj())), str2, str, Long.valueOf(j2));
            if (str.equals(zzt().zzw())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e) {
            zzr().zzf().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    final boolean zza(String str, double d) {
        try {
            SharedPreferences.Editor editorEdit = zzn().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString("deeplink", str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return editorEdit.commit();
        } catch (Exception e) {
            zzr().zzf().zza("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    public final boolean zzv() {
        try {
            zzn().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static long zza(zzam zzamVar) {
        long length = 0;
        if (zzamVar == null) {
            return 0L;
        }
        Iterator<String> it = zzamVar.iterator();
        while (it.hasNext()) {
            Object objZza = zzamVar.zza(it.next());
            if (objZza instanceof Parcelable[]) {
                length += (long) ((Parcelable[]) objZza).length;
            }
        }
        return length;
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
