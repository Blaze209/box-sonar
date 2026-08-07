package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.modelcontroller.BoxTypedObjectsCursor;
import com.box.android.coreservices.modelcontroller.MoCoCursor;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.androidsdk.content.models.BoxEntity;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxTypedObjectsMessage<T extends BoxEntity> extends BoxPluralMessage<MoCoCursor<T>, T> {
    protected final IKeyValueStore mKVStore;

    public abstract Class<T> getCursoredClass();

    protected BoxTypedObjectsMessage(IKeyValueStore iKeyValueStore) {
        this.mKVStore = iKeyValueStore;
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxPluralMessage, com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public final BoxTypedObjectsCursor<T> getPayload() {
        this.mKVStore.precacheTypedIds(getTypedIds());
        return createTypedObjectsCursor();
    }

    protected BoxTypedObjectsCursor<T> createTypedObjectsCursor() {
        return new BoxTypedObjectsCursor<>(getTypedIds(), getCursoredClass(), this.mKVStore);
    }
}
