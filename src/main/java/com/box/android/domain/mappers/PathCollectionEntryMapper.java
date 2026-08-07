package com.box.android.domain.mappers;

import com.box.android.domain.models.item.PathCollectionEntry;
import com.box.androidsdk.content.models.BoxIterator;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PathCollectionEntryMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/box/android/domain/mappers/PathCollectionEntryMapper;", "", "<init>", "()V", "toJsonString", "", "", "Lcom/box/android/domain/models/item/PathCollectionEntry;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PathCollectionEntryMapper {
    public static final PathCollectionEntryMapper INSTANCE = new PathCollectionEntryMapper();

    private PathCollectionEntryMapper() {
    }

    public final String toJsonString(List<PathCollectionEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JsonArray jsonArray = new JsonArray();
        for (PathCollectionEntry pathCollectionEntry : list) {
            jsonArray.add(new JsonObject().add("id", pathCollectionEntry.getId().getBoxId()).add("type", "folder").add("name", pathCollectionEntry.getName()));
        }
        String string = new JsonObject().add(BoxIterator.FIELD_TOTAL_COUNT, list.size()).add("entries", jsonArray).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
