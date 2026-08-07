package com.box.androidsdk.content.models;

import com.box.androidsdk.content.models.BoxEntity;
import com.eclipsesource.json.JsonObject;

/* JADX INFO: loaded from: classes13.dex */
public class BoxIteratorBoxEntity<E extends BoxEntity> extends BoxIterator<E> {
    private static final long serialVersionUID = 8036181424029520417L;
    private transient BoxJsonObject.BoxJsonObjectCreator<E> representationCreator;

    public BoxIteratorBoxEntity() {
    }

    public BoxIteratorBoxEntity(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<E> getObjectCreator() {
        BoxJsonObject.BoxJsonObjectCreator<E> boxJsonObjectCreator = this.representationCreator;
        if (boxJsonObjectCreator != null) {
            return boxJsonObjectCreator;
        }
        BoxJsonObject.BoxJsonObjectCreator<E> boxJsonObjectCreator2 = (BoxJsonObject.BoxJsonObjectCreator<E>) BoxEntity.getBoxJsonObjectCreator();
        this.representationCreator = boxJsonObjectCreator2;
        return boxJsonObjectCreator2;
    }
}
