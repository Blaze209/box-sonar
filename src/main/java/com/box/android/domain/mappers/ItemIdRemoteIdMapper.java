package com.box.android.domain.mappers;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.androidsdk.content.models.BoxItem;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ItemIdRemoteIdMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/domain/mappers/ItemIdRemoteIdMapper;", "", "<init>", "()V", "toItemIdRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/androidsdk/content/models/BoxItem;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemIdRemoteIdMapper {
    public static final ItemIdRemoteIdMapper INSTANCE = new ItemIdRemoteIdMapper();

    private ItemIdRemoteIdMapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toItemIdRemoteId$lambda$0(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        String strReplace$default = StringsKt.replace$default(str, "_", "", false, 4, (Object) null);
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = strReplace$default.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public final ItemId.Remote toItemIdRemoteId(BoxItem boxItem) {
        Intrinsics.checkNotNullParameter(boxItem, "<this>");
        Function1<? super String, String> function1 = new Function1() { // from class: com.box.android.domain.mappers.ItemIdRemoteIdMapper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemIdRemoteIdMapper.toItemIdRemoteId$lambda$0((String) obj);
            }
        };
        try {
            String id = boxItem.getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            ItemType.Companion companion = ItemType.INSTANCE;
            String type = boxItem.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            return new ItemId.Remote(id, companion.valueOfWithTransform(type, function1));
        } catch (Exception unused) {
            return null;
        }
    }
}
