package com.pspdfkit.document.library;

import com.pspdfkit.datastructures.Range;
import com.pspdfkit.internal.z40;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class QueryPreviewResult {
    private final int pageIndex;
    private final String previewText;
    private final Range range;
    private final Range rangeInPreviewText;
    private final String uid;

    public QueryPreviewResult(String str, int i, Range range, String str2, Range range2) {
        this.uid = str;
        this.pageIndex = i;
        this.range = range;
        this.previewText = str2;
        this.rangeInPreviewText = range2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryPreviewResult)) {
            return false;
        }
        QueryPreviewResult queryPreviewResult = (QueryPreviewResult) obj;
        if (this.pageIndex == queryPreviewResult.pageIndex && this.uid.equals(queryPreviewResult.uid) && this.range.equals(queryPreviewResult.range) && this.previewText.equals(queryPreviewResult.previewText)) {
            return this.rangeInPreviewText.equals(queryPreviewResult.rangeInPreviewText);
        }
        return false;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public String getPreviewText() {
        return this.previewText;
    }

    public Range getRange() {
        return this.range;
    }

    public Range getRangeInPreviewText() {
        return this.rangeInPreviewText;
    }

    public String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return this.rangeInPreviewText.hashCode() + z40.a(this.previewText, (this.range.hashCode() + (((this.uid.hashCode() * 31) + this.pageIndex) * 31)) * 31, 31);
    }

    public String toString() {
        return "QueryPreviewResult{uid='" + this.uid + "', page=" + this.pageIndex + ", range=" + this.range + ", previewText='" + this.previewText + "', rangeInPreviewText=" + this.rangeInPreviewText + AbstractJsonLexerKt.END_OBJ;
    }
}
