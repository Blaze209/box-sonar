package com.pspdfkit.annotations;

import android.graphics.RectF;
import com.pspdfkit.datastructures.TextBlock;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.lm;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TextMarkupAnnotation extends BaseRectsAnnotation {
    public TextMarkupAnnotation(int i) {
        super(i);
    }

    public String getHighlightedText() {
        return !isAttached() ? "" : getInternalDocument().a(getHighlightedTextBlocks(getInternalDocument()));
    }

    public List<TextBlock> getHighlightedTextBlocks() {
        return getInternalDocument() != null ? getHighlightedTextBlocks(getInternalDocument()) : Collections.EMPTY_LIST;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
    }

    public TextMarkupAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }

    private List<TextBlock> getHighlightedTextBlocks(lm lmVar) {
        int pageIndex = getPageIndex();
        List<RectF> rects = getRects();
        if (getPageIndex() != Integer.MIN_VALUE && !rects.isEmpty()) {
            return lmVar.a(pageIndex, rects);
        }
        return Collections.EMPTY_LIST;
    }
}
