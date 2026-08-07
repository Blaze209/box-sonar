package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.TextMarkupAnnotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.datastructures.TextBlock;
import com.pspdfkit.forms.FormElement;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class x2 {
    public EnumSet<AnnotationType> a;
    public final z2 b;
    public final at c;
    public final Context d;
    public boolean e;
    public final ArrayList f;
    public Job g;
    public lm h;
    public PdfConfiguration i;

    public x2(EnumSet enumSet, z2 z2Var, at atVar, Context context) {
        enumSet.getClass();
        context.getClass();
        this.a = enumSet;
        this.b = z2Var;
        this.c = atVar;
        this.d = context;
        this.e = true;
        this.f = new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object a(x2 x2Var, lm lmVar, int i, ContinuationImpl continuationImpl) {
        u2 u2Var;
        Object aVar;
        x2Var.getClass();
        if (continuationImpl instanceof u2) {
            u2Var = (u2) continuationImpl;
            int i2 = u2Var.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                u2Var.d = i2 - Integer.MIN_VALUE;
            } else {
                u2Var = new u2(x2Var, continuationImpl);
            }
        } else {
            u2Var = new u2(x2Var, continuationImpl);
        }
        Object annotations = u2Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = u2Var.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(annotations);
            o3 annotationProvider = lmVar.getAnnotationProvider();
            u2Var.a = lmVar;
            u2Var.d = 1;
            annotations = annotationProvider.getAnnotations(i, u2Var);
            if (annotations == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lmVar = u2Var.a;
            ResultKt.throwOnFailure(annotations);
        }
        List listAsReversed = CollectionsKt.asReversed((List) annotations);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listAsReversed) {
            Annotation annotation = (Annotation) obj;
            if (x2Var.a.contains(annotation.getType()) && ww.h(annotation)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            Annotation annotation2 = (Annotation) obj2;
            if (annotation2 instanceof WidgetAnnotation) {
                WidgetAnnotation widgetAnnotation = (WidgetAnnotation) annotation2;
                FormElement formElement = widgetAnnotation.getFormElement();
                if (formElement != null) {
                    List<String> list = fo.b.f;
                    aVar = new fo.b(widgetAnnotation, formElement, x2Var.e, a(fo.b.a.a(x2Var.d, formElement)));
                } else {
                    aVar = new fo.a(annotation2, x2Var.e, a(x2Var.a(lmVar, annotation2)));
                }
            } else {
                aVar = new fo.a(annotation2, x2Var.e, a(x2Var.a(lmVar, annotation2)));
            }
            arrayList2.add(aVar);
        }
        return arrayList2;
    }

    public final String a(lm lmVar, Annotation annotation) {
        List<RectF> rects;
        if (annotation instanceof TextMarkupAnnotation) {
            String contents = annotation.getContents();
            if (!annotation.getInternal().isInstantCommentThreadRoot() && contents != null && contents.length() != 0) {
                return contents;
            }
            TextMarkupAnnotation textMarkupAnnotation = (TextMarkupAnnotation) annotation;
            int rectsCount = textMarkupAnnotation.getRectsCount();
            if (rectsCount == 0) {
                return ww.a(this.d, annotation, false);
            }
            if (rectsCount <= 100) {
                rects = textMarkupAnnotation.getRects();
            } else {
                rects = textMarkupAnnotation.getRects(Math.min(rectsCount, 50));
            }
            String strA = lmVar.a((List<TextBlock>) lmVar.a(annotation.getPageIndex(), rects));
            return strA.length() == 0 ? ww.a(this.d, annotation, false) : strA;
        }
        return ww.a(this.d, annotation, false);
    }

    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Charset charset = u40.a;
        String strReplaceAll = str.replaceAll("[\r\n]+", "");
        strReplaceAll.getClass();
        String string = StringsKt.trim((CharSequence) strReplaceAll).toString();
        if (string.length() <= 200) {
            return string;
        }
        return StringsKt.take(string, 200) + "...";
    }
}
