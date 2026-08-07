package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class fx implements Parcelable {
    public static final Parcelable.Creator<fx> CREATOR = new a();
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;

    public static final class a implements Parcelable.Creator<fx> {
        @Override // android.os.Parcelable.Creator
        public final fx createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new fx(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final fx[] newArray(int i) {
            return new fx[i];
        }
    }

    public fx(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.g = f7;
        this.h = f8;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fx)) {
            return false;
        }
        fx fxVar = (fx) obj;
        return Float.compare(this.a, fxVar.a) == 0 && Float.compare(this.b, fxVar.b) == 0 && Float.compare(this.c, fxVar.c) == 0 && Float.compare(this.d, fxVar.d) == 0 && Float.compare(this.e, fxVar.e) == 0 && Float.compare(this.f, fxVar.f) == 0 && Float.compare(this.g, fxVar.g) == 0 && Float.compare(this.h, fxVar.h) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.h) + kv.a(this.g, kv.a(this.f, kv.a(this.e, kv.a(this.d, kv.a(this.c, kv.a(this.b, Float.hashCode(this.a) * 31, 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "Quadrilateral(topLeftX=" + this.a + ", topLeftY=" + this.b + ", topRightX=" + this.c + ", topRightY=" + this.d + ", bottomLeftX=" + this.e + ", bottomLeftY=" + this.f + ", bottomRightX=" + this.g + ", bottomRightY=" + this.h + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
        parcel.writeFloat(this.g);
        parcel.writeFloat(this.h);
    }
}
