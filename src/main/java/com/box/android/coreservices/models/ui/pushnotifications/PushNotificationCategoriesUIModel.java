package com.box.android.coreservices.models.ui.pushnotifications;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushNotificationCategoriesUIModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006 "}, d2 = {"Lcom/box/android/coreservices/models/ui/pushnotifications/PushNotificationCategoriesUIModel;", "Landroid/os/Parcelable;", BoxRequestsSearch.Search.CONTENT_TYPE_COMMENTS, "", "collabInvite", SemanticAttributes.FaasDocumentOperationValues.EDIT, BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB, "<init>", "(ZZZZ)V", "getComments", "()Z", "getCollabInvite", "getEdit", "getUpload", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PushNotificationCategoriesUIModel implements Parcelable {
    public static final Parcelable.Creator<PushNotificationCategoriesUIModel> CREATOR = new Creator();
    private final boolean collabInvite;
    private final boolean comments;
    private final boolean edit;
    private final boolean upload;

    /* JADX INFO: compiled from: PushNotificationCategoriesUIModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PushNotificationCategoriesUIModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PushNotificationCategoriesUIModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PushNotificationCategoriesUIModel(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PushNotificationCategoriesUIModel[] newArray(int i) {
            return new PushNotificationCategoriesUIModel[i];
        }
    }

    public static /* synthetic */ PushNotificationCategoriesUIModel copy$default(PushNotificationCategoriesUIModel pushNotificationCategoriesUIModel, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pushNotificationCategoriesUIModel.comments;
        }
        if ((i & 2) != 0) {
            z2 = pushNotificationCategoriesUIModel.collabInvite;
        }
        if ((i & 4) != 0) {
            z3 = pushNotificationCategoriesUIModel.edit;
        }
        if ((i & 8) != 0) {
            z4 = pushNotificationCategoriesUIModel.upload;
        }
        return pushNotificationCategoriesUIModel.copy(z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getComments() {
        return this.comments;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCollabInvite() {
        return this.collabInvite;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEdit() {
        return this.edit;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getUpload() {
        return this.upload;
    }

    public final PushNotificationCategoriesUIModel copy(boolean comments, boolean collabInvite, boolean edit, boolean upload) {
        return new PushNotificationCategoriesUIModel(comments, collabInvite, edit, upload);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushNotificationCategoriesUIModel)) {
            return false;
        }
        PushNotificationCategoriesUIModel pushNotificationCategoriesUIModel = (PushNotificationCategoriesUIModel) other;
        return this.comments == pushNotificationCategoriesUIModel.comments && this.collabInvite == pushNotificationCategoriesUIModel.collabInvite && this.edit == pushNotificationCategoriesUIModel.edit && this.upload == pushNotificationCategoriesUIModel.upload;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.comments) * 31) + Boolean.hashCode(this.collabInvite)) * 31) + Boolean.hashCode(this.edit)) * 31) + Boolean.hashCode(this.upload);
    }

    public String toString() {
        return "PushNotificationCategoriesUIModel(comments=" + this.comments + ", collabInvite=" + this.collabInvite + ", edit=" + this.edit + ", upload=" + this.upload + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.comments ? 1 : 0);
        dest.writeInt(this.collabInvite ? 1 : 0);
        dest.writeInt(this.edit ? 1 : 0);
        dest.writeInt(this.upload ? 1 : 0);
    }

    public PushNotificationCategoriesUIModel(boolean z, boolean z2, boolean z3, boolean z4) {
        this.comments = z;
        this.collabInvite = z2;
        this.edit = z3;
        this.upload = z4;
    }

    public final boolean getComments() {
        return this.comments;
    }

    public final boolean getCollabInvite() {
        return this.collabInvite;
    }

    public final boolean getEdit() {
        return this.edit;
    }

    public final boolean getUpload() {
        return this.upload;
    }
}
