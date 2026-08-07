package com.pspdfkit.document.processor;

import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.vu;

/* JADX INFO: loaded from: classes3.dex */
public class ComparisonDocument implements Parcelable {
    public static final Parcelable.Creator<ComparisonDocument> CREATOR = new Parcelable.Creator<ComparisonDocument>() { // from class: com.pspdfkit.document.processor.ComparisonDocument.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ComparisonDocument createFromParcel(Parcel parcel) {
            return new ComparisonDocument(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ComparisonDocument[] newArray(int i) {
            return new ComparisonDocument[i];
        }
    };
    private final vu documentSource;
    private final int lineColor;
    private final int pageIndex;

    public ComparisonDocument(DocumentSource documentSource, int i, int i2) {
        this(new vu(documentSource), i, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DocumentSource getDocumentSource() {
        return this.documentSource.a;
    }

    public int getLineColor() {
        return this.lineColor;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.documentSource, i);
        parcel.writeInt(this.pageIndex);
        parcel.writeInt(this.lineColor);
    }

    public ComparisonDocument(vu vuVar, int i, int i2) {
        uw.a(vuVar, "documentSource", null);
        if (i < 0) {
            throw new IllegalArgumentException("pageIndex has to be > 0 and < document.pageCount.");
        }
        this.documentSource = vuVar;
        this.pageIndex = i;
        this.lineColor = i2;
    }

    private ComparisonDocument(Parcel parcel) {
        this.documentSource = (vu) parcel.readParcelable(vu.class.getClassLoader());
        this.pageIndex = parcel.readInt();
        this.lineColor = parcel.readInt();
    }
}
