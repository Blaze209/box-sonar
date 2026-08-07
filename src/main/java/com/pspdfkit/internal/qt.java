package com.pspdfkit.internal;

import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class qt {
    public static final EnumSet<AnnotationType> a;
    public static final EnumSet<AnnotationType> b;
    public static final EnumSet<AnnotationType> c;
    public static final AtomicBoolean d;

    static {
        AnnotationType annotationType = AnnotationType.CIRCLE;
        AnnotationType annotationType2 = AnnotationType.FILE;
        AnnotationType annotationType3 = AnnotationType.NOTE;
        AnnotationType annotationType4 = AnnotationType.SOUND;
        AnnotationType annotationType5 = AnnotationType.WIDGET;
        EnumSet<AnnotationType> enumSetOf = EnumSet.of(annotationType, annotationType2, AnnotationType.FREETEXT, AnnotationType.HIGHLIGHT, AnnotationType.INK, AnnotationType.LINE, annotationType3, AnnotationType.POLYGON, AnnotationType.POLYLINE, AnnotationType.REDACT, annotationType4, AnnotationType.SQUARE, AnnotationType.SQUIGGLY, AnnotationType.STAMP, AnnotationType.STRIKEOUT, AnnotationType.UNDERLINE, annotationType5);
        enumSetOf.getClass();
        a = enumSetOf;
        EnumSet<AnnotationType> enumSetOf2 = EnumSet.of(annotationType2, annotationType3, annotationType4);
        enumSetOf2.getClass();
        b = enumSetOf2;
        EnumSet<AnnotationType> enumSetCopyOf = EnumSet.copyOf((EnumSet) enumSetOf);
        enumSetCopyOf.remove(annotationType5);
        c = enumSetCopyOf;
        d = new AtomicBoolean(false);
    }

    @JvmStatic
    public static final EnumSet<AnnotationType> a(EnumSet<AnnotationType> enumSet) {
        boolean zA;
        enumSet.getClass();
        EnumSet<AnnotationType> enumSetNoneOf = EnumSet.noneOf(AnnotationType.class);
        ArrayList arrayList = new ArrayList();
        for (Object obj : enumSet) {
            AnnotationType annotationType = (AnnotationType) obj;
            annotationType.getClass();
            if (!a.contains(annotationType)) {
                zA = false;
            } else if (b.contains(annotationType)) {
                zA = true;
            } else {
                zA = annotationType == AnnotationType.WIDGET ? ar.b().a(NativeLicenseFeatures.ACRO_FORMS) : ar.b().a();
            }
            if (zA) {
                arrayList.add(obj);
            }
        }
        enumSetNoneOf.addAll(arrayList);
        enumSetNoneOf.addAll(b);
        return enumSetNoneOf;
    }
}
