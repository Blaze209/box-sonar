package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/box/android/domain/models/RepresentationStatus;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "state", "Lcom/box/android/domain/models/RepresentationStatus$State;", "code", "", "<init>", "(Lcom/box/android/domain/models/RepresentationStatus$State;Ljava/lang/String;)V", "getState", "()Lcom/box/android/domain/models/RepresentationStatus$State;", "getCode", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "State", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RepresentationStatus implements DomainModel, Parcelable {
    public static final Parcelable.Creator<RepresentationStatus> CREATOR = new Creator();
    private final String code;
    private final State state;

    /* JADX INFO: compiled from: RepresentationModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RepresentationStatus> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RepresentationStatus createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RepresentationStatus(State.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RepresentationStatus[] newArray(int i) {
            return new RepresentationStatus[i];
        }
    }

    public static /* synthetic */ RepresentationStatus copy$default(RepresentationStatus representationStatus, State state, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            state = representationStatus.state;
        }
        if ((i & 2) != 0) {
            str = representationStatus.code;
        }
        return representationStatus.copy(state, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final RepresentationStatus copy(State state, String code) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new RepresentationStatus(state, code);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RepresentationStatus)) {
            return false;
        }
        RepresentationStatus representationStatus = (RepresentationStatus) other;
        return this.state == representationStatus.state && Intrinsics.areEqual(this.code, representationStatus.code);
    }

    public int hashCode() {
        int iHashCode = this.state.hashCode() * 31;
        String str = this.code;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RepresentationStatus(state=" + this.state + ", code=" + this.code + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.state.name());
        dest.writeString(this.code);
    }

    public RepresentationStatus(State state, String str) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.code = str;
    }

    public /* synthetic */ RepresentationStatus(State state, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(state, (i & 2) != 0 ? null : str);
    }

    public final State getState() {
        return this.state;
    }

    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: compiled from: RepresentationModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/RepresentationStatus$State;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "PENDING", "NONE", "VIEWABLE", "ERROR", "isReady", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum State {
        SUCCESS,
        PENDING,
        NONE,
        VIEWABLE,
        ERROR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public final boolean isReady() {
            return this == SUCCESS || this == VIEWABLE;
        }
    }
}
