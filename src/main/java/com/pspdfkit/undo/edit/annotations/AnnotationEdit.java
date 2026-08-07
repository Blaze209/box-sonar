package com.pspdfkit.undo.edit.annotations;

import com.pspdfkit.undo.edit.PageEdit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u001b\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/pspdfkit/undo/edit/annotations/AnnotationEdit;", "Lcom/pspdfkit/undo/edit/PageEdit;", "pageIndex", "", "objectNumber", "<init>", "(II)V", "getObjectNumber", "()I", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AnnotationEdit extends PageEdit {
    public static final int $stable = 0;
    private final int objectNumber;

    public AnnotationEdit(int i, int i2) {
        super(i);
        this.objectNumber = i2;
    }

    public final int getObjectNumber() {
        return this.objectNumber;
    }
}
