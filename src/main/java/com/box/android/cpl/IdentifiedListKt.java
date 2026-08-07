package com.box.android.cpl;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdentifiedList.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001aE\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\b\"\u0002H\u0003¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"emptyIdentifiedList", "Lcom/box/android/cpl/IdentifiedList;", "TId", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/box/android/cpl/Identifiable;", "identifiedListOf", "elements", "", "([Lcom/box/android/cpl/Identifiable;)Lcom/box/android/cpl/IdentifiedList;", "cpl-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class IdentifiedListKt {
    public static final <TId, T extends Identifiable<TId>> IdentifiedList<TId, T> emptyIdentifiedList() {
        return new IdentifiedList<>(0);
    }

    public static final <TId, T extends Identifiable<TId>> IdentifiedList<TId, T> identifiedListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return new IdentifiedList<>(elements);
    }
}
