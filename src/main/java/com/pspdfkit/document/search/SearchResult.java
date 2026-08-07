package com.pspdfkit.document.search;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.datastructures.TextBlock;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.TextBlockHelpersKt;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchResult implements Comparable<SearchResult> {
    public final Annotation annotation;
    public final PdfDocument document;
    public final int pageIndex;
    public final TextSnippet snippet;
    public final TextBlock textBlock;

    public static final class TextSnippet {
        public final Range rangeInSnippet;
        public final String text;

        public TextSnippet(String str, Range range) {
            this.text = str;
            this.rangeInSnippet = range;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static TextSnippet forTextBlock(PdfDocument pdfDocument, TextBlock textBlock, int i) {
            return forTextBlock(pdfDocument.getPageText(textBlock.pageIndex), textBlock, i);
        }

        public String toString() {
            return "TextSnippet{text='" + this.text + "', rangeInSnippet=" + this.rangeInSnippet + AbstractJsonLexerKt.END_OBJ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static TextSnippet forTextBlock(Annotation annotation, TextBlock textBlock, int i) {
            return forTextBlock(annotation.getContents(), textBlock, i);
        }

        private static TextSnippet forTextBlock(String str, TextBlock textBlock, int i) {
            int endPosition;
            int iMax;
            if (i <= 0) {
                return null;
            }
            String strTrim = textBlock.text.replaceAll("\\s+", " ").trim();
            int length = strTrim.length() + 2;
            Range range = textBlock.range;
            if (i >= length) {
                int length2 = (strTrim.length() / 2) + range.getStartPosition();
                int i2 = i / 2;
                iMax = Math.max(0, length2 - i2);
                endPosition = Math.min(str.length(), length2 + i2);
            } else {
                int startPosition = range.getStartPosition();
                endPosition = textBlock.range.getEndPosition();
                iMax = startPosition;
            }
            StringBuilder sb = new StringBuilder(str.substring(iMax, endPosition).replaceAll("\\s+", " ").replaceAll("\\p{C}", ""));
            if (endPosition < str.length()) {
                sb.append("…");
            }
            if (iMax > 0) {
                sb.insert(0, "…");
            }
            int iIndexOf = sb.toString().toLowerCase(Locale.getDefault()).indexOf(strTrim.toLowerCase(Locale.getDefault()));
            int i3 = iIndexOf >= 0 ? iIndexOf : 0;
            if (sb.length() > 2) {
                return new TextSnippet(sb.toString(), new Range(i3, strTrim.length()));
            }
            return null;
        }
    }

    public SearchResult(int i, TextBlock textBlock, TextSnippet textSnippet, Annotation annotation, PdfDocument pdfDocument) {
        uw.a(textBlock, "textBlock", null);
        this.pageIndex = i;
        this.textBlock = textBlock;
        this.snippet = textSnippet;
        this.annotation = annotation;
        this.document = pdfDocument;
    }

    public static SearchResult create(PdfDocument pdfDocument, int i, Range range, int i2) {
        uw.a(pdfDocument, "document", null);
        uw.a(range, "range", null);
        TextBlock textBlockCreateTextBlock = TextBlockHelpersKt.createTextBlock(pdfDocument, i, range);
        return new SearchResult(i, textBlockCreateTextBlock, TextSnippet.forTextBlock(pdfDocument, textBlockCreateTextBlock, i2), null, pdfDocument);
    }

    public String toString() {
        return "SearchResult{pageIndex=" + this.pageIndex + ", textBlock=" + this.textBlock + ", snippet=" + this.snippet + ", annotation=" + this.annotation + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // java.lang.Comparable
    public int compareTo(SearchResult searchResult) {
        return this.textBlock.compareTo(searchResult.textBlock);
    }

    public static SearchResult create(PdfDocument pdfDocument, Annotation annotation, Range range, int i) {
        uw.a(pdfDocument, "document", null);
        uw.a(range, "range", null);
        if (annotation.getContents() != null) {
            TextBlock textBlockCreateTextBlock = TextBlockHelpersKt.createTextBlock(annotation, pdfDocument, range);
            return new SearchResult(annotation.getPageIndex(), textBlockCreateTextBlock, TextSnippet.forTextBlock(annotation, textBlockCreateTextBlock, i), annotation, pdfDocument);
        }
        throw new IllegalArgumentException(String.format(Locale.getDefault(), "Annotation has empty contents: %s", annotation));
    }
}
