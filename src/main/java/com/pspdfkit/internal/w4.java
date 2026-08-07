package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class w4 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;

    public w4(Context context) {
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__AnnotationSelection, R.attr.pspdf__annotationSelectionStyle, R.style.PSPDFKit_AnnotationSelection);
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationSelection_pspdf__borderColor, ContextCompat.getColor(context, R.color.pspdf__annotation_selection_border));
        this.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__AnnotationSelection_pspdf__borderWidth, resources.getDimensionPixelSize(R.dimen.pspdf__annotation_selection_border_width));
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationSelection_pspdf__scaleHandleColor, ContextCompat.getColor(context, R.color.pspdf__annotation_selection_scalehandle));
        this.n = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__topLeftScaleHandleDrawable, -1);
        this.o = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__topCenterScaleHandleDrawable, -1);
        this.p = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__topRightScaleHandleDrawable, -1);
        this.q = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__centerLeftScaleHandleDrawable, -1);
        this.r = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__centerRightScaleHandleDrawable, -1);
        this.s = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__bottomLeftScaleHandleDrawable, -1);
        this.t = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__bottomCenterScaleHandleDrawable, -1);
        this.u = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__bottomRightScaleHandleDrawable, -1);
        this.v = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__rotationHandleDrawable, -1);
        this.w = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__backgroundDrawable, -1);
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationSelection_pspdf__editHandleColor, ContextCompat.getColor(context, R.color.pspdf__primaryContainerLight));
        this.e = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__AnnotationSelection_pspdf__editHandleDrawable, -1);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__AnnotationSelection_pspdf__padding, resources.getDimensionPixelOffset(R.dimen.pspdf__annotation_selection_padding));
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__AnnotationSelection_pspdf__guideLineWidth, resources.getDimensionPixelSize(R.dimen.pspdf__annotation_selection_guide_line_width));
        this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AnnotationSelection_pspdf__guideLineColor, ContextCompat.getColor(context, R.color.pspdf__tertiaryContainerLight));
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__AnnotationSelection_pspdf__guideLineIncrease, resources.getDimensionPixelSize(R.dimen.pspdf__annotation_selection_guide_line_increase));
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__Annotation, R.attr.pspdf__annotationStyle, R.style.PSPDFKit_Annotation);
        this.j = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__Annotation_pspdf__linkAnnotationBackgroundColor, ContextCompat.getColor(context, android.R.color.transparent));
        this.k = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__Annotation_pspdf__linkAnnotationBorderColor, ContextCompat.getColor(context, android.R.color.transparent));
        this.l = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__Annotation_pspdf__linkAnnotationHighlightBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__outlineLight));
        this.m = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__Annotation_pspdf__linkAnnotationHighlightBorderColor, ContextCompat.getColor(context, android.R.color.transparent));
        typedArrayObtainStyledAttributes2.recycle();
    }
}
