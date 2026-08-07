package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.inboxnotifications.InboxNotificationActionResponseModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationIteratorModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUnseenCountsModel;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IInboxNotificationService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\tJF\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0013\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0014J,\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\tJ*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\t¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IInboxNotificationService;", "", "getUnseenCounts", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUnseenCountsModel;", "Lcom/box/android/domain/models/DomainError;", "platform", "", "notificationIdStart", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInboxNotifications", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationIteratorModel;", BoxIterator.FIELD_LIMIT, "", "filterEventType", "nextMarker", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markNotificationAsRead", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "notificationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAllNotificationsAsSeen", "", "lastNotificationId", "executeAction", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationActionResponseModel;", "actionId", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IInboxNotificationService {
    Object executeAction(String str, String str2, Continuation<? super Result<InboxNotificationActionResponseModel, ? extends DomainError>> continuation);

    Object getInboxNotifications(String str, int i, String str2, String str3, Continuation<? super Result<InboxNotificationIteratorModel, ? extends DomainError>> continuation);

    Object getUnseenCounts(String str, String str2, Continuation<? super Result<InboxNotificationUnseenCountsModel, ? extends DomainError>> continuation);

    Object markAllNotificationsAsSeen(String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object markNotificationAsRead(String str, Continuation<? super Result<InboxNotificationModel, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: IInboxNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getUnseenCounts$default(IInboxNotificationService iInboxNotificationService, String str, String str2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUnseenCounts");
        }
        if ((i & 1) != 0) {
            str = "android";
        }
        return iInboxNotificationService.getUnseenCounts(str, str2, continuation);
    }

    static /* synthetic */ Object getInboxNotifications$default(IInboxNotificationService iInboxNotificationService, String str, int i, String str2, String str3, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInboxNotifications");
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
        return iInboxNotificationService.getInboxNotifications(str, i, str2, (i2 & 8) != 0 ? null : str3, continuation);
    }

    static /* synthetic */ Object markAllNotificationsAsSeen$default(IInboxNotificationService iInboxNotificationService, String str, String str2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markAllNotificationsAsSeen");
        }
        if ((i & 2) != 0) {
            str2 = "android";
        }
        return iInboxNotificationService.markAllNotificationsAsSeen(str, str2, continuation);
    }
}
