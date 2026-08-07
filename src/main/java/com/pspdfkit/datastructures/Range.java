package com.pspdfkit.datastructures;

import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class Range implements Parcelable, Comparable<Range> {
    public static final Parcelable.Creator<Range> CREATOR = new Parcelable.Creator<Range>() { // from class: com.pspdfkit.datastructures.Range.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Range createFromParcel(Parcel parcel) {
            return new Range(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Range[] newArray(int i) {
            return new Range[i];
        }
    };
    private final int length;
    private final int position;

    public Range(int i, int i2) {
        this.position = i;
        this.length = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.position == range.position && this.length == range.length;
    }

    public int getEndPosition() {
        return this.position + this.length;
    }

    public int getLength() {
        return this.length;
    }

    public int getStartPosition() {
        return this.position;
    }

    public int hashCode() {
        return (this.position * 31) + this.length;
    }

    public String toString() {
        return "Range{position=" + this.position + ", length=" + this.length + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.position);
        parcel.writeInt(this.length);
    }

    @Override // java.lang.Comparable
    public int compareTo(Range range) {
        int i;
        int i2 = this.position;
        int i3 = range.position;
        if (i2 < i3) {
            i = -1;
        } else {
            i = i2 > i3 ? 1 : 0;
        }
        if (i != 0) {
            return i;
        }
        int i4 = this.length;
        int i5 = range.length;
        if (i4 < i5) {
            return -1;
        }
        return i4 > i5 ? 1 : 0;
    }

    public Range(Parcel parcel) {
        this.position = parcel.readInt();
        this.length = parcel.readInt();
    }
}
