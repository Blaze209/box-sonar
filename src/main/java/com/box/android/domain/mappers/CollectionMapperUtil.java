package com.box.android.domain.mappers;

import com.box.android.domain.models.CollectionModel;
import com.eclipsesource.json.JsonArray;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionMapperUtil.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/domain/mappers/CollectionMapperUtil;", "", "<init>", "()V", "transformCollectionModelsToBoxCollections", "Lcom/eclipsesource/json/JsonArray;", "collectionModels", "", "Lcom/box/android/domain/models/CollectionModel;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionMapperUtil {
    public static final CollectionMapperUtil INSTANCE = new CollectionMapperUtil();

    private CollectionMapperUtil() {
    }

    public final JsonArray transformCollectionModelsToBoxCollections(List<CollectionModel> collectionModels) {
        Intrinsics.checkNotNullParameter(collectionModels, "collectionModels");
        JsonArray jsonArray = new JsonArray();
        Iterator<T> it = collectionModels.iterator();
        while (it.hasNext()) {
            jsonArray.add(CollectionModelMapper.INSTANCE.toBoxCollection((CollectionModel) it.next()).toJsonObject());
        }
        return jsonArray;
    }
}
