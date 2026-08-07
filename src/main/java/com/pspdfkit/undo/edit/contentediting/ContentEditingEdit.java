package com.pspdfkit.undo.edit.contentediting;

import com.pspdfkit.undo.edit.PageEdit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/pspdfkit/undo/edit/contentediting/ContentEditingEdit;", "Lcom/pspdfkit/undo/edit/PageEdit;", "pageIndex", "", "textBlockId", "", "<init>", "(ILjava/lang/String;)V", "getTextBlockId", "()Ljava/lang/String;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ContentEditingEdit extends PageEdit {
    public static final int $stable = 0;
    private final String textBlockId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentEditingEdit(int i, String str) {
        super(i);
        str.getClass();
        this.textBlockId = str;
    }

    public final String getTextBlockId() {
        return this.textBlockId;
    }

    public /* synthetic */ ContentEditingEdit(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str);
    }
}
