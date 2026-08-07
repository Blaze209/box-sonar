package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxFile;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxFile")
public class BoxFileSQLData extends BoxItemSQLData {
    public BoxFileSQLData() {
    }

    public BoxFileSQLData(String str) {
        super(str);
    }

    public BoxFileSQLData(BoxFile boxFile) {
        super(boxFile);
    }
}
