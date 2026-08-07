package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorItems;

/* JADX INFO: loaded from: classes9.dex */
public class BoxItemsMessage extends BoxTypedObjectsMessage<BoxItem> {
    private static final String ITEMS_LIST = "BoxItemsMessage.ItemsList";

    public BoxItemsMessage(IKeyValueStore iKeyValueStore) {
        super(iKeyValueStore);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxTypedObjectsMessage
    public Class<BoxItem> getCursoredClass() {
        return BoxItem.class;
    }

    public void setBoxIteratorItems(BoxIteratorItems boxIteratorItems) {
        putExtra(ITEMS_LIST, boxIteratorItems);
    }

    public BoxIteratorItems getBoxIteratorItems() {
        return (BoxIteratorItems) getSerializableExtra(ITEMS_LIST);
    }
}
