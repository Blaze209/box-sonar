package com.pspdfkit.undo.edit.contentediting;

import com.pspdfkit.internal.t70;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u001c\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u001c\u0010\f\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/pspdfkit/undo/edit/contentediting/ContentEditingTextBlockMoveAndResizeEdit;", "Lcom/pspdfkit/undo/edit/contentediting/ContentEditingEdit;", "", "pageIndex", "", "textBlockId", "Lcom/pspdfkit/internal/t70;", "oldAnchor", "newAnchor", "", "Lcom/pspdfkit/contentediting/models/Numeric;", "oldSize", "newSize", "<init>", "(ILjava/lang/String;Lcom/pspdfkit/internal/t70;Lcom/pspdfkit/internal/t70;Ljava/lang/Float;Ljava/lang/Float;)V", "", "forUndo", "getSize", "(Z)Ljava/lang/Float;", "getAnchor", "(Z)Lcom/pspdfkit/internal/t70;", "Lcom/pspdfkit/internal/t70;", "Ljava/lang/Float;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentEditingTextBlockMoveAndResizeEdit extends ContentEditingEdit {
    public static final int $stable = 0;
    private final t70 newAnchor;
    private final Float newSize;
    private final t70 oldAnchor;
    private final Float oldSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentEditingTextBlockMoveAndResizeEdit(int i, String str, t70 t70Var, t70 t70Var2, Float f, Float f2) {
        super(i, str);
        str.getClass();
        this.oldAnchor = t70Var;
        this.newAnchor = t70Var2;
        this.oldSize = f;
        this.newSize = f2;
    }

    public final t70 getAnchor(boolean forUndo) {
        return forUndo ? this.oldAnchor : this.newAnchor;
    }

    public final Float getSize(boolean forUndo) {
        return forUndo ? this.oldSize : this.newSize;
    }

    public /* synthetic */ ContentEditingTextBlockMoveAndResizeEdit(int i, String str, t70 t70Var, t70 t70Var2, Float f, Float f2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : t70Var, (i2 & 8) != 0 ? null : t70Var2, (i2 & 16) != 0 ? null : f, (i2 & 32) != 0 ? null : f2);
    }
}
