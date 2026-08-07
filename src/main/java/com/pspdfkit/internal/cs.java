package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import java.text.DateFormat;
import java.util.AbstractSet;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class cs implements ds {
    public final Annotation a;
    public AnnotationReviewSummary b;
    public final boolean c;
    public final long d;
    public final String e;
    public final String f;
    public final String g;
    public String h;
    public AbstractSet i;
    public int j;
    public final AnnotationType k;
    public String l;
    public boolean m;

    public cs(Annotation annotation, AnnotationReviewSummary annotationReviewSummary, boolean z) {
        String str;
        annotation.getClass();
        this.a = annotation;
        this.b = annotationReviewSummary;
        this.c = z;
        this.d = annotation.getObjectNumber();
        this.e = annotation.getSubject();
        this.f = annotation.getCreator();
        Date createdDate = annotation.getCreatedDate();
        if (createdDate != null) {
            str = DateFormat.getDateTimeInstance(2, 3).format(createdDate);
            str.getClass();
        } else {
            str = null;
        }
        this.g = str;
        this.h = annotation.getContents();
        EnumSet enumSetNoneOf = EnumSet.noneOf(fs.a.class);
        enumSetNoneOf.getClass();
        this.i = enumSetNoneOf;
        this.j = annotation.getColor();
        this.k = annotation.getType();
        NoteAnnotation noteAnnotation = annotation instanceof NoteAnnotation ? (NoteAnnotation) annotation : null;
        this.l = noteAnnotation != null ? noteAnnotation.getIconName() : null;
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(String str) {
        this.h = str;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean b() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean c() {
        return true;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean d() {
        return true;
    }

    @Override // com.pspdfkit.internal.ds
    public final AnnotationType e() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cs)) {
            return false;
        }
        cs csVar = (cs) obj;
        return this.d == csVar.d && this.j == csVar.j && this.m == csVar.m && this.c == csVar.c && Intrinsics.areEqual(this.e, csVar.e) && Intrinsics.areEqual(this.f, csVar.f) && Intrinsics.areEqual(this.g, csVar.g) && Intrinsics.areEqual(this.h, csVar.h) && Intrinsics.areEqual(this.b, csVar.b) && Intrinsics.areEqual(this.i, csVar.i) && this.k == csVar.k && Intrinsics.areEqual(this.l, csVar.l);
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean f() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final String g() {
        return this.h;
    }

    @Override // com.pspdfkit.internal.ds
    public final Annotation getAnnotation() {
        return this.a;
    }

    @Override // com.pspdfkit.internal.ds
    public final int getColor() {
        return this.j;
    }

    @Override // com.pspdfkit.internal.ds
    public final long getId() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean h() {
        return false;
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.d) * 31;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.g;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.h;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        AnnotationReviewSummary annotationReviewSummary = this.b;
        int iHashCode6 = (this.k.hashCode() + ((((this.i.hashCode() + ((iHashCode5 + (annotationReviewSummary != null ? annotationReviewSummary.hashCode() : 0)) * 31)) * 31) + this.j) * 31)) * 31;
        String str5 = this.l;
        return Boolean.hashCode(this.c) + mv.a(this.m, (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31, 31);
    }

    @Override // com.pspdfkit.internal.ds
    public final String i() {
        return this.l;
    }

    @Override // com.pspdfkit.internal.ds
    public final String j() {
        return this.f;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean k() {
        return this.m;
    }

    @Override // com.pspdfkit.internal.ds
    public final String l() {
        return this.g;
    }

    @Override // com.pspdfkit.internal.ds
    public final AnnotationReviewSummary m() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(LinkedHashSet linkedHashSet) {
        this.i = linkedHashSet;
    }

    @Override // com.pspdfkit.internal.ds
    public final Set<fs.a> a() {
        return this.i;
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(boolean z) {
        this.m = z;
    }
}
