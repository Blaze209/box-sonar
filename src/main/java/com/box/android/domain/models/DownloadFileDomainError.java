package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/models/DownloadFileDomainError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "errorType", "Lcom/box/android/domain/models/ErrorRecoveryType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ErrorRecoveryType;)V", "getMessage", "()Ljava/lang/String;", "getErrorType", "()Lcom/box/android/domain/models/ErrorRecoveryType;", "TargetLocationNotFound", "TargetFileCreationError", "FileSha1VerificationFailed", "FileToDownloadNotFound", "PartialDownloadError", "Lcom/box/android/domain/models/DownloadFileDomainError$FileSha1VerificationFailed;", "Lcom/box/android/domain/models/DownloadFileDomainError$FileToDownloadNotFound;", "Lcom/box/android/domain/models/DownloadFileDomainError$PartialDownloadError;", "Lcom/box/android/domain/models/DownloadFileDomainError$TargetFileCreationError;", "Lcom/box/android/domain/models/DownloadFileDomainError$TargetLocationNotFound;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DownloadFileDomainError extends DomainError {
    private final ErrorRecoveryType errorType;
    private final String message;

    public /* synthetic */ DownloadFileDomainError(String str, ErrorRecoveryType errorRecoveryType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, errorRecoveryType);
    }

    private DownloadFileDomainError(String str, ErrorRecoveryType errorRecoveryType) {
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
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DownloadFileDomainError$TargetLocationNotFound;", "Lcom/box/android/domain/models/DownloadFileDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TargetLocationNotFound extends DownloadFileDomainError {
        public static final Parcelable.Creator<TargetLocationNotFound> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<TargetLocationNotFound> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetLocationNotFound createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TargetLocationNotFound(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetLocationNotFound[] newArray(int i) {
                return new TargetLocationNotFound[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TargetLocationNotFound() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TargetLocationNotFound copy$default(TargetLocationNotFound targetLocationNotFound, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = targetLocationNotFound.message;
            }
            return targetLocationNotFound.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final TargetLocationNotFound copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new TargetLocationNotFound(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TargetLocationNotFound) && Intrinsics.areEqual(this.message, ((TargetLocationNotFound) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "TargetLocationNotFound(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ TargetLocationNotFound(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DownloadFileDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TargetLocationNotFound(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DownloadFileDomainError$TargetFileCreationError;", "Lcom/box/android/domain/models/DownloadFileDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TargetFileCreationError extends DownloadFileDomainError {
        public static final Parcelable.Creator<TargetFileCreationError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<TargetFileCreationError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetFileCreationError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TargetFileCreationError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetFileCreationError[] newArray(int i) {
                return new TargetFileCreationError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TargetFileCreationError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TargetFileCreationError copy$default(TargetFileCreationError targetFileCreationError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = targetFileCreationError.message;
            }
            return targetFileCreationError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final TargetFileCreationError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new TargetFileCreationError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TargetFileCreationError) && Intrinsics.areEqual(this.message, ((TargetFileCreationError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "TargetFileCreationError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ TargetFileCreationError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DownloadFileDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TargetFileCreationError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DownloadFileDomainError$FileSha1VerificationFailed;", "Lcom/box/android/domain/models/DownloadFileDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileSha1VerificationFailed extends DownloadFileDomainError {
        public static final Parcelable.Creator<FileSha1VerificationFailed> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FileSha1VerificationFailed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FileSha1VerificationFailed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FileSha1VerificationFailed(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FileSha1VerificationFailed[] newArray(int i) {
                return new FileSha1VerificationFailed[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FileSha1VerificationFailed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FileSha1VerificationFailed copy$default(FileSha1VerificationFailed fileSha1VerificationFailed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileSha1VerificationFailed.message;
            }
            return fileSha1VerificationFailed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final FileSha1VerificationFailed copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new FileSha1VerificationFailed(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FileSha1VerificationFailed) && Intrinsics.areEqual(this.message, ((FileSha1VerificationFailed) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "FileSha1VerificationFailed(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ FileSha1VerificationFailed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DownloadFileDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileSha1VerificationFailed(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DownloadFileDomainError$FileToDownloadNotFound;", "Lcom/box/android/domain/models/DownloadFileDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileToDownloadNotFound extends DownloadFileDomainError {
        public static final Parcelable.Creator<FileToDownloadNotFound> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FileToDownloadNotFound> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FileToDownloadNotFound createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FileToDownloadNotFound(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FileToDownloadNotFound[] newArray(int i) {
                return new FileToDownloadNotFound[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FileToDownloadNotFound() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ FileToDownloadNotFound copy$default(FileToDownloadNotFound fileToDownloadNotFound, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileToDownloadNotFound.message;
            }
            return fileToDownloadNotFound.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final FileToDownloadNotFound copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new FileToDownloadNotFound(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FileToDownloadNotFound) && Intrinsics.areEqual(this.message, ((FileToDownloadNotFound) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "FileToDownloadNotFound(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ FileToDownloadNotFound(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DownloadFileDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileToDownloadNotFound(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DownloadFileDomainError$PartialDownloadError;", "Lcom/box/android/domain/models/DownloadFileDomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PartialDownloadError extends DownloadFileDomainError {
        public static final Parcelable.Creator<PartialDownloadError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PartialDownloadError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PartialDownloadError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PartialDownloadError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PartialDownloadError[] newArray(int i) {
                return new PartialDownloadError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PartialDownloadError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PartialDownloadError copy$default(PartialDownloadError partialDownloadError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = partialDownloadError.message;
            }
            return partialDownloadError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final PartialDownloadError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new PartialDownloadError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PartialDownloadError) && Intrinsics.areEqual(this.message, ((PartialDownloadError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "PartialDownloadError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ PartialDownloadError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DownloadFileDomainError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PartialDownloadError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }
}
