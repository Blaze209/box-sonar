package com.box.android.collections.presentation.viewmodel;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionMembershipsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipModel;", "", "collectionModel", "Lcom/box/android/domain/models/CollectionModel;", "isChecked", "", "<init>", "(Lcom/box/android/domain/models/CollectionModel;Z)V", "getCollectionModel", "()Lcom/box/android/domain/models/CollectionModel;", "()Z", "equals", "other", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionMembershipModel {
    public static final int $stable = 8;
    private final CollectionModel collectionModel;
    private final boolean isChecked;

    public static /* synthetic */ CollectionMembershipModel copy$default(CollectionMembershipModel collectionMembershipModel, CollectionModel collectionModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            collectionModel = collectionMembershipModel.collectionModel;
        }
        if ((i & 2) != 0) {
            z = collectionMembershipModel.isChecked;
        }
        return collectionMembershipModel.copy(collectionModel, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CollectionModel getCollectionModel() {
        return this.collectionModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final CollectionMembershipModel copy(CollectionModel collectionModel, boolean isChecked) {
        Intrinsics.checkNotNullParameter(collectionModel, "collectionModel");
        return new CollectionMembershipModel(collectionModel, isChecked);
    }

    public int hashCode() {
        return (this.collectionModel.hashCode() * 31) + Boolean.hashCode(this.isChecked);
    }

    public String toString() {
        return "CollectionMembershipModel(collectionModel=" + this.collectionModel + ", isChecked=" + this.isChecked + ")";
    }

    public CollectionMembershipModel(CollectionModel collectionModel, boolean z) {
        Intrinsics.checkNotNullParameter(collectionModel, "collectionModel");
        this.collectionModel = collectionModel;
        this.isChecked = z;
    }

    public final CollectionModel getCollectionModel() {
        return this.collectionModel;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public boolean equals(Object other) {
        CollectionModel collectionModel = this.collectionModel;
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.box.android.collections.presentation.viewmodel.CollectionMembershipModel");
        return Intrinsics.areEqual(collectionModel, ((CollectionMembershipModel) other).collectionModel);
    }
}
