package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface ds {
    Set<fs.a> a();

    void a(String str);

    void a(LinkedHashSet linkedHashSet);

    void a(boolean z);

    boolean b();

    boolean c();

    boolean d();

    AnnotationType e();

    boolean f();

    String g();

    Annotation getAnnotation();

    int getColor();

    long getId();

    boolean h();

    String i();

    String j();

    boolean k();

    String l();

    AnnotationReviewSummary m();
}
