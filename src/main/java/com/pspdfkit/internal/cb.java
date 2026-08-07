package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class cb implements Parcelable {
    public static final a CREATOR = new a();
    public int a;

    public static final class a implements Parcelable.Creator<cb> {
        @Override // android.os.Parcelable.Creator
        public final cb createFromParcel(Parcel parcel) {
            parcel.getClass();
            int i = parcel.readInt();
            cb cbVar = new cb();
            cbVar.a = i;
            return cbVar;
        }

        @Override // android.os.Parcelable.Creator
        public final cb[] newArray(int i) {
            return new cb[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.a);
    }
}
