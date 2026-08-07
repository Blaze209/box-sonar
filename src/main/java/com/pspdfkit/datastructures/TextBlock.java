package com.pspdfkit.datastructures;

import android.graphics.RectF;
import com.pspdfkit.internal.ip;
import com.pspdfkit.internal.uw;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TextBlock implements Comparable<TextBlock> {
    public final int pageIndex;
    public final List<RectF> pageRects;
    public final Range range;
    public final String text;

    private TextBlock(String str, int i, Range range, List<RectF> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Provided pageRects list is empty. Cant't create a TextBlock without at least one rect.");
        }
        this.text = str;
        this.pageIndex = i;
        this.range = range;
        this.pageRects = Collections.unmodifiableList(list);
    }

    public static TextBlock create(int i, Range range, List<RectF> list, String str) {
        uw.a(range, "range", null);
        uw.a(list, "pageRects", null);
        uw.a(str, "text", null);
        uw.a(list, "pageRects may not be empty");
        return new TextBlock(str, i, range, list);
    }

    public String toString() {
        return "TextBlock{text='" + this.text + "', pageIndex=" + this.pageIndex + ", range=" + this.range + ", pageRects=" + this.pageRects + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // java.lang.Comparable
    public int compareTo(TextBlock textBlock) {
        int i = textBlock.pageIndex;
        int i2 = this.pageIndex;
        if (i != i2) {
            return i2 - i;
        }
        int startPosition = this.range.getStartPosition() - textBlock.range.getStartPosition();
        if (startPosition != 0) {
            return startPosition;
        }
        RectF rectFA = ip.a(this.pageRects);
        RectF rectFA2 = ip.a(textBlock.pageRects);
        float f = rectFA2.bottom;
        float f2 = rectFA.top;
        return (int) ((f > f2 || rectFA.bottom > rectFA2.top) ? rectFA2.top - f2 : rectFA.left - rectFA2.left);
    }
}
