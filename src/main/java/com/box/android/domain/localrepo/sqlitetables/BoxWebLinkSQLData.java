package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxBookmark;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxWebLink")
public class BoxWebLinkSQLData extends BoxItemSQLData {
    public static final String COL_URL = "url";

    @DatabaseField(canBeNull = false, index = true)
    private String url;

    public BoxWebLinkSQLData() {
    }

    public BoxWebLinkSQLData(String str) {
        super(str);
    }

    public BoxWebLinkSQLData(BoxBookmark boxBookmark) {
        super(boxBookmark);
        if (getName() == null) {
            setName("");
        }
        String url = boxBookmark.getUrl();
        this.url = url;
        if (url == null) {
            this.url = "";
        }
    }

    public String getUrl() {
        return this.url;
    }
}
