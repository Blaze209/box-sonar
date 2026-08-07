package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import java.util.Date;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRecentItem extends BoxJsonObject {
    public static final String FIELD_INTERACTED_AT = "interacted_at";
    public static final String FIELD_INTERACTION_TYPE = "interaction_type";
    protected static final String FIELD_ITEM = "item";
    public static final String FIELD_ITERACTION_SHARED_LINK = "interaction_shared_link";
    private static final String TYPE = "recent_item";
    private static final long serialVersionUID = -2642748896882484887L;

    public BoxRecentItem() {
    }

    public BoxRecentItem(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getType() {
        return getPropertyAsString(TYPE);
    }

    public BoxItem getItem() {
        return (BoxItem) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), "item");
    }

    public String getInteractionType() {
        return getPropertyAsString("interaction_type");
    }

    public Date getInteractedAt() {
        return getPropertyAsDate("interacted_at");
    }

    public String getInteractionSharedLink() {
        return getPropertyAsString("interaction_shared_link");
    }
}
