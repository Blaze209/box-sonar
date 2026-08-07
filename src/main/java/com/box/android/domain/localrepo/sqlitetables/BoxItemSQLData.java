package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxItemUtility;
import com.j256.ormlite.field.DatabaseField;

/* JADX INFO: loaded from: classes11.dex */
public abstract class BoxItemSQLData extends BoxTypedObjectSQLData {
    public static final String COL_MODIFIED_AT = "modified_at";
    public static final String COL_NAME = "name";
    public static final String COL_PARENT_ID = "parent_id";
    public static final String COL_SIZE = "size";

    @DatabaseField(index = true)
    private long modified_at;

    @DatabaseField(canBeNull = false, index = true)
    private String name;

    @DatabaseField(index = true)
    private String parent_id;

    @DatabaseField(index = true)
    private double size;

    protected BoxItemSQLData() {
    }

    protected BoxItemSQLData(String str) {
        super(str);
    }

    protected BoxItemSQLData(BoxItem boxItem) {
        super(boxItem);
        this.name = boxItem.getName();
        BoxFolder itemParentFolder = BoxItemUtility.getItemParentFolder(boxItem);
        if (itemParentFolder != null) {
            this.parent_id = itemParentFolder.getUserId();
        }
        if (boxItem.getModifiedAt() != null) {
            this.modified_at = boxItem.getModifiedAt().getTime();
        }
        if (boxItem.getSize() != null) {
            this.size = boxItem.getSize().longValue();
        }
    }

    public BoxItemSQLData setParentId(String str) {
        this.parent_id = str;
        return this;
    }

    public String getParentId() {
        return this.parent_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
