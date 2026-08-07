package com.pspdfkit.configuration.signatures;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes3.dex */
class ColorResOptions implements SignatureColorOptions {
    public static final Parcelable.Creator<ColorResOptions> CREATOR = new Parcelable.Creator<ColorResOptions>() { // from class: com.pspdfkit.configuration.signatures.ColorResOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorResOptions createFromParcel(Parcel parcel) {
            return new ColorResOptions(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorResOptions[] newArray(int i) {
            return new ColorResOptions[i];
        }
    };
    private final int option1;
    private final int option2;
    private final int option3;

    public ColorResOptions(int i, int i2, int i3) {
        this.option1 = i;
        this.option2 = i2;
        this.option3 = i3;
    }

    private void checkContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("`context` must not be null when creating `SignatureColorOptions` from @ColorRes. Use the @ColorInt creator to use without a context.");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColorResOptions)) {
            return false;
        }
        ColorResOptions colorResOptions = (ColorResOptions) obj;
        return this.option1 == colorResOptions.option1 && this.option2 == colorResOptions.option2 && this.option3 == colorResOptions.option3;
    }

    public int hashCode() {
        return (((this.option1 * 31) + this.option2) * 31) + this.option3;
    }

    @Override // com.pspdfkit.configuration.signatures.SignatureColorOptions
    public int option1(Context context) {
        checkContext(context);
        return ContextCompat.getColor(context, this.option1);
    }

    @Override // com.pspdfkit.configuration.signatures.SignatureColorOptions
    public int option2(Context context) {
        checkContext(context);
        return ContextCompat.getColor(context, this.option2);
    }

    @Override // com.pspdfkit.configuration.signatures.SignatureColorOptions
    public int option3(Context context) {
        checkContext(context);
        return ContextCompat.getColor(context, this.option3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.option1);
        parcel.writeInt(this.option2);
        parcel.writeInt(this.option3);
    }
}
