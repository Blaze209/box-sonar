package com.box.android.base.compose;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImmutableWrapper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0002\u001a\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0005\u001a\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0005¨\u0006\u0007"}, d2 = {"toImmutable", "Lcom/box/android/base/compose/ImmutableWrapper;", "", ExifInterface.GPS_DIRECTION_TRUE, "ofEmptyList", "Lcom/box/android/base/compose/ImmutableWrapper$Companion;", "ofNull", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImmutableWrapperKt {
    public static final <T> ImmutableWrapper<List<T>> toImmutable(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return new ImmutableWrapper<>(list);
    }

    public static final <T> ImmutableWrapper<List<T>> ofEmptyList(ImmutableWrapper.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new ImmutableWrapper<>(CollectionsKt.emptyList());
    }

    public static final <T> ImmutableWrapper<T> ofNull(ImmutableWrapper.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new ImmutableWrapper<>(null);
    }
}
