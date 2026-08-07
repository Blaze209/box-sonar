package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0014\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0014 !\"#$%&'()*+,-./0123¨\u00064"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "errorType", "Lcom/box/android/domain/models/ErrorRecoveryType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ErrorRecoveryType;)V", "getMessage", "()Ljava/lang/String;", "getErrorType", "()Lcom/box/android/domain/models/ErrorRecoveryType;", "BoxNotesCannotBeOfflined", "OffliningDisabledByAdministrator", "MissingFilePermissions", "InsufficientPermissionsToOffline", "DownloadingOriginalFileFailed", "FailedToRenameTempFile", "FailedToFindDownloadedFile", "MissingParentPath", "FailedToFetchRepresentations", "SupportedRepresentationNotFound", "RepresentationNotReady", "PreviewDownloadFailed", "BothDownloadOptionsNotAvailable", "RunningInfoNotAvailable", "TempFileDoesNotExist", "NoDownloadPermission", "NoPreviewPermission", "UnsupportedFileExtensionForPreview", "BoxCanvasCannotBeOfflined", "WatermarkedVideosCannotBeOfflined", "Lcom/box/android/domain/models/OfflineDomainError$BothDownloadOptionsNotAvailable;", "Lcom/box/android/domain/models/OfflineDomainError$BoxCanvasCannotBeOfflined;", "Lcom/box/android/domain/models/OfflineDomainError$BoxNotesCannotBeOfflined;", "Lcom/box/android/domain/models/OfflineDomainError$DownloadingOriginalFileFailed;", "Lcom/box/android/domain/models/OfflineDomainError$FailedToFetchRepresentations;", "Lcom/box/android/domain/models/OfflineDomainError$FailedToFindDownloadedFile;", "Lcom/box/android/domain/models/OfflineDomainError$FailedToRenameTempFile;", "Lcom/box/android/domain/models/OfflineDomainError$InsufficientPermissionsToOffline;", "Lcom/box/android/domain/models/OfflineDomainError$MissingFilePermissions;", "Lcom/box/android/domain/models/OfflineDomainError$MissingParentPath;", "Lcom/box/android/domain/models/OfflineDomainError$NoDownloadPermission;", "Lcom/box/android/domain/models/OfflineDomainError$NoPreviewPermission;", "Lcom/box/android/domain/models/OfflineDomainError$OffliningDisabledByAdministrator;", "Lcom/box/android/domain/models/OfflineDomainError$PreviewDownloadFailed;", "Lcom/box/android/domain/models/OfflineDomainError$RepresentationNotReady;", "Lcom/box/android/domain/models/OfflineDomainError$RunningInfoNotAvailable;", "Lcom/box/android/domain/models/OfflineDomainError$SupportedRepresentationNotFound;", "Lcom/box/android/domain/models/OfflineDomainError$TempFileDoesNotExist;", "Lcom/box/android/domain/models/OfflineDomainError$UnsupportedFileExtensionForPreview;", "Lcom/box/android/domain/models/OfflineDomainError$WatermarkedVideosCannotBeOfflined;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class OfflineDomainError extends DomainError {
    private final ErrorRecoveryType errorType;
    private final String message;

    public /* synthetic */ OfflineDomainError(String str, ErrorRecoveryType errorRecoveryType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, errorRecoveryType);
    }

    private OfflineDomainError(String str, ErrorRecoveryType errorRecoveryType) {
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
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$BoxNotesCannotBeOfflined;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BoxNotesCannotBeOfflined extends OfflineDomainError {
        public static final Parcelable.Creator<BoxNotesCannotBeOfflined> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<BoxNotesCannotBeOfflined> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BoxNotesCannotBeOfflined createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BoxNotesCannotBeOfflined(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BoxNotesCannotBeOfflined[] newArray(int i) {
                return new BoxNotesCannotBeOfflined[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BoxNotesCannotBeOfflined() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ BoxNotesCannotBeOfflined copy$default(BoxNotesCannotBeOfflined boxNotesCannotBeOfflined, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = boxNotesCannotBeOfflined.message;
            }
            return boxNotesCannotBeOfflined.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final BoxNotesCannotBeOfflined copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new BoxNotesCannotBeOfflined(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BoxNotesCannotBeOfflined) && Intrinsics.areEqual(this.message, ((BoxNotesCannotBeOfflined) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "BoxNotesCannotBeOfflined(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ BoxNotesCannotBeOfflined(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxNotesCannotBeOfflined(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$OffliningDisabledByAdministrator;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OffliningDisabledByAdministrator extends OfflineDomainError {
        public static final Parcelable.Creator<OffliningDisabledByAdministrator> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<OffliningDisabledByAdministrator> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final OffliningDisabledByAdministrator createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new OffliningDisabledByAdministrator(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final OffliningDisabledByAdministrator[] newArray(int i) {
                return new OffliningDisabledByAdministrator[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public OffliningDisabledByAdministrator() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ OffliningDisabledByAdministrator copy$default(OffliningDisabledByAdministrator offliningDisabledByAdministrator, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = offliningDisabledByAdministrator.message;
            }
            return offliningDisabledByAdministrator.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final OffliningDisabledByAdministrator copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new OffliningDisabledByAdministrator(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OffliningDisabledByAdministrator) && Intrinsics.areEqual(this.message, ((OffliningDisabledByAdministrator) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "OffliningDisabledByAdministrator(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ OffliningDisabledByAdministrator(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OffliningDisabledByAdministrator(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$MissingFilePermissions;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MissingFilePermissions extends OfflineDomainError {
        public static final Parcelable.Creator<MissingFilePermissions> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<MissingFilePermissions> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MissingFilePermissions createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MissingFilePermissions(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MissingFilePermissions[] newArray(int i) {
                return new MissingFilePermissions[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MissingFilePermissions() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ MissingFilePermissions copy$default(MissingFilePermissions missingFilePermissions, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingFilePermissions.message;
            }
            return missingFilePermissions.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final MissingFilePermissions copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new MissingFilePermissions(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MissingFilePermissions) && Intrinsics.areEqual(this.message, ((MissingFilePermissions) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "MissingFilePermissions(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ MissingFilePermissions(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingFilePermissions(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$InsufficientPermissionsToOffline;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InsufficientPermissionsToOffline extends OfflineDomainError {
        public static final Parcelable.Creator<InsufficientPermissionsToOffline> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<InsufficientPermissionsToOffline> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InsufficientPermissionsToOffline createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new InsufficientPermissionsToOffline(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InsufficientPermissionsToOffline[] newArray(int i) {
                return new InsufficientPermissionsToOffline[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public InsufficientPermissionsToOffline() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ InsufficientPermissionsToOffline copy$default(InsufficientPermissionsToOffline insufficientPermissionsToOffline, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = insufficientPermissionsToOffline.message;
            }
            return insufficientPermissionsToOffline.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final InsufficientPermissionsToOffline copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new InsufficientPermissionsToOffline(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InsufficientPermissionsToOffline) && Intrinsics.areEqual(this.message, ((InsufficientPermissionsToOffline) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "InsufficientPermissionsToOffline(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ InsufficientPermissionsToOffline(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InsufficientPermissionsToOffline(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$DownloadingOriginalFileFailed;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DownloadingOriginalFileFailed extends OfflineDomainError {
        public static final Parcelable.Creator<DownloadingOriginalFileFailed> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<DownloadingOriginalFileFailed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DownloadingOriginalFileFailed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DownloadingOriginalFileFailed(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DownloadingOriginalFileFailed[] newArray(int i) {
                return new DownloadingOriginalFileFailed[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DownloadingOriginalFileFailed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ DownloadingOriginalFileFailed copy$default(DownloadingOriginalFileFailed downloadingOriginalFileFailed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadingOriginalFileFailed.message;
            }
            return downloadingOriginalFileFailed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final DownloadingOriginalFileFailed copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new DownloadingOriginalFileFailed(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DownloadingOriginalFileFailed) && Intrinsics.areEqual(this.message, ((DownloadingOriginalFileFailed) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "DownloadingOriginalFileFailed(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ DownloadingOriginalFileFailed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadingOriginalFileFailed(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$FailedToRenameTempFile;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FailedToRenameTempFile extends OfflineDomainError {
        public static final Parcelable.Creator<FailedToRenameTempFile> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FailedToRenameTempFile> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FailedToRenameTempFile createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FailedToRenameTempFile(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FailedToRenameTempFile[] newArray(int i) {
                return new FailedToRenameTempFile[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FailedToRenameTempFile() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FailedToRenameTempFile copy$default(FailedToRenameTempFile failedToRenameTempFile, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failedToRenameTempFile.message;
            }
            return failedToRenameTempFile.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final FailedToRenameTempFile copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new FailedToRenameTempFile(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FailedToRenameTempFile) && Intrinsics.areEqual(this.message, ((FailedToRenameTempFile) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "FailedToRenameTempFile(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ FailedToRenameTempFile(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToRenameTempFile(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$FailedToFindDownloadedFile;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FailedToFindDownloadedFile extends OfflineDomainError {
        public static final Parcelable.Creator<FailedToFindDownloadedFile> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FailedToFindDownloadedFile> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FailedToFindDownloadedFile createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FailedToFindDownloadedFile(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FailedToFindDownloadedFile[] newArray(int i) {
                return new FailedToFindDownloadedFile[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FailedToFindDownloadedFile() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FailedToFindDownloadedFile copy$default(FailedToFindDownloadedFile failedToFindDownloadedFile, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failedToFindDownloadedFile.message;
            }
            return failedToFindDownloadedFile.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final FailedToFindDownloadedFile copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new FailedToFindDownloadedFile(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FailedToFindDownloadedFile) && Intrinsics.areEqual(this.message, ((FailedToFindDownloadedFile) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "FailedToFindDownloadedFile(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ FailedToFindDownloadedFile(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToFindDownloadedFile(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$MissingParentPath;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MissingParentPath extends OfflineDomainError {
        public static final Parcelable.Creator<MissingParentPath> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<MissingParentPath> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MissingParentPath createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MissingParentPath(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MissingParentPath[] newArray(int i) {
                return new MissingParentPath[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MissingParentPath() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ MissingParentPath copy$default(MissingParentPath missingParentPath, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = missingParentPath.message;
            }
            return missingParentPath.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final MissingParentPath copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new MissingParentPath(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MissingParentPath) && Intrinsics.areEqual(this.message, ((MissingParentPath) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "MissingParentPath(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ MissingParentPath(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingParentPath(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$FailedToFetchRepresentations;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FailedToFetchRepresentations extends OfflineDomainError {
        public static final Parcelable.Creator<FailedToFetchRepresentations> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FailedToFetchRepresentations> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FailedToFetchRepresentations createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FailedToFetchRepresentations(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FailedToFetchRepresentations[] newArray(int i) {
                return new FailedToFetchRepresentations[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FailedToFetchRepresentations() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FailedToFetchRepresentations copy$default(FailedToFetchRepresentations failedToFetchRepresentations, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failedToFetchRepresentations.message;
            }
            return failedToFetchRepresentations.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final FailedToFetchRepresentations copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new FailedToFetchRepresentations(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FailedToFetchRepresentations) && Intrinsics.areEqual(this.message, ((FailedToFetchRepresentations) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "FailedToFetchRepresentations(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ FailedToFetchRepresentations(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToFetchRepresentations(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$SupportedRepresentationNotFound;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SupportedRepresentationNotFound extends OfflineDomainError {
        public static final Parcelable.Creator<SupportedRepresentationNotFound> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SupportedRepresentationNotFound> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SupportedRepresentationNotFound createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SupportedRepresentationNotFound(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SupportedRepresentationNotFound[] newArray(int i) {
                return new SupportedRepresentationNotFound[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SupportedRepresentationNotFound() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SupportedRepresentationNotFound copy$default(SupportedRepresentationNotFound supportedRepresentationNotFound, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = supportedRepresentationNotFound.message;
            }
            return supportedRepresentationNotFound.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final SupportedRepresentationNotFound copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new SupportedRepresentationNotFound(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SupportedRepresentationNotFound) && Intrinsics.areEqual(this.message, ((SupportedRepresentationNotFound) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "SupportedRepresentationNotFound(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ SupportedRepresentationNotFound(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportedRepresentationNotFound(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$RepresentationNotReady;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RepresentationNotReady extends OfflineDomainError {
        public static final Parcelable.Creator<RepresentationNotReady> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<RepresentationNotReady> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final RepresentationNotReady createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new RepresentationNotReady(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final RepresentationNotReady[] newArray(int i) {
                return new RepresentationNotReady[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RepresentationNotReady() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ RepresentationNotReady copy$default(RepresentationNotReady representationNotReady, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = representationNotReady.message;
            }
            return representationNotReady.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final RepresentationNotReady copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new RepresentationNotReady(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RepresentationNotReady) && Intrinsics.areEqual(this.message, ((RepresentationNotReady) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "RepresentationNotReady(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ RepresentationNotReady(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RepresentationNotReady(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$PreviewDownloadFailed;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PreviewDownloadFailed extends OfflineDomainError {
        public static final Parcelable.Creator<PreviewDownloadFailed> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PreviewDownloadFailed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PreviewDownloadFailed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PreviewDownloadFailed(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PreviewDownloadFailed[] newArray(int i) {
                return new PreviewDownloadFailed[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PreviewDownloadFailed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PreviewDownloadFailed copy$default(PreviewDownloadFailed previewDownloadFailed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = previewDownloadFailed.message;
            }
            return previewDownloadFailed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final PreviewDownloadFailed copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new PreviewDownloadFailed(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PreviewDownloadFailed) && Intrinsics.areEqual(this.message, ((PreviewDownloadFailed) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "PreviewDownloadFailed(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ PreviewDownloadFailed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreviewDownloadFailed(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$BothDownloadOptionsNotAvailable;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BothDownloadOptionsNotAvailable extends OfflineDomainError {
        public static final Parcelable.Creator<BothDownloadOptionsNotAvailable> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<BothDownloadOptionsNotAvailable> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BothDownloadOptionsNotAvailable createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BothDownloadOptionsNotAvailable(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BothDownloadOptionsNotAvailable[] newArray(int i) {
                return new BothDownloadOptionsNotAvailable[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BothDownloadOptionsNotAvailable() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ BothDownloadOptionsNotAvailable copy$default(BothDownloadOptionsNotAvailable bothDownloadOptionsNotAvailable, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bothDownloadOptionsNotAvailable.message;
            }
            return bothDownloadOptionsNotAvailable.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final BothDownloadOptionsNotAvailable copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new BothDownloadOptionsNotAvailable(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BothDownloadOptionsNotAvailable) && Intrinsics.areEqual(this.message, ((BothDownloadOptionsNotAvailable) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "BothDownloadOptionsNotAvailable(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ BothDownloadOptionsNotAvailable(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BothDownloadOptionsNotAvailable(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$RunningInfoNotAvailable;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RunningInfoNotAvailable extends OfflineDomainError {
        public static final Parcelable.Creator<RunningInfoNotAvailable> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<RunningInfoNotAvailable> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final RunningInfoNotAvailable createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new RunningInfoNotAvailable(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final RunningInfoNotAvailable[] newArray(int i) {
                return new RunningInfoNotAvailable[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RunningInfoNotAvailable() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ RunningInfoNotAvailable copy$default(RunningInfoNotAvailable runningInfoNotAvailable, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = runningInfoNotAvailable.message;
            }
            return runningInfoNotAvailable.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final RunningInfoNotAvailable copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new RunningInfoNotAvailable(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RunningInfoNotAvailable) && Intrinsics.areEqual(this.message, ((RunningInfoNotAvailable) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "RunningInfoNotAvailable(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ RunningInfoNotAvailable(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RunningInfoNotAvailable(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$TempFileDoesNotExist;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TempFileDoesNotExist extends OfflineDomainError {
        public static final Parcelable.Creator<TempFileDoesNotExist> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<TempFileDoesNotExist> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TempFileDoesNotExist createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TempFileDoesNotExist(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TempFileDoesNotExist[] newArray(int i) {
                return new TempFileDoesNotExist[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TempFileDoesNotExist() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TempFileDoesNotExist copy$default(TempFileDoesNotExist tempFileDoesNotExist, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tempFileDoesNotExist.message;
            }
            return tempFileDoesNotExist.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final TempFileDoesNotExist copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new TempFileDoesNotExist(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TempFileDoesNotExist) && Intrinsics.areEqual(this.message, ((TempFileDoesNotExist) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "TempFileDoesNotExist(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ TempFileDoesNotExist(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TempFileDoesNotExist(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$NoDownloadPermission;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NoDownloadPermission extends OfflineDomainError {
        public static final Parcelable.Creator<NoDownloadPermission> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NoDownloadPermission> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoDownloadPermission createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NoDownloadPermission(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoDownloadPermission[] newArray(int i) {
                return new NoDownloadPermission[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NoDownloadPermission() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NoDownloadPermission copy$default(NoDownloadPermission noDownloadPermission, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noDownloadPermission.message;
            }
            return noDownloadPermission.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NoDownloadPermission copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NoDownloadPermission(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoDownloadPermission) && Intrinsics.areEqual(this.message, ((NoDownloadPermission) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "NoDownloadPermission(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ NoDownloadPermission(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoDownloadPermission(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$NoPreviewPermission;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NoPreviewPermission extends OfflineDomainError {
        public static final Parcelable.Creator<NoPreviewPermission> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NoPreviewPermission> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoPreviewPermission createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NoPreviewPermission(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoPreviewPermission[] newArray(int i) {
                return new NoPreviewPermission[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NoPreviewPermission() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NoPreviewPermission copy$default(NoPreviewPermission noPreviewPermission, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noPreviewPermission.message;
            }
            return noPreviewPermission.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NoPreviewPermission copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NoPreviewPermission(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoPreviewPermission) && Intrinsics.areEqual(this.message, ((NoPreviewPermission) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "NoPreviewPermission(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ NoPreviewPermission(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoPreviewPermission(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$UnsupportedFileExtensionForPreview;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnsupportedFileExtensionForPreview extends OfflineDomainError {
        public static final Parcelable.Creator<UnsupportedFileExtensionForPreview> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<UnsupportedFileExtensionForPreview> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final UnsupportedFileExtensionForPreview createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new UnsupportedFileExtensionForPreview(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final UnsupportedFileExtensionForPreview[] newArray(int i) {
                return new UnsupportedFileExtensionForPreview[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public UnsupportedFileExtensionForPreview() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ UnsupportedFileExtensionForPreview copy$default(UnsupportedFileExtensionForPreview unsupportedFileExtensionForPreview, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unsupportedFileExtensionForPreview.message;
            }
            return unsupportedFileExtensionForPreview.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final UnsupportedFileExtensionForPreview copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new UnsupportedFileExtensionForPreview(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnsupportedFileExtensionForPreview) && Intrinsics.areEqual(this.message, ((UnsupportedFileExtensionForPreview) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "UnsupportedFileExtensionForPreview(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ UnsupportedFileExtensionForPreview(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedFileExtensionForPreview(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$BoxCanvasCannotBeOfflined;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BoxCanvasCannotBeOfflined extends OfflineDomainError {
        public static final Parcelable.Creator<BoxCanvasCannotBeOfflined> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<BoxCanvasCannotBeOfflined> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BoxCanvasCannotBeOfflined createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BoxCanvasCannotBeOfflined(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BoxCanvasCannotBeOfflined[] newArray(int i) {
                return new BoxCanvasCannotBeOfflined[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BoxCanvasCannotBeOfflined() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ BoxCanvasCannotBeOfflined copy$default(BoxCanvasCannotBeOfflined boxCanvasCannotBeOfflined, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = boxCanvasCannotBeOfflined.message;
            }
            return boxCanvasCannotBeOfflined.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final BoxCanvasCannotBeOfflined copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new BoxCanvasCannotBeOfflined(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BoxCanvasCannotBeOfflined) && Intrinsics.areEqual(this.message, ((BoxCanvasCannotBeOfflined) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "BoxCanvasCannotBeOfflined(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ BoxCanvasCannotBeOfflined(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoxCanvasCannotBeOfflined(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/OfflineDomainError$WatermarkedVideosCannotBeOfflined;", "Lcom/box/android/domain/models/OfflineDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class WatermarkedVideosCannotBeOfflined extends OfflineDomainError {
        public static final Parcelable.Creator<WatermarkedVideosCannotBeOfflined> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<WatermarkedVideosCannotBeOfflined> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final WatermarkedVideosCannotBeOfflined createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new WatermarkedVideosCannotBeOfflined(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final WatermarkedVideosCannotBeOfflined[] newArray(int i) {
                return new WatermarkedVideosCannotBeOfflined[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public WatermarkedVideosCannotBeOfflined() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ WatermarkedVideosCannotBeOfflined copy$default(WatermarkedVideosCannotBeOfflined watermarkedVideosCannotBeOfflined, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = watermarkedVideosCannotBeOfflined.message;
            }
            return watermarkedVideosCannotBeOfflined.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final WatermarkedVideosCannotBeOfflined copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new WatermarkedVideosCannotBeOfflined(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WatermarkedVideosCannotBeOfflined) && Intrinsics.areEqual(this.message, ((WatermarkedVideosCannotBeOfflined) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "WatermarkedVideosCannotBeOfflined(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ WatermarkedVideosCannotBeOfflined(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.OfflineDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WatermarkedVideosCannotBeOfflined(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }
}
