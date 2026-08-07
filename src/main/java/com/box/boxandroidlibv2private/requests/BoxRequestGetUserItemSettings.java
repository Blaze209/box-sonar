package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.dao.BoxUserItemSettings;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetUserItemSettings extends BoxRequest<BoxUserItemSettings, BoxRequestGetUserItemSettings> implements BoxCacheableRequest<BoxUserItemSettings> {
    protected static final String FIELD_ITEM_ID = "item_id";
    protected static final String FIELD_ITEM_TYPE = "item_type";
    public static final String URI = "user_item_settings";

    public enum UserSettingsBoxItemType {
        ITEM_FILE_TYPE("file"),
        ITEM_FOLDER_TYPE("folder");

        private final String value;

        UserSettingsBoxItemType(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    public BoxRequestGetUserItemSettings(String str, String str2, UserSettingsBoxItemType userSettingsBoxItemType, BoxSession boxSession) {
        super(BoxUserItemSettings.class, str, boxSession);
        this.mQueryMap.put("item_id", str2);
        this.mQueryMap.put("item_type", userSettingsBoxItemType.value);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }

    protected BoxRequestGetUserItemSettings(BoxRequestGetInbox boxRequestGetInbox) {
        super(boxRequestGetInbox);
    }

    public static String getUri() {
        return URI;
    }

    public String getFieldItemId() {
        return this.mQueryMap.get("item_id");
    }

    public String getFieldItemType() {
        return this.mQueryMap.get("item_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxUserItemSettings onSend() throws BoxException {
        return (BoxUserItemSettings) super.onSend();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxUserItemSettings sendForCachedResult() throws BoxException {
        return (BoxUserItemSettings) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxUserItemSettings> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}
