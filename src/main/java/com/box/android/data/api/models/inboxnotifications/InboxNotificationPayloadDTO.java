package com.box.android.data.api.models.inboxnotifications;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\b\b\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "Lcom/box/android/data/api/models/inboxnotifications/AtMentionPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/CollabInvitePayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/CommentPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/CommonPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/EditFilePayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/NotifyCollabPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/SendSharedLinkPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/TaskUpdatedPayloadDTOInbox;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class InboxNotificationPayloadDTO {
    public /* synthetic */ InboxNotificationPayloadDTO(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getType();

    private InboxNotificationPayloadDTO() {
    }
}
