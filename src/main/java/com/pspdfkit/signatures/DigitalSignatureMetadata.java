package com.pspdfkit.signatures;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.signatures.timestamp.TimestampData;
import com.pspdfkit.utils.ParcelExtensions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u00015B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u000f\u0010\u0013J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jb\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0083\u0004J\n\u00103\u001a\u00020\u0005HÖ\u0081\u0004J\n\u00104\u001a\u00020\tHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00066"}, d2 = {"Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "Landroid/os/Parcelable;", "signatureAppearance", "Lcom/pspdfkit/signatures/SignatureAppearance;", "estimatedSize", "", "hashAlgorithm", "Lcom/pspdfkit/signatures/HashAlgorithm;", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "", FirebaseAnalytics.Param.LOCATION, "timestampData", "Lcom/pspdfkit/signatures/timestamp/TimestampData;", "biometricData", "Lcom/pspdfkit/signatures/BiometricSignatureData;", "<init>", "(Lcom/pspdfkit/signatures/SignatureAppearance;Ljava/lang/Integer;Lcom/pspdfkit/signatures/HashAlgorithm;Ljava/lang/String;Ljava/lang/String;Lcom/pspdfkit/signatures/timestamp/TimestampData;Lcom/pspdfkit/signatures/BiometricSignatureData;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSignatureAppearance", "()Lcom/pspdfkit/signatures/SignatureAppearance;", "getEstimatedSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHashAlgorithm", "()Lcom/pspdfkit/signatures/HashAlgorithm;", "getReason", "()Ljava/lang/String;", "getLocation", "getTimestampData", "()Lcom/pspdfkit/signatures/timestamp/TimestampData;", "getBiometricData", "()Lcom/pspdfkit/signatures/BiometricSignatureData;", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/pspdfkit/signatures/SignatureAppearance;Ljava/lang/Integer;Lcom/pspdfkit/signatures/HashAlgorithm;Ljava/lang/String;Ljava/lang/String;Lcom/pspdfkit/signatures/timestamp/TimestampData;Lcom/pspdfkit/signatures/BiometricSignatureData;)Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "equals", "", "other", "", "hashCode", "toString", BoxTaskCollaborator.ROLE_CREATOR, "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DigitalSignatureMetadata implements Parcelable {
    private final BiometricSignatureData biometricData;
    private final Integer estimatedSize;
    private final HashAlgorithm hashAlgorithm;
    private final String location;
    private final String reason;
    private final SignatureAppearance signatureAppearance;
    private final TimestampData timestampData;

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.pspdfkit.signatures.DigitalSignatureMetadata$CREATOR, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/pspdfkit/signatures/DigitalSignatureMetadata$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<DigitalSignatureMetadata> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DigitalSignatureMetadata createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new DigitalSignatureMetadata(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DigitalSignatureMetadata[] newArray(int size) {
            return new DigitalSignatureMetadata[size];
        }
    }

    public DigitalSignatureMetadata() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ DigitalSignatureMetadata copy$default(DigitalSignatureMetadata digitalSignatureMetadata, SignatureAppearance signatureAppearance, Integer num, HashAlgorithm hashAlgorithm, String str, String str2, TimestampData timestampData, BiometricSignatureData biometricSignatureData, int i, Object obj) {
        if ((i & 1) != 0) {
            signatureAppearance = digitalSignatureMetadata.signatureAppearance;
        }
        if ((i & 2) != 0) {
            num = digitalSignatureMetadata.estimatedSize;
        }
        if ((i & 4) != 0) {
            hashAlgorithm = digitalSignatureMetadata.hashAlgorithm;
        }
        if ((i & 8) != 0) {
            str = digitalSignatureMetadata.reason;
        }
        if ((i & 16) != 0) {
            str2 = digitalSignatureMetadata.location;
        }
        if ((i & 32) != 0) {
            timestampData = digitalSignatureMetadata.timestampData;
        }
        if ((i & 64) != 0) {
            biometricSignatureData = digitalSignatureMetadata.biometricData;
        }
        TimestampData timestampData2 = timestampData;
        BiometricSignatureData biometricSignatureData2 = biometricSignatureData;
        String str3 = str2;
        HashAlgorithm hashAlgorithm2 = hashAlgorithm;
        return digitalSignatureMetadata.copy(signatureAppearance, num, hashAlgorithm2, str, str3, timestampData2, biometricSignatureData2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SignatureAppearance getSignatureAppearance() {
        return this.signatureAppearance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getEstimatedSize() {
        return this.estimatedSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final TimestampData getTimestampData() {
        return this.timestampData;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final BiometricSignatureData getBiometricData() {
        return this.biometricData;
    }

    public final DigitalSignatureMetadata copy(SignatureAppearance signatureAppearance, Integer estimatedSize, HashAlgorithm hashAlgorithm, String reason, String location, TimestampData timestampData, BiometricSignatureData biometricData) {
        return new DigitalSignatureMetadata(signatureAppearance, estimatedSize, hashAlgorithm, reason, location, timestampData, biometricData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DigitalSignatureMetadata)) {
            return false;
        }
        DigitalSignatureMetadata digitalSignatureMetadata = (DigitalSignatureMetadata) other;
        return Intrinsics.areEqual(this.signatureAppearance, digitalSignatureMetadata.signatureAppearance) && Intrinsics.areEqual(this.estimatedSize, digitalSignatureMetadata.estimatedSize) && this.hashAlgorithm == digitalSignatureMetadata.hashAlgorithm && Intrinsics.areEqual(this.reason, digitalSignatureMetadata.reason) && Intrinsics.areEqual(this.location, digitalSignatureMetadata.location) && Intrinsics.areEqual(this.timestampData, digitalSignatureMetadata.timestampData) && Intrinsics.areEqual(this.biometricData, digitalSignatureMetadata.biometricData);
    }

    public final BiometricSignatureData getBiometricData() {
        return this.biometricData;
    }

    public final Integer getEstimatedSize() {
        return this.estimatedSize;
    }

    public final HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getReason() {
        return this.reason;
    }

    public final SignatureAppearance getSignatureAppearance() {
        return this.signatureAppearance;
    }

    public final TimestampData getTimestampData() {
        return this.timestampData;
    }

    public int hashCode() {
        SignatureAppearance signatureAppearance = this.signatureAppearance;
        int iHashCode = (signatureAppearance == null ? 0 : signatureAppearance.hashCode()) * 31;
        Integer num = this.estimatedSize;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        HashAlgorithm hashAlgorithm = this.hashAlgorithm;
        int iHashCode3 = (iHashCode2 + (hashAlgorithm == null ? 0 : hashAlgorithm.hashCode())) * 31;
        String str = this.reason;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.location;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        TimestampData timestampData = this.timestampData;
        int iHashCode6 = (iHashCode5 + (timestampData == null ? 0 : timestampData.hashCode())) * 31;
        BiometricSignatureData biometricSignatureData = this.biometricData;
        return iHashCode6 + (biometricSignatureData != null ? biometricSignatureData.hashCode() : 0);
    }

    public String toString() {
        return "DigitalSignatureMetadata(signatureAppearance=" + this.signatureAppearance + ", estimatedSize=" + this.estimatedSize + ", hashAlgorithm=" + this.hashAlgorithm + ", reason=" + this.reason + ", location=" + this.location + ", timestampData=" + this.timestampData + ", biometricData=" + this.biometricData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.getClass();
        parcel.writeParcelable(this.signatureAppearance, flags);
        parcel.writeValue(this.estimatedSize);
        HashAlgorithm hashAlgorithm = this.hashAlgorithm;
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.SHA256;
        }
        parcel.writeInt(hashAlgorithm.ordinal());
        parcel.writeString(this.reason);
        parcel.writeString(this.location);
        parcel.writeParcelable(this.timestampData, flags);
        parcel.writeParcelable(this.biometricData, flags);
    }

    public DigitalSignatureMetadata(SignatureAppearance signatureAppearance, Integer num, HashAlgorithm hashAlgorithm, String str, String str2, TimestampData timestampData, BiometricSignatureData biometricSignatureData) {
        this.signatureAppearance = signatureAppearance;
        this.estimatedSize = num;
        this.hashAlgorithm = hashAlgorithm;
        this.reason = str;
        this.location = str2;
        this.timestampData = timestampData;
        this.biometricData = biometricSignatureData;
    }

    public /* synthetic */ DigitalSignatureMetadata(SignatureAppearance signatureAppearance, Integer num, HashAlgorithm hashAlgorithm, String str, String str2, TimestampData timestampData, BiometricSignatureData biometricSignatureData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : signatureAppearance, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : hashAlgorithm, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : timestampData, (i & 64) != 0 ? null : biometricSignatureData);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DigitalSignatureMetadata(Parcel parcel) {
        parcel.getClass();
        SignatureAppearance signatureAppearance = (SignatureAppearance) ParcelExtensions.readSupportParcelable(parcel, SignatureAppearance.class.getClassLoader(), SignatureAppearance.class);
        Object value = parcel.readValue(Integer.TYPE.getClassLoader());
        this(signatureAppearance, value instanceof Integer ? (Integer) value : null, HashAlgorithm.values()[parcel.readInt()], parcel.readString(), parcel.readString(), (TimestampData) ParcelExtensions.readSupportParcelable(parcel, TimestampData.class.getClassLoader(), TimestampData.class), (BiometricSignatureData) ParcelExtensions.readSupportParcelable(parcel, BiometricSignatureData.class.getClassLoader(), BiometricSignatureData.class));
    }
}
