package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxFolder;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxFolder")
public class BoxFolderSQLData extends BoxItemSQLData {
    public BoxFolderSQLData() {
    }

    public BoxFolderSQLData(String str) {
        super(str);
    }

    public BoxFolderSQLData(BoxFolder boxFolder) {
        super(boxFolder);
    }
}
