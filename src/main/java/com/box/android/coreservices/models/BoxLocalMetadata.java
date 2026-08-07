package com.box.android.coreservices.models;

import com.box.android.domain.localrepo.IKeyValueStore;

/* JADX INFO: loaded from: classes9.dex */
public class BoxLocalMetadata extends BoxPersistableObject {
    public static final String FIELD_FILE_HAVE_COMMENTS_EVER_BEEN_FETCHED = "fileHaveCommentsEverBeenFetched";
    public static final String FIELD_FOLDER_VIEW_TYPE = "folderViewType";
    public static final String FIELD_FRONT_PAGE_IS_COLLAPSED = "frontPageIsCollapsed";
    public static final String FIELD_RECENT_TIMESTAMP = "recentTime";
    public static final String SCHEME = "metadata_local";
    private static final long serialVersionUID = 1;

    public BoxLocalMetadata() {
    }

    public BoxLocalMetadata(String str, String str2) {
        put("item_type", str);
        put("item_id", str2);
    }

    public String getKeyNamerKey(IKeyValueStore.KeyNamer keyNamer) {
        return keyNamer.getKey(SCHEME, getType(), getId());
    }
}
