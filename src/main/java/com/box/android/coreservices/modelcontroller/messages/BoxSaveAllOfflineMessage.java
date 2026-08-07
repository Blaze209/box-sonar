package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.domain.localrepo.IKeyValueStore;

/* JADX INFO: loaded from: classes9.dex */
public class BoxSaveAllOfflineMessage extends BoxItemsMessage {
    public BoxSaveAllOfflineMessage(IKeyValueStore iKeyValueStore) {
        super(iKeyValueStore);
        setAction(Controller.ACTION_REMOVED_ALL_OFFLINE);
    }
}
