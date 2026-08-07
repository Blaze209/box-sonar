package com.microsoft.intune.mam.client.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.content.pm.PackageManagerCompat;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class AppUtils {
    public static final String DEFAULT_PACKAGE_VERSION = "1.0";
    private static final String EDGE_PACKAGE_NAME = "com.microsoft.emmx";
    private static final String ROBOLECTRIC_TEST_BUILD_FINGERPRINT = "robolectric";
    private static final long SLEEP_BEFORE_FORCE_KILL_MS = 10000;
    private static final String TODO_PACKAGE_NAME = "com.microsoft.todos";
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(AppUtils.class);
    private static String sProcessName = null;
    private static final Pattern EDGE_GPU_PROCESS = Pattern.compile("com.microsoft.emmx.*:privileged_process[0123]");

    public static final void endProcess(Activity[] activityArr) {
        LOGGER.info("Ending process", new Object[0]);
        for (final Activity activity : activityArr) {
            if (!activity.isFinishing()) {
                Objects.requireNonNull(activity);
                activity.runOnUiThread(new Runnable() { // from class: com.microsoft.intune.mam.client.app.AppUtils$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        activity.finish();
                    }
                });
            }
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread() && activityArr.length > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.microsoft.intune.mam.client.app.AppUtils$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Process.killProcess(Process.myPid());
                }
            });
            new Thread(new Runnable() { // from class: com.microsoft.intune.mam.client.app.AppUtils$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AppUtils.lambda$endProcess$1();
                }
            }, "Intune MAM endProcess watchdog").start();
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    static /* synthetic */ void lambda$endProcess$1() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            LOGGER.error(MAMInterfaceError.PROCESS_TERMINATION_INTERRUPTED, "interrupted while waiting for process to terminate", e);
        }
        Process.killProcess(Process.myPid());
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        return getPackageInfo(context, str, 0L);
    }

    public static PackageInfo getPackageInfo(Context context, String str, long j) {
        try {
            return PackageManagerCompat.getPackageInfo(context.getPackageManager(), str, j);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String getPackageVersion(Context context, String str) {
        return getPackageVersion(context, str, "1.0");
    }

    public static String getPackageVersion(Context context, String str, String str2) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        return packageInfo != null ? packageInfo.versionName : str2;
    }

    public static long getPackageVersionCode(Context context) {
        return getPackageVersionCode(context, context.getPackageName());
    }

    public static long getPackageVersionCode(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo == null) {
            return 0L;
        }
        return packageInfo.getLongVersionCode();
    }

    public static boolean isPrimaryProcess(Context context) {
        return context.getPackageName().equals(getCurrentProcessName(context));
    }

    public static synchronized String getCurrentProcessName(Context context) {
        String str = sProcessName;
        if (str != null) {
            return str;
        }
        String processName = Application.getProcessName();
        sProcessName = processName;
        return processName;
    }

    public static ActivityManager.RunningServiceInfo getServiceProcessInfo(Context context, int i) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices == null) {
            return null;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (runningServiceInfo.pid == i) {
                return runningServiceInfo;
            }
        }
        return null;
    }

    public static ActivityManager.RunningAppProcessInfo getAppProcessInfo(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo;
            }
        }
        return null;
    }

    public static boolean isAllowedNonMAMProcess(Context context) {
        if (!isEdgePackage(context) && !MAMInfo.allowIsolatedProcesses()) {
            return false;
        }
        try {
            ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            return isEdgeGpuProcess(getCurrentProcessName(context));
        } catch (NullPointerException e) {
            if (isRobolectricTestRun()) {
                return false;
            }
            LOGGER.severe("Failed to determine if this process is isolated.", e);
            throw e;
        } catch (SecurityException unused) {
            return true;
        }
    }

    public static boolean isEdgeGpuProcess(String str) {
        if (str == null) {
            return false;
        }
        return EDGE_GPU_PROCESS.matcher(str).matches();
    }

    private static boolean isRobolectricTestRun() {
        return ROBOLECTRIC_TEST_BUILD_FINGERPRINT.equalsIgnoreCase(Build.FINGERPRINT);
    }

    public static boolean isEdgePackage(Context context) {
        String packageName = context.getPackageName();
        return packageName != null && packageName.startsWith(EDGE_PACKAGE_NAME);
    }

    public static boolean isToDoPackage(Context context) {
        String packageName = context.getPackageName();
        return packageName != null && packageName.startsWith(TODO_PACKAGE_NAME);
    }

    private AppUtils() {
    }
}
