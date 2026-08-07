package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class ts implements Parcelable {
    public static final Parcelable.Creator<ts> CREATOR = new a();
    public final boolean a;

    public static final class a implements Parcelable.Creator<ts> {
        @Override // android.os.Parcelable.Creator
        public final ts createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new ts(parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final ts[] newArray(int i) {
            return new ts[i];
        }
    }

    public ts(boolean z) {
        this.a = z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ts) && this.a == ((ts) obj).a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public final String toString() {
        return "NoteEditorState(styleBoxExpanded=" + this.a + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.a ? 1 : 0);
    }
}
