package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxJsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxIteratorTaskLinks extends BoxIterator<BoxTaskLink> {
    public static final String FIELD_ENTRIES = "entries";
    protected static final String NEXT_MARKER = "next_marker";
    private static final long serialVersionUID = 162672968096321133L;
    private BoxJsonObject.BoxJsonObjectCreator<BoxTaskLink> mTaskLinkCreator;

    @Override // com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxTaskLink> getObjectCreator() {
        if (this.mTaskLinkCreator == null) {
            this.mTaskLinkCreator = BoxJsonObject.getBoxJsonObjectCreator(BoxTaskLink.class);
        }
        return this.mTaskLinkCreator;
    }

    public int getLimit() {
        return getPropertyAsInt(BoxIterator.FIELD_LIMIT).intValue();
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    public String getNextMarker() {
        return getPropertyAsString("next_marker");
    }
}
