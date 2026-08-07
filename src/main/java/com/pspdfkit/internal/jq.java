package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class jq implements Parcelable {
    public static final Parcelable.Creator<jq> CREATOR = new a();
    public final int a;
    public final int b;
    public final boolean c;
    public final int d;

    public class a implements Parcelable.Creator<jq> {
        @Override // android.os.Parcelable.Creator
        public final jq createFromParcel(Parcel parcel) {
            return new jq(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final jq[] newArray(int i) {
            return new jq[i];
        }
    }

    public jq(int i, int i2, boolean z, int i3) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = i3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.d);
    }

    public jq(Parcel parcel) {
        this.c = true;
        this.d = 0;
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readInt();
    }
}
