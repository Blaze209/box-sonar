package com.pspdfkit.annotations;

import android.graphics.RectF;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.internal.j3;

/* JADX INFO: loaded from: classes3.dex */
public class LinkAnnotation extends Annotation {
    public LinkAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }

    public Action getAction() {
        return getInternal().getAction();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.LINK;
    }

    public void setAction(Action action) {
        getInternal().setAction(action);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void setFillColor(int i) {
        super.setFillColor(i);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
    }

    public LinkAnnotation(int i) {
        super(i);
    }
}
