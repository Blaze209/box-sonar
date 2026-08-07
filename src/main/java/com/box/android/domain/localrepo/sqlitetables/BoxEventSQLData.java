package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxEvent;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxEvent")
public class BoxEventSQLData extends BoxItemSQLData {
    public static final String COL_CREATED_AT = "created_at";
    public static final String COL_EVENT_OWNER_ID = "event_owner_id";
    public static final String COL_EVENT_TYPE = "event_type";
    public static final String COL_ITEM_USER_DISMISSED = "user_dismissed";

    @DatabaseField(canBeNull = false, index = true)
    private long created_at;

    @DatabaseField(canBeNull = false, index = true)
    private String event_owner_id;

    @DatabaseField(canBeNull = false, index = true)
    private String event_type;

    @DatabaseField(canBeNull = false, index = true)
    private String source_item_id;

    @DatabaseField(canBeNull = false, index = true)
    private String source_item_type;

    @DatabaseField(index = true)
    private boolean user_dismissed;

    public BoxEventSQLData() {
    }

    public BoxEventSQLData(BoxEvent boxEvent) {
        this.id = boxEvent.getEventId();
        this.created_at = boxEvent.getCreatedAt().getTime();
        this.event_type = boxEvent.getEventType();
        this.source_item_type = boxEvent.getSource().getType();
        this.source_item_id = boxEvent.getSource().getUserId();
        this.event_owner_id = boxEvent.getCreatedBy().getUserId();
        this.user_dismissed = false;
        setName("event_" + boxEvent.getEventId());
    }

    public long getCreatedAt() {
        return this.created_at;
    }

    public String getSourceItemType() {
        return this.source_item_type;
    }

    public String getSourceItemId() {
        return this.source_item_id;
    }

    public String getEventType() {
        return this.event_type;
    }

    public String getOwnerId() {
        return this.event_owner_id;
    }

    public void setUserDismissed(boolean z) {
        this.user_dismissed = z;
    }
}
