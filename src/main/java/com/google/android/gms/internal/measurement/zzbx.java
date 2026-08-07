package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzbx implements zzcb {
    private static final Map<Uri, zzbx> zza = new ArrayMap();
    private static final String[] zzh = {"key", "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private final ContentObserver zzd;
    private final Object zze;
    private volatile Map<String, String> zzf;
    private final List<zzcc> zzg;

    private zzbx(ContentResolver contentResolver, Uri uri) {
        zzbz zzbzVar = new zzbz(this, null);
        this.zzd = zzbzVar;
        this.zze = new Object();
        this.zzg = new ArrayList();
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, zzbzVar);
    }

    public static zzbx zza(ContentResolver contentResolver, Uri uri) {
        zzbx zzbxVar;
        synchronized (zzbx.class) {
            Map<Uri, zzbx> map = zza;
            zzbxVar = map.get(uri);
            if (zzbxVar == null) {
                try {
                    zzbx zzbxVar2 = new zzbx(contentResolver, uri);
                    try {
                        map.put(uri, zzbxVar2);
                    } catch (SecurityException unused) {
                    }
                    zzbxVar = zzbxVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzbxVar;
    }

    public final Map<String, String> zza() {
        Map<String, String> mapZze = this.zzf;
        if (mapZze == null) {
            synchronized (this.zze) {
                mapZze = this.zzf;
                if (mapZze == null) {
                    mapZze = zze();
                    this.zzf = mapZze;
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }

    public final void zzb() {
        synchronized (this.zze) {
            this.zzf = null;
            zzcl.zza();
        }
        synchronized (this) {
            Iterator<zzcc> it = this.zzg.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return (Map) zzce.zza(new zzcd(this) { // from class: com.google.android.gms.internal.measurement.zzca
                private final zzbx zza;

                {
                    this.zza = this;
                }

                @Override // com.google.android.gms.internal.measurement.zzcd
                public final Object zza() {
                    return this.zza.zzd();
                }
            });
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static synchronized void zzc() {
        for (zzbx zzbxVar : zza.values()) {
            zzbxVar.zzb.unregisterContentObserver(zzbxVar.zzd);
        }
        zza.clear();
    }

    @Override // com.google.android.gms.internal.measurement.zzcb
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    final /* synthetic */ Map zzd() {
        Map map;
        Cursor cursorQuery = MAMContentResolverManagement.query(this.zzb, this.zzc, zzh, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return map;
        } finally {
            cursorQuery.close();
        }
    }
}
