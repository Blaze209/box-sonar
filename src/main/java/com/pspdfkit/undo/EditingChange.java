package com.pspdfkit.undo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/pspdfkit/undo/EditingChange;", "", "editingOperation", "Lcom/pspdfkit/undo/EditingOperation;", "affectedPageIndex", "", "pageIndexDestination", "pageReferenceSourceIndex", "<init>", "(Lcom/pspdfkit/undo/EditingOperation;III)V", "getEditingOperation", "()Lcom/pspdfkit/undo/EditingOperation;", "getAffectedPageIndex", "()I", "getPageIndexDestination", "getPageReferenceSourceIndex", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EditingChange {
    public static final int $stable = 0;
    private final int affectedPageIndex;
    private final EditingOperation editingOperation;
    private final int pageIndexDestination;
    private final int pageReferenceSourceIndex;

    public EditingChange(EditingOperation editingOperation, int i, int i2, int i3) {
        editingOperation.getClass();
        this.editingOperation = editingOperation;
        this.affectedPageIndex = i;
        this.pageIndexDestination = i2;
        this.pageReferenceSourceIndex = i3;
        if (i < 0) {
            throw new IllegalArgumentException(("Invalid affected page index " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("Invalid page index destination " + i2).toString());
        }
    }

    public final int getAffectedPageIndex() {
        return this.affectedPageIndex;
    }

    public final EditingOperation getEditingOperation() {
        return this.editingOperation;
    }

    public final int getPageIndexDestination() {
        return this.pageIndexDestination;
    }

    public final int getPageReferenceSourceIndex() {
        return this.pageReferenceSourceIndex;
    }
}
