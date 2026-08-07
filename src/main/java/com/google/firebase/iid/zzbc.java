package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@20.1.0 */
/* JADX INFO: loaded from: classes14.dex */
final class zzbc {
    private int zza = 0;
    private final Map<Integer, TaskCompletionSource<Void>> zzb = new ArrayMap();
    private final zzay zzc;

    zzbc(zzay zzayVar) {
        this.zzc = zzayVar;
    }

    final synchronized Task<Void> zza(String str) {
        String strZza;
        TaskCompletionSource<Void> taskCompletionSource;
        synchronized (this.zzc) {
            strZza = this.zzc.zza();
            this.zzc.zza(new StringBuilder(String.valueOf(strZza).length() + 1 + String.valueOf(str).length()).append(strZza).append(",").append(str).toString());
        }
        taskCompletionSource = new TaskCompletionSource<>();
        this.zzb.put(Integer.valueOf(this.zza + (TextUtils.isEmpty(strZza) ? 0 : strZza.split(",").length - 1)), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    final synchronized boolean zza() {
        return zzb() != null;
    }

    final boolean zza(FirebaseInstanceId firebaseInstanceId) throws IOException {
        TaskCompletionSource<Void> taskCompletionSourceRemove;
        while (true) {
            synchronized (this) {
                String strZzb = zzb();
                if (strZzb == null) {
                    if (FirebaseInstanceId.zzd()) {
                        Log.d("FirebaseInstanceId", "topic sync succeeded");
                    }
                    return true;
                }
                if (!zza(firebaseInstanceId, strZzb)) {
                    return false;
                }
                synchronized (this) {
                    taskCompletionSourceRemove = this.zzb.remove(Integer.valueOf(this.zza));
                    zzb(strZzb);
                    this.zza++;
                }
                if (taskCompletionSourceRemove != null) {
                    taskCompletionSourceRemove.setResult(null);
                }
            }
        }
    }

    private final String zzb() {
        String strZza;
        synchronized (this.zzc) {
            strZza = this.zzc.zza();
        }
        if (TextUtils.isEmpty(strZza)) {
            return null;
        }
        String[] strArrSplit = strZza.split(",");
        if (strArrSplit.length <= 1 || TextUtils.isEmpty(strArrSplit[1])) {
            return null;
        }
        return strArrSplit[1];
    }

    private final synchronized boolean zzb(String str) {
        synchronized (this.zzc) {
            String strZza = this.zzc.zza();
            String strValueOf = String.valueOf(",");
            String strValueOf2 = String.valueOf(str);
            if (!strZza.startsWith(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf))) {
                return false;
            }
            String strValueOf3 = String.valueOf(",");
            String strValueOf4 = String.valueOf(str);
            this.zzc.zza(strZza.substring((strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3)).length()));
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    private static boolean zza(FirebaseInstanceId firebaseInstanceId, String str) throws IOException {
        byte b;
        String[] strArrSplit = str.split("!");
        if (strArrSplit.length == 2) {
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            try {
                int iHashCode = str2.hashCode();
                if (iHashCode != 83) {
                    if (iHashCode == 85 && str2.equals("U")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str2.equals(ExifInterface.LATITUDE_SOUTH)) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    firebaseInstanceId.zzb(str3);
                    if (FirebaseInstanceId.zzd()) {
                        Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                    }
                } else if (b == 1) {
                    firebaseInstanceId.zzc(str3);
                    if (FirebaseInstanceId.zzd()) {
                        Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                    }
                }
            } catch (IOException e) {
                if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                    String message = e.getMessage();
                    Log.e("FirebaseInstanceId", new StringBuilder(String.valueOf(message).length() + 53).append("Topic operation failed: ").append(message).append(". Will retry Topic operation.").toString());
                    return false;
                }
                if (e.getMessage() == null) {
                    Log.e("FirebaseInstanceId", "Topic operation failed without exception message. Will retry Topic operation.");
                    return false;
                }
                throw e;
            }
        }
        return true;
    }
}
