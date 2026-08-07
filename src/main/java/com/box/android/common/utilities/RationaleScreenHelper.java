package com.box.android.common.utilities;

import android.app.NotificationManager;
import android.content.SharedPreferences;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RationaleScreenHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R,\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/box/android/common/utilities/RationaleScreenHelper;", "", "<init>", "()V", "PREF_NAME", "", "FIRST_LAUNCH_TIME", "NOTIFICATION_RATIONALE", "sharedPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSharedPrefs$annotations", "getSharedPrefs", "()Landroid/content/SharedPreferences;", "setSharedPrefs", "(Landroid/content/SharedPreferences;)V", "hasShownRationale", "", "featureName", "setRationaleShown", "", "setFirstLaunchTime", "shouldShowRationale", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RationaleScreenHelper {
    public static final String FIRST_LAUNCH_TIME = "first launch time";
    public static final String NOTIFICATION_RATIONALE = "notification rationale";
    public static final RationaleScreenHelper INSTANCE = new RationaleScreenHelper();
    private static final String PREF_NAME = "feature_rationale_shared_prefs";
    private static SharedPreferences sharedPrefs = ApplicationProvider.getApplication().getSharedPreferences(PREF_NAME, 0);

    public static /* synthetic */ void getSharedPrefs$annotations() {
    }

    private RationaleScreenHelper() {
    }

    public final SharedPreferences getSharedPrefs() {
        return sharedPrefs;
    }

    public final void setSharedPrefs(SharedPreferences sharedPreferences) {
        sharedPrefs = sharedPreferences;
    }

    public final boolean hasShownRationale(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return sharedPrefs.getLong(featureName, -1L) != -1;
    }

    public final void setRationaleShown(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        sharedPrefs.edit().putLong(featureName, new Date().getTime()).apply();
    }

    public final void setFirstLaunchTime() {
        if (sharedPrefs.contains(FIRST_LAUNCH_TIME)) {
            return;
        }
        sharedPrefs.edit().putLong(FIRST_LAUNCH_TIME, new Date().getTime()).apply();
    }

    public final boolean shouldShowRationale(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        if (Intrinsics.areEqual(featureName, NOTIFICATION_RATIONALE)) {
            Object systemService = ApplicationProvider.getApplication().getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            boolean z = new Date().getTime() - sharedPrefs.getLong(FIRST_LAUNCH_TIME, new Date().getTime()) >= TimeUnit.DAYS.toMillis(1L);
            if (!notificationManager.areNotificationsEnabled() && z && !hasShownRationale(featureName)) {
                return true;
            }
        }
        return false;
    }
}
