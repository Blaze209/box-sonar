package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionType;
import com.pspdfkit.annotations.actions.GoToAction;
import com.pspdfkit.document.OutlineElement;
import com.pspdfkit.document.OutlineElementState;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.UInt;

/* JADX INFO: loaded from: classes3.dex */
public final class kt {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OutlineElementState.values().length];
            try {
                iArr[OutlineElementState.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutlineElementState.COLLAPSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final OutlineElement a(lm lmVar, lt ltVar) {
        Action actionA;
        ArrayList arrayList;
        OutlineElement outlineElementA;
        String pageLabel;
        int iA;
        int iA2;
        int iA3 = ltVar.a(6);
        String strB = iA3 != 0 ? ltVar.b(iA3 + ltVar.a) : null;
        if (strB == null) {
            return null;
        }
        OutlineElement.Builder builder = new OutlineElement.Builder(strB);
        int i = a.a[lmVar.n.ordinal()];
        int i2 = 2;
        builder.setExpanded(i == 1 || !(i == 2 || (iA2 = ltVar.a(18)) == 0 || ltVar.b.get(iA2 + ltVar.a) == 0));
        c9 c9Var = new c9();
        int iA4 = ltVar.a(10);
        if (iA4 != 0) {
            int i3 = iA4 + ltVar.a;
            ByteBuffer byteBuffer = ltVar.b;
            byteBuffer.getClass();
            c9Var.a(i3, byteBuffer);
        } else {
            c9Var = null;
        }
        builder.setColor(c9Var != null ? UInt.m14875constructorimpl(c9Var.b.getInt(c9Var.a)) : -16777216);
        int iA5 = ltVar.a(12);
        if (iA5 == 0 || ltVar.b.get(iA5 + ltVar.a) == 0 || (iA = ltVar.a(14)) == 0 || ltVar.b.get(iA + ltVar.a) == 0) {
            int iA6 = ltVar.a(12);
            if (iA6 == 0 || ltVar.b.get(iA6 + ltVar.a) == 0) {
                int iA7 = ltVar.a(14);
                if (iA7 == 0 || ltVar.b.get(iA7 + ltVar.a) == 0) {
                    i2 = 0;
                }
            } else {
                i2 = 1;
            }
        } else {
            i2 = 3;
        }
        builder.setStyle(i2);
        b bVar = new b();
        int iA8 = ltVar.a(16);
        if (iA8 != 0) {
            int i4 = iA8 + ltVar.a;
            int i5 = ltVar.b.getInt(i4) + i4;
            ByteBuffer byteBuffer2 = ltVar.b;
            byteBuffer2.getClass();
            bVar.a(i5, byteBuffer2);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            b bVar2 = new b();
            int iA9 = ltVar.a(16);
            if (iA9 != 0) {
                int i6 = iA9 + ltVar.a;
                int i7 = ltVar.b.getInt(i6) + i6;
                ByteBuffer byteBuffer3 = ltVar.b;
                byteBuffer3.getClass();
                bVar2.a(i7, byteBuffer3);
            } else {
                bVar2 = null;
            }
            actionA = d.a(bVar2);
            if (actionA != null) {
                builder.setAction(actionA);
            }
        } else {
            actionA = null;
        }
        if (actionA != null && actionA.getType() == ActionType.GOTO && (actionA instanceof GoToAction) && (pageLabel = lmVar.getPageLabel(((GoToAction) actionA).getPageIndex(), false)) != null) {
            builder.setPageLabel(pageLabel);
        }
        int iA10 = ltVar.a(8);
        if ((iA10 != 0 ? ltVar.d(iA10) : 0) == 0) {
            arrayList = new ArrayList(0);
        } else {
            int iA11 = ltVar.a(8);
            ArrayList arrayList2 = new ArrayList(iA11 != 0 ? ltVar.d(iA11) : 0);
            int iA12 = ltVar.a(8);
            int iD = iA12 != 0 ? ltVar.d(iA12) : 0;
            for (int i8 = 0; i8 < iD; i8++) {
                lt ltVar2 = new lt();
                int iA13 = ltVar.a(8);
                if (iA13 != 0) {
                    int iC = (i8 * 4) + ltVar.c(iA13);
                    int i9 = ltVar.b.getInt(iC) + iC;
                    ByteBuffer byteBuffer4 = ltVar.b;
                    byteBuffer4.getClass();
                    ltVar2.a(i9, byteBuffer4);
                } else {
                    ltVar2 = null;
                }
                if (ltVar2 != null && (outlineElementA = a(lmVar, ltVar2)) != null) {
                    arrayList2.add(outlineElementA);
                }
            }
            arrayList = arrayList2;
        }
        builder.setChildren(arrayList);
        return builder.build();
    }
}
