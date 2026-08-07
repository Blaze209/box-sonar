package com.microsoft.identity.common.java.nativeauth.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListUtils.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¨\u0006\u0004"}, d2 = {"toUnsanitizedString", "", "", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "common4j"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListUtilsKt {
    public static final String toUnsanitizedString(List<? extends ILoggable> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new Function1<ILoggable, CharSequence>() { // from class: com.microsoft.identity.common.java.nativeauth.util.ListUtilsKt.toUnsanitizedString.1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(ILoggable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toUnsanitizedString();
            }
        }, 30, null);
    }
}
