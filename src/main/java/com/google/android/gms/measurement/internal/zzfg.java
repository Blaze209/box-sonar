package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfg extends zze {
    private final zzff zza;
    private boolean zzb;

    zzfg(zzgo zzgoVar) {
        super(zzgoVar);
        this.zza = new zzff(this, zzn(), "google_app_measurement_local.db");
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    public final void zzab() {
        zzb();
        zzd();
        try {
            int iDelete = zzae().delete("messages", null, null);
            if (iDelete > 0) {
                zzr().zzx().zza("Reset local analytics data. records", Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0164  */
    /* JADX WARN: Code duplicated, block: B:104:0x0169  */
    /* JADX WARN: Code duplicated, block: B:111:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x009b A[Catch: all -> 0x005b, SQLiteException -> 0x005e, SQLiteDatabaseLockedException -> 0x0062, SQLiteFullException -> 0x00be, TRY_LEAVE, TryCatch #17 {SQLiteFullException -> 0x00be, blocks: (B:36:0x0077, B:38:0x009b), top: B:117:0x0077 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105 A[Catch: all -> 0x0124, TryCatch #5 {all -> 0x0124, blocks: (B:73:0x00ff, B:75:0x0105, B:76:0x0108), top: B:111:0x00ff }] */
    /* JADX WARN: Code duplicated, block: B:78:0x011b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0120  */
    /* JADX WARN: Code duplicated, block: B:89:0x0133  */
    /* JADX WARN: Code duplicated, block: B:91:0x0138  */
    /* JADX WARN: Code duplicated, block: B:96:0x0152  */
    /* JADX WARN: Code duplicated, block: B:98:0x0157  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r16v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v24 */
    /* JADX WARN: Type inference failed for: r16v25 */
    /* JADX WARN: Type inference failed for: r16v26 */
    /* JADX WARN: Type inference failed for: r16v27 */
    /* JADX WARN: Type inference failed for: r16v28 */
    /* JADX WARN: Type inference failed for: r16v29 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v30 */
    /* JADX WARN: Type inference failed for: r16v31 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    private final boolean zza(int i, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseZzae;
        ?? r16;
        boolean z;
        ?? RawQuery;
        ?? r17;
        long j;
        long j2;
        long jDelete;
        zzb();
        zzd();
        ?? r2 = 0;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 0;
        int i3 = 5;
        for (int i4 = 5; i2 < i4; i4 = 5) {
            ?? r7 = 0;
            r7 = 0;
            r7 = 0;
             = 0;
            ?? r8 = 0;
            r7 = 0;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseZzae = zzae();
                try {
                    if (sQLiteDatabaseZzae == null) {
                        try {
                            this.zzb = true;
                            if (sQLiteDatabaseZzae != null) {
                                sQLiteDatabaseZzae.close();
                            }
                            return r2;
                        } catch (SQLiteFullException e) {
                            e = e;
                            r16 = r2;
                            try {
                                zzr().zzf().zza("Error writing entry; local database full", e);
                                this.zzb = true;
                                if (r7 != 0) {
                                    r7.close();
                                }
                                if (sQLiteDatabaseZzae != null) {
                                    sQLiteDatabaseZzae.close();
                                }
                                i2++;
                                r2 = r16;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                            r17 = r2;
                            RawQuery = 0;
                            z = true;
                            sQLiteDatabase = sQLiteDatabaseZzae;
                            RawQuery = RawQuery;
                            r16 = r17;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabaseZzae = sQLiteDatabase;
                                    r7 = RawQuery;
                                    if (r7 != 0) {
                                        r7.close();
                                    }
                                    if (sQLiteDatabaseZzae != null) {
                                        sQLiteDatabaseZzae.close();
                                    }
                                    throw th;
                                }
                            }
                            zzr().zzf().zza("Error writing entry to local database", e);
                            this.zzb = z;
                            if (RawQuery != 0) {
                                RawQuery.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                            r2 = r16;
                        }
                    } else {
                        try {
                            sQLiteDatabaseZzae.beginTransaction();
                            RawQuery = sQLiteDatabaseZzae.rawQuery("select count(1) from messages", null);
                            if (RawQuery != 0) {
                                try {
                                    try {
                                        try {
                                            if (RawQuery.moveToFirst()) {
                                                j = RawQuery.getLong(r2);
                                            } else {
                                                j = 0;
                                            }
                                            if (j >= SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                                                try {
                                                    zzr().zzf().zza("Data loss, local db full");
                                                    j2 = 100001 - j;
                                                    String[] strArr = new String[1];
                                                    strArr[r2] = Long.toString(j2);
                                                    jDelete = sQLiteDatabaseZzae.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                                                    if (jDelete != j2) {
                                                        r17 = r2;
                                                        try {
                                                            try {
                                                                z = true;
                                                                try {
                                                                    zzr().zzf().zza("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                                                                    r17 = r17;
                                                                } catch (SQLiteFullException e3) {
                                                                    e = e3;
                                                                    r7 = RawQuery;
                                                                    r16 = r17;
                                                                    zzr().zzf().zza("Error writing entry; local database full", e);
                                                                    this.zzb = true;
                                                                    if (r7 != 0) {
                                                                        r7.close();
                                                                    }
                                                                    if (sQLiteDatabaseZzae != null) {
                                                                        sQLiteDatabaseZzae.close();
                                                                    }
                                                                    i2++;
                                                                    r2 = r16;
                                                                } catch (SQLiteException e4) {
                                                                    e = e4;
                                                                    sQLiteDatabase = sQLiteDatabaseZzae;
                                                                    RawQuery = RawQuery;
                                                                    r16 = r17;
                                                                    if (sQLiteDatabase != null) {
                                                                        if (sQLiteDatabase.inTransaction()) {
                                                                            sQLiteDatabase.endTransaction();
                                                                        }
                                                                    }
                                                                    zzr().zzf().zza("Error writing entry to local database", e);
                                                                    this.zzb = z;
                                                                    if (RawQuery != 0) {
                                                                        RawQuery.close();
                                                                    }
                                                                    if (sQLiteDatabase != null) {
                                                                        sQLiteDatabase.close();
                                                                    }
                                                                    i2++;
                                                                    r2 = r16;
                                                                }
                                                            } catch (SQLiteDatabaseLockedException unused) {
                                                                r8 = RawQuery;
                                                                r16 = r17;
                                                                SystemClock.sleep(i3);
                                                                i3 += 20;
                                                                if (r8 != 0) {
                                                                    r8.close();
                                                                }
                                                                if (sQLiteDatabaseZzae != null) {
                                                                    sQLiteDatabaseZzae.close();
                                                                }
                                                                i2++;
                                                                r2 = r16;
                                                            }
                                                        } catch (SQLiteFullException e5) {
                                                            e = e5;
                                                            r17 = r17;
                                                            r7 = RawQuery;
                                                            r16 = r17;
                                                            zzr().zzf().zza("Error writing entry; local database full", e);
                                                            this.zzb = true;
                                                            if (r7 != 0) {
                                                                r7.close();
                                                            }
                                                            if (sQLiteDatabaseZzae != null) {
                                                                sQLiteDatabaseZzae.close();
                                                            }
                                                            i2++;
                                                            r2 = r16;
                                                        } catch (SQLiteException e6) {
                                                            e = e6;
                                                            RawQuery = RawQuery;
                                                            r17 = r17;
                                                            z = true;
                                                            sQLiteDatabase = sQLiteDatabaseZzae;
                                                            RawQuery = RawQuery;
                                                            r16 = r17;
                                                            if (sQLiteDatabase != null) {
                                                                if (sQLiteDatabase.inTransaction()) {
                                                                    sQLiteDatabase.endTransaction();
                                                                }
                                                            }
                                                            zzr().zzf().zza("Error writing entry to local database", e);
                                                            this.zzb = z;
                                                            if (RawQuery != 0) {
                                                                RawQuery.close();
                                                            }
                                                            if (sQLiteDatabase != null) {
                                                                sQLiteDatabase.close();
                                                            }
                                                            i2++;
                                                            r2 = r16;
                                                        }
                                                    } else {
                                                        r17 = r2;
                                                        z = true;
                                                    }
                                                } catch (SQLiteFullException e7) {
                                                    e = e7;
                                                    r17 = r2;
                                                }
                                            } else {
                                                r17 = r2;
                                                z = true;
                                            }
                                            sQLiteDatabaseZzae.insertOrThrow("messages", null, contentValues);
                                            sQLiteDatabaseZzae.setTransactionSuccessful();
                                            sQLiteDatabaseZzae.endTransaction();
                                            if (RawQuery != 0) {
                                                RawQuery.close();
                                            }
                                            if (sQLiteDatabaseZzae != null) {
                                                sQLiteDatabaseZzae.close();
                                            }
                                            return z;
                                        } catch (SQLiteFullException e8) {
                                            e = e8;
                                            r17 = r2;
                                            r7 = RawQuery;
                                            r16 = r17;
                                            zzr().zzf().zza("Error writing entry; local database full", e);
                                            this.zzb = true;
                                            if (r7 != 0) {
                                                r7.close();
                                            }
                                            if (sQLiteDatabaseZzae != null) {
                                                sQLiteDatabaseZzae.close();
                                            }
                                            i2++;
                                            r2 = r16;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        r7 = RawQuery;
                                        if (r7 != 0) {
                                            r7.close();
                                        }
                                        if (sQLiteDatabaseZzae != null) {
                                            sQLiteDatabaseZzae.close();
                                        }
                                        throw th;
                                    }
                                } catch (SQLiteDatabaseLockedException unused2) {
                                    r17 = r2;
                                    r8 = RawQuery;
                                    r16 = r17;
                                    SystemClock.sleep(i3);
                                    i3 += 20;
                                    if (r8 != 0) {
                                        r8.close();
                                    }
                                    if (sQLiteDatabaseZzae != null) {
                                        sQLiteDatabaseZzae.close();
                                    }
                                    i2++;
                                    r2 = r16;
                                } catch (SQLiteException e9) {
                                    e = e9;
                                    r17 = r2;
                                    RawQuery = RawQuery;
                                    z = true;
                                    sQLiteDatabase = sQLiteDatabaseZzae;
                                    RawQuery = RawQuery;
                                    r16 = r17;
                                    if (sQLiteDatabase != null) {
                                        if (sQLiteDatabase.inTransaction()) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                    }
                                    zzr().zzf().zza("Error writing entry to local database", e);
                                    this.zzb = z;
                                    if (RawQuery != 0) {
                                        RawQuery.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    i2++;
                                    r2 = r16;
                                }
                            } else {
                                j = 0;
                                if (j >= SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                                    zzr().zzf().zza("Data loss, local db full");
                                    j2 = 100001 - j;
                                    String[] strArr2 = new String[1];
                                    strArr2[r2] = Long.toString(j2);
                                    jDelete = sQLiteDatabaseZzae.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr2);
                                    if (jDelete != j2) {
                                        r17 = r2;
                                        z = true;
                                        zzr().zzf().zza("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                                        r17 = r17;
                                    } else {
                                        r17 = r2;
                                        z = true;
                                    }
                                } else {
                                    r17 = r2;
                                    z = true;
                                }
                                sQLiteDatabaseZzae.insertOrThrow("messages", null, contentValues);
                                sQLiteDatabaseZzae.setTransactionSuccessful();
                                sQLiteDatabaseZzae.endTransaction();
                                if (RawQuery != 0) {
                                    RawQuery.close();
                                }
                                if (sQLiteDatabaseZzae != null) {
                                    sQLiteDatabaseZzae.close();
                                }
                                return z;
                            }
                        } catch (SQLiteFullException e10) {
                            e = e10;
                            r16 = r2;
                        } catch (SQLiteException e11) {
                            e = e11;
                            r17 = r2;
                            z = true;
                            RawQuery = 0;
                        }
                        if (r7 != 0) {
                            r7.close();
                        }
                        if (sQLiteDatabaseZzae != null) {
                            sQLiteDatabaseZzae.close();
                        }
                        throw th;
                    }
                } catch (SQLiteDatabaseLockedException unused3) {
                    r16 = r2;
                }
            } catch (SQLiteDatabaseLockedException unused4) {
                r16 = r2;
                sQLiteDatabaseZzae = null;
            } catch (SQLiteFullException e12) {
                e = e12;
                r16 = r2;
                sQLiteDatabaseZzae = null;
            } catch (SQLiteException e13) {
                e = e13;
                r16 = r2;
                z = true;
                RawQuery = 0;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseZzae = null;
            }
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                }
            }
            zzr().zzf().zza("Error writing entry to local database", e);
            this.zzb = z;
            if (RawQuery != 0) {
                RawQuery.close();
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            i2++;
            r2 = r16;
        }
        ?? r18 = r2;
        zzr().zzx().zza("Failed to write entry to local database");
        return r18;
    }

    public final boolean zza(zzan zzanVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzanVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 131072) {
            zzr().zzg().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return zza(0, bArrMarshall);
    }

    public final boolean zza(zzkz zzkzVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzkzVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 131072) {
            zzr().zzg().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return zza(1, bArrMarshall);
    }

    public final boolean zza(zzv zzvVar) {
        zzp();
        byte[] bArrZza = zzla.zza((Parcelable) zzvVar);
        if (bArrZza.length > 131072) {
            zzr().zzg().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return zza(2, bArrZza);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01e9 A[Catch: all -> 0x023e, TryCatch #21 {all -> 0x023e, blocks: (B:28:0x00a7, B:30:0x00ad, B:32:0x00bb, B:34:0x00ce, B:36:0x00d3, B:42:0x00ea, B:43:0x00ed, B:41:0x00e6, B:45:0x00f0, B:47:0x0103, B:54:0x011d, B:55:0x0121, B:56:0x0124, B:52:0x0116, B:58:0x0127, B:60:0x013a, B:67:0x0154, B:68:0x0159, B:69:0x015c, B:65:0x014d, B:71:0x015f, B:72:0x016e, B:73:0x017d, B:75:0x0193, B:76:0x01a0, B:107:0x01e3, B:109:0x01e9, B:110:0x01ec, B:125:0x0220, B:117:0x020a), top: B:150:0x01e3 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:114:0x0200  */
    /* JADX WARN: Code duplicated, block: B:120:0x0211  */
    /* JADX WARN: Code duplicated, block: B:122:0x0216  */
    /* JADX WARN: Code duplicated, block: B:127:0x022f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0234  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r10v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r22v1, types: [java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>] */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v17 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final List<AbstractSafeParcelable> zza(int i) throws Throwable {
        ?? Zzae;
        ?? r22;
        ?? Query;
        ?? r5;
        ?? r0;
        int i2;
        ?? r12;
        ?? r13;
        zzd();
        zzb();
        ?? r3 = 0;
        if (this.zzb) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (zzaf()) {
            int i3 = 5;
            int i4 = 0;
            for (int i5 = 5; i4 < i5; i5 = 5) {
                try {
                    Zzae = zzae();
                    try {
                        if (Zzae == 0) {
                            try {
                                this.zzb = true;
                                if (Zzae != 0) {
                                    Zzae.close();
                                }
                                return r3;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } else {
                            try {
                                Zzae.beginTransaction();
                                long j = -1;
                                r22 = r3;
                                if (zzt().zza(zzap.zzbz)) {
                                    try {
                                        long jZza = zza((SQLiteDatabase) Zzae);
                                        if (jZza != -1) {
                                            r0 = "rowid<?";
                                            r5 = new String[]{String.valueOf(jZza)};
                                        } else {
                                            ?? r1 = r22;
                                            r5 = r1;
                                            r0 = r1;
                                        }
                                        ?? r14 = r0;
                                        i2 = 3;
                                        Query = Zzae.query("messages", new String[]{"rowid", "type", "entry"}, r14, r5, null, null, "rowid asc", Integer.toString(100));
                                    } catch (SQLiteDatabaseLockedException unused) {
                                        Query = r22;
                                        SystemClock.sleep(i3);
                                        i3 += 20;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzae != 0) {
                                            Zzae.close();
                                        }
                                        i4++;
                                        r3 = r22;
                                    } catch (SQLiteFullException e) {
                                        e = e;
                                        Query = r22;
                                        zzr().zzf().zza("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzae != 0) {
                                            Zzae.close();
                                        }
                                        i4++;
                                        r3 = r22;
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        Query = r22;
                                        if (Zzae != 0) {
                                            try {
                                                if (Zzae.inTransaction()) {
                                                    Zzae.endTransaction();
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                r3 = Query;
                                            }
                                        }
                                        zzr().zzf().zza("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzae != 0) {
                                            Zzae.close();
                                        }
                                        i4++;
                                        r3 = r22;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        r3 = r22;
                                    }
                                } else {
                                    i2 = 3;
                                    Query = Zzae.query("messages", new String[]{"rowid", "type", "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                                }
                                while (Query.moveToNext()) {
                                    try {
                                        j = Query.getLong(0);
                                        int i6 = Query.getInt(1);
                                        byte[] blob = Query.getBlob(2);
                                        if (i6 == 0) {
                                            Parcel parcelObtain = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain.unmarshall(blob, 0, blob.length);
                                                    parcelObtain.setDataPosition(0);
                                                    zzan zzanVarCreateFromParcel = zzan.CREATOR.createFromParcel(parcelObtain);
                                                    parcelObtain.recycle();
                                                    if (zzanVarCreateFromParcel != null) {
                                                        arrayList.add(zzanVarCreateFromParcel);
                                                    }
                                                } catch (SafeParcelReader.ParseException unused2) {
                                                    zzr().zzf().zza("Failed to load event from local database");
                                                    parcelObtain.recycle();
                                                }
                                            } catch (Throwable th4) {
                                                parcelObtain.recycle();
                                                throw th4;
                                            }
                                        } else if (i6 == 1) {
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain2.unmarshall(blob, 0, blob.length);
                                                    parcelObtain2.setDataPosition(0);
                                                    zzkz zzkzVarCreateFromParcel = zzkz.CREATOR.createFromParcel(parcelObtain2);
                                                    parcelObtain2.recycle();
                                                    r12 = zzkzVarCreateFromParcel;
                                                } catch (SafeParcelReader.ParseException unused3) {
                                                    zzr().zzf().zza("Failed to load user property from local database");
                                                    parcelObtain2.recycle();
                                                    r12 = r22;
                                                }
                                                if (r12 != 0) {
                                                    arrayList.add(r12);
                                                }
                                            } catch (Throwable th5) {
                                                parcelObtain2.recycle();
                                                throw th5;
                                            }
                                        } else if (i6 == 2) {
                                            Parcel parcelObtain3 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain3.unmarshall(blob, 0, blob.length);
                                                    parcelObtain3.setDataPosition(0);
                                                    zzv zzvVarCreateFromParcel = zzv.CREATOR.createFromParcel(parcelObtain3);
                                                    parcelObtain3.recycle();
                                                    r13 = zzvVarCreateFromParcel;
                                                } catch (SafeParcelReader.ParseException unused4) {
                                                    zzr().zzf().zza("Failed to load conditional user property from local database");
                                                    parcelObtain3.recycle();
                                                    r13 = r22;
                                                }
                                                if (r13 != 0) {
                                                    arrayList.add(r13);
                                                }
                                            } catch (Throwable th6) {
                                                parcelObtain3.recycle();
                                                throw th6;
                                            }
                                        } else if (i6 == i2) {
                                            zzr().zzi().zza("Skipping app launch break");
                                        } else {
                                            zzr().zzf().zza("Unknown record type in local database");
                                        }
                                    } catch (SQLiteDatabaseLockedException unused5) {
                                        SystemClock.sleep(i3);
                                        i3 += 20;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzae != 0) {
                                            Zzae.close();
                                        }
                                        i4++;
                                        r3 = r22;
                                    } catch (SQLiteFullException e3) {
                                        e = e3;
                                        zzr().zzf().zza("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzae != 0) {
                                            Zzae.close();
                                        }
                                        i4++;
                                        r3 = r22;
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                        if (Zzae != 0) {
                                            if (Zzae.inTransaction()) {
                                                Zzae.endTransaction();
                                            }
                                        }
                                        zzr().zzf().zza("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzae != 0) {
                                            Zzae.close();
                                        }
                                        i4++;
                                        r3 = r22;
                                    }
                                }
                                if (Zzae.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                                    zzr().zzf().zza("Fewer entries removed from local database than expected");
                                }
                                Zzae.setTransactionSuccessful();
                                Zzae.endTransaction();
                                if (Query != 0) {
                                    Query.close();
                                }
                                if (Zzae != 0) {
                                    Zzae.close();
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        }
                    } catch (SQLiteDatabaseLockedException unused6) {
                        r22 = r3;
                    } catch (SQLiteFullException e5) {
                        e = e5;
                        r22 = r3;
                    } catch (SQLiteException e6) {
                        e = e6;
                        r22 = r3;
                    }
                } catch (SQLiteDatabaseLockedException unused7) {
                    r22 = r3;
                    Query = r22;
                    Zzae = Query;
                } catch (SQLiteFullException e7) {
                    e = e7;
                    r22 = r3;
                    Query = r22;
                    Zzae = Query;
                } catch (SQLiteException e8) {
                    e = e8;
                    r22 = r3;
                    Query = r22;
                    Zzae = Query;
                } catch (Throwable th8) {
                    th = th8;
                    Zzae = r3;
                }
                if (r3 != 0) {
                    r3.close();
                }
                if (Zzae != 0) {
                    Zzae.close();
                }
                throw th;
            }
            ?? r23 = r3;
            zzr().zzi().zza("Failed to read events from database in reasonable time");
            return r23;
        }
        return arrayList;
    }

    public final boolean zzac() {
        return zza(3, new byte[0]);
    }

    public final boolean zzad() {
        zzd();
        zzb();
        if (this.zzb || !zzaf()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseZzae = zzae();
                    if (sQLiteDatabaseZzae == null) {
                        this.zzb = true;
                        if (sQLiteDatabaseZzae != null) {
                            sQLiteDatabaseZzae.close();
                        }
                        return false;
                    }
                    sQLiteDatabaseZzae.beginTransaction();
                    sQLiteDatabaseZzae.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    sQLiteDatabaseZzae.setTransactionSuccessful();
                    sQLiteDatabaseZzae.endTransaction();
                    if (sQLiteDatabaseZzae != null) {
                        sQLiteDatabaseZzae.close();
                    }
                    return true;
                } catch (SQLiteException e) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    zzr().zzf().zza("Error deleting app launch break from local database", e);
                    this.zzb = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteFullException e2) {
                zzr().zzf().zza("Error deleting app launch break from local database", e2);
                this.zzb = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        zzr().zzi().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, null, null, "rowid desc", "1");
            if (cursorQuery.moveToFirst()) {
                return cursorQuery.getLong(0);
            }
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private final SQLiteDatabase zzae() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    private final boolean zzaf() {
        return zzn().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzhp zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfd zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzix zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zziw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfg zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzkc zzk() {
        return super.zzk();
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
