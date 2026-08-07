package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import java.text.DateFormat;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class ls implements ds {
    public final ml a;
    public final Annotation b;
    public final EnumSet<fs.a> c;
    public final String d;

    public ls(ml mlVar, Annotation annotation) {
        mlVar.getClass();
        annotation.getClass();
        this.a = mlVar;
        this.b = annotation;
        this.c = EnumSet.noneOf(fs.a.class);
        String str = DateFormat.getDateTimeInstance(2, 3).format(mlVar.d);
        str.getClass();
        this.d = str;
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(String str) {
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(boolean z) {
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean b() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean c() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean d() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final AnnotationType e() {
        return this.b.getType();
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean f() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final String g() {
        return this.a.c;
    }

    @Override // com.pspdfkit.internal.ds
    public final Annotation getAnnotation() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.ds
    public final int getColor() {
        return this.b.getColor();
    }

    @Override // com.pspdfkit.internal.ds
    public final long getId() {
        return this.a.a.hashCode();
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean h() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final String i() {
        Annotation annotation = this.b;
        NoteAnnotation noteAnnotation = annotation instanceof NoteAnnotation ? (NoteAnnotation) annotation : null;
        if (noteAnnotation != null) {
            return noteAnnotation.getIconName();
        }
        return null;
    }

    @Override // com.pspdfkit.internal.ds
    public final String j() {
        return this.a.b;
    }

    @Override // com.pspdfkit.internal.ds
    public final boolean k() {
        return false;
    }

    @Override // com.pspdfkit.internal.ds
    public final String l() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.ds
    public final AnnotationReviewSummary m() {
        return null;
    }

    @Override // com.pspdfkit.internal.ds
    public final void a(LinkedHashSet linkedHashSet) {
        this.c.clear();
        this.c.addAll(linkedHashSet);
    }

    @Override // com.pspdfkit.internal.ds
    public final Set<fs.a> a() {
        EnumSet enumSetCopyOf = EnumSet.copyOf((EnumSet) this.c);
        enumSetCopyOf.getClass();
        return enumSetCopyOf;
    }
}
