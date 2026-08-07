package com.pspdfkit.internal;

import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b5 {
    public static final EnumSet<AnnotationType> a = EnumSet.of(AnnotationType.NOTE, AnnotationType.FILE, AnnotationType.SOUND, AnnotationType.STAMP, AnnotationType.FREETEXT);

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BlendMode.values().length];
            a = iArr;
            try {
                iArr[BlendMode.MULTIPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BlendMode.SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static OverlayLayoutParams a(z4 z4Var, boolean z) {
        RectF rectFA;
        OverlayLayoutParams overlayLayoutParams = z4Var.a().getLayoutParams() instanceof OverlayLayoutParams ? (OverlayLayoutParams) z4Var.a().getLayoutParams() : new OverlayLayoutParams();
        if (z4Var instanceof a5) {
            List annotations = ((a5) z4Var).getAnnotations();
            if (annotations.isEmpty()) {
                rectFA = new RectF();
            } else {
                ArrayList arrayList = new ArrayList(annotations.size());
                Iterator it = annotations.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Annotation) it.next()).getBoundingBox());
                }
                rectFA = ip.a(arrayList);
            }
        } else {
            Annotation annotation = z4Var.getAnnotation();
            if (annotation != null) {
                RectF boundingBox = annotation.getBoundingBox();
                boolean z2 = a.contains(annotation.getType()) && (z || annotation.hasFlag(AnnotationFlags.NOZOOM));
                overlayLayoutParams.noZoom = z2;
                overlayLayoutParams.layoutPosition = z2 ? OverlayLayoutParams.LayoutPosition.CENTER : OverlayLayoutParams.LayoutPosition.TOP_LEFT;
                rectFA = boundingBox;
            } else {
                rectFA = null;
            }
        }
        if (rectFA != null) {
            overlayLayoutParams.pageRect.set(rectFA);
        }
        return overlayLayoutParams;
    }
}
