package com.box.android.domain.localrepo.sqlitetables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxPushNotificationMuteSQLData")
public class BoxPushNotificationMuteSQLData extends BoxTypedObjectSQLData {
    public static final String ITEM_ID_COLUMN_NAME = "itemId";
    public static final String ITEM_TYPE_COLUMN_NAME = "itemType";
    public static final String MUTE_TYPE_COLUMN_NAME = "muteType";

    @DatabaseField(canBeNull = false, columnName = "itemId", index = true)
    private String itemId;

    @DatabaseField(canBeNull = false, columnName = "itemType", index = false)
    private String itemType;

    @DatabaseField(canBeNull = false, columnName = MUTE_TYPE_COLUMN_NAME, index = true)
    private String muteType;

    public BoxPushNotificationMuteSQLData() {
    }

    public BoxPushNotificationMuteSQLData(String str, String str2, String str3) {
        super(str + str2 + str3);
        this.itemId = str;
        this.itemType = str2;
        this.muteType = str3;
    }

    public String getMuteType() {
        return this.muteType;
    }

    public String getItemType() {
        return this.itemType;
    }

    public String getItemId() {
        return this.itemId;
    }
}
