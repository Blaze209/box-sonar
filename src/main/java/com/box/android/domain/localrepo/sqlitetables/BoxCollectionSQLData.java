package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxCollection")
public class BoxCollectionSQLData extends BoxTypedObjectSQLData {
    public static final String COL_COLLECTION_TYPE = "collection_type";
    public static final String COL_NAME = "name";

    @DatabaseField(canBeNull = true, index = true)
    private String collection_type;

    @DatabaseField(canBeNull = false, index = true)
    private String name;

    public BoxCollectionSQLData() {
    }

    public BoxCollectionSQLData(String str) {
        super(str);
    }

    public BoxCollectionSQLData(BoxCollection boxCollection) {
        super(boxCollection);
        this.name = boxCollection.getName();
        this.collection_type = boxCollection.getCollectionType();
    }

    public String getName() {
        return this.name;
    }

    public String getCollectionType() {
        return this.collection_type;
    }
}
