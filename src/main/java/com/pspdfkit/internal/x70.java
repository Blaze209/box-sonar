package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x70 implements Parcelable {
    public static final Parcelable.Creator<x70> CREATOR = new a();
    public final RectF a;
    public final int b;
    public final float c;

    public static final class a implements Parcelable.Creator<x70> {
        @Override // android.os.Parcelable.Creator
        public final x70 createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new x70((RectF) parcel.readParcelable(x70.class.getClassLoader()), parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final x70[] newArray(int i) {
            return new x70[i];
        }
    }

    public x70(RectF rectF, int i, float f) {
        rectF.getClass();
        this.a = rectF;
        this.b = i;
        this.c = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x70)) {
            return false;
        }
        x70 x70Var = (x70) obj;
        return Intrinsics.areEqual(this.a, x70Var.a) && this.b == x70Var.b && Float.compare(this.c, x70Var.c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.c) + nd.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "ViewState{visibleRectCenter=" + new PointF(this.a.centerX(), this.a.centerY()) + ", currentZoom=" + this.c + ", currentPageIndex=" + this.b + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.a, i);
        parcel.writeInt(this.b);
        parcel.writeFloat(this.c);
    }
}
