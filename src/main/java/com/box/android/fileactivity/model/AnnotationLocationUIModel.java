package com.box.android.fileactivity.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityUIModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/fileactivity/model/AnnotationLocationUIModel;", "Landroid/os/Parcelable;", "<init>", "()V", "Page", "Frame", "None", "Lcom/box/android/fileactivity/model/AnnotationLocationUIModel$Frame;", "Lcom/box/android/fileactivity/model/AnnotationLocationUIModel$None;", "Lcom/box/android/fileactivity/model/AnnotationLocationUIModel$Page;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AnnotationLocationUIModel implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ AnnotationLocationUIModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ActivityUIModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u0003J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/fileactivity/model/AnnotationLocationUIModel$Page;", "Lcom/box/android/fileactivity/model/AnnotationLocationUIModel;", "pageNumber", "", "<init>", "(I)V", "getPageNumber", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Page extends AnnotationLocationUIModel {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Page> CREATOR = new Creator();
        private final int pageNumber;

        /* JADX INFO: compiled from: ActivityUIModel.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Page> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Page createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Page(parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Page[] newArray(int i) {
                return new Page[i];
            }
        }

        public static /* synthetic */ Page copy$default(Page page, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = page.pageNumber;
            }
            return page.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageNumber() {
            return this.pageNumber;
        }

        public final Page copy(int pageNumber) {
            return new Page(pageNumber);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Page) && this.pageNumber == ((Page) other).pageNumber;
        }

        public int hashCode() {
            return Integer.hashCode(this.pageNumber);
        }

        public String toString() {
            return "Page(pageNumber=" + this.pageNumber + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.pageNumber);
        }

        public Page(int i) {
            super(null);
            this.pageNumber = i;
        }

        public final int getPageNumber() {
            return this.pageNumber;
        }
    }

    private AnnotationLocationUIModel() {
    }

    /* JADX INFO: compiled from: ActivityUIModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u0003J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/box/android/fileactivity/model/AnnotationLocationUIModel$Frame;", "Lcom/box/android/fileactivity/model/AnnotationLocationUIModel;", "frameTimestampMs", "", "<init>", "(I)V", "getFrameTimestampMs", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Frame extends AnnotationLocationUIModel {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Frame> CREATOR = new Creator();
        private final int frameTimestampMs;

        /* JADX INFO: compiled from: ActivityUIModel.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Frame> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Frame createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Frame(parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Frame[] newArray(int i) {
                return new Frame[i];
            }
        }

        public static /* synthetic */ Frame copy$default(Frame frame, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = frame.frameTimestampMs;
            }
            return frame.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getFrameTimestampMs() {
            return this.frameTimestampMs;
        }

        public final Frame copy(int frameTimestampMs) {
            return new Frame(frameTimestampMs);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Frame) && this.frameTimestampMs == ((Frame) other).frameTimestampMs;
        }

        public int hashCode() {
            return Integer.hashCode(this.frameTimestampMs);
        }

        public String toString() {
            return "Frame(frameTimestampMs=" + this.frameTimestampMs + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.frameTimestampMs);
        }

        public Frame(int i) {
            super(null);
            this.frameTimestampMs = i;
        }

        public final int getFrameTimestampMs() {
            return this.frameTimestampMs;
        }
    }

    /* JADX INFO: compiled from: ActivityUIModel.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0006HÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"Lcom/box/android/fileactivity/model/AnnotationLocationUIModel$None;", "Lcom/box/android/fileactivity/model/AnnotationLocationUIModel;", "Landroid/os/Parcelable;", "<init>", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class None extends AnnotationLocationUIModel implements Parcelable {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();
        public static final Parcelable.Creator<None> CREATOR = new Creator();

        /* JADX INFO: compiled from: ActivityUIModel.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<None> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final None createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return None.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final None[] newArray(int i) {
                return new None[i];
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
            if (!(other instanceof None)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1523518958;
        }

        public String toString() {
            return "None";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(1);
        }

        private None() {
            super(null);
        }
    }
}
