package com.box.android.domain.localrepo.sqlitetables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxRecentFile")
public class BoxRecentFileSQLData extends BoxTypedObjectSQLData {
    public static final String COL_ITEM_ID = "item_id";
    public static final String COL_ITEM_TSTAMP = "timestamp";
    public static final String COL_ITEM_TYPE = "item_type";
    public static final String COL_ITEM_USER_DISMISSED = "user_dismissed";
    public static final int MAX_POOL_SIZE = 100;
    public static final int MAX_TABLE_SIZE = 500;

    @DatabaseField(canBeNull = false, index = true)
    private String item_id;

    @DatabaseField(canBeNull = false, index = true)
    private String item_type;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private BoxFileSQLData recent_item;

    @DatabaseField(index = true)
    private long timestamp;

    @DatabaseField(index = true)
    private boolean user_dismissed;

    public BoxRecentFileSQLData() {
    }

    public BoxRecentFileSQLData(BoxFileSQLData boxFileSQLData, long j) {
        super(createTypedId(boxFileSQLData));
        this.item_id = boxFileSQLData.getId();
        this.item_type = "file";
        this.timestamp = j;
        this.user_dismissed = false;
        this.recent_item = boxFileSQLData;
    }

    private static String createTypedId(BoxFileSQLData boxFileSQLData) {
        return "file_" + boxFileSQLData.getId();
    }

    public String getItemId() {
        return this.item_id;
    }

    public String getItemType() {
        return this.item_type;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setUserDismissed(boolean z) {
        this.user_dismissed = z;
    }
}
