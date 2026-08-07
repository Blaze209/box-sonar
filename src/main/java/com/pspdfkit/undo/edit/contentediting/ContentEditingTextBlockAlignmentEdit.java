package com.pspdfkit.undo.edit.contentediting;

import com.pspdfkit.contentediting.models.Alignment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/pspdfkit/undo/edit/contentediting/ContentEditingTextBlockAlignmentEdit;", "Lcom/pspdfkit/undo/edit/contentediting/ContentEditingEdit;", "pageIndex", "", "textBlockId", "", "oldAlignment", "Lcom/pspdfkit/contentediting/models/Alignment;", "newAlignment", "<init>", "(ILjava/lang/String;Lcom/pspdfkit/contentediting/models/Alignment;Lcom/pspdfkit/contentediting/models/Alignment;)V", "getAlignment", "forUndo", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentEditingTextBlockAlignmentEdit extends ContentEditingEdit {
    public static final int $stable = 0;
    private final Alignment newAlignment;
    private final Alignment oldAlignment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentEditingTextBlockAlignmentEdit(int i, String str, Alignment alignment, Alignment alignment2) {
        super(i, str);
        str.getClass();
        alignment.getClass();
        alignment2.getClass();
        this.oldAlignment = alignment;
        this.newAlignment = alignment2;
    }

    public final Alignment getAlignment(boolean forUndo) {
        return forUndo ? this.oldAlignment : this.newAlignment;
    }
}
