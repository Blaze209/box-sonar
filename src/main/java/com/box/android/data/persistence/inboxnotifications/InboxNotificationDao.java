package com.box.android.data.persistence.inboxnotifications;

import com.box.androidsdk.content.models.BoxIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: InboxNotificationDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationDao;", "", "insertNotifications", "", "notifications", "", "Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiNotifications", BoxIterator.FIELD_LIMIT, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReadStatus", "notificationId", "", "isRead", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldNotifications", "olderThanMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface InboxNotificationDao {
    Object deleteOldNotifications(long j, Continuation<? super Unit> continuation);

    Object getApiNotifications(int i, Continuation<? super List<InboxNotificationEntity>> continuation);

    Object insertNotifications(List<InboxNotificationEntity> list, Continuation<? super Unit> continuation);

    Object updateReadStatus(String str, boolean z, Continuation<? super Unit> continuation);
}
