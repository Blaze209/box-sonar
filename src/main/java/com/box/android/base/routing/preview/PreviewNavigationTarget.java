package com.box.android.base.routing.preview;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewNavigationTarget.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "Landroid/os/Parcelable;", "<init>", "()V", "getActivityId", "", "FileActivityItemAnnotation", "AnnotationOnPreview", "Collaborators", BoxAmplitudeAnalytics.PushNotifEventPropertyBuilder.NOTIF_TYPE_COMMENTS, "Timestamp", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget$AnnotationOnPreview;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget$Collaborators;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget$Comments;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget$FileActivityItemAnnotation;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget$Timestamp;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class PreviewNavigationTarget implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ PreviewNavigationTarget(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PreviewNavigationTarget() {
    }

    /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/routing/preview/PreviewNavigationTarget$FileActivityItemAnnotation;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "annotationId", "", "<init>", "(Ljava/lang/String;)V", "getAnnotationId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileActivityItemAnnotation extends PreviewNavigationTarget {
        public static final int $stable = 0;
        public static final Parcelable.Creator<FileActivityItemAnnotation> CREATOR = new Creator();
        private final String annotationId;

        /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FileActivityItemAnnotation> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FileActivityItemAnnotation createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FileActivityItemAnnotation(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FileActivityItemAnnotation[] newArray(int i) {
                return new FileActivityItemAnnotation[i];
            }
        }

        public static /* synthetic */ FileActivityItemAnnotation copy$default(FileActivityItemAnnotation fileActivityItemAnnotation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileActivityItemAnnotation.annotationId;
            }
            return fileActivityItemAnnotation.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnnotationId() {
            return this.annotationId;
        }

        public final FileActivityItemAnnotation copy(String annotationId) {
            return new FileActivityItemAnnotation(annotationId);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FileActivityItemAnnotation) && Intrinsics.areEqual(this.annotationId, ((FileActivityItemAnnotation) other).annotationId);
        }

        public int hashCode() {
            String str = this.annotationId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "FileActivityItemAnnotation(annotationId=" + this.annotationId + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.annotationId);
        }

        public FileActivityItemAnnotation(String str) {
            super(null);
            this.annotationId = str;
        }

        public final String getAnnotationId() {
            return this.annotationId;
        }
    }

    /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/routing/preview/PreviewNavigationTarget$AnnotationOnPreview;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "annotationId", "", "<init>", "(Ljava/lang/String;)V", "getAnnotationId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AnnotationOnPreview extends PreviewNavigationTarget {
        public static final int $stable = 0;
        public static final Parcelable.Creator<AnnotationOnPreview> CREATOR = new Creator();
        private final String annotationId;

        /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AnnotationOnPreview> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AnnotationOnPreview createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AnnotationOnPreview(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AnnotationOnPreview[] newArray(int i) {
                return new AnnotationOnPreview[i];
            }
        }

        public static /* synthetic */ AnnotationOnPreview copy$default(AnnotationOnPreview annotationOnPreview, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = annotationOnPreview.annotationId;
            }
            return annotationOnPreview.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnnotationId() {
            return this.annotationId;
        }

        public final AnnotationOnPreview copy(String annotationId) {
            Intrinsics.checkNotNullParameter(annotationId, "annotationId");
            return new AnnotationOnPreview(annotationId);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnnotationOnPreview) && Intrinsics.areEqual(this.annotationId, ((AnnotationOnPreview) other).annotationId);
        }

        public int hashCode() {
            return this.annotationId.hashCode();
        }

        public String toString() {
            return "AnnotationOnPreview(annotationId=" + this.annotationId + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.annotationId);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnnotationOnPreview(String annotationId) {
            super(null);
            Intrinsics.checkNotNullParameter(annotationId, "annotationId");
            this.annotationId = annotationId;
        }

        public final String getAnnotationId() {
            return this.annotationId;
        }
    }

    /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\n\u001a\u00020\u0005HÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/routing/preview/PreviewNavigationTarget$Collaborators;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Collaborators extends PreviewNavigationTarget {
        public static final int $stable = 0;
        public static final Collaborators INSTANCE = new Collaborators();
        public static final Parcelable.Creator<Collaborators> CREATOR = new Creator();

        /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Collaborators> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Collaborators createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Collaborators.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Collaborators[] newArray(int i) {
                return new Collaborators[i];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Collaborators)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -810110928;
        }

        public String toString() {
            return "Collaborators";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }

        private Collaborators() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/routing/preview/PreviewNavigationTarget$Comments;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "commentId", "", "<init>", "(Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Comments extends PreviewNavigationTarget {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Comments> CREATOR = new Creator();
        private final String commentId;

        /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Comments> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Comments createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Comments(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Comments[] newArray(int i) {
                return new Comments[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Comments() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Comments copy$default(Comments comments, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = comments.commentId;
            }
            return comments.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCommentId() {
            return this.commentId;
        }

        public final Comments copy(String commentId) {
            return new Comments(commentId);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Comments) && Intrinsics.areEqual(this.commentId, ((Comments) other).commentId);
        }

        public int hashCode() {
            String str = this.commentId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Comments(commentId=" + this.commentId + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.commentId);
        }

        public Comments(String str) {
            super(null);
            this.commentId = str;
        }

        public /* synthetic */ Comments(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getCommentId() {
            return this.commentId;
        }
    }

    /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/box/android/base/routing/preview/PreviewNavigationTarget$Timestamp;", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "timestampMs", "", "<init>", "(J)V", "getTimestampMs", "()J", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Timestamp extends PreviewNavigationTarget {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Timestamp> CREATOR = new Creator();
        private final long timestampMs;

        /* JADX INFO: compiled from: PreviewNavigationTarget.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Timestamp> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Timestamp createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Timestamp(parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Timestamp[] newArray(int i) {
                return new Timestamp[i];
            }
        }

        public static /* synthetic */ Timestamp copy$default(Timestamp timestamp, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = timestamp.timestampMs;
            }
            return timestamp.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getTimestampMs() {
            return this.timestampMs;
        }

        public final Timestamp copy(long timestampMs) {
            return new Timestamp(timestampMs);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Timestamp) && this.timestampMs == ((Timestamp) other).timestampMs;
        }

        public int hashCode() {
            return Long.hashCode(this.timestampMs);
        }

        public String toString() {
            return "Timestamp(timestampMs=" + this.timestampMs + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeLong(this.timestampMs);
        }

        public Timestamp(long j) {
            super(null);
            this.timestampMs = j;
        }

        public final long getTimestampMs() {
            return this.timestampMs;
        }
    }

    public final String getActivityId() {
        if (this instanceof AnnotationOnPreview) {
            return ((AnnotationOnPreview) this).getAnnotationId();
        }
        if (this instanceof FileActivityItemAnnotation) {
            return ((FileActivityItemAnnotation) this).getAnnotationId();
        }
        if (this instanceof Comments) {
            return ((Comments) this).getCommentId();
        }
        return null;
    }
}
