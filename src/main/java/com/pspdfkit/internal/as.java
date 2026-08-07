package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import java.text.DateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class as implements ds {
    public final Annotation a;
    public final String b;
    public final long c;
    public final EnumSet<fs.a> d;
    public String e;

    public as(Annotation annotation, String str, long j) {
        annotation.getClass();
        this.a = annotation;
        this.b = str;
        this.c = j;
        this.d = EnumSet.noneOf(fs.a.class);
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(String str) {
        this.e = str;
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(boolean z) {
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean b() {
        return true;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean c() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean d() {
        return true;
    }

    @Override // com.pspdfkit.internal.ds
    public final AnnotationType e() {
        return this.a.getType();
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean f() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final String g() {
        return this.e;
    }

    @Override // com.pspdfkit.internal.ds
    public final Annotation getAnnotation() {
        return this.a;
    }

    @Override // com.pspdfkit.internal.ds
    public final int getColor() {
        return this.a.getColor();
    }

    @Override // com.pspdfkit.internal.ds
    public final long getId() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean h() {
        return true;
    }

    @Override // com.pspdfkit.internal.ds
    public final String i() {
        return NoteAnnotation.NOTE;
    }

    @Override // com.pspdfkit.internal.ds
    public final String j() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean k() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final String l() {
        return DateFormat.getDateTimeInstance(2, 3).format(new Date());
    }

    @Override // com.pspdfkit.internal.ds
    public final AnnotationReviewSummary m() {
        return null;
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(LinkedHashSet linkedHashSet) {
        this.d.clear();
        this.d.addAll(linkedHashSet);
    }

    @Override // com.pspdfkit.internal.ds
    public final Set<fs.a> a() {
        EnumSet enumSetCopyOf = EnumSet.copyOf((EnumSet) this.d);
        enumSetCopyOf.getClass();
        return enumSetCopyOf;
    }
}
