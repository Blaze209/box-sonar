package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class BoxIteratorRepresentations extends BoxIterator<BoxRepresentation> {
    private static final long serialVersionUID = -4986439348667936122L;
    private transient BoxJsonObject.BoxJsonObjectCreator<BoxRepresentation> representationCreator;

    @Override // com.box.androidsdk.content.models.BoxIterator
    @Deprecated
    public Long fullSize() {
        return null;
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    @Deprecated
    public ArrayList<BoxOrder> getSortOrders() {
        return null;
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    @Deprecated
    public Long limit() {
        return null;
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    @Deprecated
    public Long offset() {
        return null;
    }

    public BoxIteratorRepresentations() {
    }

    public BoxIteratorRepresentations(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxRepresentation> getObjectCreator() {
        BoxJsonObject.BoxJsonObjectCreator<BoxRepresentation> boxJsonObjectCreator = this.representationCreator;
        if (boxJsonObjectCreator != null) {
            return boxJsonObjectCreator;
        }
        BoxJsonObject.BoxJsonObjectCreator<BoxRepresentation> boxJsonObjectCreator2 = BoxJsonObject.getBoxJsonObjectCreator(BoxRepresentation.class);
        this.representationCreator = boxJsonObjectCreator2;
        return boxJsonObjectCreator2;
    }
}
