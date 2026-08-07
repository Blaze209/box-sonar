package com.pspdfkit.undo.edit.annotations;

import com.pspdfkit.annotations.Annotation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB-\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/AnnotationPropertyEdit;", "Lcom/pspdfkit/undo/edit/annotations/AnnotationEdit;", "pageIndex", "", "objectNumber", "propertyKey", "oldValue", "", "newValue", "<init>", "(IIILjava/lang/Object;Ljava/lang/Object;)V", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "(Lcom/pspdfkit/annotations/Annotation;ILjava/lang/Object;Ljava/lang/Object;)V", "getPropertyKey", "()I", "getOldValue", "()Ljava/lang/Object;", "getNewValue", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationPropertyEdit extends AnnotationEdit {
    public static final int $stable = 8;
    private final Object newValue;
    private final Object oldValue;
    private final int propertyKey;

    public AnnotationPropertyEdit(int i, int i2, int i3, Object obj, Object obj2) {
        super(i, i2);
        this.propertyKey = i3;
        this.oldValue = obj;
        this.newValue = obj2;
    }

    public final Object getNewValue() {
        return this.newValue;
    }

    public final Object getOldValue() {
        return this.oldValue;
    }

    public final int getPropertyKey() {
        return this.propertyKey;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnotationPropertyEdit(Annotation annotation, int i, Object obj, Object obj2) {
        this(annotation.getPageIndex(), annotation.getObjectNumber(), i, obj, obj2);
        annotation.getClass();
    }
}
