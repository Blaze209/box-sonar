package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxIteratorUploadSessionParts extends BoxIterator<BoxUploadSessionPart> {
    private static final long serialVersionUID = -4986339348447936122L;
    private transient BoxJsonObject.BoxJsonObjectCreator<BoxUploadSessionPart> partsCreator;

    public BoxIteratorUploadSessionParts() {
    }

    public BoxIteratorUploadSessionParts(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxUploadSessionPart> getObjectCreator() {
        BoxJsonObject.BoxJsonObjectCreator<BoxUploadSessionPart> boxJsonObjectCreator = this.partsCreator;
        if (boxJsonObjectCreator != null) {
            return boxJsonObjectCreator;
        }
        BoxJsonObject.BoxJsonObjectCreator<BoxUploadSessionPart> boxJsonObjectCreator2 = BoxJsonObject.getBoxJsonObjectCreator(BoxUploadSessionPart.class);
        this.partsCreator = boxJsonObjectCreator2;
        return boxJsonObjectCreator2;
    }
}
