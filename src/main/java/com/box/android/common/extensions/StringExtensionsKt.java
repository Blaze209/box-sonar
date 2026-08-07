package com.box.android.common.extensions;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: StringExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"wordCount", "", "", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StringExtensionsKt {
    public static final int wordCount(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i = 0;
        List<String> listSplit = new Regex("\\s+|\\p{Punct}+").split(str, 0);
        if ((listSplit instanceof Collection) && listSplit.isEmpty()) {
            return 0;
        }
        Iterator<T> it = listSplit.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).length() > 0 && (i = i + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }
}
