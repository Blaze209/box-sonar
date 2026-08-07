package com.box.android.data.api.requests;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationActionRequestDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationActionResponseDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationIteratorDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationUnseenCountsDTO;
import com.box.android.data.api.models.inboxnotifications.MarkAllNotificationsAsSeenDTO;
import com.box.android.data.api.models.inboxnotifications.MarkNotificationAsReadDTO;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: InboxNotificationRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0007J:\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u00162\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u0012\u001a\u00020\u001bH§@¢\u0006\u0002\u0010\u001c¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/InboxNotificationRequest;", "", "getUnseenCounts", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUnseenCountsDTO;", "platform", "", "notificationIdStart", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPushNotificationsV2", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationIteratorDTO;", BoxIterator.FIELD_LIMIT, "", "filterEventType", "nextMarker", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markNotificationAsRead", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationDTO;", "notificationId", "body", "Lcom/box/android/data/api/models/inboxnotifications/MarkNotificationAsReadDTO;", "(Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/MarkNotificationAsReadDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAllNotificationsAsSeen", "", "Lcom/box/android/data/api/models/inboxnotifications/MarkAllNotificationsAsSeenDTO;", "(Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/MarkAllNotificationsAsSeenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeAction", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationActionResponseDTO;", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationActionRequestDTO;", "(Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationActionRequestDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface InboxNotificationRequest {
    @POST("notification-center/execute-action")
    Object executeAction(@Body InboxNotificationActionRequestDTO inboxNotificationActionRequestDTO, Continuation<? super InboxNotificationActionResponseDTO> continuation);

    @GET("notification-center/notifications")
    Object getPushNotificationsV2(@Query("platform") String str, @Query(BoxIterator.FIELD_LIMIT) int i, @Query("filterEventType") String str2, @Query("marker") String str3, Continuation<? super InboxNotificationIteratorDTO> continuation);

    @GET("notification-center/notifications-unseen-counts")
    Object getUnseenCounts(@Query("platform") String str, @Query("notificationIdStart") String str2, Continuation<? super InboxNotificationUnseenCountsDTO> continuation);

    @POST("notification-center/notifications/mark-all-as-seen")
    Object markAllNotificationsAsSeen(@Query("platform") String str, @Body MarkAllNotificationsAsSeenDTO markAllNotificationsAsSeenDTO, Continuation<? super Unit> continuation);

    @PATCH("notification-center/notifications/{notificationId}")
    Object markNotificationAsRead(@Path("notificationId") String str, @Body MarkNotificationAsReadDTO markNotificationAsReadDTO, Continuation<? super InboxNotificationDTO> continuation);

    /* JADX INFO: compiled from: InboxNotificationRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getUnseenCounts$default(InboxNotificationRequest inboxNotificationRequest, String str, String str2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUnseenCounts");
        }
        if ((i & 1) != 0) {
            str = "android";
        }
        return inboxNotificationRequest.getUnseenCounts(str, str2, continuation);
    }

    static /* synthetic */ Object getPushNotificationsV2$default(InboxNotificationRequest inboxNotificationRequest, String str, int i, String str2, String str3, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPushNotificationsV2");
        }
        if ((i2 & 1) != 0) {
            str = "android";
        }
        if ((i2 & 2) != 0) {
            i = 20;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return inboxNotificationRequest.getPushNotificationsV2(str, i, str2, (i2 & 8) != 0 ? null : str3, continuation);
    }

    static /* synthetic */ Object markAllNotificationsAsSeen$default(InboxNotificationRequest inboxNotificationRequest, String str, MarkAllNotificationsAsSeenDTO markAllNotificationsAsSeenDTO, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markAllNotificationsAsSeen");
        }
        if ((i & 1) != 0) {
            str = "android";
        }
        return inboxNotificationRequest.markAllNotificationsAsSeen(str, markAllNotificationsAsSeenDTO, continuation);
    }
}
