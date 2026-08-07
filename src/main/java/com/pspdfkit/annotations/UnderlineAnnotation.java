package com.pspdfkit.annotations;

import android.graphics.RectF;
import com.pspdfkit.internal.j3;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UnderlineAnnotation extends TextMarkupAnnotation {
    public UnderlineAnnotation(int i, List<RectF> list) {
        super(i);
        setRects(list);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.UNDERLINE;
    }

    public UnderlineAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}
