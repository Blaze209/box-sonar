package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.adapter.DeleteCollectionItemMutation_ResponseAdapter;
import com.box.android.data.adapter.DeleteCollectionItemMutation_VariablesAdapter;
import com.box.android.data.selections.DeleteCollectionItemMutationSelections;
import com.box.android.data.type.ItemType;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteCollectionItemMutation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003'()B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J'\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006*"}, d2 = {"Lcom/box/android/data/DeleteCollectionItemMutation;", "Lcom/apollographql/apollo3/api/Mutation;", "Lcom/box/android/data/DeleteCollectionItemMutation$Data;", BoxItemJob.COLLECTION_ID, "", "itemId", "itemType", "Lcom/box/android/data/type/ItemType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/type/ItemType;)V", "getCollectionId", "()Ljava/lang/String;", "getItemId", "getItemType", "()Lcom/box/android/data/type/ItemType;", "id", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", DeleteCollectionItemMutation.OPERATION_NAME, "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DeleteCollectionItemMutation implements Mutation<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "0ae8aa72090587db59eee251a22d079481c44d4258a3d6f01c6f4eaffcb766ba";
    public static final String OPERATION_NAME = "DeleteCollectionItem";
    private final String collectionId;
    private final String itemId;
    private final ItemType itemType;

    public static /* synthetic */ DeleteCollectionItemMutation copy$default(DeleteCollectionItemMutation deleteCollectionItemMutation, String str, String str2, ItemType itemType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteCollectionItemMutation.collectionId;
        }
        if ((i & 2) != 0) {
            str2 = deleteCollectionItemMutation.itemId;
        }
        if ((i & 4) != 0) {
            itemType = deleteCollectionItemMutation.itemType;
        }
        return deleteCollectionItemMutation.copy(str, str2, itemType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCollectionId() {
        return this.collectionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ItemType getItemType() {
        return this.itemType;
    }

    public final DeleteCollectionItemMutation copy(String collectionId, String itemId, ItemType itemType) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        return new DeleteCollectionItemMutation(collectionId, itemId, itemType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteCollectionItemMutation)) {
            return false;
        }
        DeleteCollectionItemMutation deleteCollectionItemMutation = (DeleteCollectionItemMutation) other;
        return Intrinsics.areEqual(this.collectionId, deleteCollectionItemMutation.collectionId) && Intrinsics.areEqual(this.itemId, deleteCollectionItemMutation.itemId) && this.itemType == deleteCollectionItemMutation.itemType;
    }

    public int hashCode() {
        return (((this.collectionId.hashCode() * 31) + this.itemId.hashCode()) * 31) + this.itemType.hashCode();
    }

    public String toString() {
        return "DeleteCollectionItemMutation(collectionId=" + this.collectionId + ", itemId=" + this.itemId + ", itemType=" + this.itemType + ")";
    }

    public DeleteCollectionItemMutation(String collectionId, String itemId, ItemType itemType) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.collectionId = collectionId;
        this.itemId = itemId;
        this.itemType = itemType;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final ItemType getItemType() {
        return this.itemType;
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String id() {
        return OPERATION_ID;
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String document() {
        return INSTANCE.getOPERATION_DOCUMENT();
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String name() {
        return OPERATION_NAME;
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        DeleteCollectionItemMutation_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(DeleteCollectionItemMutation_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Mutation.INSTANCE.getType()).selections(DeleteCollectionItemMutationSelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: DeleteCollectionItemMutation.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/DeleteCollectionItemMutation$Data;", "Lcom/apollographql/apollo3/api/Mutation$Data;", "deleteCollectionItem", "Lcom/box/android/data/DeleteCollectionItemMutation$DeleteCollectionItem;", "<init>", "(Lcom/box/android/data/DeleteCollectionItemMutation$DeleteCollectionItem;)V", "getDeleteCollectionItem", "()Lcom/box/android/data/DeleteCollectionItemMutation$DeleteCollectionItem;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Mutation.Data {
        private final DeleteCollectionItem deleteCollectionItem;

        public static /* synthetic */ Data copy$default(Data data, DeleteCollectionItem deleteCollectionItem, int i, Object obj) {
            if ((i & 1) != 0) {
                deleteCollectionItem = data.deleteCollectionItem;
            }
            return data.copy(deleteCollectionItem);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DeleteCollectionItem getDeleteCollectionItem() {
            return this.deleteCollectionItem;
        }

        public final Data copy(DeleteCollectionItem deleteCollectionItem) {
            return new Data(deleteCollectionItem);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.deleteCollectionItem, ((Data) other).deleteCollectionItem);
        }

        public int hashCode() {
            DeleteCollectionItem deleteCollectionItem = this.deleteCollectionItem;
            if (deleteCollectionItem == null) {
                return 0;
            }
            return deleteCollectionItem.hashCode();
        }

        public String toString() {
            return "Data(deleteCollectionItem=" + this.deleteCollectionItem + ")";
        }

        public Data(DeleteCollectionItem deleteCollectionItem) {
            this.deleteCollectionItem = deleteCollectionItem;
        }

        public final DeleteCollectionItem getDeleteCollectionItem() {
            return this.deleteCollectionItem;
        }
    }

    /* JADX INFO: compiled from: DeleteCollectionItemMutation.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/DeleteCollectionItemMutation$DeleteCollectionItem;", "", BoxItemJob.COLLECTION_ID, "", "<init>", "(Ljava/lang/String;)V", "getCollectionId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DeleteCollectionItem {
        private final String collectionId;

        public static /* synthetic */ DeleteCollectionItem copy$default(DeleteCollectionItem deleteCollectionItem, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deleteCollectionItem.collectionId;
            }
            return deleteCollectionItem.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCollectionId() {
            return this.collectionId;
        }

        public final DeleteCollectionItem copy(String collectionId) {
            return new DeleteCollectionItem(collectionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeleteCollectionItem) && Intrinsics.areEqual(this.collectionId, ((DeleteCollectionItem) other).collectionId);
        }

        public int hashCode() {
            String str = this.collectionId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "DeleteCollectionItem(collectionId=" + this.collectionId + ")";
        }

        public DeleteCollectionItem(String str) {
            this.collectionId = str;
        }

        public final String getCollectionId() {
            return this.collectionId;
        }
    }

    /* JADX INFO: compiled from: DeleteCollectionItemMutation.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/DeleteCollectionItemMutation$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "mutation DeleteCollectionItem($collectionId: ID!, $itemId: ID!, $itemType: ItemType!) { deleteCollectionItem(input: { collectionId: $collectionId itemId: $itemId itemType: $itemType } ) { collectionId } }";
        }
    }
}
