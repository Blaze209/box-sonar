package com.box.android.base;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationSQLData;
import com.microsoft.intune.mam.client.app.MAMNotificationManagement;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNotificationManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0006\u0010\u001c\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0007J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\fH\u0007J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0007J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/box/android/base/BoxNotificationManager;", "", "<init>", "()V", "DIAGNOSTICS_CHANNEL_ID", "", "RECORDER_CHANNEL_ID", "TRANSFERS_CHANNEL_ID", "UPDATES_CHANNEL_ID", "COMMENTS_CHANNEL_ID", "COLLABORATIONS_CHANNEL_ID", "RECORDER_NOTIF_ID", "", "DIAGNOSTICS_NOTIF_ID", "SUCCESSFULLY_COMPLETED_ITEMS_ID", "STARTING_ONGOING_NOTIF_ID", "notificationManager", "Landroid/app/NotificationManager;", "mapOfIdToNameAndImportance", "", "Lkotlin/Pair;", "setNotificationManager", "", "loggedNotifIds", "", "getLoggedNotifIds$annotations", "getLoggedNotifIds", "()Ljava/util/Set;", "createDiagnosticsChannel", "createAllChannels", "notify", BoxPushNotificationSQLData.NOTIF_ID_COLUMN_NAME, "notification", "Landroid/app/Notification;", "cancel", "logIfNotificationWasBlocked", "getUSChannelNameForId", "channelID", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNotificationManager {
    public static final int $stable;
    public static final String COLLABORATIONS_CHANNEL_ID = "collaborationsChannelId";
    public static final String COMMENTS_CHANNEL_ID = "commentsChannelId";
    public static final String DIAGNOSTICS_CHANNEL_ID = "DiagnosisNotifChannel";
    public static final int DIAGNOSTICS_NOTIF_ID = 100;
    public static final BoxNotificationManager INSTANCE = new BoxNotificationManager();
    public static final String RECORDER_CHANNEL_ID = "RecorderServiceChannel";
    public static final int RECORDER_NOTIF_ID = 1;
    public static final int STARTING_ONGOING_NOTIF_ID = 102;
    public static final int SUCCESSFULLY_COMPLETED_ITEMS_ID = 101;
    public static final String TRANSFERS_CHANNEL_ID = "transfersChannelId";
    public static final String UPDATES_CHANNEL_ID = "updatesChannelId";
    private static final Set<Integer> loggedNotifIds;
    private static final Map<String, Pair<String, Integer>> mapOfIdToNameAndImportance;
    private static NotificationManager notificationManager;

    public static /* synthetic */ void getLoggedNotifIds$annotations() {
    }

    private BoxNotificationManager() {
    }

    static {
        Object systemService = ApplicationProvider.getApplication().getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        notificationManager = (NotificationManager) systemService;
        mapOfIdToNameAndImportance = MapsKt.mapOf(TuplesKt.to(RECORDER_CHANNEL_ID, new Pair("audio_recording_channel_name", 2)), TuplesKt.to(TRANSFERS_CHANNEL_ID, new Pair("transfers_notification_category", 2)), TuplesKt.to(UPDATES_CHANNEL_ID, new Pair("notification_channel_general", 1)), TuplesKt.to(COMMENTS_CHANNEL_ID, new Pair("notification_channel_activity", 2)), TuplesKt.to(COLLABORATIONS_CHANNEL_ID, new Pair("notification_channel_sharing", 2)));
        loggedNotifIds = new LinkedHashSet();
        $stable = 8;
    }

    public final void setNotificationManager(NotificationManager notificationManager2) {
        Intrinsics.checkNotNullParameter(notificationManager2, "notificationManager");
        notificationManager = notificationManager2;
    }

    public final Set<Integer> getLoggedNotifIds() {
        return loggedNotifIds;
    }

    public final void createDiagnosticsChannel() {
        notificationManager.createNotificationChannel(new NotificationChannel(DIAGNOSTICS_CHANNEL_ID, CommonBoxUtil.LS(CommonBoxUtil.getStringResIdByName("diagnostics_notification_category")), 4));
    }

    @JvmStatic
    public static final void createAllChannels() {
        Map<String, Pair<String, Integer>> map = mapOfIdToNameAndImportance;
        final Function2 function2 = new Function2() { // from class: com.box.android.base.BoxNotificationManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BoxNotificationManager.createAllChannels$lambda$0((String) obj, (Pair) obj2);
            }
        };
        map.forEach(new BiConsumer() { // from class: com.box.android.base.BoxNotificationManager$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                function2.invoke(obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createAllChannels$lambda$0(String channelId, Pair pair) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        String str = (String) pair.component1();
        notificationManager.createNotificationChannel(new NotificationChannel(channelId, CommonBoxUtil.LS(CommonBoxUtil.getStringResIdByName(str)), ((Number) pair.component2()).intValue()));
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void notify(int notifId, Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        Set<Integer> set = loggedNotifIds;
        if (!set.contains(Integer.valueOf(notifId))) {
            logIfNotificationWasBlocked(notification);
            set.add(Integer.valueOf(notifId));
        }
        MAMNotificationManagement.notify(notificationManager, notifId, notification);
    }

    @JvmStatic
    public static final void cancel(int notifId) {
        loggedNotifIds.remove(Integer.valueOf(notifId));
        notificationManager.cancel(notifId);
    }

    @JvmStatic
    public static final void logIfNotificationWasBlocked(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(notification.getChannelId());
        boolean z = !notificationManager.areNotificationsEnabled() || notificationChannel.getImportance() == 0;
        String id = notificationChannel.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        String uSChannelNameForId = getUSChannelNameForId(id);
        if (z) {
            BoxAmplitudeAnalytics.createNotifBlockedEventPropertyBuilder().setNotifCategory(uSChannelNameForId).logEvent();
        }
    }

    @JvmStatic
    public static final String getUSChannelNameForId(String channelID) {
        String first;
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Pair<String, Integer> pair = mapOfIdToNameAndImportance.get(channelID);
        if (pair == null || (first = pair.getFirst()) == null) {
            return "unknown";
        }
        return CommonBoxUtil.getUSLocaleString(CommonBoxUtil.getStringResIdByName(first));
    }
}
