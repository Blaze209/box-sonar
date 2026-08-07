package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.GetFolderItemsEdgesOnlyQuery_ResponseAdapter;
import com.box.android.data.adapter.GetFolderItemsEdgesOnlyQuery_VariablesAdapter;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.fragment.ItemConnectionEdgesOnlyFragment;
import com.box.android.data.selections.GetFolderItemsEdgesOnlyQuerySelections;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetFolderItemsEdgesOnlyQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001e\u001f !B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery;", "Lcom/apollographql/apollo3/api/Query;", "Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$Data;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", "Folder", GQLCacheConstants.TYPENAME_ITEM_CONNECTION, "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GetFolderItemsEdgesOnlyQuery implements Query<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "2bcfea074739dfd632b55a1d8d71180780c320052c8c5a3e487592fabd6261c4";
    public static final String OPERATION_NAME = "getFolderItemsEdgesOnly";
    private final String id;

    public static /* synthetic */ GetFolderItemsEdgesOnlyQuery copy$default(GetFolderItemsEdgesOnlyQuery getFolderItemsEdgesOnlyQuery, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getFolderItemsEdgesOnlyQuery.id;
        }
        return getFolderItemsEdgesOnlyQuery.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final GetFolderItemsEdgesOnlyQuery copy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new GetFolderItemsEdgesOnlyQuery(id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetFolderItemsEdgesOnlyQuery) && Intrinsics.areEqual(this.id, ((GetFolderItemsEdgesOnlyQuery) other).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "GetFolderItemsEdgesOnlyQuery(id=" + this.id + ")";
    }

    public GetFolderItemsEdgesOnlyQuery(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public final String getId() {
        return this.id;
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
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        GetFolderItemsEdgesOnlyQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(GetFolderItemsEdgesOnlyQuery_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Query.INSTANCE.getType()).selections(GetFolderItemsEdgesOnlyQuerySelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: GetFolderItemsEdgesOnlyQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$Data;", "Lcom/apollographql/apollo3/api/Query$Data;", "folder", "Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$Folder;", "<init>", "(Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$Folder;)V", "getFolder", "()Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$Folder;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Query.Data {
        private final Folder folder;

        public static /* synthetic */ Data copy$default(Data data, Folder folder, int i, Object obj) {
            if ((i & 1) != 0) {
                folder = data.folder;
            }
            return data.copy(folder);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Folder getFolder() {
            return this.folder;
        }

        public final Data copy(Folder folder) {
            return new Data(folder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.folder, ((Data) other).folder);
        }

        public int hashCode() {
            Folder folder = this.folder;
            if (folder == null) {
                return 0;
            }
            return folder.hashCode();
        }

        public String toString() {
            return "Data(folder=" + this.folder + ")";
        }

        public Data(Folder folder) {
            this.folder = folder;
        }

        public final Folder getFolder() {
            return this.folder;
        }
    }

    /* JADX INFO: compiled from: GetFolderItemsEdgesOnlyQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$Folder;", "", "id", "", "itemConnection", "Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$ItemConnection;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$ItemConnection;)V", "getId", "()Ljava/lang/String;", "getItemConnection", "()Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$ItemConnection;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Folder {
        private final String id;
        private final ItemConnection itemConnection;

        public static /* synthetic */ Folder copy$default(Folder folder, String str, ItemConnection itemConnection, int i, Object obj) {
            if ((i & 1) != 0) {
                str = folder.id;
            }
            if ((i & 2) != 0) {
                itemConnection = folder.itemConnection;
            }
            return folder.copy(str, itemConnection);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemConnection getItemConnection() {
            return this.itemConnection;
        }

        public final Folder copy(String id, ItemConnection itemConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Folder(id, itemConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Folder)) {
                return false;
            }
            Folder folder = (Folder) other;
            return Intrinsics.areEqual(this.id, folder.id) && Intrinsics.areEqual(this.itemConnection, folder.itemConnection);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            ItemConnection itemConnection = this.itemConnection;
            return iHashCode + (itemConnection == null ? 0 : itemConnection.hashCode());
        }

        public String toString() {
            return "Folder(id=" + this.id + ", itemConnection=" + this.itemConnection + ")";
        }

        public Folder(String id, ItemConnection itemConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.itemConnection = itemConnection;
        }

        public final String getId() {
            return this.id;
        }

        public final ItemConnection getItemConnection() {
            return this.itemConnection;
        }
    }

    /* JADX INFO: compiled from: GetFolderItemsEdgesOnlyQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$ItemConnection;", "", GQLCacheConstants.TYPENAME_KEY, "", "itemConnectionEdgesOnlyFragment", "Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment;)V", "get__typename", "()Ljava/lang/String;", "getItemConnectionEdgesOnlyFragment", "()Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemConnection {
        private final String __typename;
        private final ItemConnectionEdgesOnlyFragment itemConnectionEdgesOnlyFragment;

        public static /* synthetic */ ItemConnection copy$default(ItemConnection itemConnection, String str, ItemConnectionEdgesOnlyFragment itemConnectionEdgesOnlyFragment, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemConnection.__typename;
            }
            if ((i & 2) != 0) {
                itemConnectionEdgesOnlyFragment = itemConnection.itemConnectionEdgesOnlyFragment;
            }
            return itemConnection.copy(str, itemConnectionEdgesOnlyFragment);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get__typename() {
            return this.__typename;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemConnectionEdgesOnlyFragment getItemConnectionEdgesOnlyFragment() {
            return this.itemConnectionEdgesOnlyFragment;
        }

        public final ItemConnection copy(String __typename, ItemConnectionEdgesOnlyFragment itemConnectionEdgesOnlyFragment) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            Intrinsics.checkNotNullParameter(itemConnectionEdgesOnlyFragment, "itemConnectionEdgesOnlyFragment");
            return new ItemConnection(__typename, itemConnectionEdgesOnlyFragment);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemConnection)) {
                return false;
            }
            ItemConnection itemConnection = (ItemConnection) other;
            return Intrinsics.areEqual(this.__typename, itemConnection.__typename) && Intrinsics.areEqual(this.itemConnectionEdgesOnlyFragment, itemConnection.itemConnectionEdgesOnlyFragment);
        }

        public int hashCode() {
            return (this.__typename.hashCode() * 31) + this.itemConnectionEdgesOnlyFragment.hashCode();
        }

        public String toString() {
            return "ItemConnection(__typename=" + this.__typename + ", itemConnectionEdgesOnlyFragment=" + this.itemConnectionEdgesOnlyFragment + ")";
        }

        public ItemConnection(String __typename, ItemConnectionEdgesOnlyFragment itemConnectionEdgesOnlyFragment) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            Intrinsics.checkNotNullParameter(itemConnectionEdgesOnlyFragment, "itemConnectionEdgesOnlyFragment");
            this.__typename = __typename;
            this.itemConnectionEdgesOnlyFragment = itemConnectionEdgesOnlyFragment;
        }

        public final String get__typename() {
            return this.__typename;
        }

        public final ItemConnectionEdgesOnlyFragment getItemConnectionEdgesOnlyFragment() {
            return this.itemConnectionEdgesOnlyFragment;
        }
    }

    /* JADX INFO: compiled from: GetFolderItemsEdgesOnlyQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/GetFolderItemsEdgesOnlyQuery$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "query getFolderItemsEdgesOnly($id: ID!) { folder(id: $id) { id itemConnection { __typename ...itemConnectionEdgesOnlyFragment } } }  fragment itemConnectionEdgesOnlyFragment on FolderItemConnection { totalCount edges { id: cursor } }";
        }
    }
}
