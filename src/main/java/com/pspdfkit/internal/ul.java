package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class ul implements Parcelable {
    public static final Parcelable.Creator<ul> CREATOR = new a();
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public class a implements Parcelable.Creator<ul> {
        @Override // android.os.Parcelable.Creator
        public final ul createFromParcel(Parcel parcel) {
            return new ul(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ul[] newArray(int i) {
            return new ul[i];
        }
    }

    public ul(String str, String str2) {
        uw.a(str, "serverUrl", null);
        uw.a(str2, "jwt", null);
        wl wlVarA = wl.a(str2);
        this.a = ll.a(str);
        this.b = wlVarA.a.documentId();
        this.c = wlVarA.a.layerName();
        this.d = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ul)) {
            return false;
        }
        ul ulVar = (ul) obj;
        return this.a.equals(ulVar.a) && this.d.equals(ulVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + (this.a.hashCode() * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.d);
    }

    public ul(Parcel parcel) {
        this.a = parcel.readString();
        String string = parcel.readString();
        this.d = string;
        wl wlVarA = wl.a(string);
        this.b = wlVarA.a.documentId();
        this.c = wlVarA.a.layerName();
    }
}
