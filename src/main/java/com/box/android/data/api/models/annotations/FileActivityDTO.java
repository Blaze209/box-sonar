package com.box.android.data.api.models.annotations;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\u0013\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "", "activityType", "Lcom/box/android/data/api/models/annotations/ActivityType;", "<init>", "(Lcom/box/android/data/api/models/annotations/ActivityType;)V", "getActivityType", "()Lcom/box/android/data/api/models/annotations/ActivityType;", "AnnotationActivityDTO", "EnhancedAnnotationActivityDTO", "CommentActivityDTO", "EnhancedCommentActivityDTO", "VersionsActivityDTO", "Lcom/box/android/data/api/models/annotations/FileActivityDTO$AnnotationActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO$CommentActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO$EnhancedAnnotationActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO$EnhancedCommentActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO$VersionsActivityDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileActivityDTO {
    private final ActivityType activityType;

    public /* synthetic */ FileActivityDTO(ActivityType activityType, DefaultConstructorMarker defaultConstructorMarker) {
        this(activityType);
    }

    private FileActivityDTO(@Json(name = "activity_type") ActivityType activityType) {
        this.activityType = activityType;
    }

    public final ActivityType getActivityType() {
        return this.activityType;
    }

    /* JADX INFO: compiled from: FileActivityDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivityDTO$AnnotationActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "source", "Lcom/box/android/data/api/models/annotations/AnnotationSourceDTO;", "<init>", "(Lcom/box/android/data/api/models/annotations/AnnotationSourceDTO;)V", "getSource", "()Lcom/box/android/data/api/models/annotations/AnnotationSourceDTO;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AnnotationActivityDTO extends FileActivityDTO {
        private final AnnotationSourceDTO source;

        public static /* synthetic */ AnnotationActivityDTO copy$default(AnnotationActivityDTO annotationActivityDTO, AnnotationSourceDTO annotationSourceDTO, int i, Object obj) {
            if ((i & 1) != 0) {
                annotationSourceDTO = annotationActivityDTO.source;
            }
            return annotationActivityDTO.copy(annotationSourceDTO);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnnotationSourceDTO getSource() {
            return this.source;
        }

        public final AnnotationActivityDTO copy(@Json(name = "source") AnnotationSourceDTO source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new AnnotationActivityDTO(source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnnotationActivityDTO) && Intrinsics.areEqual(this.source, ((AnnotationActivityDTO) other).source);
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        public String toString() {
            return "AnnotationActivityDTO(source=" + this.source + ")";
        }

        public final AnnotationSourceDTO getSource() {
            return this.source;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnnotationActivityDTO(@Json(name = "source") AnnotationSourceDTO source) {
            super(ActivityType.ANNOTATION, null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }
    }

    /* JADX INFO: compiled from: FileActivityDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivityDTO$EnhancedAnnotationActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "source", "Lcom/box/android/data/api/models/annotations/EnhancedAnnotationSourceDTO;", "<init>", "(Lcom/box/android/data/api/models/annotations/EnhancedAnnotationSourceDTO;)V", "getSource", "()Lcom/box/android/data/api/models/annotations/EnhancedAnnotationSourceDTO;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EnhancedAnnotationActivityDTO extends FileActivityDTO {
        private final EnhancedAnnotationSourceDTO source;

        public static /* synthetic */ EnhancedAnnotationActivityDTO copy$default(EnhancedAnnotationActivityDTO enhancedAnnotationActivityDTO, EnhancedAnnotationSourceDTO enhancedAnnotationSourceDTO, int i, Object obj) {
            if ((i & 1) != 0) {
                enhancedAnnotationSourceDTO = enhancedAnnotationActivityDTO.source;
            }
            return enhancedAnnotationActivityDTO.copy(enhancedAnnotationSourceDTO);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EnhancedAnnotationSourceDTO getSource() {
            return this.source;
        }

        public final EnhancedAnnotationActivityDTO copy(@Json(name = "source") EnhancedAnnotationSourceDTO source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new EnhancedAnnotationActivityDTO(source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EnhancedAnnotationActivityDTO) && Intrinsics.areEqual(this.source, ((EnhancedAnnotationActivityDTO) other).source);
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        public String toString() {
            return "EnhancedAnnotationActivityDTO(source=" + this.source + ")";
        }

        public final EnhancedAnnotationSourceDTO getSource() {
            return this.source;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnhancedAnnotationActivityDTO(@Json(name = "source") EnhancedAnnotationSourceDTO source) {
            super(ActivityType.ENHANCED_ANNOTATION, null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }
    }

    /* JADX INFO: compiled from: FileActivityDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivityDTO$CommentActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "source", "Lcom/box/android/data/api/models/annotations/CommentSourceDTO;", "<init>", "(Lcom/box/android/data/api/models/annotations/CommentSourceDTO;)V", "getSource", "()Lcom/box/android/data/api/models/annotations/CommentSourceDTO;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CommentActivityDTO extends FileActivityDTO {
        private final CommentSourceDTO source;

        public static /* synthetic */ CommentActivityDTO copy$default(CommentActivityDTO commentActivityDTO, CommentSourceDTO commentSourceDTO, int i, Object obj) {
            if ((i & 1) != 0) {
                commentSourceDTO = commentActivityDTO.source;
            }
            return commentActivityDTO.copy(commentSourceDTO);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CommentSourceDTO getSource() {
            return this.source;
        }

        public final CommentActivityDTO copy(@Json(name = "source") CommentSourceDTO source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new CommentActivityDTO(source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CommentActivityDTO) && Intrinsics.areEqual(this.source, ((CommentActivityDTO) other).source);
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        public String toString() {
            return "CommentActivityDTO(source=" + this.source + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentActivityDTO(@Json(name = "source") CommentSourceDTO source) {
            super(ActivityType.COMMENT, null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        public final CommentSourceDTO getSource() {
            return this.source;
        }
    }

    /* JADX INFO: compiled from: FileActivityDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivityDTO$EnhancedCommentActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "source", "Lcom/box/android/data/api/models/annotations/EnhancedCommentSourceDTO;", "<init>", "(Lcom/box/android/data/api/models/annotations/EnhancedCommentSourceDTO;)V", "getSource", "()Lcom/box/android/data/api/models/annotations/EnhancedCommentSourceDTO;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EnhancedCommentActivityDTO extends FileActivityDTO {
        private final EnhancedCommentSourceDTO source;

        public static /* synthetic */ EnhancedCommentActivityDTO copy$default(EnhancedCommentActivityDTO enhancedCommentActivityDTO, EnhancedCommentSourceDTO enhancedCommentSourceDTO, int i, Object obj) {
            if ((i & 1) != 0) {
                enhancedCommentSourceDTO = enhancedCommentActivityDTO.source;
            }
            return enhancedCommentActivityDTO.copy(enhancedCommentSourceDTO);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EnhancedCommentSourceDTO getSource() {
            return this.source;
        }

        public final EnhancedCommentActivityDTO copy(@Json(name = "source") EnhancedCommentSourceDTO source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new EnhancedCommentActivityDTO(source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EnhancedCommentActivityDTO) && Intrinsics.areEqual(this.source, ((EnhancedCommentActivityDTO) other).source);
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        public String toString() {
            return "EnhancedCommentActivityDTO(source=" + this.source + ")";
        }

        public final EnhancedCommentSourceDTO getSource() {
            return this.source;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnhancedCommentActivityDTO(@Json(name = "source") EnhancedCommentSourceDTO source) {
            super(ActivityType.ENHANCED_COMMENT, null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }
    }

    /* JADX INFO: compiled from: FileActivityDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/annotations/FileActivityDTO$VersionsActivityDTO;", "Lcom/box/android/data/api/models/annotations/FileActivityDTO;", "source", "Lcom/box/android/data/api/models/annotations/VersionsSourceDTO;", "<init>", "(Lcom/box/android/data/api/models/annotations/VersionsSourceDTO;)V", "getSource", "()Lcom/box/android/data/api/models/annotations/VersionsSourceDTO;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class VersionsActivityDTO extends FileActivityDTO {
        private final VersionsSourceDTO source;

        public static /* synthetic */ VersionsActivityDTO copy$default(VersionsActivityDTO versionsActivityDTO, VersionsSourceDTO versionsSourceDTO, int i, Object obj) {
            if ((i & 1) != 0) {
                versionsSourceDTO = versionsActivityDTO.source;
            }
            return versionsActivityDTO.copy(versionsSourceDTO);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VersionsSourceDTO getSource() {
            return this.source;
        }

        public final VersionsActivityDTO copy(@Json(name = "source") VersionsSourceDTO source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new VersionsActivityDTO(source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VersionsActivityDTO) && Intrinsics.areEqual(this.source, ((VersionsActivityDTO) other).source);
        }

        public int hashCode() {
            return this.source.hashCode();
        }

        public String toString() {
            return "VersionsActivityDTO(source=" + this.source + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VersionsActivityDTO(@Json(name = "source") VersionsSourceDTO source) {
            super(ActivityType.VERSIONS, null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        public final VersionsSourceDTO getSource() {
            return this.source;
        }
    }
}
