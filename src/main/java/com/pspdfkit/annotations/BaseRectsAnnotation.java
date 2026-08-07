package com.pspdfkit.annotations;

import android.graphics.RectF;
import com.box.androidsdk.content.models.BoxIterator;
import com.pspdfkit.internal.bm;
import com.pspdfkit.internal.fx;
import com.pspdfkit.internal.hx;
import com.pspdfkit.internal.j3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b'\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/pspdfkit/annotations/BaseRectsAnnotation;", "Lcom/pspdfkit/annotations/Annotation;", "", "pageIndex", "<init>", "(I)V", "Lcom/pspdfkit/internal/j3;", "properties", "", "markDirty", "(Lcom/pspdfkit/internal/j3;Z)V", BoxIterator.FIELD_LIMIT, "", "Landroid/graphics/RectF;", "getRects", "(I)Ljava/util/List;", "isResizable", "Z", "()Z", "value", "()Ljava/util/List;", "setRects", "(Ljava/util/List;)V", "rects", "getRectsCount", "()I", "rectsCount", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BaseRectsAnnotation extends Annotation {
    public static final int $stable = 8;
    private final boolean isResizable;

    public BaseRectsAnnotation(int i) {
        super(i);
    }

    public final List<RectF> getRects() {
        return hx.a(getInternal().getQuadrilaterals(), Integer.MAX_VALUE);
    }

    public final int getRectsCount() {
        return getInternal().getQuadrilaterals().size();
    }

    @Override // com.pspdfkit.annotations.Annotation
    /* JADX INFO: renamed from: isResizable, reason: from getter */
    public boolean getIsResizable() {
        return this.isResizable;
    }

    public final void setRects(List<? extends RectF> list) {
        list.getClass();
        bm internal = getInternal();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (RectF rectF : list) {
            rectF.getClass();
            float f = rectF.left;
            float f2 = rectF.top;
            float f3 = rectF.right;
            float f4 = rectF.bottom;
            arrayList.add(new fx(f, f2, f3, f2, f, f4, f3, f4));
        }
        internal.setQuadrilaterals(arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRectsAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
        j3Var.getClass();
    }

    public final List<RectF> getRects(int limit) {
        return hx.a(getInternal().getQuadrilaterals(), limit);
    }
}
