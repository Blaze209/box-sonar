package com.box.android.base.presentation.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.content.ContextCompat;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.RationaleScreenKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.RationaleScreenHelper;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationPermissionRationaleActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/activities/NotificationPermissionRationaleActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "initialRationaleStatus", "", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "requestPermissionLauncher", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "redirectUserToSystemSettings", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class NotificationPermissionRationaleActivity extends Hilt_NotificationPermissionRationaleActivity {
    public static final int $stable = 8;
    private boolean initialRationaleStatus = true;
    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            NotificationPermissionRationaleActivity.activityResultLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity$$ExternalSyntheticLambda2
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            NotificationPermissionRationaleActivity.requestPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
        }
    });

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activityResultLauncher$lambda$0(NotificationPermissionRationaleActivity notificationPermissionRationaleActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        notificationPermissionRationaleActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$0(NotificationPermissionRationaleActivity notificationPermissionRationaleActivity, boolean z) {
        if (!notificationPermissionRationaleActivity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS") && !notificationPermissionRationaleActivity.initialRationaleStatus && !z) {
            notificationPermissionRationaleActivity.redirectUserToSystemSettings();
        } else {
            notificationPermissionRationaleActivity.finish();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        this.initialRationaleStatus = shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS");
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            finish();
        } else {
            RationaleScreenHelper.INSTANCE.setRationaleShown(RationaleScreenHelper.NOTIFICATION_RATIONALE);
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-317822847, true, new Function2() { // from class: com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationPermissionRationaleActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final NotificationPermissionRationaleActivity notificationPermissionRationaleActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@2647L910,65@2638L919:NotificationPermissionRationaleActivity.kt#cqq7cd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-317822847, i, -1, "com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity.onCreate.<anonymous> (NotificationPermissionRationaleActivity.kt:65)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1053865804, true, new Function2() { // from class: com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationPermissionRationaleActivity.onCreate$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final NotificationPermissionRationaleActivity notificationPermissionRationaleActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C67@2734L509,77@3283L242,66@2665L878:NotificationPermissionRationaleActivity.kt#cqq7cd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1053865804, i, -1, "com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity.onCreate.<anonymous>.<anonymous> (NotificationPermissionRationaleActivity.kt:66)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -847240919, "CC(remember):NotificationPermissionRationaleActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(notificationPermissionRationaleActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationPermissionRationaleActivity.onCreate$lambda$0$0$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -847223618, "CC(remember):NotificationPermissionRationaleActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(notificationPermissionRationaleActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationPermissionRationaleActivity.onCreate$lambda$0$0$1$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            RationaleScreenKt.NotificationRationaleScreen(function0, (Function0) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0$0(NotificationPermissionRationaleActivity notificationPermissionRationaleActivity) {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_NOTIFICATION_RATIONALE_ACCEPTED);
        if (!CommonBoxUtil.isAtLeastVersion(33)) {
            notificationPermissionRationaleActivity.redirectUserToSystemSettings();
        } else {
            notificationPermissionRationaleActivity.requestPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$1$0(NotificationPermissionRationaleActivity notificationPermissionRationaleActivity) {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_NOTIFICATION_RATIONALE_DENIED);
        notificationPermissionRationaleActivity.finish();
        return Unit.INSTANCE;
    }

    private final void redirectUserToSystemSettings() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.addFlags(268435456);
        intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        this.activityResultLauncher.launch(intent);
    }
}
