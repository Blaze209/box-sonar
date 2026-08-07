package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.models.BoxLocalMetadata;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.androidsdk.content.models.BoxObject;

/* JADX INFO: loaded from: classes9.dex */
public class BoxMessageWithLocalMetadata<E extends BoxObject> extends BoxMessage<E> {
    protected static final String ID_EXTRA = "id";
    private static final String LOCAL_METADATA_EXTRA = "local_metadata";

    public BoxMessageWithLocalMetadata() {
    }

    public BoxMessageWithLocalMetadata(String str, String str2, IKeyValueStore iKeyValueStore) {
        setLocalMetadata(str, str2, iKeyValueStore);
        setId(str2);
    }

    public BoxLocalMetadata getLocalMetadata() {
        return (BoxLocalMetadata) getSerializableExtra(LOCAL_METADATA_EXTRA);
    }

    public void setId(String str) {
        putExtra("id", str);
    }

    public String getId() {
        return getStringExtra("id");
    }

    public void setLocalMetadata(String str, String str2, IKeyValueStore iKeyValueStore) {
        putExtra(LOCAL_METADATA_EXTRA, (BoxLocalMetadata) iKeyValueStore.getLocalMetadataForObject(str, str2));
    }
}
