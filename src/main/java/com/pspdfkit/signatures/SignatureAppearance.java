package com.pspdfkit.signatures;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.mv;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u00016Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003Jq\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0006\u0010)\u001a\u00020*J\u0014\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0083\u0004J\n\u0010.\u001a\u00020*HÖ\u0081\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00067"}, d2 = {"Lcom/pspdfkit/signatures/SignatureAppearance;", "Landroid/os/Parcelable;", "signatureAppearanceMode", "Lcom/pspdfkit/signatures/SignatureAppearance$SignatureAppearanceMode;", "showSignerName", "", "showSignDate", "showSignatureReason", "showSignatureLocation", "signatureGraphic", "Lcom/pspdfkit/signatures/SignatureGraphic;", "signatureWatermark", "reuseExistingSignatureAppearanceStream", "showWatermark", "showDateTimezone", "<init>", "(Lcom/pspdfkit/signatures/SignatureAppearance$SignatureAppearanceMode;ZZZZLcom/pspdfkit/signatures/SignatureGraphic;Lcom/pspdfkit/signatures/SignatureGraphic;ZZZ)V", "getSignatureAppearanceMode", "()Lcom/pspdfkit/signatures/SignatureAppearance$SignatureAppearanceMode;", "getShowSignerName", "()Z", "getShowSignDate", "getShowSignatureReason", "getShowSignatureLocation", "getSignatureGraphic", "()Lcom/pspdfkit/signatures/SignatureGraphic;", "getSignatureWatermark", "getReuseExistingSignatureAppearanceStream", "getShowWatermark", "getShowDateTimezone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "SignatureAppearanceMode", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SignatureAppearance implements Parcelable {
    private final boolean reuseExistingSignatureAppearanceStream;
    private final boolean showDateTimezone;
    private final boolean showSignDate;
    private final boolean showSignatureLocation;
    private final boolean showSignatureReason;
    private final boolean showSignerName;
    private final boolean showWatermark;
    private final SignatureAppearanceMode signatureAppearanceMode;
    private final SignatureGraphic signatureGraphic;
    private final SignatureGraphic signatureWatermark;
    public static final Parcelable.Creator<SignatureAppearance> CREATOR = new Creator();
    public static final int $stable = 8;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SignatureAppearance> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SignatureAppearance createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            parcel.getClass();
            SignatureAppearanceMode signatureAppearanceModeValueOf = SignatureAppearanceMode.valueOf(parcel.readString());
            boolean z3 = true;
            boolean z4 = false;
            if (parcel.readInt() == 0) {
                z3 = false;
            }
            if (parcel.readInt() != 0) {
                z4 = true;
            }
            if (parcel.readInt() != 0) {
                z4 = z3;
            }
            if (parcel.readInt() != 0) {
                z4 = z3;
            }
            SignatureGraphic signatureGraphicCreateFromParcel = parcel.readInt() == 0 ? null : SignatureGraphic.CREATOR.createFromParcel(parcel);
            SignatureGraphic signatureGraphicCreateFromParcel2 = parcel.readInt() != 0 ? SignatureGraphic.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                z = false;
                z2 = z3;
            } else {
                z = z4;
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z = z3;
            }
            if (parcel.readInt() != 0) {
                z = z3;
            }
            return new SignatureAppearance(signatureAppearanceModeValueOf, z3, z4, z4, z4, signatureGraphicCreateFromParcel, signatureGraphicCreateFromParcel2, z2, z, z);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SignatureAppearance[] newArray(int i) {
            return new SignatureAppearance[i];
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/pspdfkit/signatures/SignatureAppearance$SignatureAppearanceMode;", "", "<init>", "(Ljava/lang/String;I)V", "SIGNATURE_AND_DESCRIPTION", "DESCRIPTION_ONLY", "SIGNATURE_ONLY", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum SignatureAppearanceMode {
        SIGNATURE_AND_DESCRIPTION,
        DESCRIPTION_ONLY,
        SIGNATURE_ONLY;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<SignatureAppearanceMode> getEntries() {
            return $ENTRIES;
        }
    }

    public SignatureAppearance() {
        this(null, false, false, false, false, null, null, false, false, false, 1023, null);
    }

    public static /* synthetic */ SignatureAppearance copy$default(SignatureAppearance signatureAppearance, SignatureAppearanceMode signatureAppearanceMode, boolean z, boolean z2, boolean z3, boolean z4, SignatureGraphic signatureGraphic, SignatureGraphic signatureGraphic2, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            signatureAppearanceMode = signatureAppearance.signatureAppearanceMode;
        }
        if ((i & 2) != 0) {
            z = signatureAppearance.showSignerName;
        }
        if ((i & 4) != 0) {
            z2 = signatureAppearance.showSignDate;
        }
        if ((i & 8) != 0) {
            z3 = signatureAppearance.showSignatureReason;
        }
        if ((i & 16) != 0) {
            z4 = signatureAppearance.showSignatureLocation;
        }
        if ((i & 32) != 0) {
            signatureGraphic = signatureAppearance.signatureGraphic;
        }
        if ((i & 64) != 0) {
            signatureGraphic2 = signatureAppearance.signatureWatermark;
        }
        if ((i & 128) != 0) {
            z5 = signatureAppearance.reuseExistingSignatureAppearanceStream;
        }
        if ((i & 256) != 0) {
            z6 = signatureAppearance.showWatermark;
        }
        if ((i & 512) != 0) {
            z7 = signatureAppearance.showDateTimezone;
        }
        boolean z8 = z6;
        boolean z9 = z7;
        SignatureGraphic signatureGraphic3 = signatureGraphic2;
        boolean z10 = z5;
        boolean z11 = z4;
        SignatureGraphic signatureGraphic4 = signatureGraphic;
        return signatureAppearance.copy(signatureAppearanceMode, z, z2, z3, z11, signatureGraphic4, signatureGraphic3, z10, z8, z9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SignatureAppearanceMode getSignatureAppearanceMode() {
        return this.signatureAppearanceMode;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getShowDateTimezone() {
        return this.showDateTimezone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowSignerName() {
        return this.showSignerName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowSignDate() {
        return this.showSignDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowSignatureReason() {
        return this.showSignatureReason;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowSignatureLocation() {
        return this.showSignatureLocation;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SignatureGraphic getSignatureGraphic() {
        return this.signatureGraphic;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SignatureGraphic getSignatureWatermark() {
        return this.signatureWatermark;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getReuseExistingSignatureAppearanceStream() {
        return this.reuseExistingSignatureAppearanceStream;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getShowWatermark() {
        return this.showWatermark;
    }

    public final SignatureAppearance copy(SignatureAppearanceMode signatureAppearanceMode, boolean showSignerName, boolean showSignDate, boolean showSignatureReason, boolean showSignatureLocation, SignatureGraphic signatureGraphic, SignatureGraphic signatureWatermark, boolean reuseExistingSignatureAppearanceStream, boolean showWatermark, boolean showDateTimezone) {
        signatureAppearanceMode.getClass();
        return new SignatureAppearance(signatureAppearanceMode, showSignerName, showSignDate, showSignatureReason, showSignatureLocation, signatureGraphic, signatureWatermark, reuseExistingSignatureAppearanceStream, showWatermark, showDateTimezone);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignatureAppearance)) {
            return false;
        }
        SignatureAppearance signatureAppearance = (SignatureAppearance) other;
        return this.signatureAppearanceMode == signatureAppearance.signatureAppearanceMode && this.showSignerName == signatureAppearance.showSignerName && this.showSignDate == signatureAppearance.showSignDate && this.showSignatureReason == signatureAppearance.showSignatureReason && this.showSignatureLocation == signatureAppearance.showSignatureLocation && Intrinsics.areEqual(this.signatureGraphic, signatureAppearance.signatureGraphic) && Intrinsics.areEqual(this.signatureWatermark, signatureAppearance.signatureWatermark) && this.reuseExistingSignatureAppearanceStream == signatureAppearance.reuseExistingSignatureAppearanceStream && this.showWatermark == signatureAppearance.showWatermark && this.showDateTimezone == signatureAppearance.showDateTimezone;
    }

    public final boolean getReuseExistingSignatureAppearanceStream() {
        return this.reuseExistingSignatureAppearanceStream;
    }

    public final boolean getShowDateTimezone() {
        return this.showDateTimezone;
    }

    public final boolean getShowSignDate() {
        return this.showSignDate;
    }

    public final boolean getShowSignatureLocation() {
        return this.showSignatureLocation;
    }

    public final boolean getShowSignatureReason() {
        return this.showSignatureReason;
    }

    public final boolean getShowSignerName() {
        return this.showSignerName;
    }

    public final boolean getShowWatermark() {
        return this.showWatermark;
    }

    public final SignatureAppearanceMode getSignatureAppearanceMode() {
        return this.signatureAppearanceMode;
    }

    public final SignatureGraphic getSignatureGraphic() {
        return this.signatureGraphic;
    }

    public final SignatureGraphic getSignatureWatermark() {
        return this.signatureWatermark;
    }

    public int hashCode() {
        int iA = mv.a(this.showSignatureLocation, mv.a(this.showSignatureReason, mv.a(this.showSignDate, mv.a(this.showSignerName, this.signatureAppearanceMode.hashCode() * 31, 31), 31), 31), 31);
        SignatureGraphic signatureGraphic = this.signatureGraphic;
        int iHashCode = (iA + (signatureGraphic == null ? 0 : signatureGraphic.hashCode())) * 31;
        SignatureGraphic signatureGraphic2 = this.signatureWatermark;
        return Boolean.hashCode(this.showDateTimezone) + mv.a(this.showWatermark, mv.a(this.reuseExistingSignatureAppearanceStream, (iHashCode + (signatureGraphic2 != null ? signatureGraphic2.hashCode() : 0)) * 31, 31), 31);
    }

    public String toString() {
        return "SignatureAppearance(signatureAppearanceMode=" + this.signatureAppearanceMode + ", showSignerName=" + this.showSignerName + ", showSignDate=" + this.showSignDate + ", showSignatureReason=" + this.showSignatureReason + ", showSignatureLocation=" + this.showSignatureLocation + ", signatureGraphic=" + this.signatureGraphic + ", signatureWatermark=" + this.signatureWatermark + ", reuseExistingSignatureAppearanceStream=" + this.reuseExistingSignatureAppearanceStream + ", showWatermark=" + this.showWatermark + ", showDateTimezone=" + this.showDateTimezone + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeString(this.signatureAppearanceMode.name());
        dest.writeInt(this.showSignerName ? 1 : 0);
        dest.writeInt(this.showSignDate ? 1 : 0);
        dest.writeInt(this.showSignatureReason ? 1 : 0);
        dest.writeInt(this.showSignatureLocation ? 1 : 0);
        SignatureGraphic signatureGraphic = this.signatureGraphic;
        if (signatureGraphic == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            signatureGraphic.writeToParcel(dest, flags);
        }
        SignatureGraphic signatureGraphic2 = this.signatureWatermark;
        if (signatureGraphic2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            signatureGraphic2.writeToParcel(dest, flags);
        }
        dest.writeInt(this.reuseExistingSignatureAppearanceStream ? 1 : 0);
        dest.writeInt(this.showWatermark ? 1 : 0);
        dest.writeInt(this.showDateTimezone ? 1 : 0);
    }

    public SignatureAppearance(SignatureAppearanceMode signatureAppearanceMode, boolean z, boolean z2, boolean z3, boolean z4, SignatureGraphic signatureGraphic, SignatureGraphic signatureGraphic2, boolean z5, boolean z6, boolean z7) {
        signatureAppearanceMode.getClass();
        this.signatureAppearanceMode = signatureAppearanceMode;
        this.showSignerName = z;
        this.showSignDate = z2;
        this.showSignatureReason = z3;
        this.showSignatureLocation = z4;
        this.signatureGraphic = signatureGraphic;
        this.signatureWatermark = signatureGraphic2;
        this.reuseExistingSignatureAppearanceStream = z5;
        this.showWatermark = z6;
        this.showDateTimezone = z7;
    }

    public /* synthetic */ SignatureAppearance(SignatureAppearanceMode signatureAppearanceMode, boolean z, boolean z2, boolean z3, boolean z4, SignatureGraphic signatureGraphic, SignatureGraphic signatureGraphic2, boolean z5, boolean z6, boolean z7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SignatureAppearanceMode.SIGNATURE_AND_DESCRIPTION : signatureAppearanceMode, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? null : signatureGraphic, (i & 64) != 0 ? null : signatureGraphic2, (i & 128) != 0 ? true : z5, (i & 256) != 0 ? true : z6, (i & 512) != 0 ? true : z7);
    }
}
