package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.androidsdk.content.models.BoxEntity;

/* JADX INFO: loaded from: classes9.dex */
public class BoxRecentItemsMessage extends BoxTypedObjectsMessage<BoxEntity> {
    private final String EVERYONE_SELECTED_KEY;

    public BoxRecentItemsMessage(IKeyValueStore iKeyValueStore) {
        super(iKeyValueStore);
        this.EVERYONE_SELECTED_KEY = "everyoneSelected";
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxTypedObjectsMessage
    public Class<BoxEntity> getCursoredClass() {
        return BoxEntity.class;
    }

    public void setEveryoneSelected(boolean z) {
        putExtra("everyoneSelected", z);
    }

    public boolean getEveryoneSelected() {
        return getBooleanExtra("everyoneSelected", true);
    }
}
