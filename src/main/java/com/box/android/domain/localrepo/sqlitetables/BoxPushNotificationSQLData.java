package com.box.android.domain.localrepo.sqlitetables;

import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxPushNotificationSQLData")
public class BoxPushNotificationSQLData extends BoxTypedObjectSQLData {
    public static final String EVENT_TIME_COLUMN_NAME = "eventTime";
    public static final String EVENT_TYPE_COLUMN_NAME = "notifType";
    public static final String ITEM_ID_COLUMN_NAME = "itemId";
    public static final String ITEM_TYPE_COLUMN_NAME = "itemType";
    public static final String NOTIF_ID_COLUMN_NAME = "notifId";

    @DatabaseField(canBeNull = false, columnName = EVENT_TIME_COLUMN_NAME, index = true)
    private long eventTime;

    @DatabaseField(canBeNull = false, columnName = "itemId", index = true)
    private String itemId;

    @DatabaseField(canBeNull = false, columnName = "itemType", index = false)
    private String itemType;

    @DatabaseField(canBeNull = false, columnName = NOTIF_ID_COLUMN_NAME, index = false)
    private String notifId;

    @DatabaseField(canBeNull = false, columnName = EVENT_TYPE_COLUMN_NAME, index = true)
    private String notifType;

    public BoxPushNotificationSQLData() {
    }

    public BoxPushNotificationSQLData(String str, String str2, String str3, String str4, long j) {
        super(str);
        this.itemId = str2;
        this.notifId = str;
        this.itemType = str3;
        this.notifType = str4;
        this.eventTime = j;
    }

    public BoxPushNotificationSQLData(BoxPushNotification boxPushNotification) {
        this(boxPushNotification.getUserId(), boxPushNotification.getTargetResourceId(), boxPushNotification.getTargetResourceType(), boxPushNotification.getNotifTypeString(), getBestNotifTime(boxPushNotification).longValue());
    }

    public static Long getBestNotifTime(BoxPushNotification boxPushNotification) {
        return boxPushNotification.getModifiedAt() != null ? Long.valueOf(boxPushNotification.getModifiedAt().getTime()) : boxPushNotification.getSentTime();
    }

    public String getNotifType() {
        return this.notifType;
    }

    public String getNotifId() {
        return this.notifId;
    }

    public String getItemType() {
        return this.itemType;
    }

    public String getItemId() {
        return this.itemId;
    }

    public long getEventTime() {
        return this.eventTime;
    }
}
