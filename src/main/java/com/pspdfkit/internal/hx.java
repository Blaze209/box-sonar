package com.pspdfkit.internal;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class hx {
    public static final ArrayList a(List list, int i) {
        list.getClass();
        List<fx> listTake = CollectionsKt.take(list, i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
        for (fx fxVar : listTake) {
            fxVar.getClass();
            float[] fArr = {fxVar.a, fxVar.c, fxVar.e, fxVar.g};
            float[] fArr2 = {fxVar.b, fxVar.d, fxVar.f, fxVar.h};
            arrayList.add(new RectF(ArraysKt.minOrThrow(fArr), ArraysKt.maxOrThrow(fArr2), ArraysKt.maxOrThrow(fArr), ArraysKt.minOrThrow(fArr2)));
        }
        return arrayList;
    }
}
