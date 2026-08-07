package com.box.android.data.datasource.gql.cache;

import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GQLCacheKeyUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/GQLCacheKeyUtils;", "", "<init>", "()V", "createCacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "id", "", "type", "fieldName", "constructCacheKeyString", "itemType", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCacheKeyUtils {
    public static final GQLCacheKeyUtils INSTANCE = new GQLCacheKeyUtils();

    private GQLCacheKeyUtils() {
    }

    public static /* synthetic */ CacheKey createCacheKey$default(GQLCacheKeyUtils gQLCacheKeyUtils, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return gQLCacheKeyUtils.createCacheKey(str, str2, str3);
    }

    public final CacheKey createCacheKey(String id, String type, String fieldName) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        if (id != null) {
            return new CacheKey(INSTANCE.constructCacheKeyString(id, type, fieldName));
        }
        return null;
    }

    public static /* synthetic */ String constructCacheKeyString$default(GQLCacheKeyUtils gQLCacheKeyUtils, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return gQLCacheKeyUtils.constructCacheKeyString(str, str2, str3);
    }

    public final String constructCacheKeyString(String id, String itemType, String fieldName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        String strReplace$default = itemType != null ? StringsKt.replace$default(itemType, "_", "", false, 4, (Object) null) : null;
        if (strReplace$default != null) {
            fieldName = strReplace$default;
        }
        if (fieldName.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char cCharAt = fieldName.charAt(0);
            StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.titlecase(cCharAt) : String.valueOf(cCharAt)));
            String strSubstring = fieldName.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            fieldName = sbAppend.append(strSubstring).toString();
        }
        return fieldName + ":" + id;
    }
}
