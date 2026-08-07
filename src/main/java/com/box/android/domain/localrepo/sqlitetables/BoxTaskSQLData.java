package com.box.android.domain.localrepo.sqlitetables;

import com.box.boxandroidlibv2private.model.BoxTask;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxTasks")
public class BoxTaskSQLData extends BoxTypedObjectSQLData {
    public static final String COLLABORATOR_ROLE_NAME = "collaborator_role_name";
    public static final String CREATED_AT_COLUMN_NAME = "created_at";
    public static final String ITEM_ID_COLUMN_NAME = "item_id";
    public static final String STATUS_COLUMN_NAME = "status";

    @DatabaseField(canBeNull = false, columnName = COLLABORATOR_ROLE_NAME, index = true)
    private String collaboratorRoleName;

    @DatabaseField(canBeNull = false, columnName = "created_at", index = true)
    private Date created_at;

    @DatabaseField(canBeNull = false, columnName = "item_id")
    private String item_id;

    @DatabaseField(canBeNull = false, index = true)
    private String item_type;

    @DatabaseField(canBeNull = false, columnName = "status", index = true)
    private String status;

    public BoxTaskSQLData() {
    }

    public BoxTaskSQLData(String str, String str2, Date date, String str3, String str4) {
        super(str2 + "_" + str + "_" + str3);
        this.collaboratorRoleName = str3;
        this.created_at = date;
        this.status = str4;
        this.item_id = str;
        this.item_type = str2;
    }

    public BoxTaskSQLData(BoxTask boxTask, String str) {
        this(boxTask.getUserId(), boxTask.getType(), boxTask.getCreatedAt(), str, boxTask.getStatus());
    }

    public String getCreatedById() {
        return this.collaboratorRoleName;
    }

    public Date getCreatedAt() {
        return this.created_at;
    }

    public String getStatus() {
        return this.status;
    }

    public String getItemId() {
        return this.item_id;
    }

    public String getItemType() {
        return this.item_type;
    }
}
