package com.box.android.observability;

import android.content.Context;
import android.content.Intent;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.BoxNotificationManager;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationSQLData;
import com.box.android.domain.usecases.observability.CreateLogArchiveInteractor;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DiagnosticsNotificationHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/observability/DiagnosticsNotificationHandler;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "observabilitySettingsManager", "Lcom/box/android/observability/ObservabilitySettingsManager;", "getObservabilitySettingsManager", "()Lcom/box/android/observability/ObservabilitySettingsManager;", "setObservabilitySettingsManager", "(Lcom/box/android/observability/ObservabilitySettingsManager;)V", "createLogArchiveInteractor", "Lcom/box/android/domain/usecases/observability/CreateLogArchiveInteractor;", "getCreateLogArchiveInteractor", "()Lcom/box/android/domain/usecases/observability/CreateLogArchiveInteractor;", "setCreateLogArchiveInteractor", "(Lcom/box/android/domain/usecases/observability/CreateLogArchiveInteractor;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "cancelNotification", BoxPushNotificationSQLData.NOTIF_ID_COLUMN_NAME, "", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class DiagnosticsNotificationHandler extends Hilt_DiagnosticsNotificationHandler {
    private static final String EXTRA_ACTION = "notifAction";
    private static final String EXTRA_NOTIF_ID = "notifIId";
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new CoroutineName("javaClass")));

    @Inject
    public CreateLogArchiveInteractor createLogArchiveInteractor;

    @Inject
    public ObservabilitySettingsManager observabilitySettingsManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final ObservabilitySettingsManager getObservabilitySettingsManager() {
        ObservabilitySettingsManager observabilitySettingsManager = this.observabilitySettingsManager;
        if (observabilitySettingsManager != null) {
            return observabilitySettingsManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilitySettingsManager");
        return null;
    }

    public final void setObservabilitySettingsManager(ObservabilitySettingsManager observabilitySettingsManager) {
        Intrinsics.checkNotNullParameter(observabilitySettingsManager, "<set-?>");
        this.observabilitySettingsManager = observabilitySettingsManager;
    }

    public final CreateLogArchiveInteractor getCreateLogArchiveInteractor() {
        CreateLogArchiveInteractor createLogArchiveInteractor = this.createLogArchiveInteractor;
        if (createLogArchiveInteractor != null) {
            return createLogArchiveInteractor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("createLogArchiveInteractor");
        return null;
    }

    public final void setCreateLogArchiveInteractor(CreateLogArchiveInteractor createLogArchiveInteractor) {
        Intrinsics.checkNotNullParameter(createLogArchiveInteractor, "<set-?>");
        this.createLogArchiveInteractor = createLogArchiveInteractor;
    }

    @Override // com.box.android.observability.Hilt_DiagnosticsNotificationHandler, com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(Context context, Intent intent) {
        super.onMAMReceive(context, intent);
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(EXTRA_ACTION) : null;
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.box.android.observability.DiagnosisNotifManager.NOTIF_ACTIONS");
        DiagnosisNotifManager.NOTIF_ACTIONS notif_actions = (DiagnosisNotifManager.NOTIF_ACTIONS) serializableExtra;
        int intExtra = intent.getIntExtra(EXTRA_NOTIF_ID, -1);
        if (notif_actions != DiagnosisNotifManager.NOTIF_ACTIONS.EXIT) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new DiagnosticsNotificationHandler$onReceive$1(this, context, null), 3, null);
            return;
        }
        getObservabilitySettingsManager().disableDiagnosisMode();
        cancelNotification(intExtra);
        BoxAnalytics.trackEvent$default(BoxAnalytics.INSTANCE, "observability", BoxAnalyticsParams.ACTION_EXIT_DIAGNOSTICS_MODE, "", null, 8, null);
    }

    private final void cancelNotification(int notifId) {
        BoxNotificationManager.cancel(notifId);
    }

    /* JADX INFO: compiled from: DiagnosticsNotificationHandler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/observability/DiagnosticsNotificationHandler$Companion;", "", "<init>", "()V", "EXTRA_NOTIF_ID", "", "EXTRA_ACTION", "getIntent", "Landroid/content/Intent;", "notificationId", "", DiagnosticsNotificationHandler.EXTRA_ACTION, "Lcom/box/android/observability/DiagnosisNotifManager$NOTIF_ACTIONS;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(int notificationId, DiagnosisNotifManager.NOTIF_ACTIONS notifAction) {
            Intrinsics.checkNotNullParameter(notifAction, "notifAction");
            Intent intent = new Intent(BoxBaseApplication.getInstance(), (Class<?>) DiagnosticsNotificationHandler.class);
            intent.putExtra(DiagnosticsNotificationHandler.EXTRA_NOTIF_ID, notificationId);
            intent.putExtra(DiagnosticsNotificationHandler.EXTRA_ACTION, notifAction);
            return intent;
        }
    }
}
