package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes13.dex */
public interface BoxCache {
    void deleteFile(String str) throws SQLException;

    void deleteFolder(String str) throws SQLException;

    <T extends BoxObject, R extends BoxRequest & BoxCacheableRequest> T get(R r) throws BoxException;

    String getFavoritesId();

    BoxItem getItem(String str, String str2) throws SQLException;

    <T extends BoxObject> void put(BoxResponse<T> boxResponse) throws BoxException;

    void saveItem(BoxItem boxItem, boolean z) throws SQLException;

    void saveItemLegacyOnly(BoxItem boxItem) throws SQLException;
}
