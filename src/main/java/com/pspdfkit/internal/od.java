package com.pspdfkit.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class od implements Parcelable {
    public static final Parcelable.Creator<od> CREATOR = new a();
    public final int a;
    public final String b;
    public String c;
    public final boolean d;

    public class a implements Parcelable.Creator<od> {
        @Override // android.os.Parcelable.Creator
        public final od createFromParcel(Parcel parcel) {
            return new od(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final od[] newArray(int i) {
            return new od[i];
        }
    }

    public od(int i, String str, String str2, boolean z) {
        this.a = i;
        this.b = str;
        a(str2);
        this.d = z;
    }

    public String a(Context context) {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        parcel.writeInt(i2 == 0 ? -1 : y30.a(i2));
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
    }

    public final void a(String str) {
        if (this.a == 4) {
            str = str.replaceAll("\\s*,\\s*", ", ");
        }
        this.c = str;
    }

    public boolean a() {
        return TextUtils.isEmpty(this.c);
    }

    public od(Parcel parcel) {
        int i = parcel.readInt();
        this.a = i == -1 ? 0 : y30.b(16)[i];
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readByte() != 0;
    }
}
