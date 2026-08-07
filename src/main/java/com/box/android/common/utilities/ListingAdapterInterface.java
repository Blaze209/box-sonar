package com.box.android.common.utilities;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ListingAdapterInterface.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/box/android/common/utilities/ListingAdapterInterface;", ExifInterface.GPS_DIRECTION_TRUE, "", "updateItems", "", "newList", "", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ListingAdapterInterface<T> {
    void updateItems(List<? extends T> newList);
}
