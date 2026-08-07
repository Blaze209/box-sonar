package com.box.android.domain.mappers;

import com.box.android.common.utilities.EnumUtils;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxEntity;
import com.eclipsesource.json.JsonObject;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/box/android/domain/mappers/CollectionModelMapper;", "", "<init>", "()V", "toCollectionModel", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/androidsdk/content/models/BoxCollection;", "toBoxCollection", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionModelMapper {
    public static final CollectionModelMapper INSTANCE = new CollectionModelMapper();

    private CollectionModelMapper() {
    }

    public final CollectionModel toCollectionModel(BoxCollection boxCollection) {
        CollectionType collectionType;
        Intrinsics.checkNotNullParameter(boxCollection, "<this>");
        String id = boxCollection.getUserId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        EnumUtils enumUtils = EnumUtils.INSTANCE;
        String collectionType2 = boxCollection.getCollectionType();
        Intrinsics.checkNotNullExpressionValue(collectionType2, "getCollectionType(...)");
        String upperCase = collectionType2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        CollectionType[] collectionTypeArrValues = CollectionType.values();
        int length = collectionTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                collectionType = null;
                break;
            }
            collectionType = collectionTypeArrValues[i];
            if (Intrinsics.areEqual(collectionType.toString(), upperCase)) {
                break;
            }
            i++;
        }
        CollectionType collectionType3 = collectionType;
        if (collectionType3 == null) {
            collectionType3 = CollectionType.FAVORITES;
        }
        String name = boxCollection.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return new CollectionModel(id, collectionType3, name, null, null);
    }

    public final BoxCollection toBoxCollection(CollectionModel collectionModel) {
        Intrinsics.checkNotNullParameter(collectionModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("name", collectionModel.getName());
        jsonObject.add("id", collectionModel.getId());
        jsonObject.add("type", BoxCollection.TYPE);
        jsonObject.add("collection_type", collectionModel.getType().toString());
        BoxEntity boxEntityCreateEntityFromJson = BoxCollection.createEntityFromJson(jsonObject);
        Intrinsics.checkNotNull(boxEntityCreateEntityFromJson, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxCollection");
        return (BoxCollection) boxEntityCreateEntityFromJson;
    }
}
