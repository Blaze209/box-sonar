package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ld implements Parcelable {
    public static final Parcelable.Creator<ld> CREATOR = new a();
    public final int a;
    public final String b;
    public int c;
    public final List<od> d;

    public class a implements Parcelable.Creator<ld> {
        @Override // android.os.Parcelable.Creator
        public final ld createFromParcel(Parcel parcel) {
            return new ld(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ld[] newArray(int i) {
            return new ld[i];
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/lang/String;ILjava/util/List<Lcom/pspdfkit/internal/od;>;)V */
    public ld(int i, String str, int i2, List list) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = list;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        parcel.writeInt(i2 == 0 ? -1 : y30.a(i2));
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeList(this.d);
    }

    public ld(Parcel parcel) {
        int i = parcel.readInt();
        this.a = i == -1 ? 0 : y30.b(3)[i];
        this.b = parcel.readString();
        this.c = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        parcel.readList(arrayList, od.class.getClassLoader());
    }
}
