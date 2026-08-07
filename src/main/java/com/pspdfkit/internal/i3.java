package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.undo.edit.annotations.AnnotationPropertyEdit;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i3 extends lf<AnnotationPropertyEdit> implements zs {
    public final ArrayList d;

    public i3(List list, at atVar) {
        super(atVar);
        this.d = new ArrayList(list);
    }

    @Override // com.pspdfkit.internal.lf
    public final void a() {
        if (this.c.size() <= 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList2 = this.c;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            AnnotationPropertyEdit annotationPropertyEdit = (AnnotationPropertyEdit) obj;
            Pair pair = new Pair(Integer.valueOf(annotationPropertyEdit.getObjectNumber()), Integer.valueOf(annotationPropertyEdit.getPropertyKey()));
            if (!linkedHashSet.contains(pair)) {
                linkedHashSet.add(pair);
                ArrayList arrayList3 = this.c;
                ListIterator listIterator = arrayList3.listIterator(arrayList3.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                    AnnotationPropertyEdit annotationPropertyEdit2 = (AnnotationPropertyEdit) listIterator.previous();
                    if (annotationPropertyEdit2.getObjectNumber() == annotationPropertyEdit.getObjectNumber() && annotationPropertyEdit2.getPropertyKey() == annotationPropertyEdit.getPropertyKey()) {
                        arrayList.add(new AnnotationPropertyEdit(annotationPropertyEdit.getPageIndex(), annotationPropertyEdit.getObjectNumber(), annotationPropertyEdit.getPropertyKey(), annotationPropertyEdit.getOldValue(), annotationPropertyEdit2.getNewValue()));
                        break;
                    }
                }
            }
        }
        this.c = arrayList;
    }

    @Override // com.pspdfkit.internal.lf
    public final void b() {
        this.b = true;
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Annotation) obj).getInternal().addOnAnnotationPropertyChangeListener(this);
        }
    }

    @Override // com.pspdfkit.internal.lf
    public final void c() {
        super.c();
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Annotation) obj).getInternal().removeOnAnnotationPropertyChangeListener(this);
        }
    }

    @Override // com.pspdfkit.internal.zs
    public final void onAnnotationPropertyChange(Annotation annotation, int i, Object obj, Object obj2) {
        annotation.getClass();
        if (!this.d.contains(annotation)) {
            PdfLog.w("Nutri.AnnotPropEditRec", "Annotation reporting property changes to this recorder is not the in the collection of annotations whose property edits were set to be recorded by this object.", new Object[0]);
        }
        if (obj == null || !Intrinsics.areEqual(obj, obj2)) {
            AnnotationPropertyEdit annotationPropertyEdit = new AnnotationPropertyEdit(annotation, i, obj, obj2);
            if (this.b) {
                this.c.add(annotationPropertyEdit);
            }
        }
    }
}
