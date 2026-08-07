package com.box.android.domain.models.annotations;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "<init>", "()V", "Page", "Frame", "None", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel$Frame;", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel$None;", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel$Page;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AnnotationLocationModel implements DomainModel, Parcelable {
    public /* synthetic */ AnnotationLocationModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AnnotationLocationModel() {
    }

    /* JADX INFO: compiled from: AnnotationModel.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\f\u001a\u00020\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationLocationModel$Page;", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "pageNumber", "", "<init>", "(I)V", "getPageNumber", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Page extends AnnotationLocationModel implements DomainModel, Parcelable {
        public static final Parcelable.Creator<Page> CREATOR = new Creator();
        private final int pageNumber;

        /* JADX INFO: compiled from: AnnotationModel.kt */
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

    /* JADX INFO: compiled from: AnnotationModel.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\f\u001a\u00020\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationLocationModel$Frame;", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "frameTimestampMs", "", "<init>", "(I)V", "getFrameTimestampMs", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Frame extends AnnotationLocationModel implements DomainModel, Parcelable {
        public static final Parcelable.Creator<Frame> CREATOR = new Creator();
        private final int frameTimestampMs;

        /* JADX INFO: compiled from: AnnotationModel.kt */
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

    /* JADX INFO: compiled from: AnnotationModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationLocationModel$None;", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "Landroid/os/Parcelable;", "<init>", "()V", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class None extends AnnotationLocationModel implements Parcelable {
        public static final None INSTANCE = new None();
        public static final Parcelable.Creator<None> CREATOR = new Creator();

        /* JADX INFO: compiled from: AnnotationModel.kt */
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
