package com.box.android.data.api.models.adapters;

import com.box.android.domain.models.item.ItemType;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ItemTypeAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/data/api/models/adapters/ItemTypeAdapter;", "", "<init>", "()V", "fromJson", "Lcom/box/android/domain/models/item/ItemType;", "string", "", "toJson", "type", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemTypeAdapter {
    @FromJson
    public final ItemType fromJson(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return ItemType.INSTANCE.valueOfWithTransform(string, new Function1() { // from class: com.box.android.data.api.models.adapters.ItemTypeAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemTypeAdapter.fromJson$lambda$0((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fromJson$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.replace$default(it, "_", "", false, 4, (Object) null);
    }

    @ToJson
    public final String toJson(ItemType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String string = type.toString();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
