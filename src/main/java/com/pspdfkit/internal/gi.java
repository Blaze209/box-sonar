package com.pspdfkit.internal;

import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.FreeTextAnnotation;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class gi extends e1 {
    public gi(String str) {
        str.getClass();
        FreeTextAnnotation freeTextAnnotation = new FreeTextAnnotation(0, new RectF(0.0f, 0.0f, 100.0f, 100.0f), str);
        freeTextAnnotation.setTextSize(12.0f);
        this.a = freeTextAnnotation;
    }

    @Override // com.pspdfkit.internal.e1
    public final boolean e() {
        Annotation annotation = this.a;
        FreeTextAnnotation freeTextAnnotation = annotation instanceof FreeTextAnnotation ? (FreeTextAnnotation) annotation : null;
        if (freeTextAnnotation != null) {
            return z8.a(freeTextAnnotation.getContents(), freeTextAnnotation.getName(), null, 0, 60);
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gi)) {
            return false;
        }
        Annotation annotation = this.a;
        String contents = annotation != null ? annotation.getContents() : null;
        Annotation annotation2 = ((gi) obj).a;
        return Intrinsics.areEqual(contents, annotation2 != null ? annotation2.getContents() : null);
    }

    public final int hashCode() {
        Object contents;
        Annotation annotation = this.a;
        if (annotation == null || (contents = annotation.getContents()) == null) {
            contents = 0;
        }
        return Objects.hash(contents);
    }

    public gi(FreeTextAnnotation freeTextAnnotation) {
        this.a = freeTextAnnotation;
    }
}
