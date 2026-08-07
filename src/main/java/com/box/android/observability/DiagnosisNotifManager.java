package com.box.android.observability;

import android.app.Notification;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.box.android.R;
import com.box.android.application.BoxApplication;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.BoxNotificationManager;
import com.box.android.domain.jobs.JobConstants;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiagnosisNotifManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/box/android/observability/DiagnosisNotifManager;", "", "<init>", "()V", JobConstants.SHOW_NOTIFICATION, "", "notification", "Landroid/app/Notification;", "NOTIF_ACTIONS", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DiagnosisNotifManager {
    public static final int $stable = 0;
    public static final int DEFAULT_TIMEOUT_DURATION_H = 12;
    private static final long TIMEOUT_DURATION = 43200000;

    /* JADX INFO: compiled from: DiagnosisNotifManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/observability/DiagnosisNotifManager$NOTIF_ACTIONS;", "", "<init>", "(Ljava/lang/String;I)V", "SEND_LOGS", "EXIT", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum NOTIF_ACTIONS {
        SEND_LOGS,
        EXIT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<NOTIF_ACTIONS> getEntries() {
            return $ENTRIES;
        }
    }

    public final void showNotification() {
        BoxBaseApplication boxApplication = BoxApplication.getInstance();
        BoxBaseApplication boxBaseApplication = boxApplication;
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder(BoxApplication.getInstance(), BoxNotificationManager.DIAGNOSTICS_CHANNEL_ID).setSmallIcon(2131231969).setContentTitle(BoxApplication.getInstance().getResources().getString(R.string.diagnosis_mode_notif_title)).setContentText(BoxApplication.getInstance().getResources().getString(R.string.diagnostics_notification_content)).setStyle(new NotificationCompat.BigTextStyle().bigText(BoxApplication.getInstance().getResources().getString(R.string.diagnostics_notification_content))).setPriority(2).setColor(ContextCompat.getColor(boxBaseApplication, R.color.box_blue)).setTimeoutAfter(43200000L).setOngoing(true);
        Intrinsics.checkNotNullExpressionValue(ongoing, "setOngoing(...)");
        ongoing.addAction(0, boxApplication.getResources().getString(R.string.exit), MAMPendingIntent.getBroadcast(boxBaseApplication, 100, DiagnosticsNotificationHandler.INSTANCE.getIntent(100, NOTIF_ACTIONS.EXIT), 1140850688)).addAction(0, boxApplication.getResources().getString(R.string.send_logs), MAMPendingIntent.getBroadcast(boxBaseApplication, 100, DiagnosticsNotificationHandler.INSTANCE.getIntent(100, NOTIF_ACTIONS.SEND_LOGS), 335544320));
        Notification notificationBuild = ongoing.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        showNotification(notificationBuild);
    }

    private final void showNotification(Notification notification) {
        BoxNotificationManager.INSTANCE.createDiagnosticsChannel();
        BoxNotificationManager.notify(100, notification);
    }
}
