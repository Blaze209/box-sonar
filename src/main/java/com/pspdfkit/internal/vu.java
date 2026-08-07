package com.pspdfkit.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.providers.DataProvider;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class vu implements Parcelable {
    public static final Parcelable.Creator<vu> CREATOR = new a();
    public final DocumentSource a;

    public class a implements Parcelable.Creator<vu> {
        @Override // android.os.Parcelable.Creator
        public final vu createFromParcel(Parcel parcel) {
            return new vu(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final vu[] newArray(int i) {
            return new vu[i];
        }
    }

    public vu(DocumentSource documentSource) {
        uw.a(documentSource, "documentSource", null);
        if (!a(documentSource)) {
            throw new IllegalArgumentException("The DataProvider must implement Parcelable when writing DocumentSource to Parcel.");
        }
        this.a = documentSource;
    }

    public static boolean a(DocumentSource documentSource) {
        return documentSource.getDataProvider() == null || (documentSource.getDataProvider() instanceof Parcelable);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a.getFileUri(), i);
        parcel.writeParcelable((Parcelable) this.a.getDataProvider(), i);
        parcel.writeString(this.a.getContentSignature());
        parcel.writeString(this.a.getPassword());
        parcel.writeSerializable(this.a.getCheckpointFile());
        parcel.writeByte(this.a.isCheckpointAlreadyCreated() ? (byte) 1 : (byte) 0);
    }

    public vu(Parcel parcel) {
        this.a = new DocumentSource((Uri) parcel.readParcelable(Uri.class.getClassLoader()), (DataProvider) parcel.readParcelable(DataProvider.class.getClassLoader()), parcel.readString(), parcel.readString(), (File) parcel.readSerializable(), parcel.readByte() != 0);
    }
}
