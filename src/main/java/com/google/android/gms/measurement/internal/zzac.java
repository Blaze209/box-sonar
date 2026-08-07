package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.collection.SieveCacheKt;
import com.box.android.domain.configuration.SplitConfiguration;
import com.box.android.utilities.DeviceIdStorage;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.microsoft.identity.client.internal.MsalUtils;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzac extends zzkp {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", DeviceIdStorage.ANDROID_ID_SHARED_PREFS_KEY, "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzad zzj;
    private final zzkl zzk;

    zzac(zzks zzksVar) {
        super(zzksVar);
        this.zzk = new zzkl(zzm());
        this.zzj = new zzad(this, zzn(), "google_app_measurement.db");
    }

    @Override // com.google.android.gms.measurement.internal.zzkp
    protected final boolean zze() {
        return false;
    }

    public final void zzf() {
        zzak();
        c_().beginTransaction();
    }

    public final void b_() {
        zzak();
        c_().setTransactionSuccessful();
    }

    public final void zzh() {
        zzak();
        c_().endTransaction();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = c_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j = cursorRawQuery.getLong(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzr().zzf().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return j;
                }
                long j2 = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j2;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    final SQLiteDatabase c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    public final zzaj zza(String str, String str2) throws Throwable {
        String str3;
        Cursor cursor;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        boolean zZze = zzt().zze(str, zzap.zzbn);
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"));
        if (zZze) {
            arrayList.add("current_session_count");
        }
        Cursor cursor2 = null;
        try {
            try {
                Cursor cursorQuery = c_().query(BoxConvertedPushNotificationDevice.EVENTS, (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    try {
                        if (!cursorQuery.moveToFirst()) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                        long j = cursorQuery.getLong(0);
                        boolean z = false;
                        long j2 = cursorQuery.getLong(1);
                        long j3 = cursorQuery.getLong(2);
                        long j4 = 0;
                        long j5 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                        Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                        Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                        Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                        if (cursorQuery.isNull(7)) {
                            boolValueOf = null;
                        } else {
                            try {
                                if (cursorQuery.getLong(7) == 1) {
                                    z = true;
                                }
                                boolValueOf = Boolean.valueOf(z);
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursorQuery;
                            }
                        }
                        if (zZze && !cursorQuery.isNull(8)) {
                            j4 = cursorQuery.getLong(8);
                        }
                        cursor = cursorQuery;
                        str3 = str2;
                        try {
                            zzaj zzajVar = new zzaj(str, str3, j, j2, j4, j3, j5, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                            if (cursor.moveToNext()) {
                                zzr().zzf().zza("Got multiple records for event aggregates, expected one. appId", zzfk.zza(str));
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return zzajVar;
                        } catch (SQLiteException e) {
                            e = e;
                            zzr().zzf().zza("Error querying events. appId", zzfk.zza(str), zzo().zza(str3), e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursorQuery;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursor = cursorQuery;
                    str3 = str2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLiteException e3) {
            e = e3;
            str3 = str2;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
        }
        if (cursor2 != null) {
            cursor2.close();
        }
        throw th;
    }

    public final void zza(zzaj zzajVar) {
        Preconditions.checkNotNull(zzajVar);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzajVar.zza);
        contentValues.put("name", zzajVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzajVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzajVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzajVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzajVar.zzg));
        contentValues.put("last_bundled_day", zzajVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzajVar.zzi);
        contentValues.put("last_sampling_rate", zzajVar.zzj);
        if (zzt().zze(zzajVar.zza, zzap.zzbn)) {
            contentValues.put("current_session_count", Long.valueOf(zzajVar.zze));
        }
        contentValues.put("last_exempt_from_sampling", (zzajVar.zzk == null || !zzajVar.zzk.booleanValue()) ? null : 1L);
        try {
            if (c_().insertWithOnConflict(BoxConvertedPushNotificationDevice.EVENTS, null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzfk.zza(zzajVar.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzfk.zza(zzajVar.zza), e);
        }
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            int iDelete = c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
            if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zza.zzb().zze(str, zzap.zzcz)) {
                return;
            }
            zzr().zzx().zza("Deleted user attribute rows", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zza.zzb().zze(str, zzap.zzcz)) {
                zzr().zzf().zza("Error deleting user property. appId", zzfk.zza(str), zzo().zzc(str2), e);
            } else {
                zzr().zzf().zza("Error deleting user attribute. appId", zzfk.zza(str), zzo().zzc(str2), e);
            }
        }
    }

    public final boolean zza(zzlb zzlbVar) {
        Preconditions.checkNotNull(zzlbVar);
        zzd();
        zzak();
        if (zzc(zzlbVar.zza, zzlbVar.zzc) == null) {
            if (zzla.zza(zzlbVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzlbVar.zza}) >= zzt().zzc(zzlbVar.zza)) {
                    return false;
                }
            } else if (zzt().zze(zzlbVar.zza, zzap.zzbc)) {
                if (!"_npa".equals(zzlbVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzlbVar.zza, zzlbVar.zzb}) >= 25) {
                    return false;
                }
            } else if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzlbVar.zza, zzlbVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzlbVar.zza);
        contentValues.put("origin", zzlbVar.zzb);
        contentValues.put("name", zzlbVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzlbVar.zzd));
        zza(contentValues, "value", zzlbVar.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzfk.zza(zzlbVar.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzfk.zza(zzlbVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:? A[SYNTHETIC] */
    public final zzlb zzc(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        Cursor cursor = null;
        try {
            cursorQuery = c_().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    str3 = str;
                    str4 = str2;
                    try {
                        zzlb zzlbVar = new zzlb(str3, cursorQuery.getString(2), str4, cursorQuery.getLong(0), zza(cursorQuery, 1));
                        if (cursorQuery.moveToNext()) {
                            zzr().zzf().zza("Got multiple records for user property, expected one. appId", zzfk.zza(str3));
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return zzlbVar;
                    } catch (SQLiteException e) {
                        e = e;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    str3 = str;
                    str4 = str2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                    throw th;
                }
                throw th;
            }
            sQLiteException = e;
        } catch (SQLiteException e3) {
            str3 = str;
            str4 = str2;
            sQLiteException = e3;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
                throw th;
            }
            throw th;
        }
        zzr().zzf().zza("Error querying user property. appId", zzfk.zza(str3), zzo().zzc(str4), sQLiteException);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:43:? A[SYNTHETIC] */
    public final List<zzlb> zza(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursorQuery = c_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            if (string2 == null) {
                                string2 = "";
                            }
                            String str2 = string2;
                            long j = cursorQuery.getLong(2);
                            Object objZza = zza(cursorQuery, 3);
                            if (objZza == null) {
                                zzr().zzf().zza("Read invalid user property value, ignoring it. appId", zzfk.zza(str));
                            } else {
                                arrayList.add(new zzlb(str, str2, string, j, objZza));
                            }
                        } while (cursorQuery.moveToNext());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } else if (cursorQuery != null) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    return arrayList;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Error querying user properties. appId", zzfk.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
                throw th;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0133  */
    /* JADX WARN: Code duplicated, block: B:63:0x013b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.google.android.gms.measurement.internal.zzac, com.google.android.gms.measurement.internal.zzhf] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.google.android.gms.measurement.internal.zzhf] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r17v1, types: [com.google.android.gms.measurement.internal.zzac] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final List<zzlb> zza(String str, String str2, String str3) throws Throwable {
        List<zzlb> list;
        String string;
        ?? r1;
        zzac zzacVar;
        ?? Query;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                String str4 = str;
                arrayList2.add(str4);
                StringBuilder sb = new StringBuilder("app_id=?");
                if (TextUtils.isEmpty(str2)) {
                    string = str2;
                } else {
                    string = str2;
                    try {
                        arrayList2.add(string);
                        sb.append(" and origin=?");
                    } catch (SQLiteException e) {
                        e = e;
                        Query = 0;
                        zzacVar = this;
                        list = null;
                        zzacVar.zzr().zzf().zza("(2)Error querying user properties", zzfk.zza(str), string, e);
                        if (Query != 0) {
                            Query.close();
                        }
                        return list;
                    } catch (Throwable th) {
                        th = th;
                        r1 = 0;
                        if (r1 != 0) {
                            r1.close();
                        }
                        throw th;
                    }
                }
                try {
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList2.add(String.valueOf(str3).concat("*"));
                        sb.append(" and name glob ?");
                    }
                    String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    SQLiteDatabase sQLiteDatabaseC_ = c_();
                    String[] strArr2 = {"name", "set_timestamp", "value", "origin"};
                    String string2 = sb.toString();
                    int i = 1;
                    list = null;
                    try {
                        Query = sQLiteDatabaseC_.query("user_attributes", strArr2, string2, strArr, null, null, "rowid", "1001");
                        try {
                            try {
                                if (Query.moveToFirst()) {
                                    while (true) {
                                        if (arrayList.size() >= 1000) {
                                            zzr().zzf().zza("Read more than the max allowed user properties, ignoring excess", 1000);
                                            break;
                                        }
                                        String string3 = Query.getString(0);
                                        long j = Query.getLong(i);
                                        zzacVar = this;
                                        try {
                                            Object objZza = zzacVar.zza(Query, 2);
                                            string = Query.getString(3);
                                            if (objZza == null) {
                                                zzacVar.zzr().zzf().zza("(2)Read invalid user property value, ignoring it", zzfk.zza(str4), string, str3);
                                            } else {
                                                arrayList.add(new zzlb(str4, string, string3, j, objZza));
                                            }
                                            if (!Query.moveToNext()) {
                                                break;
                                            }
                                            str4 = str;
                                            i = i;
                                        } catch (SQLiteException e2) {
                                            e = e2;
                                            zzacVar.zzr().zzf().zza("(2)Error querying user properties", zzfk.zza(str), string, e);
                                            if (Query != 0) {
                                                Query.close();
                                            }
                                            return list;
                                        }
                                    }
                                    if (Query != 0) {
                                        Query.close();
                                    }
                                } else if (Query != 0) {
                                    Query.close();
                                    return arrayList;
                                }
                                return arrayList;
                            } catch (SQLiteException e3) {
                                e = e3;
                                zzacVar = this;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r1 = Query;
                            if (r1 != 0) {
                                r1.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e4) {
                        e = e4;
                        zzacVar = this;
                        Query = list;
                        zzacVar.zzr().zzf().zza("(2)Error querying user properties", zzfk.zza(str), string, e);
                        if (Query != 0) {
                            Query.close();
                        }
                        return list;
                    } catch (Throwable th3) {
                        th = th3;
                        r1 = list;
                        if (r1 != 0) {
                            r1.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e5) {
                    e = e5;
                    list = null;
                    this = this;
                    Query = list;
                    zzacVar.zzr().zzf().zza("(2)Error querying user properties", zzfk.zza(str), string, e);
                    if (Query != 0) {
                        Query.close();
                    }
                    return list;
                }
            } catch (SQLiteException e6) {
                e = e6;
                string = str2;
            }
        } catch (Throwable th4) {
            th = th4;
            list = null;
        }
    }

    public final boolean zza(zzv zzvVar) {
        Preconditions.checkNotNull(zzvVar);
        zzd();
        zzak();
        if (zzc(zzvVar.zza, zzvVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzvVar.zza}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzvVar.zza);
        contentValues.put("origin", zzvVar.zzb);
        contentValues.put("name", zzvVar.zzc.zza);
        zza(contentValues, "value", zzvVar.zzc.zza());
        contentValues.put("active", Boolean.valueOf(zzvVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzvVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzvVar.zzh));
        zzp();
        contentValues.put("timed_out_event", zzla.zza((Parcelable) zzvVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzvVar.zzd));
        zzp();
        contentValues.put("triggered_event", zzla.zza((Parcelable) zzvVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzvVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzvVar.zzj));
        zzp();
        contentValues.put("expired_event", zzla.zza((Parcelable) zzvVar.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzfk.zza(zzvVar.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzfk.zza(zzvVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x015b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r35v0, types: [com.google.android.gms.measurement.internal.zzac, com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzkp] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.google.android.gms.measurement.internal.zzhf] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8, types: [com.google.android.gms.measurement.internal.zzac, com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzkq] */
    public final zzv zzd(String str, String str2) throws Throwable {
        zzv zzvVar;
        ?? r6;
        ?? Query;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            zzvVar = null;
            try {
                Query = c_().query("conditional_properties", new String[]{"origin", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    try {
                        if (!Query.moveToFirst()) {
                            if (Query != 0) {
                                Query.close();
                            }
                            return null;
                        }
                        String string = Query.getString(0);
                        this = this;
                        try {
                            Object objZza = this.zza(Query, 1);
                            boolean z = Query.getInt(2) != 0;
                            String string2 = Query.getString(3);
                            long j = Query.getLong(4);
                            str2 = str2;
                            try {
                                zzv zzvVar2 = new zzv(str, string, new zzkz(str2, Query.getLong(8), objZza, string), Query.getLong(6), z, string2, (zzan) this.zzg().zza(Query.getBlob(5), zzan.CREATOR), j, (zzan) this.zzg().zza(Query.getBlob(7), zzan.CREATOR), Query.getLong(9), (zzan) this.zzg().zza(Query.getBlob(10), zzan.CREATOR));
                                if (Query.moveToNext()) {
                                    this.zzr().zzf().zza("Got multiple records for conditional property, expected one", zzfk.zza(str), this.zzo().zzc(str2));
                                }
                                if (Query != 0) {
                                    Query.close();
                                }
                                return zzvVar2;
                            } catch (SQLiteException e) {
                                e = e;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            str2 = str2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r6 = Query;
                        if (r6 != 0) {
                            r6.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    this = this;
                }
                str2 = str2;
            } catch (SQLiteException e4) {
                e = e4;
                Query = zzvVar;
            } catch (Throwable th2) {
                th = th2;
                r6 = zzvVar;
                if (r6 != 0) {
                    r6.close();
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            e = e5;
            zzvVar = null;
        } catch (Throwable th3) {
            th = th3;
            zzvVar = null;
        }
        this.zzr().zzf().zza("Error querying conditional property", zzfk.zza(str), this.zzo().zzc(str2), e);
        if (Query != 0) {
            Query.close();
        }
        return zzvVar;
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting conditional property", zzfk.zza(str), zzo().zzc(str2), e);
            return 0;
        }
    }

    public final List<zzv> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0165  */
    public final List<zzv> zza(String str, String[] strArr) throws Throwable {
        Cursor cursor;
        zzac zzacVar;
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        try {
            int i = 5;
            Cursor cursorQuery = c_().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            if (arrayList.size() >= 1000) {
                                zzr().zzf().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                                break;
                            }
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            String string3 = cursorQuery.getString(2);
                            zzacVar = this;
                            try {
                                Object objZza = zzacVar.zza(cursorQuery, 3);
                                boolean z = cursorQuery.getInt(4) != 0;
                                arrayList.add(new zzv(string, string2, new zzkz(string3, cursorQuery.getLong(10), objZza, string2), cursorQuery.getLong(8), z, cursorQuery.getString(i), (zzan) zzacVar.zzg().zza(cursorQuery.getBlob(7), zzan.CREATOR), cursorQuery.getLong(6), (zzan) zzacVar.zzg().zza(cursorQuery.getBlob(9), zzan.CREATOR), cursorQuery.getLong(11), (zzan) zzacVar.zzg().zza(cursorQuery.getBlob(12), zzan.CREATOR)));
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                }
                                i = 5;
                            } catch (SQLiteException e) {
                                e = e;
                                cursor = cursorQuery;
                                try {
                                    zzacVar.zzr().zzf().zza("Error querying conditional user property value", e);
                                    List<zzv> listEmptyList = Collections.emptyList();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return listEmptyList;
                                } catch (Throwable th) {
                                    th = th;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } else if (cursorQuery != null) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    return arrayList;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzacVar = this;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzacVar = this;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0299  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.Cursor] */
    public final zzg zzb(String str) {
        zzg zzgVar;
        ?? r2;
        ?? Query;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            SQLiteDatabase sQLiteDatabaseC_ = c_();
            String[] strArr = new String[29];
            strArr[0] = "app_instance_id";
            strArr[1] = "gmp_app_id";
            strArr[2] = "resettable_device_id_hash";
            strArr[3] = "last_bundle_index";
            strArr[4] = "last_bundle_start_timestamp";
            strArr[5] = "last_bundle_end_timestamp";
            strArr[6] = SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY;
            strArr[7] = "app_store";
            strArr[8] = "gmp_version";
            strArr[9] = "dev_cert_hash";
            zzgVar = null;
            try {
                strArr[10] = "measurement_enabled";
                strArr[11] = "day";
                strArr[12] = "daily_public_events_count";
                strArr[13] = "daily_events_count";
                strArr[14] = "daily_conversions_count";
                strArr[15] = "config_fetched_time";
                strArr[16] = "failed_config_fetch_time";
                strArr[17] = "app_version_int";
                strArr[18] = "firebase_instance_id";
                strArr[19] = "daily_error_events_count";
                strArr[20] = "daily_realtime_events_count";
                strArr[21] = "health_monitor_sample";
                strArr[22] = DeviceIdStorage.ANDROID_ID_SHARED_PREFS_KEY;
                strArr[23] = "adid_reporting_enabled";
                strArr[24] = "ssaid_reporting_enabled";
                strArr[25] = "admob_app_id";
                strArr[26] = "dynamite_version";
                strArr[27] = "safelisted_events";
                strArr[28] = "ga_app_id";
                Query = sQLiteDatabaseC_.query("apps", strArr, "app_id=?", new String[]{str}, null, null, null);
                try {
                    try {
                        if (!Query.moveToFirst()) {
                            if (Query != 0) {
                                Query.close();
                            }
                            return null;
                        }
                        this = this;
                        try {
                            zzg zzgVar2 = new zzg(this.zza.zzs(), str);
                            zzgVar2.zza(Query.getString(0));
                            zzgVar2.zzb(Query.getString(1));
                            zzgVar2.zze(Query.getString(2));
                            zzgVar2.zzg(Query.getLong(3));
                            zzgVar2.zza(Query.getLong(4));
                            zzgVar2.zzb(Query.getLong(5));
                            zzgVar2.zzg(Query.getString(6));
                            zzgVar2.zzh(Query.getString(7));
                            zzgVar2.zzd(Query.getLong(8));
                            zzgVar2.zze(Query.getLong(9));
                            zzgVar2.zza(Query.isNull(10) || Query.getInt(10) != 0);
                            zzgVar2.zzj(Query.getLong(11));
                            zzgVar2.zzk(Query.getLong(12));
                            zzgVar2.zzl(Query.getLong(13));
                            zzgVar2.zzm(Query.getLong(14));
                            zzgVar2.zzh(Query.getLong(15));
                            zzgVar2.zzi(Query.getLong(16));
                            zzgVar2.zzc(Query.isNull(17) ? SieveCacheKt.NodeMetaAndPreviousMask : Query.getInt(17));
                            zzgVar2.zzf(Query.getString(18));
                            zzgVar2.zzo(Query.getLong(19));
                            zzgVar2.zzn(Query.getLong(20));
                            zzgVar2.zzi(Query.getString(21));
                            zzgVar2.zzp(Query.isNull(22) ? 0L : Query.getLong(22));
                            zzgVar2.zzb(Query.isNull(23) || Query.getInt(23) != 0);
                            zzgVar2.zzc(Query.isNull(24) || Query.getInt(24) != 0);
                            zzgVar2.zzc(Query.getString(25));
                            zzgVar2.zzf(Query.isNull(26) ? 0L : Query.getLong(26));
                            if (!Query.isNull(27)) {
                                zzgVar2.zza(Arrays.asList(Query.getString(27).split(",", -1)));
                            }
                            if (zzll.zzb() && this.zzt().zze(str, zzap.zzch)) {
                                zzgVar2.zzd(Query.getString(28));
                            }
                            zzgVar2.zzb();
                            if (Query.moveToNext()) {
                                this.zzr().zzf().zza("Got multiple records for app, expected one. appId", zzfk.zza(str));
                            }
                            if (Query != 0) {
                                Query.close();
                            }
                            return zzgVar2;
                        } catch (SQLiteException e) {
                            e = e;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        this = this;
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = Query;
                    if (r2 != 0) {
                        r2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                Query = zzgVar;
            } catch (Throwable th2) {
                th = th2;
                r2 = zzgVar;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            zzgVar = null;
        } catch (Throwable th3) {
            th = th3;
            zzgVar = null;
        }
        this.zzr().zzf().zza("Error querying app. appId", zzfk.zza(str), e);
        if (Query != 0) {
            Query.close();
        }
        return zzgVar;
    }

    public final void zza(zzg zzgVar) {
        Preconditions.checkNotNull(zzgVar);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzc());
        contentValues.put("app_instance_id", zzgVar.zzd());
        contentValues.put("gmp_app_id", zzgVar.zze());
        contentValues.put("resettable_device_id_hash", zzgVar.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzgVar.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzgVar.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzgVar.zzk()));
        contentValues.put(SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY, zzgVar.zzl());
        contentValues.put("app_store", zzgVar.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzgVar.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzgVar.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzgVar.zzr()));
        contentValues.put("day", Long.valueOf(zzgVar.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzgVar.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzgVar.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzgVar.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzgVar.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzgVar.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzgVar.zzm()));
        contentValues.put("firebase_instance_id", zzgVar.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzgVar.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzgVar.zzaa()));
        contentValues.put("health_monitor_sample", zzgVar.zzac());
        contentValues.put(DeviceIdStorage.ANDROID_ID_SHARED_PREFS_KEY, Long.valueOf(zzgVar.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzgVar.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzgVar.zzag()));
        contentValues.put("admob_app_id", zzgVar.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzgVar.zzq()));
        if (zzgVar.zzai() != null) {
            if (zzgVar.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzgVar.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzgVar.zzai()));
            }
        }
        if (zzll.zzb() && zzt().zze(zzgVar.zzc(), zzap.zzch)) {
            contentValues.put("ga_app_id", zzgVar.zzg());
        }
        try {
            SQLiteDatabase sQLiteDatabaseC_ = c_();
            if (sQLiteDatabaseC_.update("apps", contentValues, "app_id = ?", new String[]{zzgVar.zzc()}) == 0 && sQLiteDatabaseC_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzfk.zza(zzgVar.zzc()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzfk.zza(zzgVar.zzc()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzap.zzo))))});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzfk.zza(str), e);
            return 0L;
        }
    }

    public final zzab zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1L, false, false, z3, false, z5);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x012e  */
    public final zzab zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) throws Throwable {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        String[] strArr = {str};
        zzab zzabVar = new zzab();
        try {
            SQLiteDatabase sQLiteDatabaseC_ = c_();
            Cursor cursorQuery = sQLiteDatabaseC_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    zzr().zzi().zza("Not updating daily counts, app is not known. appId", zzfk.zza(str));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return zzabVar;
                    }
                } else {
                    if (cursorQuery.getLong(0) == j) {
                        zzabVar.zzb = cursorQuery.getLong(1);
                        zzabVar.zza = cursorQuery.getLong(2);
                        zzabVar.zzc = cursorQuery.getLong(3);
                        zzabVar.zzd = cursorQuery.getLong(4);
                        zzabVar.zze = cursorQuery.getLong(5);
                    }
                    if (z) {
                        zzabVar.zzb += j2;
                    }
                    if (z2) {
                        zzabVar.zza += j2;
                    }
                    if (z3) {
                        zzabVar.zzc += j2;
                    }
                    if (z4) {
                        zzabVar.zzd += j2;
                    }
                    if (z5) {
                        zzabVar.zze += j2;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzabVar.zza));
                    contentValues.put("daily_events_count", Long.valueOf(zzabVar.zzb));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzabVar.zzc));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzabVar.zzd));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzabVar.zze));
                    sQLiteDatabaseC_.update("apps", contentValues, "app_id=?", strArr);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        return zzabVar;
                    }
                }
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    zzr().zzf().zza("Error updating daily counts. appId", zzfk.zza(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return zzabVar;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:34:? A[SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0072: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x0071 */
    public final byte[] zzd(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = c_().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    if (cursorQuery.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for app config, expected one. appId", zzfk.zza(str));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return blob;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Error querying remote config. appId", zzfk.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
                throw th;
            }
            throw th;
        }
    }

    public final boolean zza(com.google.android.gms.internal.measurement.zzbr.zzg zzgVar, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        Preconditions.checkState(zzgVar.zzk());
        zzv();
        long jCurrentTimeMillis = zzm().currentTimeMillis();
        if (zzgVar.zzl() < jCurrentTimeMillis - zzx.zzj() || zzgVar.zzl() > zzx.zzj() + jCurrentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfk.zza(zzgVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgVar.zzl()));
        }
        try {
            byte[] bArrZzc = zzg().zzc(zzgVar.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(bArrZzc.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.zzl()));
            contentValues.put("data", bArrZzc);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.zzba()));
            }
            try {
                if (c_().insert(SemanticAttributes.MessagingDestinationKindValues.QUEUE, null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzfk.zza(zzgVar.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error storing bundle. appId", zzfk.zza(zzgVar.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzr().zzf().zza("Data loss. Failed to serialize bundle. appId", zzfk.zza(zzgVar.zzx()), e2);
            return false;
        }
    }

    public final String d_() throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            cursorRawQuery = c_().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return string;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorRawQuery;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorRawQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final List<Pair<com.google.android.gms.internal.measurement.zzbr.zzg, Long>> zza(String str, int i, int i2) {
        zzd();
        zzak();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = c_().query(SemanticAttributes.MessagingDestinationKindValues.QUEUE, new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<com.google.android.gms.internal.measurement.zzbr.zzg, Long>> listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                do {
                    long j = cursorQuery.getLong(0);
                    try {
                        byte[] bArrZzb = zzg().zzb(cursorQuery.getBlob(1));
                        if (!arrayList.isEmpty() && bArrZzb.length + length > i2) {
                            break;
                        }
                        try {
                            com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVar = (com.google.android.gms.internal.measurement.zzbr.zzg.zza) zzkw.zza(com.google.android.gms.internal.measurement.zzbr.zzg.zzbf(), bArrZzb);
                            if (!cursorQuery.isNull(2)) {
                                zzaVar.zzi(cursorQuery.getInt(2));
                            }
                            length += bArrZzb.length;
                            arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzbr.zzg) ((com.google.android.gms.internal.measurement.zzfd) zzaVar.zzu()), Long.valueOf(j)));
                        } catch (IOException e) {
                            zzr().zzf().zza("Failed to merge queued bundle. appId", zzfk.zza(str), e);
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to unzip queued bundle. appId", zzfk.zza(str), e2);
                    }
                } while (length <= i2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                zzr().zzf().zza("Error querying bundles. appId", zzfk.zza(str), e3);
                List<Pair<com.google.android.gms.internal.measurement.zzbr.zzg, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
                throw th;
            }
            throw th;
        }
    }

    final void zzv() {
        int iDelete;
        zzd();
        zzak();
        if (zzam()) {
            long jZza = zzs().zzf.zza();
            long jElapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzap.zzx.zza(null).longValue()) {
                zzs().zzf.zza(jElapsedRealtime);
                zzd();
                zzak();
                if (!zzam() || (iDelete = c_().delete(SemanticAttributes.MessagingDestinationKindValues.QUEUE, "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzx.zzj())})) <= 0) {
                    return;
                }
                zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String strJoin = TextUtils.join(",", list);
            String string = new StringBuilder(String.valueOf(strJoin).length() + 2).append("(").append(strJoin).append(")").toString();
            if (zzb(new StringBuilder(String.valueOf(string).length() + 80).append("SELECT COUNT(1) FROM queue WHERE rowid IN ").append(string).append(" AND retry_count =  2147483647 LIMIT 1").toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                c_().execSQL(new StringBuilder(String.valueOf(string).length() + 127).append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ").append(string).append(" AND (retry_count IS NULL OR retry_count < 2147483647)").toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private final boolean zza(String str, int i, com.google.android.gms.internal.measurement.zzbj.zzb zzbVar) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (TextUtils.isEmpty(zzbVar.zzc())) {
            zzr().zzi().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfk.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbi = zzbVar.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzc());
        if (zzt().zze(str, zzap.zzbm)) {
            contentValues.put("session_scoped", zzbVar.zzj() ? Boolean.valueOf(zzbVar.zzk()) : null);
        }
        contentValues.put("data", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzfk.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzfk.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, com.google.android.gms.internal.measurement.zzbj.zze zzeVar) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (TextUtils.isEmpty(zzeVar.zzc())) {
            zzr().zzi().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfk.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbi = zzeVar.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null);
        contentValues.put("property_name", zzeVar.zzc());
        if (zzt().zze(str, zzap.zzbm)) {
            contentValues.put("session_scoped", zzeVar.zzg() ? Boolean.valueOf(zzeVar.zzh()) : null);
        }
        contentValues.put("data", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzfk.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzfk.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:45:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v2 */
    final Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zzb>> zzf(String str, String str2) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        ?? r10 = 0;
        try {
            try {
                cursorQuery = c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zzb>> mapEmptyMap = Collections.emptyMap();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return mapEmptyMap;
                    }
                    do {
                        try {
                            com.google.android.gms.internal.measurement.zzbj.zzb zzbVar = (com.google.android.gms.internal.measurement.zzbj.zzb) ((com.google.android.gms.internal.measurement.zzfd) ((com.google.android.gms.internal.measurement.zzbj.zzb.zza) zzkw.zza(com.google.android.gms.internal.measurement.zzbj.zzb.zzl(), cursorQuery.getBlob(1))).zzu());
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        } catch (IOException e) {
                            zzr().zzf().zza("Failed to merge filter. appId", zzfk.zza(str), e);
                        }
                    } while (cursorQuery.moveToNext());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayMap;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzr().zzf().zza("Database error querying filters. appId", zzfk.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                r10 = str2;
                if (r10 != 0) {
                    r10.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r10 != 0) {
                r10.close();
                throw th;
            }
            throw th;
        }
    }

    final Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.zzbj.zzb zzbVar = (com.google.android.gms.internal.measurement.zzbj.zzb) ((com.google.android.gms.internal.measurement.zzfd) ((com.google.android.gms.internal.measurement.zzbj.zzb.zza) zzkw.zza(com.google.android.gms.internal.measurement.zzbj.zzb.zzl(), cursorQuery.getBlob(1))).zzu());
                        if (zzbVar.zzf()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to merge filter. appId", zzfk.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayMap;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error querying filters. appId", zzfk.zza(str), e2);
            Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zzb>> mapEmptyMap2 = Collections.emptyMap();
            if (0 != 0) {
                cursor.close();
            }
            return mapEmptyMap2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:45:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v2 */
    final Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zze>> zzg(String str, String str2) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        ?? r10 = 0;
        try {
            try {
                cursorQuery = c_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zze>> mapEmptyMap = Collections.emptyMap();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return mapEmptyMap;
                    }
                    do {
                        try {
                            com.google.android.gms.internal.measurement.zzbj.zze zzeVar = (com.google.android.gms.internal.measurement.zzbj.zze) ((com.google.android.gms.internal.measurement.zzfd) ((com.google.android.gms.internal.measurement.zzbj.zze.zza) zzkw.zza(com.google.android.gms.internal.measurement.zzbj.zze.zzi(), cursorQuery.getBlob(1))).zzu());
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzeVar);
                        } catch (IOException e) {
                            zzr().zzf().zza("Failed to merge filter", zzfk.zza(str), e);
                        }
                    } while (cursorQuery.moveToNext());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayMap;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzr().zzf().zza("Database error querying filters. appId", zzfk.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                r10 = str2;
                if (r10 != 0) {
                    r10.close();
                    throw th;
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r10 != 0) {
                r10.close();
                throw th;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:51:? A[SYNTHETIC] */
    final Map<Integer, List<Integer>> zza(String str, List<String> list) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        ArrayMap arrayMap = new ArrayMap();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("app_id=? AND property_name in (");
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(MsalUtils.QUERY_STRING_SYMBOL);
            }
            sb.append(")");
            ArrayList arrayList = new ArrayList(list);
            arrayList.add(0, str);
            Cursor cursor = null;
            try {
                cursorQuery = c_().query("property_filters", new String[]{"audience_id", "filter_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                int i2 = cursorQuery.getInt(0);
                                List arrayList2 = (List) arrayMap.get(Integer.valueOf(i2));
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                    arrayMap.put(Integer.valueOf(i2), arrayList2);
                                }
                                arrayList2.add(Integer.valueOf(cursorQuery.getInt(1)));
                            } while (cursorQuery.moveToNext());
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } else if (cursorQuery != null) {
                            cursorQuery.close();
                            return arrayMap;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        zzr().zzf().zza("Database error querying filters. appId", zzfk.zza(str), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                    throw th;
                }
                throw th;
            }
        }
        return arrayMap;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0086  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    final Map<Integer, List<Integer>> zzf(String str) throws Throwable {
        Cursor cursorRawQuery;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        ?? r2 = 0;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseC_.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        Map<Integer, List<Integer>> mapEmptyMap = Collections.emptyMap();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return mapEmptyMap;
                    }
                    do {
                        int i = cursorRawQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                    } while (cursorRawQuery.moveToNext());
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return arrayMap;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Database error querying scoped filters. appId", zzfk.zza(str), e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r2 = sQLiteDatabaseC_;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    private final boolean zzc(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zzt().zzb(str, zzap.zzae)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            String string = new StringBuilder(String.valueOf(strJoin).length() + 2).append("(").append(strJoin).append(")").toString();
            return sQLiteDatabaseC_.delete("audience_filter_values", new StringBuilder(String.valueOf(string).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(string).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzfk.zza(str), e);
            return false;
        }
    }

    final Map<Integer, com.google.android.gms.internal.measurement.zzbr.zzi> zzg(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursorQuery = c_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                    ArrayMap arrayMap = new ArrayMap();
                    do {
                        int i = cursorQuery.getInt(0);
                        try {
                            arrayMap.put(Integer.valueOf(i), (com.google.android.gms.internal.measurement.zzbr.zzi) ((com.google.android.gms.internal.measurement.zzfd) ((com.google.android.gms.internal.measurement.zzbr.zzi.zza) zzkw.zza(com.google.android.gms.internal.measurement.zzbr.zzi.zzi(), cursorQuery.getBlob(1))).zzu()));
                        } catch (IOException e) {
                            zzr().zzf().zza("Failed to merge filter results. appId, audienceId, error", zzfk.zza(str), Integer.valueOf(i), e);
                        }
                    } while (cursorQuery.moveToNext());
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayMap;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzr().zzf().zza("Database error querying filter results. appId", zzfk.zza(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
        th = th2;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
            throw th;
        }
        throw th;
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    protected final long zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        sQLiteDatabaseC_.beginTransaction();
        long j = 0;
        try {
            try {
                long jZza = zza(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1L);
                if (jZza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseC_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzr().zzf().zza("Failed to insert column (got -1). appId", zzfk.zza(str), str2);
                        return -1L;
                    }
                    jZza = 0;
                    zzr().zzf().zza("Error inserting column. appId", zzfk.zza(str), str2, e);
                    return j;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + jZza));
                    if (sQLiteDatabaseC_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        zzr().zzf().zza("Failed to update column (got 0). appId", zzfk.zza(str), str2);
                        return -1L;
                    }
                    sQLiteDatabaseC_.setTransactionSuccessful();
                    return jZza;
                } catch (SQLiteException e) {
                    e = e;
                    j = jZza;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } finally {
            sQLiteDatabaseC_.endTransaction();
        }
    }

    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zza(com.google.android.gms.internal.measurement.zzbr.zzg zzgVar) throws IOException {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        byte[] bArrZzbi = zzgVar.zzbi();
        long jZza = zzg().zza(bArrZzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put("metadata", bArrZzbi);
        try {
            c_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzfk.zza(zzgVar.zzx()), e);
            throw e;
        }
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    public final String zza(long j) throws Throwable {
        Cursor cursorRawQuery;
        zzd();
        zzak();
        ?? r0 = 0;
        try {
            try {
                cursorRawQuery = c_().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf((long) j)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzr().zzx().zza("No expired configs for apps with pending events");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return string;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = j;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    public final long zzaa() {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (cursorRawQuery.moveToFirst()) {
                return cursorRawQuery.getLong(0);
            }
            return -1L;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error querying raw events", e);
            return -1L;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0094  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0091: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0091 */
    public final Pair<com.google.android.gms.internal.measurement.zzbr.zzc, Long> zza(String str, Long l) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzd();
        zzak();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzr().zzx().zza("Main event not found");
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    try {
                        Pair<com.google.android.gms.internal.measurement.zzbr.zzc, Long> pairCreate = Pair.create((com.google.android.gms.internal.measurement.zzbr.zzc) ((com.google.android.gms.internal.measurement.zzfd) ((com.google.android.gms.internal.measurement.zzbr.zzc.zza) zzkw.zza(com.google.android.gms.internal.measurement.zzbr.zzc.zzj(), cursorRawQuery.getBlob(0))).zzu()), Long.valueOf(cursorRawQuery.getLong(1)));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return pairCreate;
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to merge main event. appId, eventId", zzfk.zza(str), l, e);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzr().zzf().zza("Error selecting main event", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final boolean zza(String str, Long l, long j, com.google.android.gms.internal.measurement.zzbr.zzc zzcVar) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzcVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbi = zzcVar.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(bArrZzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(BoxEvent.FIELD_EVENT_ID, l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzfk.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzfk.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzak zzakVar, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzakVar);
        Preconditions.checkNotEmpty(zzakVar.zza);
        com.google.android.gms.internal.measurement.zzbr.zzc.zza zzaVarZzb = com.google.android.gms.internal.measurement.zzbr.zzc.zzj().zzb(zzakVar.zzd);
        for (String str : zzakVar.zze) {
            com.google.android.gms.internal.measurement.zzbr.zze.zza zzaVarZza = com.google.android.gms.internal.measurement.zzbr.zze.zzk().zza(str);
            zzg().zza(zzaVarZza, zzakVar.zze.zza(str));
            zzaVarZzb.zza(zzaVarZza);
        }
        byte[] bArrZzbi = ((com.google.android.gms.internal.measurement.zzbr.zzc) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzb.zzu())).zzbi();
        if (!com.google.android.gms.internal.measurement.zzky.zzb() || !zzt().zze(zzakVar.zza, zzap.zzcz)) {
            zzr().zzx().zza("Saving event, name, data size", zzo().zza(zzakVar.zzb), Integer.valueOf(bArrZzbi.length));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzakVar.zza);
        contentValues.put("name", zzakVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzakVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrZzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzfk.zza(zzakVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzfk.zza(zzakVar.zza), e);
            return false;
        }
    }

    final void zzb(String str, List<com.google.android.gms.internal.measurement.zzbj.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            com.google.android.gms.internal.measurement.zzbj.zza.C0204zza c0204zzaZzbm = list.get(i).zzbm();
            if (c0204zzaZzbm.zzb() != 0) {
                for (int i2 = 0; i2 < c0204zzaZzbm.zzb(); i2++) {
                    com.google.android.gms.internal.measurement.zzbj.zzb.zza zzaVarZzbm = c0204zzaZzbm.zzb(i2).zzbm();
                    com.google.android.gms.internal.measurement.zzbj.zzb.zza zzaVar = (com.google.android.gms.internal.measurement.zzbj.zzb.zza) ((com.google.android.gms.internal.measurement.zzfd.zzb) zzaVarZzbm.clone());
                    String strZzb = zzhj.zzb(zzaVarZzbm.zza());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzaVarZzbm.zzb(); i3++) {
                        com.google.android.gms.internal.measurement.zzbj.zzc zzcVarZza = zzaVarZzbm.zza(i3);
                        String strZza = zzhm.zza(zzcVarZza.zzh());
                        if (strZza != null) {
                            zzaVar.zza(i3, (com.google.android.gms.internal.measurement.zzbj.zzc) ((com.google.android.gms.internal.measurement.zzfd) zzcVarZza.zzbm().zza(strZza).zzu()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        c0204zzaZzbm = c0204zzaZzbm.zza(i2, zzaVar);
                        list.set(i, (com.google.android.gms.internal.measurement.zzbj.zza) ((com.google.android.gms.internal.measurement.zzfd) c0204zzaZzbm.zzu()));
                    }
                }
            }
            if (c0204zzaZzbm.zza() != 0) {
                for (int i4 = 0; i4 < c0204zzaZzbm.zza(); i4++) {
                    com.google.android.gms.internal.measurement.zzbj.zze zzeVarZza = c0204zzaZzbm.zza(i4);
                    String strZza2 = zzhl.zza(zzeVarZza.zzc());
                    if (strZza2 != null) {
                        c0204zzaZzbm = c0204zzaZzbm.zza(i4, zzeVarZza.zzbm().zza(strZza2));
                        list.set(i, (com.google.android.gms.internal.measurement.zzbj.zza) ((com.google.android.gms.internal.measurement.zzfd) c0204zzaZzbm.zzu()));
                    }
                }
            }
        }
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        sQLiteDatabaseC_.beginTransaction();
        try {
            zzak();
            zzd();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseC_2 = c_();
            sQLiteDatabaseC_2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseC_2.delete("event_filters", "app_id=?", new String[]{str});
            for (com.google.android.gms.internal.measurement.zzbj.zza zzaVar2 : list) {
                zzak();
                zzd();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zza()) {
                    zzr().zzi().zza("Audience with no ID. appId", zzfk.zza(str));
                } else {
                    int iZzb = zzaVar2.zzb();
                    Iterator<com.google.android.gms.internal.measurement.zzbj.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzr().zzi().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfk.zza(str), Integer.valueOf(iZzb));
                                break;
                            }
                        } else {
                            Iterator<com.google.android.gms.internal.measurement.zzbj.zze> it2 = zzaVar2.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzr().zzi().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfk.zza(str), Integer.valueOf(iZzb));
                                        break;
                                    }
                                } else {
                                    Iterator<com.google.android.gms.internal.measurement.zzbj.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, iZzb, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<com.google.android.gms.internal.measurement.zzbj.zze> it4 = zzaVar2.zzc().iterator();
                                        while (it4.hasNext()) {
                                            if (!zza(str, iZzb, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzd();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseC_3 = c_();
                                        sQLiteDatabaseC_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                        sQLiteDatabaseC_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.zzbj.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zza() ? Integer.valueOf(zzaVar3.zzb()) : null);
            }
            zzc(str, arrayList);
            sQLiteDatabaseC_.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseC_.endTransaction();
        }
    }

    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }
}
