package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxUserNotificationCategories;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUpdateUserNotificationCategories extends BoxRequest<BoxUserNotificationCategories, BoxRequestUpdateUserNotificationCategories> implements BoxCacheableRequest<BoxUserNotificationCategories> {
    protected static final String FIELD_NOTIFICATION_FLAG = "is_notification_enabled";
    public static final String URI = "settings/users/notification_categories";
    private NotificationCategories requestCategory;

    public enum NotificationCategories {
        CATEGORY_SHARING("SHARING"),
        CATEGORY_MENTIONS("MENTIONS"),
        CATEGORY_TASKS("TASKS"),
        CATEGORY_RELEVANT_UPDATES("RELEVANT_UPDATES");

        private final String value;

        NotificationCategories(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    public BoxRequestUpdateUserNotificationCategories(String str, NotificationCategories notificationCategories, boolean z, BoxSession boxSession) {
        super(BoxUserNotificationCategories.class, str, boxSession);
        this.requestCategory = notificationCategories;
        this.mBodyMap.put(notificationCategories.value, BoxUserNotificationCategories.createFromNotificationStatus(z));
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    protected BoxRequestUpdateUserNotificationCategories(BoxRequestGetInbox boxRequestGetInbox) {
        super(boxRequestGetInbox);
    }

    public static String getUri() {
        return "settings/users/notification_categories";
    }

    public BoxUserNotificationCategories.BoxUserNotificationCategory getNotificationCategorySetting() {
        return (BoxUserNotificationCategories.BoxUserNotificationCategory) this.mBodyMap.get(this.requestCategory.value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxUserNotificationCategories onSend() throws BoxException {
        return (BoxUserNotificationCategories) super.onSend();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxUserNotificationCategories> boxResponse) throws BoxException {
        super.handleUpdateCache(boxResponse);
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxUserNotificationCategories sendForCachedResult() throws BoxException {
        return (BoxUserNotificationCategories) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}
