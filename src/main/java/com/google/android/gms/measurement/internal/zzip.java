package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzip implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zziq zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzin zzf;

    public zzip(zzin zzinVar, String str, URL url, byte[] bArr, Map<String, String> map, zziq zziqVar) {
        this.zzf = zzinVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zziqVar);
        this.zza = url;
        this.zzb = null;
        this.zzc = zziqVar;
        this.zzd = str;
        this.zze = null;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnectionZza;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        this.zzf.zzc();
        int responseCode = 0;
        try {
            httpURLConnectionZza = this.zzf.zza(this.zza);
            try {
                Map<String, String> map3 = this.zze;
                if (map3 != null) {
                    for (Map.Entry<String, String> entry : map3.entrySet()) {
                        httpURLConnectionZza.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                responseCode = httpURLConnectionZza.getResponseCode();
                Map<String, List<String>> headerFields = httpURLConnectionZza.getHeaderFields();
                try {
                    zzin zzinVar = this.zzf;
                    byte[] bArrZza = zzin.zza(httpURLConnectionZza);
                    if (httpURLConnectionZza != null) {
                        httpURLConnectionZza.disconnect();
                    }
                    zzb(responseCode, null, bArrZza, headerFields);
                } catch (IOException e) {
                    map2 = headerFields;
                    e = e;
                    if (httpURLConnectionZza != null) {
                        httpURLConnectionZza.disconnect();
                    }
                    zzb(responseCode, e, null, map2);
                } catch (Throwable th) {
                    map = headerFields;
                    th = th;
                    if (httpURLConnectionZza != null) {
                        httpURLConnectionZza.disconnect();
                    }
                    zzb(responseCode, null, null, map);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                map2 = null;
            } catch (Throwable th2) {
                th = th2;
                map = null;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnectionZza = null;
            map2 = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnectionZza = null;
            map = null;
        }
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.zzf.zzq().zza(new Runnable(this, i, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.zzis
            private final zzip zza;
            private final int zzb;
            private final Exception zzc;
            private final byte[] zzd;
            private final Map zze;

            {
                this.zza = this;
                this.zzb = i;
                this.zzc = exc;
                this.zzd = bArr;
                this.zze = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
