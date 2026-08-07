package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.microsoft.intune.mam.client.app.MAMNotificationManagement;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@20.1.1 */
/* JADX INFO: loaded from: classes14.dex */
final class zzd {
    private final Executor zza;
    private final Context zzb;
    private final zzn zzc;

    public zzd(Context context, zzn zznVar, Executor executor) {
        this.zza = executor;
        this.zzb = context;
        this.zzc = zznVar;
    }

    final boolean zza() {
        if (this.zzc.zzb("gcm.n.noui")) {
            return true;
        }
        if (!((KeyguardManager) this.zzb.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10L);
            }
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.zzb.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (runningAppProcessInfo.importance != 100) {
                            break;
                        }
                        return false;
                    }
                }
            }
        }
        zzm zzmVarZza = zzm.zza(this.zzc.zza("gcm.n.image"));
        if (zzmVarZza != null) {
            zzmVarZza.zza(this.zza);
        }
        zza zzaVarZza = zzb.zza(this.zzb, this.zzc);
        NotificationCompat.Builder builder = zzaVarZza.zza;
        if (zzmVarZza != null) {
            try {
                Bitmap bitmap = (Bitmap) Tasks.await(zzmVarZza.zza(), 5L, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                zzmVarZza.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                String strValueOf = String.valueOf(e.getCause());
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(strValueOf).length() + 26).append("Failed to download image: ").append(strValueOf).toString());
            } catch (TimeoutException unused2) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                zzmVarZza.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        MAMNotificationManagement.notify((NotificationManager) this.zzb.getSystemService("notification"), zzaVarZza.zzb, 0, zzaVarZza.zza.build());
        return true;
    }
}
