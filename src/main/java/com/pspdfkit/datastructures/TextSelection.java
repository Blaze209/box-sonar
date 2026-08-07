package com.pspdfkit.datastructures;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.ip;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TextSelection implements Parcelable {
    public static final Parcelable.Creator<TextSelection> CREATOR = new Parcelable.Creator<TextSelection>() { // from class: com.pspdfkit.datastructures.TextSelection.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextSelection createFromParcel(Parcel parcel) {
            return new TextSelection(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextSelection[] newArray(int i) {
            return new TextSelection[i];
        }
    };
    public final int pageIndex;
    public final String text;
    public final List<RectF> textBlocks;
    public final Range textRange;

    private TextSelection(int i, Range range, String str, List<RectF> list) {
        this.textRange = range;
        this.text = str;
        this.pageIndex = i;
        this.textBlocks = list;
    }

    public static TextSelection fromTextRange(PdfDocument pdfDocument, int i, Range range) {
        String pageText = pdfDocument.getPageText(i, range.getStartPosition(), range.getLength());
        if (range.getLength() == 0 && TextUtils.isEmpty(pageText)) {
            pageText = null;
        }
        List<RectF> pageTextRects = pdfDocument.getPageTextRects(i, range.getStartPosition(), range.getLength(), true);
        if (pageTextRects.size() == 1 && pageTextRects.get(0).left == 0.0f && pageTextRects.get(0).right == 0.0f && pageTextRects.get(0).top == 0.0f && pageTextRects.get(0).bottom == 0.0f) {
            pageTextRects.clear();
        }
        return new TextSelection(i, range, pageText, pageTextRects);
    }

    public static TextSelection fromTextRects(PdfDocument pdfDocument, int i, TextSelectionRectangles textSelectionRectangles) {
        RectF rectFA = ip.a(textSelectionRectangles.getRectangles());
        String pageText = pdfDocument.getPageText(i, rectFA);
        if (pageText.endsWith(IOUtils.LINE_SEPARATOR_WINDOWS)) {
            pageText = pageText.substring(0, pageText.length() - 2);
        }
        return new TextSelection(i, pageText, textSelectionRectangles.getMarkupRectangles(), Integer.valueOf(pdfDocument.getCharIndexAt(i, rectFA.left, rectFA.centerY())));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSelection)) {
            return false;
        }
        TextSelection textSelection = (TextSelection) obj;
        if (this.pageIndex != textSelection.pageIndex || !this.textRange.equals(textSelection.textRange)) {
            return false;
        }
        String str = this.text;
        String str2 = textSelection.text;
        if (str == null ? str2 == null : str.equals(str2)) {
            return this.textBlocks.equals(textSelection.textBlocks);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.textRange.hashCode() * 31;
        String str = this.text;
        return this.textBlocks.hashCode() + ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.pageIndex) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.textRange, i);
        parcel.writeString(this.text);
        parcel.writeInt(this.pageIndex);
        parcel.writeTypedList(this.textBlocks);
    }

    private TextSelection(int i, String str, List<RectF> list, Integer num) {
        this.text = str;
        this.pageIndex = i;
        this.textBlocks = list;
        this.textRange = str == null ? new Range(num.intValue(), 0) : new Range(num.intValue(), str.length());
    }

    public TextSelection(Parcel parcel) {
        this.textRange = (Range) parcel.readParcelable(Range.class.getClassLoader());
        this.text = parcel.readString();
        this.pageIndex = parcel.readInt();
        this.textBlocks = parcel.createTypedArrayList(RectF.CREATOR);
    }
}
