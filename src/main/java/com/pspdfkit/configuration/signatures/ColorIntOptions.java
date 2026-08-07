package com.pspdfkit.configuration.signatures;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
class ColorIntOptions implements SignatureColorOptions {
    public static final Parcelable.Creator<ColorIntOptions> CREATOR = new Parcelable.Creator<ColorIntOptions>() { // from class: com.pspdfkit.configuration.signatures.ColorIntOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorIntOptions createFromParcel(Parcel parcel) {
            return new ColorIntOptions(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorIntOptions[] newArray(int i) {
            return new ColorIntOptions[i];
        }
    };
    private final int option1;
    private final int option2;
    private final int option3;

    public ColorIntOptions(int i, int i2, int i3) {
        this.option1 = i;
        this.option2 = i2;
        this.option3 = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorIntOptions)) {
            return false;
        }
        ColorIntOptions colorIntOptions = (ColorIntOptions) obj;
        return this.option1 == colorIntOptions.option1 && this.option2 == colorIntOptions.option2 && this.option3 == colorIntOptions.option3;
    }

    public int hashCode() {
        return (((this.option1 * 31) + this.option2) * 31) + this.option3;
    }

    @Override // com.pspdfkit.configuration.signatures.SignatureColorOptions
    public int option1(Context context) {
        return this.option1;
    }

    @Override // com.pspdfkit.configuration.signatures.SignatureColorOptions
    public int option2(Context context) {
        return this.option2;
    }

    @Override // com.pspdfkit.configuration.signatures.SignatureColorOptions
    public int option3(Context context) {
        return this.option3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.option1);
        parcel.writeInt(this.option2);
        parcel.writeInt(this.option3);
    }
}
