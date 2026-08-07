package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/models/AudioRecordingError;", "Lcom/box/android/domain/models/DomainError;", "message", "", "errorType", "Lcom/box/android/domain/models/ErrorRecoveryType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ErrorRecoveryType;)V", "getMessage", "()Ljava/lang/String;", "getErrorType", "()Lcom/box/android/domain/models/ErrorRecoveryType;", "MicrophoneInUseError", "AudioRecordingStartError", "AudioRecordingResumeError", "AudioRecordingPauseError", "AudioRecordingStopError", "Lcom/box/android/domain/models/AudioRecordingError$AudioRecordingPauseError;", "Lcom/box/android/domain/models/AudioRecordingError$AudioRecordingResumeError;", "Lcom/box/android/domain/models/AudioRecordingError$AudioRecordingStartError;", "Lcom/box/android/domain/models/AudioRecordingError$AudioRecordingStopError;", "Lcom/box/android/domain/models/AudioRecordingError$MicrophoneInUseError;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AudioRecordingError extends DomainError {
    private final ErrorRecoveryType errorType;
    private final String message;

    public /* synthetic */ AudioRecordingError(String str, ErrorRecoveryType errorRecoveryType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, errorRecoveryType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AudioRecordingError(String str, ErrorRecoveryType errorRecoveryType) {
        super(null, errorRecoveryType, 1, 0 == true ? 1 : 0);
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
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AudioRecordingError$MicrophoneInUseError;", "Lcom/box/android/domain/models/AudioRecordingError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MicrophoneInUseError extends AudioRecordingError {
        public static final Parcelable.Creator<MicrophoneInUseError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<MicrophoneInUseError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MicrophoneInUseError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MicrophoneInUseError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final MicrophoneInUseError[] newArray(int i) {
                return new MicrophoneInUseError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MicrophoneInUseError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ MicrophoneInUseError copy$default(MicrophoneInUseError microphoneInUseError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = microphoneInUseError.message;
            }
            return microphoneInUseError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final MicrophoneInUseError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new MicrophoneInUseError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MicrophoneInUseError) && Intrinsics.areEqual(this.message, ((MicrophoneInUseError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "MicrophoneInUseError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MicrophoneInUseError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public /* synthetic */ MicrophoneInUseError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AudioRecordingError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AudioRecordingError$AudioRecordingStartError;", "Lcom/box/android/domain/models/AudioRecordingError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AudioRecordingStartError extends AudioRecordingError {
        public static final Parcelable.Creator<AudioRecordingStartError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AudioRecordingStartError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AudioRecordingStartError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AudioRecordingStartError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AudioRecordingStartError[] newArray(int i) {
                return new AudioRecordingStartError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AudioRecordingStartError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AudioRecordingStartError copy$default(AudioRecordingStartError audioRecordingStartError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = audioRecordingStartError.message;
            }
            return audioRecordingStartError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final AudioRecordingStartError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new AudioRecordingStartError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AudioRecordingStartError) && Intrinsics.areEqual(this.message, ((AudioRecordingStartError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "AudioRecordingStartError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ AudioRecordingStartError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AudioRecordingError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioRecordingStartError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AudioRecordingError$AudioRecordingResumeError;", "Lcom/box/android/domain/models/AudioRecordingError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AudioRecordingResumeError extends AudioRecordingError {
        public static final Parcelable.Creator<AudioRecordingResumeError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AudioRecordingResumeError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AudioRecordingResumeError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AudioRecordingResumeError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AudioRecordingResumeError[] newArray(int i) {
                return new AudioRecordingResumeError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AudioRecordingResumeError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AudioRecordingResumeError copy$default(AudioRecordingResumeError audioRecordingResumeError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = audioRecordingResumeError.message;
            }
            return audioRecordingResumeError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final AudioRecordingResumeError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new AudioRecordingResumeError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AudioRecordingResumeError) && Intrinsics.areEqual(this.message, ((AudioRecordingResumeError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "AudioRecordingResumeError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ AudioRecordingResumeError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AudioRecordingError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioRecordingResumeError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AudioRecordingError$AudioRecordingPauseError;", "Lcom/box/android/domain/models/AudioRecordingError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AudioRecordingPauseError extends AudioRecordingError {
        public static final Parcelable.Creator<AudioRecordingPauseError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AudioRecordingPauseError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AudioRecordingPauseError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AudioRecordingPauseError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AudioRecordingPauseError[] newArray(int i) {
                return new AudioRecordingPauseError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AudioRecordingPauseError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AudioRecordingPauseError copy$default(AudioRecordingPauseError audioRecordingPauseError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = audioRecordingPauseError.message;
            }
            return audioRecordingPauseError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final AudioRecordingPauseError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new AudioRecordingPauseError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AudioRecordingPauseError) && Intrinsics.areEqual(this.message, ((AudioRecordingPauseError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "AudioRecordingPauseError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ AudioRecordingPauseError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AudioRecordingError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioRecordingPauseError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }

    /* JADX INFO: compiled from: DomainError.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/AudioRecordingError$AudioRecordingStopError;", "Lcom/box/android/domain/models/AudioRecordingError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AudioRecordingStopError extends AudioRecordingError {
        public static final Parcelable.Creator<AudioRecordingStopError> CREATOR = new Creator();
        private final String message;

        /* JADX INFO: compiled from: DomainError.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AudioRecordingStopError> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AudioRecordingStopError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AudioRecordingStopError(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AudioRecordingStopError[] newArray(int i) {
                return new AudioRecordingStopError[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AudioRecordingStopError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AudioRecordingStopError copy$default(AudioRecordingStopError audioRecordingStopError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = audioRecordingStopError.message;
            }
            return audioRecordingStopError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final AudioRecordingStopError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new AudioRecordingStopError(message);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AudioRecordingStopError) && Intrinsics.areEqual(this.message, ((AudioRecordingStopError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "AudioRecordingStopError(message=" + this.message + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.message);
        }

        public /* synthetic */ AudioRecordingStopError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        @Override // com.box.android.domain.models.AudioRecordingError, com.box.android.domain.models.DomainError
        public String getMessage() {
            return this.message;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioRecordingStopError(String message) {
            super(message, ErrorRecoveryType.MANUAL, null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }
    }
}
