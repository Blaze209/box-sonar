package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxUser;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxUser")
public class BoxUserSQLData extends BoxTypedObjectSQLData {
    public static final String COL_USER_NAME = "user_name";

    @DatabaseField(canBeNull = false, index = true)
    private String user_name;

    public BoxUserSQLData() {
    }

    public BoxUserSQLData(BoxUser boxUser) {
        super(boxUser);
        this.user_name = boxUser.getUserName();
    }

    public String getUserName() {
        return this.user_name;
    }
}
