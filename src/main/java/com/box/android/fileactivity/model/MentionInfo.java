package com.box.android.fileactivity.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityModelToUiModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0005J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/box/android/fileactivity/model/MentionInfo;", "Landroid/os/Parcelable;", "userUIModel", "Lcom/box/android/fileactivity/model/UserUIModel;", "startIndex", "", "endIndex", "<init>", "(Lcom/box/android/fileactivity/model/UserUIModel;II)V", "getUserUIModel", "()Lcom/box/android/fileactivity/model/UserUIModel;", "getStartIndex", "()I", "getEndIndex", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MentionInfo implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<MentionInfo> CREATOR = new Creator();
    private final int endIndex;
    private final int startIndex;
    private final UserUIModel userUIModel;

    /* JADX INFO: compiled from: FileActivityModelToUiModelMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MentionInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MentionInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MentionInfo((UserUIModel) parcel.readSerializable(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MentionInfo[] newArray(int i) {
            return new MentionInfo[i];
        }
    }

    public static /* synthetic */ MentionInfo copy$default(MentionInfo mentionInfo, UserUIModel userUIModel, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            userUIModel = mentionInfo.userUIModel;
        }
        if ((i3 & 2) != 0) {
            i = mentionInfo.startIndex;
        }
        if ((i3 & 4) != 0) {
            i2 = mentionInfo.endIndex;
        }
        return mentionInfo.copy(userUIModel, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UserUIModel getUserUIModel() {
        return this.userUIModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getEndIndex() {
        return this.endIndex;
    }

    public final MentionInfo copy(UserUIModel userUIModel, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(userUIModel, "userUIModel");
        return new MentionInfo(userUIModel, startIndex, endIndex);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MentionInfo)) {
            return false;
        }
        MentionInfo mentionInfo = (MentionInfo) other;
        return Intrinsics.areEqual(this.userUIModel, mentionInfo.userUIModel) && this.startIndex == mentionInfo.startIndex && this.endIndex == mentionInfo.endIndex;
    }

    public int hashCode() {
        return (((this.userUIModel.hashCode() * 31) + Integer.hashCode(this.startIndex)) * 31) + Integer.hashCode(this.endIndex);
    }

    public String toString() {
        return "MentionInfo(userUIModel=" + this.userUIModel + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeSerializable(this.userUIModel);
        dest.writeInt(this.startIndex);
        dest.writeInt(this.endIndex);
    }

    public MentionInfo(UserUIModel userUIModel, int i, int i2) {
        Intrinsics.checkNotNullParameter(userUIModel, "userUIModel");
        this.userUIModel = userUIModel;
        this.startIndex = i;
        this.endIndex = i2;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final UserUIModel getUserUIModel() {
        return this.userUIModel;
    }
}
