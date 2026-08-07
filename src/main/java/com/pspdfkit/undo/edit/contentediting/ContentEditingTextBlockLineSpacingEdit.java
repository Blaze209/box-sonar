package com.pspdfkit.undo.edit.contentediting;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/pspdfkit/undo/edit/contentediting/ContentEditingTextBlockLineSpacingEdit;", "Lcom/pspdfkit/undo/edit/contentediting/ContentEditingEdit;", "pageIndex", "", "textBlockId", "", "oldLineSpacing", "", "newLineSpacing", "<init>", "(ILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "Ljava/lang/Float;", "getLineSpacing", "forUndo", "", "(Z)Ljava/lang/Float;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentEditingTextBlockLineSpacingEdit extends ContentEditingEdit {
    public static final int $stable = 0;
    private final Float newLineSpacing;
    private final Float oldLineSpacing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentEditingTextBlockLineSpacingEdit(int i, String str, Float f, Float f2) {
        super(i, str);
        str.getClass();
        this.oldLineSpacing = f;
        this.newLineSpacing = f2;
    }

    public final Float getLineSpacing(boolean forUndo) {
        return forUndo ? this.oldLineSpacing : this.newLineSpacing;
    }
}
