package com.box.android.updates.force;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.metrics.ForceUpdateObservability;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.updates.force.analytics.ForceUpdateAnalytics;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: ForceUpdateActionHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/updates/force/ForceUpdateActionHandler;", "", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "observability", "Lcom/box/android/domain/metrics/ForceUpdateObservability;", "analytics", "Lcom/box/android/updates/force/analytics/ForceUpdateAnalytics;", "<init>", "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lcom/box/android/domain/metrics/ForceUpdateObservability;Lcom/box/android/updates/force/analytics/ForceUpdateAnalytics;)V", "resumeIfUpdateInProgress", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "resumeIfUpdateInProgress$app_updates_generalProdRelease", "isUpdateInProgress", "", BoxRepresentation.FIELD_INFO, "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "startUpdate", "startUpdate$app_updates_generalProdRelease", "isImmediateUpdateAvailable", "isImmediateUpdateAvailable$app_updates_generalProdRelease", "openGooglePlayFromDialog", "openGooglePlayFromDialog$app_updates_generalProdRelease", "openGooglePlay", "openGooglePlay$app_updates_generalProdRelease", "closeApp", "closeApp$app_updates_generalProdRelease", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateActionHandler {
    public static final int $stable = 8;
    private final ForceUpdateAnalytics analytics;
    private final AppUpdateManager appUpdateManager;
    private final ForceUpdateObservability observability;

    @Inject
    public ForceUpdateActionHandler(AppUpdateManager appUpdateManager, ForceUpdateObservability observability, ForceUpdateAnalytics analytics) {
        Intrinsics.checkNotNullParameter(appUpdateManager, "appUpdateManager");
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.appUpdateManager = appUpdateManager;
        this.observability = observability;
        this.analytics = analytics;
    }

    public final void resumeIfUpdateInProgress$app_updates_generalProdRelease(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new ForceUpdateActionHandler$resumeIfUpdateInProgress$1(this, activity, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isUpdateInProgress(AppUpdateInfo info) {
        return info.updateAvailability() == 3;
    }

    public final void startUpdate$app_updates_generalProdRelease(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BoxLogUtils.d(ExtensionsKt.getTAG(this), "Starting update flow");
        this.analytics.forceUpdateDialogUpdateTapped();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new ForceUpdateActionHandler$startUpdate$1(this, activity, null), 3, null);
    }

    public final boolean isImmediateUpdateAvailable$app_updates_generalProdRelease(AppUpdateInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return (info.updateAvailability() == 2) && info.isUpdateTypeAllowed(1);
    }

    public final void openGooglePlayFromDialog$app_updates_generalProdRelease(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.analytics.forceUpdateDialogGooglePlayTapped();
        openGooglePlay$app_updates_generalProdRelease(activity);
    }

    public final void openGooglePlay$app_updates_generalProdRelease(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String packageName = activity.getPackageName();
        BoxLogUtils.d(ExtensionsKt.getTAG(this), "Opening Google Play");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
            intent.setPackage("com.android.vending");
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "Google Play app not found, falling back to web", e);
            this.observability.logGooglePlayWebFallback();
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BoxCommonConstants.BOX_PLAY_STORE_URL)));
        }
    }

    public final void closeApp$app_updates_generalProdRelease(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BoxLogUtils.d(ExtensionsKt.getTAG(this), "User closed the app from force update dialog");
        this.analytics.forceUpdateDialogCloseAppTapped();
        activity.finishAffinity();
    }
}
