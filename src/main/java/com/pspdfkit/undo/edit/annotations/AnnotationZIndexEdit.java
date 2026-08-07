package com.pspdfkit.undo.edit.annotations;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0082\u0004J\n\u0010\u0010\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/AnnotationZIndexEdit;", "Lcom/pspdfkit/undo/edit/annotations/AnnotationEdit;", "pageIndex", "", "objectNumber", "oldZIndex", "newZIndex", "<init>", "(IIII)V", "getOldZIndex", "()I", "getNewZIndex", "equals", "", "other", "", "hashCode", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationZIndexEdit extends AnnotationEdit {
    public static final int $stable = 0;
    private final int newZIndex;
    private final int oldZIndex;

    public AnnotationZIndexEdit(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.oldZIndex = i3;
        this.newZIndex = i4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && Intrinsics.areEqual(AnnotationZIndexEdit.class, other.getClass())) {
            AnnotationZIndexEdit annotationZIndexEdit = (AnnotationZIndexEdit) other;
            if (this.oldZIndex == annotationZIndexEdit.oldZIndex && this.newZIndex == annotationZIndexEdit.newZIndex) {
                return true;
            }
        }
        return false;
    }

    public final int getNewZIndex() {
        return this.newZIndex;
    }

    public final int getOldZIndex() {
        return this.oldZIndex;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.oldZIndex), Integer.valueOf(this.newZIndex));
    }
}
