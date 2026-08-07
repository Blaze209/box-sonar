package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxItem;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxCollectionItem")
public class BoxCollectionItemSQLData extends BoxTypedObjectSQLData {
    public static final String COL_COLLECTION_ID = "collection_id";
    public static final String COL_ITEM_ID = "item_id";
    public static final String COL_ITEM_TYPE = "item_type";

    @DatabaseField(canBeNull = false, index = true)
    private String collection_id;

    @DatabaseField(canBeNull = false, index = true)
    private String item_id;

    @DatabaseField(canBeNull = false, index = true)
    private String item_type;

    public BoxCollectionItemSQLData() {
    }

    public BoxCollectionItemSQLData(String str) {
        super(str);
    }

    public BoxCollectionItemSQLData(BoxItem boxItem, String str) {
        super(boxItem.getType() + "_" + boxItem.getUserId() + "," + str);
        this.item_type = boxItem.getType();
        this.item_id = boxItem.getUserId();
        this.collection_id = str;
    }

    public String getItemType() {
        return this.item_type;
    }

    public String getItemId() {
        return this.item_id;
    }

    public String getCollectionId() {
        return this.collection_id;
    }
}
