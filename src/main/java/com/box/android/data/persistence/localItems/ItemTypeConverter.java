package com.box.android.data.persistence.localItems;

import com.box.android.domain.models.item.ItemType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LocalIdToServerIdRelationEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/data/persistence/localItems/ItemTypeConverter;", "", "<init>", "()V", "fromString", "Lcom/box/android/domain/models/item/ItemType;", "value", "", "toString", "itemType", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemTypeConverter {
    public final ItemType fromString(String value) {
        if (value != null) {
            return ItemType.INSTANCE.valueOfWithTransform(value, new Function1() { // from class: com.box.android.data.persistence.localItems.ItemTypeConverter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ItemTypeConverter.fromString$lambda$0$0((String) obj);
                }
            });
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String fromString$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.replace$default(it, "_", "", false, 4, (Object) null);
    }

    public final String toString(ItemType itemType) {
        if (itemType != null) {
            return itemType.toString();
        }
        return null;
    }
}
