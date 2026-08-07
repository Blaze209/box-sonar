package sdk.pendo.io.s7;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class l {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cpuUsage", Float.toString(l()));
            jSONObject.put("cpuCount", Integer.toString(j()));
            jSONObject.put("availableMemory", Long.toString(e()));
            jSONObject.put("appUsedMemorySize", Long.toString(d()));
            jSONObject.put("appFreeMemorySize", Long.toString(b()));
            jSONObject.put("appTotalMemorySize", Long.toString(c()));
            jSONObject.put("systemUpTime", Long.toString(k()));
            jSONObject.put("batterUsage", Float.toString(f()));
            jSONObject.put("networkType", i());
            jSONObject.put("deviceOrientation", g());
            return jSONObject;
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return jSONObject;
        }
    }

    public static long b() {
        try {
            return Runtime.getRuntime().freeMemory();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return 0L;
        }
    }

    public static long c() {
        try {
            return Runtime.getRuntime().totalMemory();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return 0L;
        }
    }

    public static long d() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return runtime.totalMemory() - runtime.freeMemory();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return -1L;
        }
    }

    public static long e() {
        return h().availMem / 1048576;
    }

    public static float f() {
        int intExtra;
        int intExtra2;
        Intent intentRegisterReceiver = PendoInternal.o().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            intExtra2 = intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            intExtra = intentRegisterReceiver.getIntExtra("scale", -1);
        } else {
            intExtra = -1;
            intExtra2 = -1;
        }
        if (intExtra2 == -1 || intExtra == -1) {
            return 0.0f;
        }
        return (intExtra2 / intExtra) * 100.0f;
    }

    public static String g() {
        return s0.a(PendoInternal.o().getResources().getConfiguration().orientation);
    }

    private static ActivityManager.MemoryInfo h() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) PendoInternal.o().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String i() {
        switch (((TelephonyManager) PendoInternal.o().getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkType()) {
            case 0:
                return "Unknown";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO rev. 0";
            case 6:
                return "EVDO rev. A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "EVDO rev. B";
            case 13:
                return "LTE";
            case 14:
                return "eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            default:
                return "Unknown network type";
        }
    }

    public static int j() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static long k() {
        return SystemClock.uptimeMillis();
    }

    public static float l() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            try {
                String[] strArrSplit = randomAccessFile.readLine().split(" ");
                long j = Long.parseLong(strArrSplit[5]);
                long j2 = Long.parseLong(strArrSplit[2]) + Long.parseLong(strArrSplit[3]) + Long.parseLong(strArrSplit[4]) + Long.parseLong(strArrSplit[6]) + Long.parseLong(strArrSplit[7]) + Long.parseLong(strArrSplit[8]);
                try {
                    Thread.sleep(360L);
                } catch (Exception e) {
                    PendoLogger.i(e, e.getMessage(), new Object[0]);
                }
                randomAccessFile.seek(0L);
                String[] strArrSplit2 = randomAccessFile.readLine().split(" ");
                long j3 = Long.parseLong(strArrSplit2[5]);
                long j4 = Long.parseLong(strArrSplit2[2]) + Long.parseLong(strArrSplit2[3]) + Long.parseLong(strArrSplit2[4]) + Long.parseLong(strArrSplit2[6]) + Long.parseLong(strArrSplit2[7]) + Long.parseLong(strArrSplit2[8]);
                float f = (j4 - j2) / ((j4 + j3) - (j2 + j));
                randomAccessFile.close();
                return f;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (IOException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
            return 0.0f;
        }
    }
}
