package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxIteratorTaskCollaborators extends BoxIterator<BoxTaskCollaborator> {
    public static final String FIELD_ENTRIES = "entries";
    protected static final String NEXT_MARKER = "next_marker";
    private static final long serialVersionUID = 162672968096321134L;
    private BoxJsonObject.BoxJsonObjectCreator<BoxTaskCollaborator> mObjectCreator;

    public BoxIteratorTaskCollaborators() {
    }

    public BoxIteratorTaskCollaborators(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxTaskCollaborator> getObjectCreator() {
        if (this.mObjectCreator == null) {
            this.mObjectCreator = BoxJsonObject.getBoxJsonObjectCreator(BoxTaskCollaborator.class);
        }
        return this.mObjectCreator;
    }

    public int getLimit() {
        return getPropertyAsInt(BoxIterator.FIELD_LIMIT).intValue();
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public String getNextMarker() {
        return getPropertyAsString("next_marker");
    }
}
