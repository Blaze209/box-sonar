package com.pspdfkit.signatures;

import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.utils.ParcelExtensions;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0012\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u0014\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\n\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/pspdfkit/signatures/SignatureGraphic;", "Landroid/os/Parcelable;", "isBitmap", "", "uri", "Landroid/net/Uri;", "<init>", "(ZLandroid/net/Uri;)V", "dataProvider", "Lcom/pspdfkit/document/providers/DataProvider;", "(ZLcom/pspdfkit/document/providers/DataProvider;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()Z", "getUri", "()Landroid/net/Uri;", "getDataProvider", "()Lcom/pspdfkit/document/providers/DataProvider;", "equals", "other", "", "hashCode", "", "writeToParcel", "", "dest", "flags", "describeContents", "toString", "", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SignatureGraphic implements Parcelable {
    private final DataProvider dataProvider;
    private final boolean isBitmap;
    private final Uri uri;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<SignatureGraphic> CREATOR = new Parcelable.Creator<SignatureGraphic>() { // from class: com.pspdfkit.signatures.SignatureGraphic$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignatureGraphic createFromParcel(Parcel in) {
            in.getClass();
            return new SignatureGraphic(in, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SignatureGraphic[] newArray(int size) {
            return new SignatureGraphic[size];
        }
    };

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/pspdfkit/signatures/SignatureGraphic$Companion;", "", "<init>", "()V", "fromBitmap", "Lcom/pspdfkit/signatures/SignatureGraphic;", "uri", "Landroid/net/Uri;", "dataProvider", "Lcom/pspdfkit/document/providers/DataProvider;", "fromPdf", "source", "Lcom/pspdfkit/document/DocumentSource;", BoxTaskCollaborator.ROLE_CREATOR, "Landroid/os/Parcelable$Creator;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SignatureGraphic fromBitmap(Uri uri) {
            uri.getClass();
            return new SignatureGraphic(true, uri, (DefaultConstructorMarker) null);
        }

        public final SignatureGraphic fromPdf(DocumentSource source) {
            source.getClass();
            DataProvider dataProvider = source.getDataProvider();
            DefaultConstructorMarker defaultConstructorMarker = null;
            boolean z = false;
            if (dataProvider != null) {
                return new SignatureGraphic(z, dataProvider, defaultConstructorMarker);
            }
            Uri fileUri = source.getFileUri();
            if (fileUri != null) {
                return new SignatureGraphic(z, fileUri, defaultConstructorMarker);
            }
            throw new IllegalArgumentException("Passed in an invalid document source.");
        }

        private Companion() {
        }

        public final SignatureGraphic fromBitmap(DataProvider dataProvider) {
            dataProvider.getClass();
            return new SignatureGraphic(true, dataProvider, (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ SignatureGraphic(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignatureGraphic)) {
            return false;
        }
        SignatureGraphic signatureGraphic = (SignatureGraphic) other;
        return this.isBitmap == signatureGraphic.isBitmap && Intrinsics.areEqual(this.uri, signatureGraphic.uri) && Intrinsics.areEqual(this.dataProvider, signatureGraphic.dataProvider);
    }

    public final DataProvider getDataProvider() {
        return this.dataProvider;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.isBitmap), this.uri, this.dataProvider);
    }

    /* JADX INFO: renamed from: isBitmap, reason: from getter */
    public final boolean getIsBitmap() {
        return this.isBitmap;
    }

    public String toString() {
        return "SignatureGraphic{isBitmap=" + this.isBitmap + ", uri=" + this.uri + ", dataProvider=" + this.dataProvider + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeByte(this.isBitmap ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.uri, flags);
        dest.writeParcelable((Parcelable) this.dataProvider, flags);
    }

    public /* synthetic */ SignatureGraphic(boolean z, Uri uri, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, uri);
    }

    public /* synthetic */ SignatureGraphic(boolean z, DataProvider dataProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, dataProvider);
    }

    private SignatureGraphic(boolean z, Uri uri) {
        this.isBitmap = z;
        this.uri = uri;
        this.dataProvider = null;
    }

    private SignatureGraphic(boolean z, DataProvider dataProvider) {
        if (dataProvider instanceof Parcelable) {
            this.isBitmap = z;
            this.uri = null;
            this.dataProvider = dataProvider;
            return;
        }
        throw new IllegalArgumentException("You need to pass in a parcelable data provider.");
    }

    private SignatureGraphic(Parcel parcel) {
        DataProvider dataProvider;
        this.isBitmap = parcel.readByte() != 0;
        this.uri = (Uri) ParcelExtensions.readSupportParcelable(parcel, Uri.class.getClassLoader(), Uri.class);
        if (Build.VERSION.SDK_INT >= 33) {
            dataProvider = (DataProvider) parcel.readParcelable(DataProvider.class.getClassLoader(), DataProvider.class);
        } else {
            dataProvider = (DataProvider) parcel.readParcelable(DataProvider.class.getClassLoader());
        }
        this.dataProvider = dataProvider;
    }
}
