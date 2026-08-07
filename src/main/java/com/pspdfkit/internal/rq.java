package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.utils.PdfLog;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class rq implements DataProvider, Parcelable {
    public static final Parcelable.Creator<rq> CREATOR = new a();
    public static final ArrayMap<String, byte[]> d = new ArrayMap<>();
    public String a;
    public byte[] b;
    public byte[] c;

    public class a implements Parcelable.Creator<rq> {
        @Override // android.os.Parcelable.Creator
        public final rq createFromParcel(Parcel parcel) {
            return new rq(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final rq[] newArray(int i) {
            return new rq[i];
        }
    }

    public rq(byte[] bArr) {
        this.a = null;
        this.c = new byte[8192];
        uw.a(bArr, "pdfData", null);
        this.b = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final long getSize() {
        return this.b.length;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final String getTitle() {
        return null;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final String getUid() {
        if (this.a == null) {
            this.a = u40.a(this.b, 5242880);
        }
        return this.a;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final byte[] read(long j, long j2) {
        if (j > this.c.length) {
            this.c = new byte[(int) j];
        }
        long jMin = Math.min(((long) this.b.length) - j2, j);
        if (jMin != j) {
            Arrays.fill(this.c, (byte) 0);
        }
        System.arraycopy(this.b, (int) j2, this.c, 0, (int) jMin);
        return this.c;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final void release() {
        this.b = new byte[0];
        d.remove(getUid());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String uid = getUid();
        PdfLog.v("Nutri.MemoryDataProv", "Parceling memory provider with UID " + uid, new Object[0]);
        d.put(uid, this.b);
        parcel.writeString(uid);
    }

    public rq(Parcel parcel) {
        this.a = null;
        this.c = new byte[8192];
        String string = parcel.readString();
        ArrayMap<String, byte[]> arrayMap = d;
        if (arrayMap.containsKey(string)) {
            this.b = arrayMap.get(string);
            arrayMap.remove(string);
            PdfLog.v("Nutri.MemoryDataProv", "Restored memory provider with UID " + string, new Object[0]);
        } else {
            PdfLog.e("Nutri.MemoryDataProv", "Could not restore PDF activity - memory PDF data is not valid after process death.", new Object[0]);
            this.b = new byte[0];
        }
    }
}
