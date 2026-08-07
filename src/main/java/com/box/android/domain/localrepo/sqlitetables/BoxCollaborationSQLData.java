package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxCollaboration;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxCollaboration")
public class BoxCollaborationSQLData extends BoxTypedObjectSQLData {
    public static final String COL_ITEM_ID = "item_id";
    public static final String COL_ITEM_TYPE = "item_type";

    @DatabaseField(canBeNull = false, index = true)
    private String item_id;

    @DatabaseField(canBeNull = false, index = true)
    private String item_type;

    public BoxCollaborationSQLData() {
    }

    public BoxCollaborationSQLData(BoxCollaboration boxCollaboration) {
        super(boxCollaboration);
    }

    public String getItemType() {
        return this.item_type;
    }

    public String getItemId() {
        return this.item_id;
    }
}
