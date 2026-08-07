package com.box.android.data.datasource.gql.cache.partial;

import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.box.android.data.datasource.gql.cache.partial.models.PartialFolderItemConnection;
import com.box.android.data.datasource.gql.cache.partial.models.PartialMiniItem;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLPartialModelParser.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialModelParser;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "parsePartialFolderItemConnection", "Lcom/box/android/data/datasource/gql/cache/partial/models/PartialFolderItemConnection;", "folderItemConnectionAsJsonString", "", "parseCacheKeyListForNodes", "", "partialFolderItemConnection", "parseCacheKeys", "parsePartialMiniItems", "Lcom/box/android/data/datasource/gql/cache/partial/models/PartialMiniItem;", "partialMiniItemsAsJsonString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLPartialModelParser {
    private final Moshi moshi;

    @Inject
    public GQLPartialModelParser(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.moshi = moshi;
    }

    public final PartialFolderItemConnection parsePartialFolderItemConnection(String folderItemConnectionAsJsonString) {
        if (folderItemConnectionAsJsonString == null) {
            return null;
        }
        try {
            return (PartialFolderItemConnection) this.moshi.adapter(PartialFolderItemConnection.class).fromJson(folderItemConnectionAsJsonString);
        } catch (IOException e) {
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "Cannot parse folder item connection json string", e);
            return null;
        }
    }

    public final List<String> parseCacheKeyListForNodes(PartialFolderItemConnection partialFolderItemConnection) {
        List<String> cacheKeys;
        return (partialFolderItemConnection == null || (cacheKeys = parseCacheKeys(partialFolderItemConnection)) == null) ? CollectionsKt.emptyList() : cacheKeys;
    }

    private final List<String> parseCacheKeys(PartialFolderItemConnection partialFolderItemConnection) {
        Pattern patternCompile = Pattern.compile("FolderItemConnectionEdge:(.*)");
        ArrayList arrayList = new ArrayList();
        for (String key : partialFolderItemConnection.getEdges()) {
            if (CacheKey.INSTANCE.canDeserialize(key)) {
                key = CacheKey.INSTANCE.deserialize(key).getKey();
            }
            Matcher matcher = patternCompile.matcher(key);
            String strGroup = null;
            while (matcher.find()) {
                strGroup = matcher.group(1);
            }
            if (strGroup != null) {
                arrayList.add(strGroup);
            }
        }
        return arrayList;
    }

    public final List<PartialMiniItem> parsePartialMiniItems(List<String> partialMiniItemsAsJsonString) {
        Intrinsics.checkNotNullParameter(partialMiniItemsAsJsonString, "partialMiniItemsAsJsonString");
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(PartialMiniItem.class);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = partialMiniItemsAsJsonString.iterator();
        while (it.hasNext()) {
            try {
                PartialMiniItem partialMiniItem = (PartialMiniItem) jsonAdapterAdapter.fromJson((String) it.next());
                if (partialMiniItem != null) {
                    arrayList.add(partialMiniItem);
                }
            } catch (IOException e) {
                BoxLogUtils.w(ExtensionsKt.getTAG(this), "Cannot parse partial mini item json string", e);
            }
        }
        return arrayList;
    }
}
