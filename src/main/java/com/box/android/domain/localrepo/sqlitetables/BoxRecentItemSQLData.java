package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxRecentItem;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxRecentItems")
public class BoxRecentItemSQLData extends BoxTypedObjectSQLData {
    public static final String INTERACTED_AT_COLUMN_NAME = "interacted_at";
    public static final String INTERACTION_SHARED_LINK_COLUMN_NAME = "interaction_shared_link";
    public static final String INTERACTION_TYPE_COLUMN_NAME = "interaction_type";
    public static final String ITEM_ID_COLUMN_NAME = "item_id";
    public static final String ITEM_TYPE_COLUMN_NAME = "item_type";
    public static final String OFFLINE_COLUMN_NAME = "offline";

    @DatabaseField(canBeNull = false, columnName = "interacted_at", index = true)
    private Date interacted_at;

    @DatabaseField
    private String interaction_shared_link;

    @DatabaseField(canBeNull = false, columnName = "interaction_type", index = true)
    private String interaction_type;

    @DatabaseField(canBeNull = false, columnName = "item_id")
    private String item_id;

    @DatabaseField(canBeNull = false, index = true)
    private String item_type;

    @DatabaseField(canBeNull = false, columnName = OFFLINE_COLUMN_NAME, defaultValue = "false")
    private Boolean offline;

    public BoxRecentItemSQLData() {
    }

    public BoxRecentItemSQLData(String str, String str2, Date date, String str3, String str4) {
        super(str2 + "_" + str);
        this.interacted_at = date;
        this.interaction_type = str3;
        this.interaction_shared_link = str4;
        this.item_id = str;
        this.item_type = str2;
        this.offline = false;
    }

    public BoxRecentItemSQLData(BoxRecentItem boxRecentItem) {
        super(boxRecentItem.getItem().getType() + "_" + boxRecentItem.getItem().getUserId());
        this.interaction_type = boxRecentItem.getInteractionType();
        this.interacted_at = boxRecentItem.getInteractedAt();
        this.interaction_shared_link = boxRecentItem.getInteractionSharedLink();
        this.item_id = boxRecentItem.getItem().getUserId();
        this.item_type = boxRecentItem.getItem().getType();
        this.offline = false;
    }

    public String getInteractionType() {
        return this.interaction_type;
    }

    public Date getInteractedAt() {
        return this.interacted_at;
    }

    public String getInteractionSharedLink() {
        return this.interaction_shared_link;
    }

    public String getItemId() {
        return this.item_id;
    }

    public String getItemType() {
        return this.item_type;
    }

    public boolean isOffline() {
        return this.offline.booleanValue();
    }

    public void setOffline(boolean z) {
        this.offline = Boolean.valueOf(z);
    }
}
