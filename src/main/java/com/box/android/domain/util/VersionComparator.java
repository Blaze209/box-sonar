package com.box.android.domain.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VersionComparator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/util/VersionComparator;", "", "<init>", "()V", "compare", "", "left", "", "right", "isLessThan", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VersionComparator {
    public static final VersionComparator INSTANCE = new VersionComparator();

    private VersionComparator() {
    }

    public final int compare(String left, String right) {
        Long longOrNull;
        Long longOrNull2;
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        List listSplit$default = StringsKt.split$default((CharSequence) left, new char[]{'.'}, false, 0, 6, (Object) null);
        List listSplit$default2 = StringsKt.split$default((CharSequence) right, new char[]{'.'}, false, 0, 6, (Object) null);
        int iMax = Math.max(listSplit$default.size(), listSplit$default2.size());
        for (int i = 0; i < iMax; i++) {
            String str = (String) CollectionsKt.getOrNull(listSplit$default, i);
            long jLongValue = 0;
            long jLongValue2 = (str == null || (longOrNull2 = StringsKt.toLongOrNull(str)) == null) ? 0L : longOrNull2.longValue();
            String str2 = (String) CollectionsKt.getOrNull(listSplit$default2, i);
            if (str2 != null && (longOrNull = StringsKt.toLongOrNull(str2)) != null) {
                jLongValue = longOrNull.longValue();
            }
            if (jLongValue2 != jLongValue) {
                return Intrinsics.compare(jLongValue2, jLongValue);
            }
        }
        return 0;
    }

    public final boolean isLessThan(String left, String right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        return compare(left, right) < 0;
    }
}
