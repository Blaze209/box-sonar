package com.box.boxandroidlibv2private.resourcemanagers;

import com.box.androidsdk.content.BoxApiCollection;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.boxandroidlibv2private.requests.BoxRequestGetFavoritesCollection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes13.dex */
public class BoxExtendedApiCollections extends BoxApiCollection {
    public static final String COLLECTION_TYPE_EMPTY = "";
    public static final String COLLECTION_TYPE_FAVORITES = "favorites";
    public static final String COLLECTION_TYPE_MUTE_CONVERSATIONS = "muteConversations";
    public static final String COLLECTION_TYPE_MUTE_UPDATES = "muteUpdates";

    @Retention(RetentionPolicy.SOURCE)
    public @interface CollectionType {
    }

    public BoxExtendedApiCollections(BoxSession boxSession) {
        super(boxSession);
    }

    public static boolean isItemInAnyCollection(BoxItem boxItem) {
        return (boxItem == null || boxItem.getCollections() == null || boxItem.getCollections().size() <= 0) ? false : true;
    }

    @Override // com.box.androidsdk.content.BoxApiCollection
    public String getCollectionItemsUrl(String str) {
        return super.getCollectionItemsUrl(str);
    }

    public BoxRequestGetFavoritesCollection getFavoritesCollectionRequest() {
        return new BoxRequestGetFavoritesCollection(super.getCollectionsUrl(), this.mSession, this).setFields(BoxApiPrivate.FOLDER_FIELDS);
    }
}
