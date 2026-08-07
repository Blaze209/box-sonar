package com.pspdfkit.ui.signatures;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.configuration.forms.SignaturePickerOrientation;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "`SignatureOptions` was replaced by {@link ElectronicSignatureOptions} in 2021.")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/pspdfkit/ui/signatures/SignatureOptions;", "Landroid/os/Parcelable;", "signaturePickerOrientation", "Lcom/pspdfkit/configuration/forms/SignaturePickerOrientation;", "signatureSavingStrategy", "Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;", "<init>", "(Lcom/pspdfkit/configuration/forms/SignaturePickerOrientation;Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;)V", "getSignaturePickerOrientation", "()Lcom/pspdfkit/configuration/forms/SignaturePickerOrientation;", "getSignatureSavingStrategy", "()Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SignatureOptions implements Parcelable {
    private final SignaturePickerOrientation signaturePickerOrientation;
    private final SignatureSavingStrategy signatureSavingStrategy;
    public static final Parcelable.Creator<SignatureOptions> CREATOR = new Creator();
    public static final int $stable = 8;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SignatureOptions> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SignatureOptions createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new SignatureOptions(SignaturePickerOrientation.valueOf(parcel.readString()), SignatureSavingStrategy.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SignatureOptions[] newArray(int i) {
            return new SignatureOptions[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SignatureOptions() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SignatureOptions copy$default(SignatureOptions signatureOptions, SignaturePickerOrientation signaturePickerOrientation, SignatureSavingStrategy signatureSavingStrategy, int i, Object obj) {
        if ((i & 1) != 0) {
            signaturePickerOrientation = signatureOptions.signaturePickerOrientation;
        }
        if ((i & 2) != 0) {
            signatureSavingStrategy = signatureOptions.signatureSavingStrategy;
        }
        return signatureOptions.copy(signaturePickerOrientation, signatureSavingStrategy);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SignaturePickerOrientation getSignaturePickerOrientation() {
        return this.signaturePickerOrientation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SignatureSavingStrategy getSignatureSavingStrategy() {
        return this.signatureSavingStrategy;
    }

    public final SignatureOptions copy(SignaturePickerOrientation signaturePickerOrientation, SignatureSavingStrategy signatureSavingStrategy) {
        signaturePickerOrientation.getClass();
        signatureSavingStrategy.getClass();
        return new SignatureOptions(signaturePickerOrientation, signatureSavingStrategy);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignatureOptions)) {
            return false;
        }
        SignatureOptions signatureOptions = (SignatureOptions) other;
        return this.signaturePickerOrientation == signatureOptions.signaturePickerOrientation && this.signatureSavingStrategy == signatureOptions.signatureSavingStrategy;
    }

    public final SignaturePickerOrientation getSignaturePickerOrientation() {
        return this.signaturePickerOrientation;
    }

    public final SignatureSavingStrategy getSignatureSavingStrategy() {
        return this.signatureSavingStrategy;
    }

    public int hashCode() {
        return this.signatureSavingStrategy.hashCode() + (this.signaturePickerOrientation.hashCode() * 31);
    }

    public String toString() {
        return "SignatureOptions(signaturePickerOrientation=" + this.signaturePickerOrientation + ", signatureSavingStrategy=" + this.signatureSavingStrategy + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeString(this.signaturePickerOrientation.name());
        dest.writeString(this.signatureSavingStrategy.name());
    }

    public SignatureOptions(SignaturePickerOrientation signaturePickerOrientation, SignatureSavingStrategy signatureSavingStrategy) {
        signaturePickerOrientation.getClass();
        signatureSavingStrategy.getClass();
        this.signaturePickerOrientation = signaturePickerOrientation;
        this.signatureSavingStrategy = signatureSavingStrategy;
    }

    public /* synthetic */ SignatureOptions(SignaturePickerOrientation signaturePickerOrientation, SignatureSavingStrategy signatureSavingStrategy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SignaturePickerOrientation.AUTOMATIC : signaturePickerOrientation, (i & 2) != 0 ? SignatureSavingStrategy.SAVE_IF_SELECTED : signatureSavingStrategy);
    }
}
