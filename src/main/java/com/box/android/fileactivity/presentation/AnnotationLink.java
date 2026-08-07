package com.box.android.fileactivity.presentation;

import com.amplitude.api.Constants;
import com.box.android.base.presentation.components.commentbar.TimestampData;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/fileactivity/presentation/AnnotationLink;", "", "<init>", "()V", "FrameAnnotation", "TimestampComment", "Lcom/box/android/fileactivity/presentation/AnnotationLink$FrameAnnotation;", "Lcom/box/android/fileactivity/presentation/AnnotationLink$TimestampComment;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AnnotationLink {
    public static final int $stable = 0;

    public /* synthetic */ AnnotationLink(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FileActivitiesScreen.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/fileactivity/presentation/AnnotationLink$FrameAnnotation;", "Lcom/box/android/fileactivity/presentation/AnnotationLink;", "timestampMs", "", Constants.AMP_PLAN_VERSION_ID, "", "annotationId", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getTimestampMs", "()J", "getVersionId", "()Ljava/lang/String;", "getAnnotationId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FrameAnnotation extends AnnotationLink {
        public static final int $stable = 0;
        private final String annotationId;
        private final long timestampMs;
        private final String versionId;

        public static /* synthetic */ FrameAnnotation copy$default(FrameAnnotation frameAnnotation, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = frameAnnotation.timestampMs;
            }
            if ((i & 2) != 0) {
                str = frameAnnotation.versionId;
            }
            if ((i & 4) != 0) {
                str2 = frameAnnotation.annotationId;
            }
            return frameAnnotation.copy(j, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestampMs() {
            return this.timestampMs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getVersionId() {
            return this.versionId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAnnotationId() {
            return this.annotationId;
        }

        public final FrameAnnotation copy(long timestampMs, String versionId, String annotationId) {
            Intrinsics.checkNotNullParameter(versionId, "versionId");
            Intrinsics.checkNotNullParameter(annotationId, "annotationId");
            return new FrameAnnotation(timestampMs, versionId, annotationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FrameAnnotation)) {
                return false;
            }
            FrameAnnotation frameAnnotation = (FrameAnnotation) other;
            return this.timestampMs == frameAnnotation.timestampMs && Intrinsics.areEqual(this.versionId, frameAnnotation.versionId) && Intrinsics.areEqual(this.annotationId, frameAnnotation.annotationId);
        }

        public int hashCode() {
            return (((Long.hashCode(this.timestampMs) * 31) + this.versionId.hashCode()) * 31) + this.annotationId.hashCode();
        }

        public String toString() {
            return "FrameAnnotation(timestampMs=" + this.timestampMs + ", versionId=" + this.versionId + ", annotationId=" + this.annotationId + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FrameAnnotation(long j, String versionId, String annotationId) {
            super(null);
            Intrinsics.checkNotNullParameter(versionId, "versionId");
            Intrinsics.checkNotNullParameter(annotationId, "annotationId");
            this.timestampMs = j;
            this.versionId = versionId;
            this.annotationId = annotationId;
        }

        public final String getAnnotationId() {
            return this.annotationId;
        }

        public final long getTimestampMs() {
            return this.timestampMs;
        }

        public final String getVersionId() {
            return this.versionId;
        }
    }

    private AnnotationLink() {
    }

    /* JADX INFO: compiled from: FileActivitiesScreen.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/fileactivity/presentation/AnnotationLink$TimestampComment;", "Lcom/box/android/fileactivity/presentation/AnnotationLink;", "displayMessage", "", "timestampData", "Lcom/box/android/base/presentation/components/commentbar/TimestampData;", "<init>", "(Ljava/lang/String;Lcom/box/android/base/presentation/components/commentbar/TimestampData;)V", "getDisplayMessage", "()Ljava/lang/String;", "getTimestampData", "()Lcom/box/android/base/presentation/components/commentbar/TimestampData;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TimestampComment extends AnnotationLink {
        public static final int $stable = TimestampData.$stable;
        private final String displayMessage;
        private final TimestampData timestampData;

        public static /* synthetic */ TimestampComment copy$default(TimestampComment timestampComment, String str, TimestampData timestampData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = timestampComment.displayMessage;
            }
            if ((i & 2) != 0) {
                timestampData = timestampComment.timestampData;
            }
            return timestampComment.copy(str, timestampData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDisplayMessage() {
            return this.displayMessage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TimestampData getTimestampData() {
            return this.timestampData;
        }

        public final TimestampComment copy(String displayMessage, TimestampData timestampData) {
            Intrinsics.checkNotNullParameter(displayMessage, "displayMessage");
            Intrinsics.checkNotNullParameter(timestampData, "timestampData");
            return new TimestampComment(displayMessage, timestampData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TimestampComment)) {
                return false;
            }
            TimestampComment timestampComment = (TimestampComment) other;
            return Intrinsics.areEqual(this.displayMessage, timestampComment.displayMessage) && Intrinsics.areEqual(this.timestampData, timestampComment.timestampData);
        }

        public int hashCode() {
            return (this.displayMessage.hashCode() * 31) + this.timestampData.hashCode();
        }

        public String toString() {
            return "TimestampComment(displayMessage=" + this.displayMessage + ", timestampData=" + this.timestampData + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TimestampComment(String displayMessage, TimestampData timestampData) {
            super(null);
            Intrinsics.checkNotNullParameter(displayMessage, "displayMessage");
            Intrinsics.checkNotNullParameter(timestampData, "timestampData");
            this.displayMessage = displayMessage;
            this.timestampData = timestampData;
        }

        public final String getDisplayMessage() {
            return this.displayMessage;
        }

        public final TimestampData getTimestampData() {
            return this.timestampData;
        }
    }
}
