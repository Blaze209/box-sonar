package com.box.android.base.presentation.components.commentbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.amplitude.api.Constants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0007J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JN\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020#J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020#HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006."}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "Landroid/os/Parcelable;", "enabled", "", "currentTimestampMs", "", Constants.AMP_PLAN_VERSION_ID, "", "overrideTimestampMs", "overrideVersionId", "shouldShowToggle", "<init>", "(ZJLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Z)V", "getEnabled", "()Z", "getCurrentTimestampMs", "()J", "getVersionId", "()Ljava/lang/String;", "getOverrideTimestampMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOverrideVersionId", "getShouldShowToggle", "getTimestampForSubmission", "getVersionIdForSubmission", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(ZJLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Z)Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TimestampedCommentConfig implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<TimestampedCommentConfig> CREATOR = new Creator();
    private final long currentTimestampMs;
    private final boolean enabled;
    private final Long overrideTimestampMs;
    private final String overrideVersionId;
    private final boolean shouldShowToggle;
    private final String versionId;

    /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TimestampedCommentConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimestampedCommentConfig createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            String str;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z3 = true;
            if (parcel.readInt() != 0) {
                z = false;
            } else {
                z3 = false;
                z = false;
            }
            long j = parcel.readLong();
            boolean z4 = z;
            String string = parcel.readString();
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String string2 = parcel.readString();
            if (parcel.readInt() != 0) {
                str = string2;
                z2 = true;
            } else {
                z2 = z4;
                str = string2;
            }
            return new TimestampedCommentConfig(z3, j, string, lValueOf, str, z2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TimestampedCommentConfig[] newArray(int i) {
            return new TimestampedCommentConfig[i];
        }
    }

    public TimestampedCommentConfig() {
        this(false, 0L, null, null, null, false, 63, null);
    }

    public static /* synthetic */ TimestampedCommentConfig copy$default(TimestampedCommentConfig timestampedCommentConfig, boolean z, long j, String str, Long l, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = timestampedCommentConfig.enabled;
        }
        if ((i & 2) != 0) {
            j = timestampedCommentConfig.currentTimestampMs;
        }
        if ((i & 4) != 0) {
            str = timestampedCommentConfig.versionId;
        }
        if ((i & 8) != 0) {
            l = timestampedCommentConfig.overrideTimestampMs;
        }
        if ((i & 16) != 0) {
            str2 = timestampedCommentConfig.overrideVersionId;
        }
        if ((i & 32) != 0) {
            z2 = timestampedCommentConfig.shouldShowToggle;
        }
        return timestampedCommentConfig.copy(z, j, str, l, str2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getCurrentTimestampMs() {
        return this.currentTimestampMs;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getOverrideTimestampMs() {
        return this.overrideTimestampMs;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOverrideVersionId() {
        return this.overrideVersionId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShouldShowToggle() {
        return this.shouldShowToggle;
    }

    public final TimestampedCommentConfig copy(boolean enabled, long currentTimestampMs, String versionId, Long overrideTimestampMs, String overrideVersionId, boolean shouldShowToggle) {
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        return new TimestampedCommentConfig(enabled, currentTimestampMs, versionId, overrideTimestampMs, overrideVersionId, shouldShowToggle);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimestampedCommentConfig)) {
            return false;
        }
        TimestampedCommentConfig timestampedCommentConfig = (TimestampedCommentConfig) other;
        return this.enabled == timestampedCommentConfig.enabled && this.currentTimestampMs == timestampedCommentConfig.currentTimestampMs && Intrinsics.areEqual(this.versionId, timestampedCommentConfig.versionId) && Intrinsics.areEqual(this.overrideTimestampMs, timestampedCommentConfig.overrideTimestampMs) && Intrinsics.areEqual(this.overrideVersionId, timestampedCommentConfig.overrideVersionId) && this.shouldShowToggle == timestampedCommentConfig.shouldShowToggle;
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.enabled) * 31) + Long.hashCode(this.currentTimestampMs)) * 31) + this.versionId.hashCode()) * 31;
        Long l = this.overrideTimestampMs;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.overrideVersionId;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.shouldShowToggle);
    }

    public String toString() {
        return "TimestampedCommentConfig(enabled=" + this.enabled + ", currentTimestampMs=" + this.currentTimestampMs + ", versionId=" + this.versionId + ", overrideTimestampMs=" + this.overrideTimestampMs + ", overrideVersionId=" + this.overrideVersionId + ", shouldShowToggle=" + this.shouldShowToggle + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.enabled ? 1 : 0);
        dest.writeLong(this.currentTimestampMs);
        dest.writeString(this.versionId);
        Long l = this.overrideTimestampMs;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.overrideVersionId);
        dest.writeInt(this.shouldShowToggle ? 1 : 0);
    }

    public TimestampedCommentConfig(boolean z, long j, String versionId, Long l, String str, boolean z2) {
        Intrinsics.checkNotNullParameter(versionId, "versionId");
        this.enabled = z;
        this.currentTimestampMs = j;
        this.versionId = versionId;
        this.overrideTimestampMs = l;
        this.overrideVersionId = str;
        this.shouldShowToggle = z2;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final long getCurrentTimestampMs() {
        return this.currentTimestampMs;
    }

    public /* synthetic */ TimestampedCommentConfig(boolean z, long j, String str, Long l, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? true : z2);
    }

    public final String getVersionId() {
        return this.versionId;
    }

    public final Long getOverrideTimestampMs() {
        return this.overrideTimestampMs;
    }

    public final String getOverrideVersionId() {
        return this.overrideVersionId;
    }

    public final boolean getShouldShowToggle() {
        return this.shouldShowToggle;
    }

    public final long getTimestampForSubmission() {
        Long l = this.overrideTimestampMs;
        return l != null ? l.longValue() : this.currentTimestampMs;
    }

    public final String getVersionIdForSubmission() {
        String str = this.overrideVersionId;
        return str == null ? this.versionId : str;
    }
}
