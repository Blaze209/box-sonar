package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\fB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0001\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/domain/models/FileActivityDomainError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "errorType", "Lcom/box/android/domain/models/ErrorRecoveryType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ErrorRecoveryType;)V", "getMessage", "()Ljava/lang/String;", "getErrorType", "()Lcom/box/android/domain/models/ErrorRecoveryType;", "CouldNotFetchActivityError", "Lcom/box/android/domain/models/FileActivityDomainError$CouldNotFetchActivityError;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileActivityDomainError extends DomainError {
    private final ErrorRecoveryType errorType;
    private final String message;

    public /* synthetic */ FileActivityDomainError(String str, ErrorRecoveryType errorRecoveryType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, errorRecoveryType);
    }

    private FileActivityDomainError(String str, ErrorRecoveryType errorRecoveryType) {
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
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006!"}, d2 = {"Lcom/box/android/domain/models/FileActivityDomainError$CouldNotFetchActivityError;", "Lcom/box/android/domain/models/FileActivityDomainError;", "annotationNotFetched", "", "versionsNotFetched", "commentsNotFetched", "<init>", "(ZZZ)V", "getAnnotationNotFetched", "()Z", "setAnnotationNotFetched", "(Z)V", "getVersionsNotFetched", "setVersionsNotFetched", "getCommentsNotFetched", "setCommentsNotFetched", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CouldNotFetchActivityError extends FileActivityDomainError {
        public static final Parcelable.Creator<CouldNotFetchActivityError> CREATOR = new Creator();
        private boolean annotationNotFetched;
        private boolean commentsNotFetched;
        private boolean versionsNotFetched;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<CouldNotFetchActivityError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CouldNotFetchActivityError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CouldNotFetchActivityError(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CouldNotFetchActivityError[] newArray(int i) {
                return new CouldNotFetchActivityError[i];
            }
        }

        public CouldNotFetchActivityError() {
            this(false, false, false, 7, null);
        }

        public static /* synthetic */ CouldNotFetchActivityError copy$default(CouldNotFetchActivityError couldNotFetchActivityError, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = couldNotFetchActivityError.annotationNotFetched;
            }
            if ((i & 2) != 0) {
                z2 = couldNotFetchActivityError.versionsNotFetched;
            }
            if ((i & 4) != 0) {
                z3 = couldNotFetchActivityError.commentsNotFetched;
            }
            return couldNotFetchActivityError.copy(z, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getAnnotationNotFetched() {
            return this.annotationNotFetched;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getVersionsNotFetched() {
            return this.versionsNotFetched;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCommentsNotFetched() {
            return this.commentsNotFetched;
        }

        public final CouldNotFetchActivityError copy(boolean annotationNotFetched, boolean versionsNotFetched, boolean commentsNotFetched) {
            return new CouldNotFetchActivityError(annotationNotFetched, versionsNotFetched, commentsNotFetched);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CouldNotFetchActivityError)) {
                return false;
            }
            CouldNotFetchActivityError couldNotFetchActivityError = (CouldNotFetchActivityError) other;
            return this.annotationNotFetched == couldNotFetchActivityError.annotationNotFetched && this.versionsNotFetched == couldNotFetchActivityError.versionsNotFetched && this.commentsNotFetched == couldNotFetchActivityError.commentsNotFetched;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.annotationNotFetched) * 31) + Boolean.hashCode(this.versionsNotFetched)) * 31) + Boolean.hashCode(this.commentsNotFetched);
        }

        public String toString() {
            return "CouldNotFetchActivityError(annotationNotFetched=" + this.annotationNotFetched + ", versionsNotFetched=" + this.versionsNotFetched + ", commentsNotFetched=" + this.commentsNotFetched + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.annotationNotFetched ? 1 : 0);
            dest.writeInt(this.versionsNotFetched ? 1 : 0);
            dest.writeInt(this.commentsNotFetched ? 1 : 0);
        }

        public /* synthetic */ CouldNotFetchActivityError(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
        }

        public final boolean getAnnotationNotFetched() {
            return this.annotationNotFetched;
        }

        public final void setAnnotationNotFetched(boolean z) {
            this.annotationNotFetched = z;
        }

        public final boolean getVersionsNotFetched() {
            return this.versionsNotFetched;
        }

        public final void setVersionsNotFetched(boolean z) {
            this.versionsNotFetched = z;
        }

        public final boolean getCommentsNotFetched() {
            return this.commentsNotFetched;
        }

        public final void setCommentsNotFetched(boolean z) {
            this.commentsNotFetched = z;
        }

        public CouldNotFetchActivityError(boolean z, boolean z2, boolean z3) {
            super("", ErrorRecoveryType.MANUAL, null);
            this.annotationNotFetched = z;
            this.versionsNotFetched = z2;
            this.commentsNotFetched = z3;
        }
    }
}
