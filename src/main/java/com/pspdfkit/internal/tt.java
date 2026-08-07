package com.pspdfkit.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.R;
import com.pspdfkit.document.PageBinding;

/* JADX INFO: loaded from: classes3.dex */
public final class tt extends od {
    public static final a CREATOR = new a();
    public PageBinding e;

    public static final class a implements Parcelable.Creator<tt> {
        @Override // android.os.Parcelable.Creator
        public final tt createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new tt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final tt[] newArray(int i) {
            return new tt[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt(Context context, PageBinding pageBinding) {
        super(15, no.a(context, R.string.pspdf__page_binding, null), pageBinding.toString(), true);
        pageBinding.getClass();
        this.e = pageBinding;
    }

    @Override // com.pspdfkit.internal.od
    public final String a(Context context) {
        context.getClass();
        PageBinding pageBinding = this.e;
        if (pageBinding == PageBinding.LEFT_EDGE) {
            String strA = no.a(context, R.string.pspdf__page_binding_left_edge, null);
            strA.getClass();
            return strA;
        }
        if (pageBinding == PageBinding.RIGHT_EDGE) {
            String strA2 = no.a(context, R.string.pspdf__page_binding_right_edge, null);
            strA2.getClass();
            return strA2;
        }
        String strA3 = no.a(context, R.string.pspdf__page_binding_unknown, null);
        strA3.getClass();
        return strA3;
    }

    @Override // com.pspdfkit.internal.od, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.pspdfkit.internal.od, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.e.ordinal());
    }

    public tt(Parcel parcel) {
        super(parcel);
        this.e = PageBinding.values()[parcel.readInt()];
    }

    @Override // com.pspdfkit.internal.od
    public final boolean a() {
        return this.e == PageBinding.UNKNOWN;
    }
}
