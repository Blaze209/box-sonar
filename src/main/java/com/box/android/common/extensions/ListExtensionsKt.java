package com.box.android.common.extensions;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: ListExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u0006\u001aD\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0006¨\u0006\f"}, d2 = {"filterIf", "", ExifInterface.GPS_DIRECTION_TRUE, "condition", "", IdentificationData.PREDICATE, "Lkotlin/Function1;", "filterBy", "K", "set", "", "key", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ListExtensionsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> filterIf(List<? extends T> list, boolean z, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T, K> List<T> filterBy(List<? extends T> list, Set<? extends K> set, Function1<? super T, ? extends K> key) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (set.contains(key.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
