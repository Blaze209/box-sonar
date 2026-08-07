package com.pspdfkit.internal;

import android.graphics.PointF;
import com.pspdfkit.internal.jni.NativePointsPager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class kw extends NativePointsPager {
    public final qr<PointF> a;

    public kw(ArrayList arrayList) {
        this.a = new qr<>(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.pspdfkit.internal.jni.NativePointsPager
    public final ArrayList<PointF> get(int i, int i2) {
        qr<PointF> qrVar = this.a;
        qrVar.getClass();
        ArrayList<PointF> arrayList = new ArrayList<>(i2);
        int size = qrVar.a.size();
        for (int i3 = i; i3 < Math.min(i + i2, size); i3++) {
            arrayList.add(qrVar.a.get(i3));
        }
        return arrayList;
    }

    @Override // com.pspdfkit.internal.jni.NativePointsPager
    public final int size() {
        return this.a.a.size();
    }
}
