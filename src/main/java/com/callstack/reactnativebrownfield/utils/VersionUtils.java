package com.callstack.reactnativebrownfield.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VersionUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/callstack/reactnativebrownfield/utils/VersionUtils;", "", "<init>", "()V", "isVersionLessThan", "", "version", "", "threshold", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VersionUtils {
    public static final VersionUtils INSTANCE = new VersionUtils();

    private VersionUtils() {
    }

    public final boolean isVersionLessThan(String version, String threshold) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(threshold, "threshold");
        List listSplit$default = StringsKt.split$default((CharSequence) version, new String[]{"."}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            Integer intOrNull = StringsKt.toIntOrNull((String) it.next());
            arrayList.add(Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0));
        }
        ArrayList arrayList2 = arrayList;
        List listSplit$default2 = StringsKt.split$default((CharSequence) threshold, new String[]{"."}, false, 0, 6, (Object) null);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default2, 10));
        Iterator it2 = listSplit$default2.iterator();
        while (it2.hasNext()) {
            Integer intOrNull2 = StringsKt.toIntOrNull((String) it2.next());
            arrayList3.add(Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0));
        }
        ArrayList arrayList4 = arrayList3;
        int iMax = Math.max(arrayList2.size(), arrayList4.size());
        for (int i = 0; i < iMax; i++) {
            Integer num = (Integer) CollectionsKt.getOrNull(arrayList2, i);
            int iIntValue = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) CollectionsKt.getOrNull(arrayList4, i);
            int iIntValue2 = num2 != null ? num2.intValue() : 0;
            if (iIntValue != iIntValue2) {
                return iIntValue < iIntValue2;
            }
        }
        return false;
    }
}
