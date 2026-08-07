package com.box.android.coreservices.modelcontroller;

import com.box.android.coreservices.models.BoxLocalMetadata;
import com.box.android.domain.localrepo.IKeyValueStore;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class BoxTypedObjectsCursor<T> extends MoCoCursor<T> {
    private final Class<T> mCursoredClass;
    private final IKeyValueStore mKVStore;

    public BoxTypedObjectsCursor(List<String> list, Class<T> cls, IKeyValueStore iKeyValueStore) {
        super(list);
        this.mCursoredClass = cls;
        this.mKVStore = iKeyValueStore;
    }

    @Override // com.box.android.coreservices.modelcontroller.MoCoCursor
    public T getItemAt(int i) {
        return this.mCursoredClass.cast(this.mKVStore.getBoxJsonObject(getItemTypeAt(i), getItemIdAt(i)));
    }

    @Override // com.box.android.coreservices.modelcontroller.MoCoCursor
    public BoxLocalMetadata getItemLocalMetadataAt(int i) {
        return (BoxLocalMetadata) this.mKVStore.getLocalMetadataForObject(getItemTypeAt(i), getItemIdAt(i));
    }

    @Override // com.box.android.coreservices.modelcontroller.MoCoCursor
    public String getItemTypeAt(int i) {
        return this.mKVStore.keyNamer().getType(getTypedIds().get(i));
    }

    @Override // com.box.android.coreservices.modelcontroller.MoCoCursor
    public String getItemIdAt(int i) {
        return this.mKVStore.keyNamer().getId(getTypedIds().get(i));
    }
}
