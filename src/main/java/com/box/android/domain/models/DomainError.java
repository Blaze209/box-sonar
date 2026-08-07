package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemModel;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u001a\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*B\u001b\b\u0004\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n\u0082\u0001'+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQ¨\u0006R"}, d2 = {"Lcom/box/android/domain/models/DomainError;", "Lcom/box/android/domain/models/IGenericError;", "Landroid/os/Parcelable;", "message", "", "errorType", "Lcom/box/android/domain/models/ErrorRecoveryType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ErrorRecoveryType;)V", "getMessage", "()Ljava/lang/String;", "getErrorType", "()Lcom/box/android/domain/models/ErrorRecoveryType;", "className", "getClassName", "simpleClassName", "getSimpleClassName", "CreateJobError", "CacheInitError", "CacheReadError", "CacheWriteError", "NoUserLoggedInError", "NoResultFoundError", "InputValidationError", "NameConflict", "ForbiddenByShieldPolicy", "GeniusScanLicenseUnavailable", "StoragePermissionMissing", "APINotFoundError", "APIRequestError", "APIAuthError", "APIResourceConflict", "APIServerError", "NoConnectivityError", "NetworkError", "TermsOfServiceError", "PreconditionFailed", "CustomError", PasskeyReplyChannel.DOM_EXCEPTION_UNKNOWN_ERROR, "CachedDomainError", "JobCancelledError", "Unauthorized", "ItemRemoteIdIsNull", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "Lcom/box/android/domain/models/AudioRecordingError;", "Lcom/box/android/domain/models/CollaborationDomainError;", "Lcom/box/android/domain/models/CollectionsDomainError;", "Lcom/box/android/domain/models/CreateFolderDomainError;", "Lcom/box/android/domain/models/DocumentScanningError;", "Lcom/box/android/domain/models/DomainError$APIAuthError;", "Lcom/box/android/domain/models/DomainError$APINotFoundError;", "Lcom/box/android/domain/models/DomainError$APIRequestError;", "Lcom/box/android/domain/models/DomainError$APIResourceConflict;", "Lcom/box/android/domain/models/DomainError$APIServerError;", "Lcom/box/android/domain/models/DomainError$CacheInitError;", "Lcom/box/android/domain/models/DomainError$CacheReadError;", "Lcom/box/android/domain/models/DomainError$CacheWriteError;", "Lcom/box/android/domain/models/DomainError$CachedDomainError;", "Lcom/box/android/domain/models/DomainError$CreateJobError;", "Lcom/box/android/domain/models/DomainError$CustomError;", "Lcom/box/android/domain/models/DomainError$ForbiddenByShieldPolicy;", "Lcom/box/android/domain/models/DomainError$GeniusScanLicenseUnavailable;", "Lcom/box/android/domain/models/DomainError$InputValidationError;", "Lcom/box/android/domain/models/DomainError$ItemRemoteIdIsNull;", "Lcom/box/android/domain/models/DomainError$JobCancelledError;", "Lcom/box/android/domain/models/DomainError$NameConflict;", "Lcom/box/android/domain/models/DomainError$NetworkError;", "Lcom/box/android/domain/models/DomainError$NoConnectivityError;", "Lcom/box/android/domain/models/DomainError$NoResultFoundError;", "Lcom/box/android/domain/models/DomainError$NoUserLoggedInError;", "Lcom/box/android/domain/models/DomainError$PreconditionFailed;", "Lcom/box/android/domain/models/DomainError$StoragePermissionMissing;", "Lcom/box/android/domain/models/DomainError$TermsOfServiceError;", "Lcom/box/android/domain/models/DomainError$Unauthorized;", "Lcom/box/android/domain/models/DomainError$UnknownError;", "Lcom/box/android/domain/models/DownloadFileDomainError;", "Lcom/box/android/domain/models/FileActivityDomainError;", "Lcom/box/android/domain/models/FilePreviewDomainError;", "Lcom/box/android/domain/models/FileUploadDomainError;", "Lcom/box/android/domain/models/NoteCreationError;", "Lcom/box/android/domain/models/OfflineDomainError;", "Lcom/box/android/domain/models/PushNotificationSettingsDomainError;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DomainError implements IGenericError, Parcelable {
    private final String className;
    private final ErrorRecoveryType errorType;
    private final String message;
    private final String simpleClassName;

    public /* synthetic */ DomainError(String str, ErrorRecoveryType errorRecoveryType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, errorRecoveryType);
    }

    private DomainError(String str, ErrorRecoveryType errorRecoveryType) {
        this.message = str;
        this.errorType = errorRecoveryType;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        this.className = name;
        String simpleName = JvmClassMappingKt.getKotlinClass(getClass()).getSimpleName();
        if (simpleName == null) {
            simpleName = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getName(...)");
        }
        this.simpleClassName = simpleName;
    }

    public /* synthetic */ DomainError(String str, ErrorRecoveryType errorRecoveryType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, errorRecoveryType, null);
    }

    public ErrorRecoveryType getErrorType() {
        return this.errorType;
    }

    public String getMessage() {
        return this.message;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getSimpleClassName() {
        return this.simpleClassName;
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$CreateJobError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CreateJobError extends DomainError {
        public static final Parcelable.Creator<CreateJobError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<CreateJobError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CreateJobError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CreateJobError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CreateJobError[] newArray(int i) {
                return new CreateJobError[i];
            }
        }

        public static /* synthetic */ CreateJobError copy$default(CreateJobError createJobError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = createJobError.message;
            }
            return createJobError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final CreateJobError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new CreateJobError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CreateJobError) && Intrinsics.areEqual(this.message, ((CreateJobError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "CreateJobError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreateJobError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$CacheInitError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CacheInitError extends DomainError {
        public static final Parcelable.Creator<CacheInitError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<CacheInitError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CacheInitError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CacheInitError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CacheInitError[] newArray(int i) {
                return new CacheInitError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CacheInitError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CacheInitError copy$default(CacheInitError cacheInitError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cacheInitError.message;
            }
            return cacheInitError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final CacheInitError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new CacheInitError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CacheInitError) && Intrinsics.areEqual(this.message, ((CacheInitError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "CacheInitError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheInitError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ CacheInitError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$CacheReadError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CacheReadError extends DomainError {
        public static final Parcelable.Creator<CacheReadError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<CacheReadError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CacheReadError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CacheReadError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CacheReadError[] newArray(int i) {
                return new CacheReadError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CacheReadError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CacheReadError copy$default(CacheReadError cacheReadError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cacheReadError.message;
            }
            return cacheReadError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final CacheReadError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new CacheReadError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CacheReadError) && Intrinsics.areEqual(this.message, ((CacheReadError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "CacheReadError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheReadError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ CacheReadError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$CacheWriteError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CacheWriteError extends DomainError {
        public static final Parcelable.Creator<CacheWriteError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<CacheWriteError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CacheWriteError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CacheWriteError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CacheWriteError[] newArray(int i) {
                return new CacheWriteError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CacheWriteError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ CacheWriteError copy$default(CacheWriteError cacheWriteError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cacheWriteError.message;
            }
            return cacheWriteError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final CacheWriteError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new CacheWriteError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CacheWriteError) && Intrinsics.areEqual(this.message, ((CacheWriteError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "CacheWriteError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheWriteError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ CacheWriteError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$NoUserLoggedInError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NoUserLoggedInError extends DomainError {
        public static final Parcelable.Creator<NoUserLoggedInError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NoUserLoggedInError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoUserLoggedInError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NoUserLoggedInError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoUserLoggedInError[] newArray(int i) {
                return new NoUserLoggedInError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NoUserLoggedInError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NoUserLoggedInError copy$default(NoUserLoggedInError noUserLoggedInError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noUserLoggedInError.message;
            }
            return noUserLoggedInError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NoUserLoggedInError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NoUserLoggedInError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoUserLoggedInError) && Intrinsics.areEqual(this.message, ((NoUserLoggedInError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "NoUserLoggedInError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoUserLoggedInError(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ NoUserLoggedInError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$NoResultFoundError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NoResultFoundError extends DomainError {
        public static final Parcelable.Creator<NoResultFoundError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NoResultFoundError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoResultFoundError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NoResultFoundError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoResultFoundError[] newArray(int i) {
                return new NoResultFoundError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NoResultFoundError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NoResultFoundError copy$default(NoResultFoundError noResultFoundError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noResultFoundError.message;
            }
            return noResultFoundError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NoResultFoundError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NoResultFoundError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoResultFoundError) && Intrinsics.areEqual(this.message, ((NoResultFoundError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "NoResultFoundError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoResultFoundError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ NoResultFoundError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$InputValidationError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InputValidationError extends DomainError {
        public static final Parcelable.Creator<InputValidationError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<InputValidationError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InputValidationError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new InputValidationError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final InputValidationError[] newArray(int i) {
                return new InputValidationError[i];
            }
        }

        public static /* synthetic */ InputValidationError copy$default(InputValidationError inputValidationError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inputValidationError.message;
            }
            return inputValidationError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final InputValidationError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new InputValidationError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InputValidationError) && Intrinsics.areEqual(this.message, ((InputValidationError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "InputValidationError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InputValidationError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/models/DomainError$NameConflict;", "Lcom/box/android/domain/models/DomainError;", "itemModels", "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getItemModels", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NameConflict extends DomainError {
        public static final Parcelable.Creator<NameConflict> CREATOR = new Creator();
        private final List<ItemModel> itemModels;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NameConflict> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NameConflict createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(parcel.readParcelable(NameConflict.class.getClassLoader()));
                }
                return new NameConflict(arrayList);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NameConflict[] newArray(int i) {
                return new NameConflict[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NameConflict copy$default(NameConflict nameConflict, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = nameConflict.itemModels;
            }
            return nameConflict.copy(list);
        }

        public final List<ItemModel> component1() {
            return this.itemModels;
        }

        public final NameConflict copy(List<? extends ItemModel> itemModels) {
            Intrinsics.checkNotNullParameter(itemModels, "itemModels");
            return new NameConflict(itemModels);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NameConflict) && Intrinsics.areEqual(this.itemModels, ((NameConflict) other).itemModels);
        }

        public int hashCode() {
            return this.itemModels.hashCode();
        }

        public String toString() {
            return "NameConflict(itemModels=" + this.itemModels + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            List<ItemModel> list = this.itemModels;
            dest.writeInt(list.size());
            Iterator<ItemModel> it = list.iterator();
            while (it.hasNext()) {
                dest.writeParcelable(it.next(), flags);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NameConflict(List<? extends ItemModel> itemModels) {
            super(null, ErrorRecoveryType.MANUAL, 1, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(itemModels, "itemModels");
            this.itemModels = itemModels;
        }

        public final List<ItemModel> getItemModels() {
            return this.itemModels;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$ForbiddenByShieldPolicy;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ForbiddenByShieldPolicy extends DomainError {
        public static final Parcelable.Creator<ForbiddenByShieldPolicy> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ForbiddenByShieldPolicy> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ForbiddenByShieldPolicy createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ForbiddenByShieldPolicy(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ForbiddenByShieldPolicy[] newArray(int i) {
                return new ForbiddenByShieldPolicy[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ForbiddenByShieldPolicy() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ForbiddenByShieldPolicy copy$default(ForbiddenByShieldPolicy forbiddenByShieldPolicy, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = forbiddenByShieldPolicy.message;
            }
            return forbiddenByShieldPolicy.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ForbiddenByShieldPolicy copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ForbiddenByShieldPolicy(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ForbiddenByShieldPolicy) && Intrinsics.areEqual(this.message, ((ForbiddenByShieldPolicy) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ForbiddenByShieldPolicy(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForbiddenByShieldPolicy(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ ForbiddenByShieldPolicy(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$GeniusScanLicenseUnavailable;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class GeniusScanLicenseUnavailable extends DomainError {
        public static final Parcelable.Creator<GeniusScanLicenseUnavailable> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<GeniusScanLicenseUnavailable> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GeniusScanLicenseUnavailable createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GeniusScanLicenseUnavailable(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GeniusScanLicenseUnavailable[] newArray(int i) {
                return new GeniusScanLicenseUnavailable[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public GeniusScanLicenseUnavailable() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ GeniusScanLicenseUnavailable copy$default(GeniusScanLicenseUnavailable geniusScanLicenseUnavailable, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = geniusScanLicenseUnavailable.message;
            }
            return geniusScanLicenseUnavailable.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final GeniusScanLicenseUnavailable copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new GeniusScanLicenseUnavailable(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GeniusScanLicenseUnavailable) && Intrinsics.areEqual(this.message, ((GeniusScanLicenseUnavailable) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "GeniusScanLicenseUnavailable(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GeniusScanLicenseUnavailable(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ GeniusScanLicenseUnavailable(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$StoragePermissionMissing;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StoragePermissionMissing extends DomainError {
        public static final Parcelable.Creator<StoragePermissionMissing> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<StoragePermissionMissing> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StoragePermissionMissing createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new StoragePermissionMissing(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StoragePermissionMissing[] newArray(int i) {
                return new StoragePermissionMissing[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public StoragePermissionMissing() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ StoragePermissionMissing copy$default(StoragePermissionMissing storagePermissionMissing, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storagePermissionMissing.message;
            }
            return storagePermissionMissing.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final StoragePermissionMissing copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new StoragePermissionMissing(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StoragePermissionMissing) && Intrinsics.areEqual(this.message, ((StoragePermissionMissing) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "StoragePermissionMissing(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StoragePermissionMissing(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ StoragePermissionMissing(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$APINotFoundError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class APINotFoundError extends DomainError {
        public static final Parcelable.Creator<APINotFoundError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<APINotFoundError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APINotFoundError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new APINotFoundError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APINotFoundError[] newArray(int i) {
                return new APINotFoundError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public APINotFoundError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ APINotFoundError copy$default(APINotFoundError aPINotFoundError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aPINotFoundError.message;
            }
            return aPINotFoundError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final APINotFoundError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new APINotFoundError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof APINotFoundError) && Intrinsics.areEqual(this.message, ((APINotFoundError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "APINotFoundError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public APINotFoundError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ APINotFoundError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$APIRequestError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class APIRequestError extends DomainError {
        public static final Parcelable.Creator<APIRequestError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<APIRequestError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APIRequestError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new APIRequestError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APIRequestError[] newArray(int i) {
                return new APIRequestError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public APIRequestError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ APIRequestError copy$default(APIRequestError aPIRequestError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aPIRequestError.message;
            }
            return aPIRequestError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final APIRequestError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new APIRequestError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof APIRequestError) && Intrinsics.areEqual(this.message, ((APIRequestError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "APIRequestError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public APIRequestError(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ APIRequestError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$APIAuthError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class APIAuthError extends DomainError {
        public static final Parcelable.Creator<APIAuthError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<APIAuthError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APIAuthError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new APIAuthError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APIAuthError[] newArray(int i) {
                return new APIAuthError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public APIAuthError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ APIAuthError copy$default(APIAuthError aPIAuthError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aPIAuthError.message;
            }
            return aPIAuthError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final APIAuthError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new APIAuthError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof APIAuthError) && Intrinsics.areEqual(this.message, ((APIAuthError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "APIAuthError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public APIAuthError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ APIAuthError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$APIResourceConflict;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class APIResourceConflict extends DomainError {
        public static final Parcelable.Creator<APIResourceConflict> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<APIResourceConflict> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APIResourceConflict createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new APIResourceConflict(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APIResourceConflict[] newArray(int i) {
                return new APIResourceConflict[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public APIResourceConflict() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ APIResourceConflict copy$default(APIResourceConflict aPIResourceConflict, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aPIResourceConflict.message;
            }
            return aPIResourceConflict.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final APIResourceConflict copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new APIResourceConflict(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof APIResourceConflict) && Intrinsics.areEqual(this.message, ((APIResourceConflict) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "APIResourceConflict(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public APIResourceConflict(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ APIResourceConflict(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$APIServerError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class APIServerError extends DomainError {
        public static final Parcelable.Creator<APIServerError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<APIServerError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APIServerError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new APIServerError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final APIServerError[] newArray(int i) {
                return new APIServerError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public APIServerError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ APIServerError copy$default(APIServerError aPIServerError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aPIServerError.message;
            }
            return aPIServerError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final APIServerError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new APIServerError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof APIServerError) && Intrinsics.areEqual(this.message, ((APIServerError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "APIServerError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public APIServerError(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ APIServerError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$NoConnectivityError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NoConnectivityError extends DomainError {
        public static final Parcelable.Creator<NoConnectivityError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NoConnectivityError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoConnectivityError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NoConnectivityError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoConnectivityError[] newArray(int i) {
                return new NoConnectivityError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NoConnectivityError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NoConnectivityError copy$default(NoConnectivityError noConnectivityError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noConnectivityError.message;
            }
            return noConnectivityError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NoConnectivityError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NoConnectivityError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoConnectivityError) && Intrinsics.areEqual(this.message, ((NoConnectivityError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "NoConnectivityError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoConnectivityError(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ NoConnectivityError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$NetworkError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NetworkError extends DomainError {
        public static final Parcelable.Creator<NetworkError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NetworkError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NetworkError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NetworkError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NetworkError[] newArray(int i) {
                return new NetworkError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public NetworkError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = networkError.message;
            }
            return networkError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final NetworkError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new NetworkError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NetworkError) && Intrinsics.areEqual(this.message, ((NetworkError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "NetworkError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkError(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ NetworkError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$TermsOfServiceError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TermsOfServiceError extends DomainError {
        public static final Parcelable.Creator<TermsOfServiceError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<TermsOfServiceError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TermsOfServiceError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TermsOfServiceError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TermsOfServiceError[] newArray(int i) {
                return new TermsOfServiceError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TermsOfServiceError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TermsOfServiceError copy$default(TermsOfServiceError termsOfServiceError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = termsOfServiceError.message;
            }
            return termsOfServiceError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final TermsOfServiceError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new TermsOfServiceError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TermsOfServiceError) && Intrinsics.areEqual(this.message, ((TermsOfServiceError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "TermsOfServiceError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TermsOfServiceError(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ TermsOfServiceError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$PreconditionFailed;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PreconditionFailed extends DomainError {
        public static final Parcelable.Creator<PreconditionFailed> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PreconditionFailed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PreconditionFailed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PreconditionFailed(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PreconditionFailed[] newArray(int i) {
                return new PreconditionFailed[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PreconditionFailed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PreconditionFailed copy$default(PreconditionFailed preconditionFailed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = preconditionFailed.message;
            }
            return preconditionFailed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final PreconditionFailed copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new PreconditionFailed(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PreconditionFailed) && Intrinsics.areEqual(this.message, ((PreconditionFailed) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "PreconditionFailed(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreconditionFailed(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ PreconditionFailed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$CustomError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CustomError extends DomainError {
        public static final Parcelable.Creator<CustomError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<CustomError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CustomError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CustomError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CustomError[] newArray(int i) {
                return new CustomError[i];
            }
        }

        public static /* synthetic */ CustomError copy$default(CustomError customError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customError.message;
            }
            return customError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final CustomError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new CustomError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CustomError) && Intrinsics.areEqual(this.message, ((CustomError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "CustomError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomError(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$UnknownError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UnknownError extends DomainError {
        public static final Parcelable.Creator<UnknownError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<UnknownError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final UnknownError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new UnknownError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final UnknownError[] newArray(int i) {
                return new UnknownError[i];
            }
        }

        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.message;
            }
            return unknownError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final UnknownError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new UnknownError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnknownError) && Intrinsics.areEqual(this.message, ((UnknownError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "UnknownError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001c\u0012\u000b\u0010\u0003\u001a\u00078\u0000¢\u0006\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00078\u0000¢\u0006\u0002\b\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0002HÆ\u0003J-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\r\b\u0002\u0010\u0003\u001a\u00078\u0000¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012R\u0018\u0010\u0003\u001a\u00078\u0000¢\u0006\u0002\b\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/models/DomainError$CachedDomainError;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/domain/models/DomainError;", SemanticAttributes.DbSystemValues.CACHE, "Lkotlinx/parcelize/RawValue;", "error", "<init>", "(Ljava/lang/Object;Lcom/box/android/domain/models/DomainError;)V", "getCache", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Object;Lcom/box/android/domain/models/DomainError;)Lcom/box/android/domain/models/DomainError$CachedDomainError;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CachedDomainError<T> extends DomainError {
        public static final Parcelable.Creator<CachedDomainError<?>> CREATOR = new Creator();
        private final T cache;
        private final DomainError error;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<CachedDomainError<?>> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CachedDomainError<?> createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CachedDomainError<>(parcel.readValue(CachedDomainError.class.getClassLoader()), (DomainError) parcel.readParcelable(CachedDomainError.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CachedDomainError<?>[] newArray(int i) {
                return new CachedDomainError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CachedDomainError copy$default(CachedDomainError cachedDomainError, Object obj, DomainError domainError, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = cachedDomainError.cache;
            }
            if ((i & 2) != 0) {
                domainError = cachedDomainError.error;
            }
            return cachedDomainError.copy(obj, domainError);
        }

        public final T component1() {
            return this.cache;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        public final CachedDomainError<T> copy(T cache, DomainError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new CachedDomainError<>(cache, error);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedDomainError)) {
                return false;
            }
            CachedDomainError cachedDomainError = (CachedDomainError) other;
            return Intrinsics.areEqual(this.cache, cachedDomainError.cache) && Intrinsics.areEqual(this.error, cachedDomainError.error);
        }

        public int hashCode() {
            T t = this.cache;
            return ((t == null ? 0 : t.hashCode()) * 31) + this.error.hashCode();
        }

        public String toString() {
            return "CachedDomainError(cache=" + this.cache + ", error=" + this.error + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeValue(this.cache);
            dest.writeParcelable(this.error, flags);
        }

        public final T getCache() {
            return this.cache;
        }

        public final DomainError getError() {
            return this.error;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CachedDomainError(T t, DomainError error) {
            super(null, ErrorRecoveryType.MANUAL, 1, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(error, "error");
            this.cache = t;
            this.error = error;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$JobCancelledError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class JobCancelledError extends DomainError {
        public static final Parcelable.Creator<JobCancelledError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<JobCancelledError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final JobCancelledError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new JobCancelledError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final JobCancelledError[] newArray(int i) {
                return new JobCancelledError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public JobCancelledError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ JobCancelledError copy$default(JobCancelledError jobCancelledError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jobCancelledError.message;
            }
            return jobCancelledError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final JobCancelledError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new JobCancelledError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof JobCancelledError) && Intrinsics.areEqual(this.message, ((JobCancelledError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "JobCancelledError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JobCancelledError(String message) {
            super(message, ErrorRecoveryType.AUTOMATIC, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ JobCancelledError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$Unauthorized;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Unauthorized extends DomainError {
        public static final Parcelable.Creator<Unauthorized> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Unauthorized> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unauthorized createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Unauthorized(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unauthorized[] newArray(int i) {
                return new Unauthorized[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Unauthorized() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Unauthorized copy$default(Unauthorized unauthorized, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unauthorized.message;
            }
            return unauthorized.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Unauthorized copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Unauthorized(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Unauthorized) && Intrinsics.areEqual(this.message, ((Unauthorized) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Unauthorized(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ Unauthorized(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unauthorized(String message) {
            super(message, ErrorRecoveryType.UNRECOVERABLE, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/DomainError$ItemRemoteIdIsNull;", "Lcom/box/android/domain/models/DomainError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemRemoteIdIsNull extends DomainError {
        public static final Parcelable.Creator<ItemRemoteIdIsNull> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ItemRemoteIdIsNull> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ItemRemoteIdIsNull createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ItemRemoteIdIsNull(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ItemRemoteIdIsNull[] newArray(int i) {
                return new ItemRemoteIdIsNull[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ItemRemoteIdIsNull() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ItemRemoteIdIsNull copy$default(ItemRemoteIdIsNull itemRemoteIdIsNull, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemRemoteIdIsNull.message;
            }
            return itemRemoteIdIsNull.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ItemRemoteIdIsNull copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ItemRemoteIdIsNull(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemRemoteIdIsNull) && Intrinsics.areEqual(this.message, ((ItemRemoteIdIsNull) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ItemRemoteIdIsNull(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemRemoteIdIsNull(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ ItemRemoteIdIsNull(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }
}
