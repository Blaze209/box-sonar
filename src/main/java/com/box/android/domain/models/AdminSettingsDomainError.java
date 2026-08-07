package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/models/AdminSettingsDomainError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "errorType", "Lcom/box/android/domain/models/ErrorRecoveryType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ErrorRecoveryType;)V", "getMessage", "()Ljava/lang/String;", "getErrorType", "()Lcom/box/android/domain/models/ErrorRecoveryType;", "FeatureDisabled", "EncryptedDeviceRequired", "SaveToLocationDisabled", "PreviewOnlyOffliningDisabled", "SavingOnDeviceDisabled", "Lcom/box/android/domain/models/AdminSettingsDomainError$EncryptedDeviceRequired;", "Lcom/box/android/domain/models/AdminSettingsDomainError$FeatureDisabled;", "Lcom/box/android/domain/models/AdminSettingsDomainError$PreviewOnlyOffliningDisabled;", "Lcom/box/android/domain/models/AdminSettingsDomainError$SaveToLocationDisabled;", "Lcom/box/android/domain/models/AdminSettingsDomainError$SavingOnDeviceDisabled;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AdminSettingsDomainError extends DomainError {
    private final ErrorRecoveryType errorType;
    private final String message;

    public /* synthetic */ AdminSettingsDomainError(String str, ErrorRecoveryType errorRecoveryType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, errorRecoveryType);
    }

    private AdminSettingsDomainError(String str, ErrorRecoveryType errorRecoveryType) {
        super(null, errorRecoveryType, 1, null);
        this.message = str;
        this.errorType = errorRecoveryType;
    }

    @Override // com.box.android.domain.models.DomainError
    public ErrorRecoveryType getErrorType() {
        return this.errorType;
    }

    @Override // com.box.android.domain.models.DomainError
    public String getMessage() {
        return this.message;
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AdminSettingsDomainError$FeatureDisabled;", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FeatureDisabled extends AdminSettingsDomainError {
        public static final Parcelable.Creator<FeatureDisabled> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FeatureDisabled> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FeatureDisabled createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FeatureDisabled(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FeatureDisabled[] newArray(int i) {
                return new FeatureDisabled[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FeatureDisabled() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FeatureDisabled copy$default(FeatureDisabled featureDisabled, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = featureDisabled.message;
            }
            return featureDisabled.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final FeatureDisabled copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new FeatureDisabled(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FeatureDisabled) && Intrinsics.areEqual(this.message, ((FeatureDisabled) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "FeatureDisabled(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeatureDisabled(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ FeatureDisabled(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AdminSettingsDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AdminSettingsDomainError$EncryptedDeviceRequired;", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EncryptedDeviceRequired extends AdminSettingsDomainError {
        public static final Parcelable.Creator<EncryptedDeviceRequired> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<EncryptedDeviceRequired> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EncryptedDeviceRequired createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new EncryptedDeviceRequired(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EncryptedDeviceRequired[] newArray(int i) {
                return new EncryptedDeviceRequired[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public EncryptedDeviceRequired() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ EncryptedDeviceRequired copy$default(EncryptedDeviceRequired encryptedDeviceRequired, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = encryptedDeviceRequired.message;
            }
            return encryptedDeviceRequired.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final EncryptedDeviceRequired copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new EncryptedDeviceRequired(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EncryptedDeviceRequired) && Intrinsics.areEqual(this.message, ((EncryptedDeviceRequired) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "EncryptedDeviceRequired(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ EncryptedDeviceRequired(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AdminSettingsDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EncryptedDeviceRequired(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AdminSettingsDomainError$SaveToLocationDisabled;", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SaveToLocationDisabled extends AdminSettingsDomainError {
        public static final Parcelable.Creator<SaveToLocationDisabled> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SaveToLocationDisabled> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SaveToLocationDisabled createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SaveToLocationDisabled(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SaveToLocationDisabled[] newArray(int i) {
                return new SaveToLocationDisabled[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SaveToLocationDisabled() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SaveToLocationDisabled copy$default(SaveToLocationDisabled saveToLocationDisabled, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = saveToLocationDisabled.message;
            }
            return saveToLocationDisabled.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final SaveToLocationDisabled copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new SaveToLocationDisabled(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SaveToLocationDisabled) && Intrinsics.areEqual(this.message, ((SaveToLocationDisabled) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "SaveToLocationDisabled(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ SaveToLocationDisabled(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AdminSettingsDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SaveToLocationDisabled(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AdminSettingsDomainError$PreviewOnlyOffliningDisabled;", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PreviewOnlyOffliningDisabled extends AdminSettingsDomainError {
        public static final Parcelable.Creator<PreviewOnlyOffliningDisabled> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PreviewOnlyOffliningDisabled> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PreviewOnlyOffliningDisabled createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PreviewOnlyOffliningDisabled(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PreviewOnlyOffliningDisabled[] newArray(int i) {
                return new PreviewOnlyOffliningDisabled[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PreviewOnlyOffliningDisabled() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PreviewOnlyOffliningDisabled copy$default(PreviewOnlyOffliningDisabled previewOnlyOffliningDisabled, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = previewOnlyOffliningDisabled.message;
            }
            return previewOnlyOffliningDisabled.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final PreviewOnlyOffliningDisabled copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new PreviewOnlyOffliningDisabled(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PreviewOnlyOffliningDisabled) && Intrinsics.areEqual(this.message, ((PreviewOnlyOffliningDisabled) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "PreviewOnlyOffliningDisabled(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ PreviewOnlyOffliningDisabled(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AdminSettingsDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreviewOnlyOffliningDisabled(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AdminSettingsDomainError$SavingOnDeviceDisabled;", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SavingOnDeviceDisabled extends AdminSettingsDomainError {
        public static final Parcelable.Creator<SavingOnDeviceDisabled> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SavingOnDeviceDisabled> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavingOnDeviceDisabled createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SavingOnDeviceDisabled(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavingOnDeviceDisabled[] newArray(int i) {
                return new SavingOnDeviceDisabled[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SavingOnDeviceDisabled() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SavingOnDeviceDisabled copy$default(SavingOnDeviceDisabled savingOnDeviceDisabled, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = savingOnDeviceDisabled.message;
            }
            return savingOnDeviceDisabled.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final SavingOnDeviceDisabled copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new SavingOnDeviceDisabled(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SavingOnDeviceDisabled) && Intrinsics.areEqual(this.message, ((SavingOnDeviceDisabled) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "SavingOnDeviceDisabled(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ SavingOnDeviceDisabled(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AdminSettingsDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavingOnDeviceDisabled(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }
}
