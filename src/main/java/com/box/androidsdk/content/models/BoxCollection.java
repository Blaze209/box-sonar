package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxCollection extends BoxEntity {
    public static final String FIELD_COLLECTION_TYPE = "collection_type";
    public static final String FIELD_NAME = "name";
    public static final String TYPE = "collection";

    public BoxCollection() {
    }

    public BoxCollection(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static BoxCollection createFromId(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", str);
        return new BoxCollection(jsonObject);
    }

    public String getName() {
        return getPropertyAsString("name");
    }

    public String getCollectionType() {
        return getPropertyAsString("collection_type");
    }
}
