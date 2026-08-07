package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;

/* JADX INFO: loaded from: classes11.dex */
public abstract class BoxTypedObjectSQLData extends BaseDaoEnabled {
    public static final String ID_COLUMN_NAME = "id";

    @DatabaseField(id = true)
    protected String id;

    protected BoxTypedObjectSQLData() {
    }

    protected BoxTypedObjectSQLData(String str) {
        this.id = str;
    }

    protected BoxTypedObjectSQLData(BoxEntity boxEntity) {
        this.id = boxEntity.getId();
    }

    public String getId() {
        return this.id;
    }
}
