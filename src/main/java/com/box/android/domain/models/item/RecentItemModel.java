package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.usecases.InteractionType;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentItemModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/box/android/domain/models/item/RecentItemModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "interactionType", "Lcom/box/android/domain/usecases/InteractionType;", "interactedAt", "Ljava/util/Date;", "interactionSharedLink", "", "<init>", "(Lcom/box/android/domain/usecases/InteractionType;Ljava/util/Date;Ljava/lang/String;)V", "getInteractionType", "()Lcom/box/android/domain/usecases/InteractionType;", "getInteractedAt", "()Ljava/util/Date;", "getInteractionSharedLink", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RecentItemModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<RecentItemModel> CREATOR = new Creator();
    private final Date interactedAt;
    private final String interactionSharedLink;
    private final InteractionType interactionType;

    /* JADX INFO: compiled from: RecentItemModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RecentItemModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecentItemModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RecentItemModel(InteractionType.valueOf(parcel.readString()), (Date) parcel.readSerializable(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecentItemModel[] newArray(int i) {
            return new RecentItemModel[i];
        }
    }

    public static /* synthetic */ RecentItemModel copy$default(RecentItemModel recentItemModel, InteractionType interactionType, Date date, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            interactionType = recentItemModel.interactionType;
        }
        if ((i & 2) != 0) {
            date = recentItemModel.interactedAt;
        }
        if ((i & 4) != 0) {
            str = recentItemModel.interactionSharedLink;
        }
        return recentItemModel.copy(interactionType, date, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final InteractionType getInteractionType() {
        return this.interactionType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getInteractedAt() {
        return this.interactedAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInteractionSharedLink() {
        return this.interactionSharedLink;
    }

    public final RecentItemModel copy(InteractionType interactionType, Date interactedAt, String interactionSharedLink) {
        Intrinsics.checkNotNullParameter(interactionType, "interactionType");
        return new RecentItemModel(interactionType, interactedAt, interactionSharedLink);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecentItemModel)) {
            return false;
        }
        RecentItemModel recentItemModel = (RecentItemModel) other;
        return this.interactionType == recentItemModel.interactionType && Intrinsics.areEqual(this.interactedAt, recentItemModel.interactedAt) && Intrinsics.areEqual(this.interactionSharedLink, recentItemModel.interactionSharedLink);
    }

    public int hashCode() {
        int iHashCode = this.interactionType.hashCode() * 31;
        Date date = this.interactedAt;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        String str = this.interactionSharedLink;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "RecentItemModel(interactionType=" + this.interactionType + ", interactedAt=" + this.interactedAt + ", interactionSharedLink=" + this.interactionSharedLink + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.interactionType.name());
        dest.writeSerializable(this.interactedAt);
        dest.writeString(this.interactionSharedLink);
    }

    public RecentItemModel(InteractionType interactionType, Date date, String str) {
        Intrinsics.checkNotNullParameter(interactionType, "interactionType");
        this.interactionType = interactionType;
        this.interactedAt = date;
        this.interactionSharedLink = str;
    }

    public final Date getInteractedAt() {
        return this.interactedAt;
    }

    public final String getInteractionSharedLink() {
        return this.interactionSharedLink;
    }

    public final InteractionType getInteractionType() {
        return this.interactionType;
    }
}
