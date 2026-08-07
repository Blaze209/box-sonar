package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.models.BoxFragmentFilenameFilter;
import com.box.android.domain.localrepo.IKeyValueStore;

/* JADX INFO: loaded from: classes9.dex */
public class BoxFilenameFilteredItemsMessage extends BoxFolderItemsMessage {
    private static final String EXTRA_FILTER_TYPE = "extraFilterType";

    public BoxFilenameFilteredItemsMessage(IKeyValueStore iKeyValueStore, String str, BoxFragmentFilenameFilter.FILTER_TYPE filter_type) {
        super(iKeyValueStore, str);
        if (filter_type != null) {
            putExtra(EXTRA_FILTER_TYPE, filter_type.name());
        }
    }

    public BoxFragmentFilenameFilter.FILTER_TYPE getFilterType() {
        if (getStringExtra(EXTRA_FILTER_TYPE) == null) {
            return null;
        }
        return BoxFragmentFilenameFilter.FILTER_TYPE.valueOf(getStringExtra(EXTRA_FILTER_TYPE));
    }
}
