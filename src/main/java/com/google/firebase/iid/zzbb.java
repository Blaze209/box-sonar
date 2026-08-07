package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@20.1.0 */
/* JADX INFO: loaded from: classes14.dex */
final class zzbb {
    private static final long zzb = TimeUnit.DAYS.toMillis(7);
    final String zza;
    private final String zzc;
    private final long zzd;

    private zzbb(String str, String str2, long j) {
        this.zza = str;
        this.zzc = str2;
        this.zzd = j;
    }

    static zzbb zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new zzbb(jSONObject.getString("token"), jSONObject.getString(RemoteConfigConstants.RequestFieldKey.APP_VERSION), jSONObject.getLong("timestamp"));
            } catch (JSONException e) {
                String strValueOf = String.valueOf(e);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Failed to parse token: ").append(strValueOf).toString());
                return null;
            }
        }
        return new zzbb(str, null, 0L);
    }

    static String zza(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String strValueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(strValueOf).length() + 24).append("Failed to encode token: ").append(strValueOf).toString());
            return null;
        }
    }

    static String zza(zzbb zzbbVar) {
        if (zzbbVar == null) {
            return null;
        }
        return zzbbVar.zza;
    }

    final boolean zzb(String str) {
        return System.currentTimeMillis() > this.zzd + zzb || !str.equals(this.zzc);
    }
}
