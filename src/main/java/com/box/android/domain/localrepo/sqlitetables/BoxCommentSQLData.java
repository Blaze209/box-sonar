package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxComment")
public class BoxCommentSQLData extends BoxTypedObjectSQLData {
    public static final String COL_CREATED_AT = "created_at";
    public static final String COL_ITEM_ID = "item_id";
    public static final String COL_ITEM_TYPE = "item_type";

    @DatabaseField(canBeNull = true, index = true)
    private String created_at;

    @DatabaseField(canBeNull = false, index = true)
    private String item_id;

    @DatabaseField(canBeNull = false, index = true)
    private String item_type;

    public BoxCommentSQLData() {
    }

    public BoxCommentSQLData(BoxComment boxComment) {
        super(boxComment);
        this.created_at = BoxDateFormat.format(boxComment.getCreatedAt());
        this.item_type = boxComment.getItem().getType();
        this.item_id = boxComment.getItem().getUserId();
    }

    public String getItemType() {
        return this.item_type;
    }

    public String getItemId() {
        return this.item_id;
    }

    public String getCreatedAt() {
        return this.created_at;
    }
}
