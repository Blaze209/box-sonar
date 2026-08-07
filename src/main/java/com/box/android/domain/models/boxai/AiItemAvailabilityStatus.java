package com.box.android.domain.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiItemAvailabilityStatus.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;", "", "Available", "Unavailable", "Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus$Available;", "Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus$Unavailable;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AiItemAvailabilityStatus {

    /* JADX INFO: compiled from: AiItemAvailabilityStatus.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus$Available;", "Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;", "fileType", "Lcom/box/android/domain/models/boxai/AiFileType;", "<init>", "(Lcom/box/android/domain/models/boxai/AiFileType;)V", "getFileType", "()Lcom/box/android/domain/models/boxai/AiFileType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Available implements AiItemAvailabilityStatus {
        private final AiFileType fileType;

        public static /* synthetic */ Available copy$default(Available available, AiFileType aiFileType, int i, Object obj) {
            if ((i & 1) != 0) {
                aiFileType = available.fileType;
            }
            return available.copy(aiFileType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AiFileType getFileType() {
            return this.fileType;
        }

        public final Available copy(AiFileType fileType) {
            Intrinsics.checkNotNullParameter(fileType, "fileType");
            return new Available(fileType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Available) && this.fileType == ((Available) other).fileType;
        }

        public int hashCode() {
            return this.fileType.hashCode();
        }

        public String toString() {
            return "Available(fileType=" + this.fileType + ")";
        }

        public Available(AiFileType fileType) {
            Intrinsics.checkNotNullParameter(fileType, "fileType");
            this.fileType = fileType;
        }

        public final AiFileType getFileType() {
            return this.fileType;
        }
    }

    /* JADX INFO: compiled from: AiItemAvailabilityStatus.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus$Unavailable;", "Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "isRetryable", "", "<init>", "(Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;Z)V", "getReason", "()Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Unavailable implements AiItemAvailabilityStatus {
        private final boolean isRetryable;
        private final AiUnavailabilityReason reason;

        public static /* synthetic */ Unavailable copy$default(Unavailable unavailable, AiUnavailabilityReason aiUnavailabilityReason, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                aiUnavailabilityReason = unavailable.reason;
            }
            if ((i & 2) != 0) {
                z = unavailable.isRetryable;
            }
            return unavailable.copy(aiUnavailabilityReason, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AiUnavailabilityReason getReason() {
            return this.reason;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsRetryable() {
            return this.isRetryable;
        }

        public final Unavailable copy(AiUnavailabilityReason reason, boolean isRetryable) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Unavailable(reason, isRetryable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unavailable)) {
                return false;
            }
            Unavailable unavailable = (Unavailable) other;
            return this.reason == unavailable.reason && this.isRetryable == unavailable.isRetryable;
        }

        public int hashCode() {
            return (this.reason.hashCode() * 31) + Boolean.hashCode(this.isRetryable);
        }

        public String toString() {
            return "Unavailable(reason=" + this.reason + ", isRetryable=" + this.isRetryable + ")";
        }

        public Unavailable(AiUnavailabilityReason reason, boolean z) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
            this.isRetryable = z;
        }

        public /* synthetic */ Unavailable(AiUnavailabilityReason aiUnavailabilityReason, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(aiUnavailabilityReason, (i & 2) != 0 ? false : z);
        }

        public final AiUnavailabilityReason getReason() {
            return this.reason;
        }

        public final boolean isRetryable() {
            return this.isRetryable;
        }
    }
}
