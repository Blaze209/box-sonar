package com.pspdfkit.utils;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class Size implements Comparable<Size>, Parcelable {
    public static final Parcelable.Creator<Size> CREATOR = new Parcelable.Creator<Size>() { // from class: com.pspdfkit.utils.Size.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Size createFromParcel(Parcel parcel) {
            return new Size(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Size[] newArray(int i) {
            return new Size[i];
        }
    };
    public final float height;
    public final float width;

    public Size(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    private Size getSizeForOrientation(Size size, boolean z) {
        float fMax = Math.max(size.width, size.height);
        float fMin = Math.min(size.width, size.height);
        return z ? new Size(fMin, fMax) : new Size(fMax, fMin);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return Float.compare(size.width, this.width) == 0 && Float.compare(size.height, this.height) == 0;
    }

    public int hashCode() {
        float f = this.width;
        int iFloatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
        float f2 = this.height;
        return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    public boolean isPortrait() {
        return this.height >= this.width;
    }

    public Size toLandscape() {
        return getSizeForOrientation(this, false);
    }

    public Size toPortrait() {
        return getSizeForOrientation(this, true);
    }

    public RectF toRect() {
        return toRect(null);
    }

    public String toString() {
        return "Size{width=" + this.width + ", height=" + this.height + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
    }

    @Override // java.lang.Comparable
    public int compareTo(Size size) {
        float fMax = Math.max(this.width, this.height);
        float fMax2 = Math.max(size.width, size.height);
        if (fMax == fMax2) {
            return 0;
        }
        return fMax > fMax2 ? 1 : -1;
    }

    public RectF toRect(RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(0.0f, 0.0f, this.width, this.height);
        return rectF;
    }

    public Size(Parcel parcel) {
        this.width = parcel.readFloat();
        this.height = parcel.readFloat();
    }
}
