package com.pspdfkit.internal;

import com.pspdfkit.ui.thumbnail.ThumbnailBarUiState;
import com.pspdfkit.ui.thumbnail.ThumbnailItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class q60 {
    /* JADX WARN: Code duplicated, block: B:15:0x0023  */
    public static Float a(int i, ThumbnailBarUiState thumbnailBarUiState, q40 q40Var, int i2, int i3, int i4) {
        thumbnailBarUiState.getClass();
        q40Var.getClass();
        boolean zIsFirstPageSingle = thumbnailBarUiState.isFirstPageSingle();
        if (i != 0) {
            if (i != 1 || zIsFirstPageSingle) {
                if ((!zIsFirstPageSingle) != (i % 2 == 0)) {
                    i--;
                }
            } else {
                i--;
            }
        }
        return b(i, thumbnailBarUiState, q40Var, i2, i3, i4);
    }

    public static Float b(int i, ThumbnailBarUiState thumbnailBarUiState, q40 q40Var, int i2, int i3, int i4) {
        int size;
        Object obj;
        thumbnailBarUiState.getClass();
        q40Var.getClass();
        ArrayList arrayList = q40Var.i;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size2 = arrayList.size();
        int size3 = 0;
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList.get(i5);
            i5++;
            arrayList2.add(Integer.valueOf(((p60) obj2).a));
        }
        List listReversed = arrayList2;
        if (thumbnailBarUiState.isRTL()) {
            listReversed = CollectionsKt.reversed(arrayList2);
        }
        List list = listReversed;
        if (list.isEmpty()) {
            return null;
        }
        if (thumbnailBarUiState.getThumbnails().isEmpty()) {
            ArrayList arrayList3 = q40Var.i;
            int size4 = arrayList3.size();
            do {
                if (size3 >= size4) {
                    obj = null;
                    break;
                }
                obj = arrayList3.get(size3);
                size3++;
            } while (((p60) obj).a != i);
            p60 p60Var = (p60) obj;
            if (p60Var != null) {
                return Float.valueOf(((i3 + i2) + p60Var.b) - i4);
            }
            return null;
        }
        int iBinarySearch$default = CollectionsKt.binarySearch$default(list, Integer.valueOf(i), 0, 0, 6, (Object) null);
        if (iBinarySearch$default >= 0) {
            if (thumbnailBarUiState.isRTL()) {
                iBinarySearch$default = (list.size() - 1) - iBinarySearch$default;
            }
            ThumbnailItem thumbnailItem = (ThumbnailItem) CollectionsKt.getOrNull(thumbnailBarUiState.getThumbnails(), iBinarySearch$default);
            if (thumbnailItem != null) {
                return Float.valueOf(i3 + i2 + thumbnailItem.getPosition().b);
            }
            return null;
        }
        int size5 = -(iBinarySearch$default + 1);
        if (size5 == 0) {
            int iIntValue = ((Number) list.get(0)).intValue();
            int iIntValue2 = list.size() > 1 ? ((Number) list.get(1)).intValue() : iIntValue;
            size3 = thumbnailBarUiState.isRTL() ? list.size() - 1 : 0;
            size = thumbnailBarUiState.isRTL() ? list.size() - 2 : 1;
            ThumbnailItem thumbnailItem2 = (ThumbnailItem) CollectionsKt.getOrNull(thumbnailBarUiState.getThumbnails(), size3);
            ThumbnailItem thumbnailItem3 = (ThumbnailItem) CollectionsKt.getOrNull(thumbnailBarUiState.getThumbnails(), size);
            if (thumbnailItem2 == null || thumbnailItem3 == null) {
                return null;
            }
            float f = iIntValue2 - iIntValue;
            return Float.valueOf(i3 + i2 + thumbnailItem2.getPosition().b + ((f != 0.0f ? (thumbnailItem3.getPosition().b - thumbnailItem2.getPosition().b) / f : 0.0f) * (i - iIntValue)));
        }
        if (size5 >= list.size()) {
            int iIntValue3 = ((Number) list.get(list.size() - 1)).intValue();
            int iIntValue4 = list.size() > 1 ? ((Number) list.get(list.size() - 2)).intValue() : iIntValue3;
            size3 = thumbnailBarUiState.isRTL() ? 0 : list.size() - 1;
            size = thumbnailBarUiState.isRTL() ? 1 : list.size() - 2;
            ThumbnailItem thumbnailItem4 = (ThumbnailItem) CollectionsKt.getOrNull(thumbnailBarUiState.getThumbnails(), size3);
            ThumbnailItem thumbnailItem5 = (ThumbnailItem) CollectionsKt.getOrNull(thumbnailBarUiState.getThumbnails(), size);
            if (thumbnailItem4 == null || thumbnailItem5 == null) {
                return null;
            }
            float f2 = iIntValue3 - iIntValue4;
            return Float.valueOf(i3 + i2 + thumbnailItem4.getPosition().b + ((f2 != 0.0f ? (thumbnailItem4.getPosition().b - thumbnailItem5.getPosition().b) / f2 : 0.0f) * (i - iIntValue3)));
        }
        int size6 = size5 - 1;
        int iIntValue5 = ((Number) list.get(size6)).intValue();
        int iIntValue6 = ((Number) list.get(size5)).intValue();
        if (thumbnailBarUiState.isRTL()) {
            size6 = list.size() - size5;
        }
        if (thumbnailBarUiState.isRTL()) {
            size5 = (list.size() - size5) - 1;
        }
        ThumbnailItem thumbnailItem6 = (ThumbnailItem) CollectionsKt.getOrNull(thumbnailBarUiState.getThumbnails(), size6);
        ThumbnailItem thumbnailItem7 = (ThumbnailItem) CollectionsKt.getOrNull(thumbnailBarUiState.getThumbnails(), size5);
        if (thumbnailItem6 == null || thumbnailItem7 == null) {
            return null;
        }
        float f3 = iIntValue6 - iIntValue5;
        float f4 = f3 != 0.0f ? (i - iIntValue5) / f3 : 0.0f;
        int i6 = thumbnailItem6.getPosition().b;
        return Float.valueOf(i3 + i2 + ((thumbnailItem7.getPosition().b - i6) * f4) + i6);
    }
}
