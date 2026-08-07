package com.box.android.data.datasource.errors;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0006\u0007\b\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "code", "", "<init>", "(I)V", "AccessDeniedError", "FileSizeLimitError", "InsufficientStorageError", "AccountSpaceError", "NameExistsErr", "CommitNotReady", "SourceOrDestNotFound", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError$AccessDeniedError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError$AccountSpaceError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError$CommitNotReady;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError$FileSizeLimitError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError$InsufficientStorageError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError$NameExistsErr;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError$SourceOrDestNotFound;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileUploadRemoteError extends RemoteError {
    public /* synthetic */ FileUploadRemoteError(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private FileUploadRemoteError(int i) {
        super(i, null, 2, null);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/FileUploadRemoteError$AccessDeniedError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AccessDeniedError extends FileUploadRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public AccessDeniedError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AccessDeniedError copy$default(AccessDeniedError accessDeniedError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = accessDeniedError.message;
            }
            return accessDeniedError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final AccessDeniedError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new AccessDeniedError(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AccessDeniedError) && Intrinsics.areEqual(this.message, ((AccessDeniedError) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "AccessDeniedError(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccessDeniedError(String message) {
            super(403, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ AccessDeniedError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/FileUploadRemoteError$FileSizeLimitError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FileSizeLimitError extends FileUploadRemoteError {
        public static final FileSizeLimitError INSTANCE = new FileSizeLimitError();

        private FileSizeLimitError() {
            super(403, null);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/FileUploadRemoteError$InsufficientStorageError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InsufficientStorageError extends FileUploadRemoteError {
        public static final InsufficientStorageError INSTANCE = new InsufficientStorageError();

        private InsufficientStorageError() {
            super(403, null);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/FileUploadRemoteError$AccountSpaceError;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AccountSpaceError extends FileUploadRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public AccountSpaceError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AccountSpaceError copy$default(AccountSpaceError accountSpaceError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = accountSpaceError.message;
            }
            return accountSpaceError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final AccountSpaceError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new AccountSpaceError(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AccountSpaceError) && Intrinsics.areEqual(this.message, ((AccountSpaceError) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "AccountSpaceError(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccountSpaceError(String message) {
            super(403, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ AccountSpaceError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/FileUploadRemoteError$NameExistsErr;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NameExistsErr extends FileUploadRemoteError {
        public static final NameExistsErr INSTANCE = new NameExistsErr();

        private NameExistsErr() {
            super(409, null);
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/FileUploadRemoteError$CommitNotReady;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CommitNotReady extends FileUploadRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public CommitNotReady() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CommitNotReady copy$default(CommitNotReady commitNotReady, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = commitNotReady.message;
            }
            return commitNotReady.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final CommitNotReady copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new CommitNotReady(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CommitNotReady) && Intrinsics.areEqual(this.message, ((CommitNotReady) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "CommitNotReady(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommitNotReady(String message) {
            super(-1, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ CommitNotReady(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/FileUploadRemoteError$SourceOrDestNotFound;", "Lcom/box/android/data/datasource/errors/FileUploadRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SourceOrDestNotFound extends FileUploadRemoteError {
        private final String message;

        /* JADX WARN: Multi-variable type inference failed */
        public SourceOrDestNotFound() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SourceOrDestNotFound copy$default(SourceOrDestNotFound sourceOrDestNotFound, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sourceOrDestNotFound.message;
            }
            return sourceOrDestNotFound.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final SourceOrDestNotFound copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new SourceOrDestNotFound(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SourceOrDestNotFound) && Intrinsics.areEqual(this.message, ((SourceOrDestNotFound) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "SourceOrDestNotFound(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SourceOrDestNotFound(String message) {
            super(404, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ SourceOrDestNotFound(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }
}
