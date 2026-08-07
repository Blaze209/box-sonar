package com.pspdfkit.undo.edit;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0013\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pspdfkit/undo/edit/PageEdit;", "Lcom/pspdfkit/undo/edit/Edit;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PageEdit implements Edit {
    public static final int $stable = 0;
    private final int pageIndex;

    public PageEdit(int i) {
        this.pageIndex = i;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }
}
