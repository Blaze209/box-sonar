package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxMetadata extends BoxJsonObject {
    public static final String FIELD_PARENT = "parent";
    public static final String FIELD_SCOPE = "scope";
    public static final String FIELD_TEMPLATE = "template";

    public BoxMetadata() {
    }

    public BoxMetadata(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getParent() {
        return getPropertyAsString("parent");
    }

    public String getTemplate() {
        return getPropertyAsString(FIELD_TEMPLATE);
    }

    public String getScope() {
        return getPropertyAsString("scope");
    }
}
