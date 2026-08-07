package com.box.android.data.mappers;

import com.box.android.domain.models.item.ItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TypenameMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toGQLTypename", "", "Lcom/box/android/domain/models/item/ItemType;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TypenameMapperKt {
    public static final String toGQLTypename(ItemType itemType) {
        Intrinsics.checkNotNullParameter(itemType, "<this>");
        String strReplace$default = StringsKt.replace$default(itemType.getValue(), "_", "", false, 4, (Object) null);
        if (strReplace$default.length() <= 0) {
            return strReplace$default;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = strReplace$default.charAt(0);
        StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.titlecase(cCharAt) : String.valueOf(cCharAt)));
        String strSubstring = strReplace$default.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }
}
